package com.example.websitenavigation.mapper;

import com.example.websitenavigation.pojo.Search;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SearchMapper {
    int deleteByPrimaryKey(Integer searchId);

    int insert(Search record);

    int insertSelective(Search record);

    List<Search> selectAll();

    List<Search> selectByUserId(Integer userId);

    Search selectByPrimaryKey(Integer searchId);

    int updateByPrimaryKeySelective(Search record);

    int updateByPrimaryKey(Search record);
}