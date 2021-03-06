<%--
  Created by IntelliJ IDEA.
  User: wynfrith
  Date: 15-6-2
  Time: 下午7:18
  To change this template use File | Settings | File Templates.
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ju" uri="/WEB-INF/tld/JsonUtils.tld"%>

<%request.setCharacterEncoding("UTF-8");%>
<%@ page session="false" %>
<%--html头部--%>


<!doctype html>
<html class="no-js" ng-app="tljApp" ng-controller="resumeListCtrl">
<head>
    <meta charset="utf-8">
    <title>兼职</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->

    <!-- build:css /styles/vendor.css -->
    <!-- bower:css -->
    <!-- endbower -->
    <!-- endbuild -->

    <!-- build:css({.tmp,app}) /styles/css/style.css -->
    <link rel="stylesheet" href="/styles/animate.css"/>
    <link rel="stylesheet" href="/styles/style.css">
    <%--图片上传美化--%>
    <link rel="stylesheet" href="/styles/webuploader.css"/>
    <!-- endbuild -->
    <link rel="stylesheet" href="/styles/jquery.bxslider.css">
    <%--<link rel="stylesheet" href="http://libs.useso.com/js/font-awesome/4.2.0/css/font-awesome.min.css">--%>
    <link rel="stylesheet" href="/styles/font-awesome.min.css"/>
    <link rel="stylesheet" href="/styles/root/resumelist.css"/>

    <!-- build:js /scripts/vendor/modernizr.js -->
    <script src="/scripts/modernizr.js"></script>
    <!-- endbuild -->

</head>
<body>
<!--[if lt IE 10]>
<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->



<%--顶栏--%>
<jsp:include page="block/top-bar.jsp"/>
<%--页首--%>
<jsp:include page="block/header.jsp"/>

<div class="container">
    <style>.ng-cloak{display: none}</style>

  <%--轮播--%>
  <jsp:include page="block/silder.jsp"/>
  <%--侧边栏--%>
  <jsp:include page="block/side.jsp"/>


      <div class="resumelist main">
          <ul class="nav-bar">
              <li ng-click="getRecommend()">热门推荐
              </li>
              <li class="choose"><span class="choose-title" data-default="求职意向">求职意向</span> <i class="fa fa-caret-down"></i>
                <div class="choose-menu" data-type="intendIds" >
                    <span class="active" >全部</span>
                    <span ng-repeat="c in cates" ng-bind="c.name" ng-attr-data-val="{{c.id}}"> </span>
                </div>
              </li>
              <li class="choose"><span class="choose-title" data-default="性别选择">性别选择</span> <i class="fa fa-caret-down"></i>
                  <div class="choose-menu" data-type="gender">
                      <span class="active">全部</span>
                      <span data-val="m">男</span>
                      <span data-val="f">女</span>
                  </div>
              </li>
          </ul>
          <div class="lists">
            <span class="loading-page"></span>
              <a href="/item/resume/{{resume.id}}" target="_blank" ng-repeat="resume in list" ng-cloak class="ng-cloak">
                  <div class="list">
                      <img src="/static/images/users/{{resume.photoPath}}" alt="">
                      <div>
                          <div class="fl">
                              <p class="info">
                              <span ng-bind="resume.name" class="name info-item"></span>
                              <span ng-if="resume.gender == 'f'" class="info-item red">女</span>
                              <span ng-if="resume.gender == 'm'" class="info-item light-green">男</span>
                              <span ng-bind="(resume.age) + '岁'" class="info-item"></span>
                              </p>
                              <p class="intent">
                              <span class="intent-title theme-color-bg">求职意向</span>
                              <%-- <span ng-repeat="i in resume.intend" ng-bind="i" class="intend-item"></span> --%>
                              <span ng-bind="resume.intend.join('、')" class="intend-item"></span>
                              </p>
                          </div>
                          <div class="fr">
                              <p>
                              <span ng-bind="resume.major"></span>
                              </p>
                              <p>
                              <span class="time" ng-bind="resume.createdTime | date:'yyyy-MM-dd HH:mm:ss'"></span>
                              </p>
                          </div>
                      </div>
                  </div>
              </a>
          </div>
          <div style="clear:both"></div>
          <div class="page">
            <ul>
                <li ng-cloak class="ng-cloak"><a class="next" ng-click="pageChange(false)" ng-if="lastPage()" href="javascript:;">上一页</a></li>
                <li ng-cloak class="ng-cloak"><a class="next" ng-click="pageChange(true)" ng-if="nextPage()" href="javascript:;">下一页</a></li>
            </ul>
            </li>
          </div>
      </div>
</div>

<%--脚部--%>
<jsp:include page="block/footer.jsp"/>
<script src="/scripts/list/listoperate.js"></script>
<script src="/scripts/list/resumelist.js"></script>
<script>
    // var resumes = JSON.parse('${ju:toJson(resumes.list)}');
    // var pages = {};
    // pages.page = JSON.parse('${ju:toJson(page)}');;
    // pages.pageStatus = JSON.parse('${ju:toJson(pageStatus)}');
    // pages.pageSize = JSON.parse('${ju:toJson(pageSize)}');
</script>

</body>
</html>
