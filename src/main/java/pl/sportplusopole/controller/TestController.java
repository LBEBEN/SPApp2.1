package pl.sportplusopole.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
    public class TestController {
        @RequestMapping("/helloPanel")
        public String hello(){
            return "hello/helloPanel";
        }
    }

