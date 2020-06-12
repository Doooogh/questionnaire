package com.xcyg.project.common.shiro;

import com.xcyg.project.common.exception.BusinessException;
import com.xcyg.project.common.exception.code.BaseResponseCode;
import com.xcyg.project.service.RedisService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;


/**
 * 认证
 */
public class CustomHashedCredentialsMatcher extends SimpleCredentialsMatcher {

    @Lazy
    @Autowired
    private RedisService redisDB;
    @Value("${spring.redis.key.prefix.userToken}")
    private String USER_TOKEN_PREFIX;

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String accessToken = (String) token.getPrincipal();
        if (!redisDB.exists(USER_TOKEN_PREFIX + accessToken)) {
            SecurityUtils.getSubject().logout();
            throw new BusinessException(BaseResponseCode.TOKEN_ERROR);
        }
        return true;
    }
}
