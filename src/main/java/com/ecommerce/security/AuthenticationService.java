package com.ecommerce.security;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationService {
	static final long EXPIRATIONTIME = 864_000_00; // 1 day in milliseconds
	static final String SIGNINGKEY = "SecretKey";
	static final String PREFIX = "Bearer";

	// creates the token and adds it to the request's 'Authorization' header
	static public void addToken(HttpServletResponse res, Authentication authResult) {
		String JwtToken = Jwts.builder().setSubject(authResult.getName())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
				.signWith(SignatureAlgorithm.HS512, SIGNINGKEY).compact();
		res.addHeader("Authorization", PREFIX + " " + JwtToken);
		// enable to access the 'Authorization' header through a JavaScript front-end
		res.addHeader("Access-Control-Expose-Headers", "Authorization");
	}

	static public String getUsernameFromToken(HttpServletRequest request) {
		// gets the token from the response 'Authorization' header
		String token = request.getHeader("Authorization");
		if (token != null) {
			return Jwts.parser().setSigningKey(SIGNINGKEY).parseClaimsJws(token.replace(PREFIX, "")).getBody()
					.getSubject();
		}
		return null;
	}

	static public Authentication getAuthentication(HttpServletRequest request, UserDetails userDetails) {
		// gets the token from the response 'Authorization' header
		String token = request.getHeader("Authorization");
		if (token != null) {
			return new UsernamePasswordAuthenticationToken(getUsernameFromToken(request), null,
					userDetails.getAuthorities());
		}
		return null;
	}

}
