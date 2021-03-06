# encoding=UTF-8
__author__ = 'whf'

import sys
import os
import thread
import time
import logging

import BaseHTTPServer
import subprocess
import json
import redis

# 配置logger
FORMAT = "%(asctime)-15s %(message)s"
CUR_TIME = time.strftime('%Y-%m-%d', time.localtime(time.time()))
logging.basicConfig(filename="/data/taolijie/scripts-log/deploy-server.log", format=FORMAT, level=logging.DEBUG)
#logging.basicConfig(filename="deploy-server_%s.log" % CUR_TIME, format=FORMAT, level=logging.DEBUG)


# 刷新Redis cache
def flush_redis():
    REDIS_HOST = '127.0.0.1'
    REDIS_PASSWORD = '111111'
    REDIS_PORT = 6379

    conn = redis.Redis(REDIS_HOST, REDIS_PORT, password=REDIS_PASSWORD)
    conn.flushall()


# 该函数用于执行外部命令来部署工程
def deploy():
    os.chdir('/root/projects/taolijie')

    try:
        outcome = subprocess.check_output(('/root/projects/taolijie/server-deploy.sh'), stderr=subprocess.STDOUT)
        logging.info(outcome)
    except Exception as e:
        logging.error('deploy failed! Retry')

        # 如果第一次失败，则再尝试一次
        try:
            outcome = subprocess.check_output(('/root/projects/taolijie/server-deploy.sh'), stderr=subprocess.STDOUT)
            logging.info(outcome)
        except Exception as e:
            # 两次都失败，拉倒
            logging.error('deploy failed again, abort!')
            return

    # flush redis
    #logging.info('flushing redis')
    #flush_redis()
    #logging.info('done flushing')

    logging.info('deployment finished without error')

    return outcome


# HTTP请求处理类
class Handler(BaseHTTPServer.BaseHTTPRequestHandler):
    # 处理POST请求
    def do_POST(self):
        logging.info('client addr:%s', self.client_address[0])
        logging.info('client port:%s', self.client_address[1])
        logging.info('method:%s', self.command)

        # 读取请求内容
        json_str = self.rfile.read(int(self.headers['Content-Length']))
        json_dict = None
        try:
            json_dict = json.loads(json_str)
        except:
            logging.error('decoding JSON failed; [%s]', json_str)
            self.send_error(400)
            return

        branch_name = json_dict['ref']
        # 判断是否是master分支
        if not branch_name == 'refs/heads/master':
            logging.info('[%s] is not master branch, do nothing', branch_name)
            self.send_response(200)
            return

        # 启动新线程执行命令
        thread.start_new_thread(deploy, ())

        self.send_response(200)

    def log_error(self, format, *args):
        logging.error(args)


# 启动HTTP Server
server_addr = ('', 10000)
httpd = BaseHTTPServer.HTTPServer(server_addr, Handler)
httpd.serve_forever()
