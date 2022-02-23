package com.example.websitenavigation.controller;

import com.example.websitenavigation.mapper.SearchMapper;
import com.example.websitenavigation.pojo.Search;
import com.example.websitenavigation.pojo.Result;
import com.example.websitenavigation.utils.Invalid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/search"})
public class SearchController {

    @Autowired
    SearchMapper searchMapper;

    //默认用户所有内容
//    List<Search> defaultSites = searchMapper.selectByUserId(1);

    /**
     * 所有网页
     * @return 网页的Json接口
     */
    @RequestMapping("/allSites")
    @CrossOrigin(origins = "*")
    public List<Search> selectAllSites(){
        return searchMapper.selectAll();
    }

    /**
     * 依照网页ID查询
     * @param id 网页的id
     * @return 该ID对应的网页
     */
    @RequestMapping("/siteInfo/{id}")
    @CrossOrigin(origins = "*")
    public Search selectById(@PathVariable("id") Integer id){
        return searchMapper.selectByPrimaryKey(id);
    }

    /**
     * 用户添加的网页
     * @param userId 用户ID
     * @return 该用户添加的全部网页
     */
    @RequestMapping("/userSites/{userId}")
    @CrossOrigin(origins = "*")
    public List<Search> selectByUserId(@PathVariable("userId")Integer userId){
        List<Search> userSites = searchMapper.selectByUserId(1);
        if (userId != 1){
            userSites.addAll(searchMapper.selectByUserId(userId));
        }

        return userSites;
//        return searchMapper.selectByUserId(userId);
    }

    /**
     * 添加网页
     * @param search 网页bean
     * @param userId 对应用户
     * @return 添加结果
     */
    @PostMapping("/addSite/{userId}")
    @CrossOrigin(origins = "*")
    public Result addSearch(
            @RequestBody Search search,
                                     @PathVariable Integer userId){
//        System.out.println(search)
        Result r = new Result();
        r.setSuccess(false);
        r.setDetail(null);
        search.setUserId(userId);
        try {
            if (searchMapper.insert(search) >= 1){
//                System.out.println("添加成功");
                r.setMsg("添加成功");
                r.setSuccess(true);
                r.setDetail(search);
            } else {
                r.setMsg("添加失败");
                int invalid = Invalid.INVALID;
            }
        } catch (Exception e){
            r.setMsg(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return r;
    }

    /**
     * 删除网站
     * @param id 网站id
     * @return 返回结果
     */
    @DeleteMapping("/deleteSite/{id}")
    @CrossOrigin(origins = "*")
    public Result deleteWebSite(@PathVariable Integer id){
        Result r = new Result();
        r.setSuccess(false);
        r.setDetail(null);
        try {
            int result = searchMapper.deleteByPrimaryKey(id);
            if (result >= 1){
//                System.out.println("删除成功");
                r.setMsg("删除成功");
                r.setSuccess(true);
                r.setDetail(searchMapper);
            } else {
                r.setMsg("删除失败");
                int invalid = Invalid.INVALID;
            }
        } catch (Exception e){
            r.setDetail(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return r;
    }

    /**
     * 修改网站
     * @param id 被修改网站id
     * @param userId 用户ID
     * @param search 被修改网页类
     * @return 返回修改结果
     */
    @PutMapping("/altWebSite/{userId}/{id}")
    public Result altWebSite(@PathVariable Integer id,
                          @PathVariable Integer userId,
                          @RequestBody Search search){
        Result r = new Result();
        r.setSuccess(false);
        r.setDetail(null);

        search.setUserId(userId);

        try {
            if (id != null && id == search.getSearchId()
                    && searchMapper.selectByPrimaryKey(search.getSearchId()) != null){
                int result = searchMapper.updateByPrimaryKey(search);
                if (result >= 1){
//                    System.out.println("成功");
                    r.setMsg("修改成功");
                    r.setSuccess(true);
                    r.setDetail(search);
                } else {
                    r.setMsg("修改失败");
                    int invalid = Invalid.INVALID;
                }
            } else {
                r.setMsg("修改失败");
                int invalid = Invalid.INVALID;
            }
        } catch (Exception e){
            r.setDetail(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//            return 0;
        }
        return r;
    }


}
