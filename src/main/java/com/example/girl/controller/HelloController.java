package com.example.girl.controller;

import com.example.girl.Properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    @GetMapping(value = "/say")
    public String run(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){
            return "id: " + id;
    }
}
