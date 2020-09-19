package uniloft.springframework.springrecipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"/", "", "index", "index.html", "privet"})
    public String getIndexPage() {
        System.out.println("Some to say...123433322 ssss 111 222");
        return "index";
    }

}
