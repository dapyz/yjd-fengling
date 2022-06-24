package com.fengling.yjd.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: dapyz
 * @Description:
 * @Date: 2022/6/19 22:53
 * @Group: fengling
 */
@Component
@ConfigurationProperties(prefix = "weixin")
@Data
public class WeixinProperties {

    private String jscode2sessionUrl; // 登录凭证校验请求地址

    private String appid; // 小程序 appId

    private String secret; // 小程序 appSecret


}
