package com.fengling.yjd.controller;

import com.fengling.yjd.entity.R;
import com.fengling.yjd.entity.Video;
import com.fengling.yjd.service.IVideoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: dapyz
 * @Description:
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
@RestController
@RequestMapping("/video")
public class VideoController {

    @Resource
    private IVideoService videoService;
    /**
     * @Author: dapyz
     * @Description: 按ID查找视频信息
     * @Date: 2022/6/20 23:59
     */
    @GetMapping("/findinfo")
    public R detail(Integer Vid){
        Video video = videoService.getById(Vid);
        Map<String,Object> map = new HashMap<>();
        map.put("message",video);
        return R.ok(map);
    }
}
