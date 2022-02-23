package com.example.websitenavigation.controller;

import com.example.websitenavigation.mapper.HomepageWebsiteMapper;
import com.example.websitenavigation.pojo.HomepageWebsite;
import com.example.websitenavigation.pojo.Result;
import com.example.websitenavigation.utils.Invalid;
import com.example.websitenavigation.utils.TextDealing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/homepageWebsite"})
public class HomePageWebSiteController {

    @Autowired
    HomepageWebsiteMapper homepageWebsiteMapper;

    //默认用户所有内容
//    List<HomepageWebsite> defaultSites = homepageWebsiteMapper.selectByUserId(1);

    /**
     * 所有网页
     * @return 网页的Json接口
     */
    @RequestMapping("/allSites")
    @CrossOrigin(origins = "*")
    public List<HomepageWebsite> selectAllSites(){
        return homepageWebsiteMapper.selectAllSites();
    }

    /**
     * 依照网页ID查询
     * @param id 网页的id
     * @return 该ID对应的网页
     */
    @RequestMapping("/siteInfo/{id}")
    @CrossOrigin(origins = "*")
    public HomepageWebsite selectById(@PathVariable("id") Integer id){
        return homepageWebsiteMapper.selectByPrimaryKey(id);
    }

    /**
     * 用户添加的网页
     * @param userId 用户ID
     * @return 该用户添加的全部网页
     */
    @RequestMapping("/userSites/{userId}")
    @CrossOrigin(origins = "*")
    public List<HomepageWebsite> selectByUserId(@PathVariable("userId")Integer userId){
        List<HomepageWebsite> userSites = homepageWebsiteMapper.selectByUserId(1);
        if (userId != 1){
            userSites.addAll(homepageWebsiteMapper.selectByUserId(userId));
        }

        return userSites;
//        return homepageWebsiteMapper.selectByUserId(userId);
    }

    /**
     * 添加网页
     * @param homepageWebsite 网页bean
     * @return 添加结果
     */
    @PostMapping("/addSite/")
    @CrossOrigin(origins = "*")
    public Result addHomepageWebsite(
            @RequestBody HomepageWebsite homepageWebsite
                                     ){
//        System.out.println(homepageWebsite)

        Result r = new Result();
        r.setSuccess(false);
        r.setDetail(null);
        homepageWebsite.setUserId(1);
        try {
            if (homepageWebsiteMapper.insert(homepageWebsite) >= 1){
//                System.out.println("添加成功");
                r.setMsg("添加成功");
                r.setSuccess(true);
                r.setDetail(homepageWebsite);
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
            int result = homepageWebsiteMapper.deleteByPrimaryKey(id);
            if (result >= 1){
//                System.out.println("删除成功");
                r.setMsg("删除成功");
                r.setSuccess(true);
                r.setDetail(homepageWebsiteMapper);
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
     * @param homepageWebsite 被修改网页类
     * @return 返回修改结果
     */
    @PutMapping("/altWebSite/")
    @CrossOrigin(origins = "*")
    public Result altWebSite(
                          @RequestBody HomepageWebsite homepageWebsite){
        Result r = new Result();
        r.setSuccess(false);
        r.setDetail(null);

        try {


                if (homepageWebsiteMapper.updateByPrimaryKeySelective(homepageWebsite) >= 1){
//                    System.out.println("成功");
                    r.setMsg("修改成功");
                    r.setSuccess(true);
                    r.setDetail(homepageWebsite);
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
