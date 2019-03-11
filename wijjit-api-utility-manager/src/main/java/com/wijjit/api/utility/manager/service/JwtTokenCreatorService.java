package com.wijjit.api.utility.manager.service;

import com.wijjit.api.utility.manager.models.TokenType;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtTokenCreatorService {
    private static Logger logger = LoggerFactory.getLogger(JwtTokenCreatorService.class);

    @Value("${com.wijjit.jwt.issuer}")
    private String jwtIssuer;

    public JwtTokenCreatorService() {
    }

    /**********************************************************************************************************************
     * * Creates the JWT token for the user.
     *
     * @param userId
     * @return
     */
    public String createJwtWijjitToken(String userId, TokenType tokenType) throws InterruptedException {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        Date nowPlusTime = new Date(nowMillis + 10080 * 60 * 1000);

        JwtBuilder builder = Jwts.builder()
                .setIssuedAt(now)
                .setAudience(userId)
                .setSubject(tokenType.toString())
                .setIssuer(jwtIssuer)
                .setExpiration(nowPlusTime).signWith(SignatureAlgorithm.HS256,
                        "1938473939A83729DBEIO847PEMAMDIEY3847DELISOS102930RUYVBN29394001");
        //"wjt_skprod_877d804c_6fc9_4801_a555_0c321352ab72XXXX");
        return builder.compact();
    }
}
