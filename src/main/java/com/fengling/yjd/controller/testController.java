package com.fengling.yjd.controller;


import com.fengling.yjd.entity.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fengling")
public class testController {

    @GetMapping("/test")
    public R test(){
        return R.ok("牛批fengling");
    }
}
