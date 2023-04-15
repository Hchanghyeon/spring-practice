package spring.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template"; // viewResolver를 통해 동작
    }

    @GetMapping("hello-string")
    @ResponseBody // HTTP의 BODY에 문자 내용을 직접 반환, ViewResolver가 아닌 HttpMessageConverter가 동작
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; // "hello spring"
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // ResponseBody일 때 string 값이면 그대로 String으로 전달하지만 객체일 경우 json으로 반환함(StringConverter, JsonConverter)
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
