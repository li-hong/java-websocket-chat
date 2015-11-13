package com.youle.chat;

import com.youle.utils.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by modprobe on 2015/11/12.
 */
@Controller
@RequestMapping("/chat")
public class ChatController {
    @RequestMapping("/index")
    public String printWelcome(HttpServletRequest request, ModelMap model, String nickName) {
        HttpSession session = request.getSession();
        session.setAttribute(Constant.NICK_NAME_KEY, nickName);
        model.addAttribute("message", "Hello world!");
        return "/index";
    }
}
