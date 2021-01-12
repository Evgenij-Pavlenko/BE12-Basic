package com.example.hallowebworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @RequestMapping(value = "/hello-mvc/{name}", method = RequestMethod.GET)
    public String hello(@PathVariable String name, Model model) {
        model.addAttribute("text", "Hello, " + name);
        return "hello-mvc";
    }
    @RequestMapping(value = "/hello-simple/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String helloSimpleText(@PathVariable String name){
        return "Hello simple, " + name;
    }
    @RequestMapping(value = "/hello-json/{name}", method = RequestMethod.GET)
    @ResponseBody
    public JsonName helloJsonText(@PathVariable String name){
        JsonName jsonName = new JsonName(name);
        return jsonName;
    }

    @RequestMapping(value = "/hello-json", method = RequestMethod.POST)
    @ResponseBody
    public JsonName helloJsonText(@RequestBody JsonName incomingDate){
        incomingDate.name = "Hello, " + incomingDate.name;
        return incomingDate;
    }
}
