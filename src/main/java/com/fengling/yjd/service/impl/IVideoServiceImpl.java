package com.fengling.yjd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.yjd.entity.Video;
import com.fengling.yjd.mapper.VideoMapper;
import com.fengling.yjd.service.IVideoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: dapyz
 * @Description:上传的video的service实现类
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
@Service
public class IVideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements IVideoService {

    @Resource
    private VideoMapper videoMapper;
}
