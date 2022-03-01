package com.example.opentable.jwt;

import java.util.Date;

import javax.crypto.SecretKey;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class GenerateToken {
	
	private final String SECRET = "PFcxCgZC3MRJvNmGzZHnzuwe3FH52Uru5c7EZ4VZC0o=";
	 
	private final long EXPIRATION_TIME = 3600000;
	
	private final String ISSUER = "Open_Table";

	public String createJWT(int userId) {
		
		long nowMillis = System.currentTimeMillis();
		
		Date now = new Date(nowMillis);
		
		Date exp = new Date(nowMillis + EXPIRATION_TIME);
		
		SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET));
		
		JwtBuilder builder = Jwts.builder();
		
		builder.claim("userId", userId);
		
		builder.setIssuedAt(now).setExpiration(exp).setIssuer(ISSUER).signWith(key);
		
		return builder.compact();
	}
}
