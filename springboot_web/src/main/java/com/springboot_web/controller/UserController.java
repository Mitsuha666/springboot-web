package com.springboot_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        Model model, RedirectAttributes redirectAttributes, HttpSession session){
        if(password.equals("123456")){
            session.setAttribute("username", username);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg", "用户名或密码错误！");
//           redirectAttributes.addFlashAttribute("msg", "用户名或密码错误！"); //重定向要用RedirectAttributes替代Model
//           return "redirect:/index.html";                                           //否则接收不到msg
             return "index";
        }
    }

    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }
}
