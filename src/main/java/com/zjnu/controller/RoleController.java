package com.zjnu.controller;

import com.zjnu.domain.Role;
import com.zjnu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/getList")
    public ModelAndView getUserList(){
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.getRoleList();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("role-list");
        return  modelAndView;
    }

    @RequestMapping("/saveRole")
    public String saveRole(Role role){
        roleService.saveRole(role);
        return "redirect:/role/getList";
    }
}
