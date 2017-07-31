package com.example.demo.controller;

import com.example.demo.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

/**
 * Created by fankun.zfk on 2017/7/20.
 */

@RestController
@RequestMapping(value="/hello")
public class HelloContriller {
//通过value注解把application.yml中的cupSize的值读出来
    @Autowired
    private GirlProperties girlProperties;

    //@RequestMapping(value = "/say",method = RequestMethod.GET)
    @GetMapping(value = "/say")
    public String say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){
        return "id: "+id;
    }
}
