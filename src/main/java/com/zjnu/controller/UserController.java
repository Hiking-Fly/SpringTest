package com.zjnu.controller;

import com.zjnu.domain.Role;
import com.zjnu.domain.User;
import com.zjnu.service.RoleService;
import com.zjnu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/addUserUI")
    public ModelAndView addUserUI(){
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.getRoleList();
        System.out.println(roleList);
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-add");
        return modelAndView;
    }
    @RequestMapping("/getList")
    public ModelAndView getUserList(){
        ModelAndView modelAndView = new ModelAndView();
        List<User> userList = userService.getUserList();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/saveUser")
    public String saveUser(User user,Long[] roleIds){
        userService.saveUser(user,roleIds);
        return "redirect:/user/getList";
    }

    @RequestMapping("/delete/{userId}")
    public String deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return "redirect:/user/getList";
    }

    @RequestMapping("/Login")
    public String login(String username, String password, HttpSession session){
        User user = userService.login(username,password);
        if(user == null){
            return "redirect:/login.jsp";
        }else{
            session.setAttribute("user",user);
            return "redirect:/pages/main.jsp";
        }
    }

}
