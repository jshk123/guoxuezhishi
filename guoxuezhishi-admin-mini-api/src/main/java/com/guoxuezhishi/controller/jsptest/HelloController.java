package com.guoxuezhishi.controller.jsptest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: jiang
 * @date: 2019/8/26
 */
@Controller
public class HelloController {
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("msg", "this is jsp!");
        return "index.jsp";
    }

}
