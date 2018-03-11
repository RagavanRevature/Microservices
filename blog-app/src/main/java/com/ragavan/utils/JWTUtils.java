package com.ragavan.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JWTUtils {

  @Value("${jwt.issuer}")
  private String ISSUER;

  @Value("${jwt.secretKey}")
  private String SECRET_KEY;

  @Value("${jwt.minutesToLive}")
  private int minutesToLive;

  @Value("${jwt.regeneration}")
  private int regeneration;

  private Date getExpiresAt() {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.MINUTE, minutesToLive);
    Date expiresAt = calendar.getTime();
    return expiresAt;
  }

  private Claims getAllClaimsFromToken(String token) {
    return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
  }

  private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = getAllClaimsFromToken(token);
    return claimsResolver.apply(claims);
  }

  public String createToken(String userName) {
    try {
      return Jwts.builder()
          .setId("f815bca7-f467-4713-828b-7ea709869ba2")
          .setIssuedAt(new Date())
          .setExpiration(getExpiresAt())
          .claim("UserName", userName)
          .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes("UTF-8"))
          .compact();
    } catch (UnsupportedEncodingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  public Claims verifyToken(String token) {
    try {
      return Jwts.parser()
          .setSigningKey(SECRET_KEY.getBytes("UTF-8"))
          .parseClaimsJws(token)
          .getBody();
    } catch (SignatureException e) {

      // don't trust the JWT!
    } catch (ExpiredJwtException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (UnsupportedJwtException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (MalformedJwtException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  public String refreshToken(String token) {
    final Claims claims = getAllClaimsFromToken(token);
    claims.setIssuedAt(new Date());
    claims.setExpiration(getExpiresAt());

    return Jwts.builder()
        .setClaims(claims)
        .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
        .compact();
  }

  public Boolean isTokenExpired(String token) {
    final Date expiration = getExpirationDateFromToken(token);
    return expiration.before(new Date());
  }

  public Date getIssuedAtDateFromToken(String token) {
    return getClaimFromToken(token, Claims::getIssuedAt);
  }

  public Date getExpirationDateFromToken(String token) {
    return getClaimFromToken(token, Claims::getExpiration);
  }

  public String getAudienceFromToken(String token) {
    return getClaimFromToken(token, Claims::getAudience);
  }
}
