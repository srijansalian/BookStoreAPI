package com.bridgelabz.bookstore.utility;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Component
public class Jwt {

	private static final String SECRET_KEY = "6360803337";

	public String getToken(Long userid) {
		String token = null;
		try {
			token = JWT.create().withClaim("id", userid).sign(Algorithm.HMAC256(SECRET_KEY));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return token;
	}

	public Long getId(String token) {

		Long userid = (long) 0;
		if (token != null) {
			userid = JWT.require(Algorithm.HMAC256(SECRET_KEY)).build().verify(token).getClaim("id").asLong();
		}
		return userid;

	}

}
