package com.example.websitenavigation.controller;

import com.example.websitenavigation.mapper.UserMapper;
import com.example.websitenavigation.pojo.Result;
import com.example.websitenavigation.pojo.User;
import com.example.websitenavigation.utils.Invalid;
import com.example.websitenavigation.utils.TextDealing;
import com.sun.istack.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = {"/user"})
public class UserController {
    
    @Autowired
    UserMapper userMapper;

    /**
     * 查询全部用户
     * @return 用户集
     */
    @RequestMapping(value = {"/allUserinfo"})
    @CrossOrigin(origins = "*")
    public List<User> selectAllUser(){
        List<User> users = userMapper.selectAllUser();
        users.forEach(u -> {
            u.setUserPassword(TextDealing.getTheMD5Code(u.getUserPassword()));
        });
        return users;
    }

    /**
     * 透过用户ID查询
     * @param id 用户ID
     * @return ID对应的用户
     */
    @RequestMapping(value = {"/userInfo/{id}"})
    @CrossOrigin(origins = "*")
    public User selectById(@PathVariable Integer id){
        User result = userMapper.selectByPrimaryKey(id);
        String pw = result.getUserPassword();
        String md5 = TextDealing.getTheMD5Code(pw);
        result.setUserPassword(md5);
        return result;
    }

    /**
     * 修改用户
     * @param id 用户id
     * @param userName 用户名
     * @param userPassword 用户密码
     * @param userPhone 用户手机号
     * @param userMotto 用户的签名（座右铭）
     * @param user 被修改用户
     * @return 修改结果
     */
    @PutMapping(value = {"/altUser/{id}"})
    @CrossOrigin(origins = "*")
    public int altUser(@PathVariable Integer id,
                       String userName,
                       String userPassword,
                       String userPhone,
                       String userMotto,
                       User user){
        try {
            if (id != null && id == user.getId()){
                user.setUserName(userName);
                user.setUserPassword(userPassword);
                user.setUserPhone(userPhone);
                user.setUserMotto(userMotto);
                int result = userMapper.updateByPrimaryKey(user);
                if (result >= 1){
                    System.out.println("成功");
                    user.setUserPassword(TextDealing.getTheMD5Code(userPassword));
                } else {
                    int invalid = Invalid.INVALID;
                }
            } else {
                int invalid = Invalid.INVALID;
            }
        } catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
        return 1;
    }

    @PostMapping(value = {"/registeredUser"})
    @CrossOrigin(origins = "*")
    public Result registeredUser(@RequestBody User user){

        Result r = new Result();
        r.setSuccess(false);
        r.setDetail(null);
        
        try {
            User exist = userMapper.selectByPrimaryKey(user.getId());
            if (exist == null && userMapper.insert(user) >= 1){
                System.out.println("注册成功");
                exist = userMapper.selectTheLoginUser(user.getUserName(), user.getUserPassword());
                exist.setUserPassword(TextDealing.getTheMD5Code(user.getUserPassword()));
                r.setMsg("注册成功");
                r.setSuccess(true);
                r.setDetail(exist);
            } else {
                r.setMsg("注册失败");
                int invalid = Invalid.INVALID;
            }
        } catch (Exception e){

            r.setDetail(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return r;
    }


    @PostMapping("/login")
    @CrossOrigin("*")
    public Result login(@RequestBody User user
                        ){
        Result r = new Result();
        r.setSuccess(false);
        r.setDetail(null);
        try {
            User exist = userMapper.selectTheLoginUser(
                    user.getUserName(),
                    user.getUserPassword()
            );

            if (exist != null){
                r.setMsg("登陆成功");
                r.setSuccess(true);
                exist.setUserPassword(TextDealing.getTheMD5Code(user.getUserPassword()));
                r.setDetail(exist);
            } else {
                r.setMsg("登陆失败");
                int invalid = Invalid.INVALID;
            }
        } catch (Exception e){
            r.setDetail(e.getMessage());
            e.printStackTrace();

        }
        return r;
    }
}

