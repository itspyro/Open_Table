package com.example.opentable.jwt;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class ValidateToken {

	private final String SECRET = "PFcxCgZC3MRJvNmGzZHnzuwe3FH52Uru5c7EZ4VZC0o=";
	
	public int parseJWT(String jwt) throws Exception {
		
		int userId;
		
		SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET));
		
		Jws<Claims> jws;
		
		try {
			
			jws = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt);
			
			userId = (int) jws.getBody().get("userId");
			
		} catch (Exception e) {
			
			throw e;
		}
		return userId;
	}
}
