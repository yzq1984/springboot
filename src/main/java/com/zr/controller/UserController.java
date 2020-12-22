package com.zr.controller;

import com.alibaba.fastjson.JSON;
import com.zr.model.Account;
import com.zr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/hi")
    public String hi(String cardid){
        Account account = userService.findById(cardid);
       return JSON.toJSONString(account);
    }

    @ResponseBody
    @RequestMapping("/list")
    public String list(){
        List<Account> accountList = userService.findAll();
        return JSON.toJSONString(accountList);
    }

    @RequestMapping("/user")
    public String user(Model model){
        model.addAttribute("message","你好");
        return "user";
    }

    @ResponseBody
    @RequestMapping("/add")
    public String add(String cardid){
       try{
           userService.add(cardid);
       }catch (Exception e){
           e.printStackTrace();
       }
        return "ok";
    }

}
