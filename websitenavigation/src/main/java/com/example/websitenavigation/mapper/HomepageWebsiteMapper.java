package com.example.websitenavigation.mapper;

import com.example.websitenavigation.pojo.HomepageWebsite;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HomepageWebsiteMapper {
    int deleteByPrimaryKey(Integer siteId);

    int insert(HomepageWebsite record);

    int insertSelective(HomepageWebsite record);

    HomepageWebsite selectByPrimaryKey(Integer siteId);

    List<HomepageWebsite> selectAllSites();

    List<HomepageWebsite> selectByUserId(Integer userId);

    int updateByPrimaryKeySelective(HomepageWebsite record);


    int updateByPrimaryKey(HomepageWebsite record);
}