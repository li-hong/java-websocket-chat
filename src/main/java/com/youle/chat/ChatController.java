package com.youle.chat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by modprobe on 2015/11/12.
 */
@Controller
@RequestMapping("/chat")
public class ChatController {
    @RequestMapping("/index")
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "/index";
    }
}
