package com.example.websitenavigation.controller;

import com.example.websitenavigation.mapper.MarkMapper;
import com.example.websitenavigation.pojo.Mark;
import com.example.websitenavigation.pojo.Result;
import com.example.websitenavigation.utils.Invalid;
import com.example.websitenavigation.utils.TextDealing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/mark"})
public class MarkController {
    @Autowired
    MarkMapper markMapper;

    /**
     * 发表评论（给意见）
     * @param mark 意见内容
     * @return 发表结果
     */
    @PostMapping("/addYourSuggestion")
    @CrossOrigin(origins = "*")
    public Result signUpYourSuggestion(@RequestBody Mark mark){
        Result r = new Result();
        r.setMsg(null);
        r.setSuccess(false);
        r.setDetail(null);
        try {
            if(markMapper.insert(mark) >= 1){
                System.out.println("对方已经提出意见");
                r.setMsg("等待管理员反馈");
                r.setSuccess(true);
                r.setDetail(mark);
            } else {
                r.setMsg("提交失败，请检查");
                int invalid = Invalid.INVALID;
            }
        } catch (Exception e){
            r.setDetail(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return r;
    }

    @RequestMapping("/allSuggestions/{userId}")
    @CrossOrigin(origins = "*")
    public List<Mark> queryAllMarksByUserId(@PathVariable Integer userId){
        return markMapper.selectByUserId(userId);
    }

    @RequestMapping("/allSuggestions")
    @CrossOrigin(origins = "*")
    public List<Mark> queryAllSuggestions(){
        return markMapper.selectAll();
    }


}
