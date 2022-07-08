package com.investree.demo.repository.oauth;

import com.investree.demo.model.oauth.OauthUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OauthUserRepository extends PagingAndSortingRepository<OauthUser, Long> {
    @Query("FROM OauthUser u WHERE LOWER(u.username) = LOWER(?1)")
    OauthUser findOneByUsername(String username);

    @Query("FROM OauthUser u WHERE u.otp = ?1")
    OauthUser findOneByOTP(String otp);

    @Query("FROM OauthUser u WHERE LOWER(u.username) = LOWER(:username)")
    OauthUser checkExistingEmail(String username);
}
