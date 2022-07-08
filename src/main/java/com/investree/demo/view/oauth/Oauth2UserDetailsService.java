package com.investree.demo.view.oauth;

import com.investree.demo.model.oauth.OauthUser;
import com.investree.demo.repository.oauth.OauthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class Oauth2UserDetailsService implements UserDetailsService{

    @Autowired
    private OauthUserRepository oauthUserRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        OauthUser dataUser = oauthUserRepository.findOneByUsername(s);
        if (null == dataUser) {
            throw new UsernameNotFoundException(String.format("Username %s is not found", s));
        }

        return dataUser;
    }

    @CacheEvict("oauth_username")
    public void clearCache(String s) {
    }
}
