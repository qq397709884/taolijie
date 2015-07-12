package com.fh.taolijie.dao.mapper;

import com.fh.taolijie.cache.annotation.RedisCache;
import com.fh.taolijie.cache.annotation.RedisEvict;
import com.fh.taolijie.domain.SHPostCategoryModel;
import com.fh.taolijie.domain.SHPostModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShPostCategoryModelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_hand_post_category
     *
     * @mbggenerated
     */
    @RedisEvict({
            SHPostCategoryModel.class,
            SHPostModel.class
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_hand_post_category
     *
     * @mbggenerated
     */
    //@CacheEvict(value = "shPostCategoryListCache", allEntries = true, beforeInvocation = true )
    @RedisEvict({
            SHPostCategoryModel.class,
            SHPostModel.class
    })
    int insert(SHPostCategoryModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_hand_post_category
     *
     * @mbggenerated
     */
    //@CacheEvict(value = "shPostCategoryListCache", allEntries = true, beforeInvocation = true )
    @RedisEvict({
            SHPostCategoryModel.class,
            SHPostModel.class
    })
    int insertSelective(SHPostCategoryModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_hand_post_category
     *
     * @mbggenerated
     */
    @RedisCache(SHPostCategoryModel.class)
    SHPostCategoryModel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_hand_post_category
     *
     * @mbggenerated
     */
/*    @Caching(
            evict = {
                    @CacheEvict(value = "shPostCategoryCache", key = "'ShPostCategory:id:'.concat(#p0.id)", beforeInvocation = true ),
                    @CacheEvict(value = "shPostCategoryListCache", allEntries = true, beforeInvocation = true )
            }
    )*/
    @RedisEvict({
            SHPostCategoryModel.class,
            SHPostModel.class
    })
    int updateByPrimaryKeySelective(SHPostCategoryModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_hand_post_category
     *
     * @mbggenerated
     */
/*    @Caching(
            evict = {
                    @CacheEvict(value = "shPostCategoryCache", key = "'ShPostCategory:id:'.concat(#p0.id)", beforeInvocation = true ),
                    @CacheEvict(value = "shPostCategoryListCache", allEntries = true, beforeInvocation = true )
            }
    )*/
    @RedisEvict({
            SHPostCategoryModel.class,
            SHPostModel.class
    })
    int updateByPrimaryKey(SHPostCategoryModel record);

    @RedisCache(SHPostCategoryModel.class)
    List<SHPostCategoryModel> getAll(@Param("pageNumber") int pageNumber, @Param("pageSize") int pageSize);
}