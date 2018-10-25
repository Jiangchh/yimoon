package com.yimoom.pplay.service.impl;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.yimoom.pplay.constants.Constants;
import com.yimoom.pplay.domain.TokenEntity;
import com.yimoom.pplay.service.TokenService;

/**
 * @author sukaiyi
 */
@Component
public class RedisTokenServiceImpl implements TokenService {

    @Autowired
    RedisTemplate<String, TokenEntity> redisTemplate;

    @Override
    public TokenEntity createToken(String userId) {
        String token = UUID.randomUUID().toString();
        TokenEntity tokenEntity = new TokenEntity(userId, token);
        redisTemplate.opsForValue().set(userId, tokenEntity, Constants.TOKEN_EXPIRES_HOUR, TimeUnit.MINUTES);
        return tokenEntity;
    }

    @Override
    public boolean checkToken(TokenEntity entity) {
        if (entity == null) {
            return false;
        }
        TokenEntity token = redisTemplate.opsForValue().get(entity.getUserId());
        if (token == null || StringUtils.isEmpty(token.getToken())) {
            return false;
        }
        return token.getToken().equals(entity.getToken());
    }

    @Override
    public TokenEntity getToken(String authentication) {
        //      userId 为32位字符串
        //      userId拼接token得到authentication
        //      所以要求authentication长度大于32
        if (!StringUtils.isEmpty(authentication) && authentication.length() > 32) {
            TokenEntity tokenEntity = new TokenEntity();
            String userId = authentication.substring(0, 32);
            String token = authentication.substring(32);
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            return tokenEntity;
        }
        return null;
    }

    @Override
    public void deleteToken(String userId) {
        redisTemplate.delete(userId);
    }
}

