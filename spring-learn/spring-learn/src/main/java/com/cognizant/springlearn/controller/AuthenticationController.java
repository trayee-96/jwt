package com.cognizant.springlearn.controller;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.JwtBuilder; 
import io.jsonwebtoken.Jwts; 
import io.jsonwebtoken.SignatureAlgorithm; 

@RestController
public class AuthenticationController {
	private static final Logger LOGGER=LoggerFactory.getLogger(AuthenticationController.class);
@GetMapping("/authenticate")
public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader ){
	LOGGER.info("START");
	LOGGER.debug(authHeader);
	Map<String,String>map=new HashMap<String, String>();
	String user = getUser(authHeader);
	LOGGER.debug(user);
	//map.put("token", null);
	String jwt = generateJwt(user);
	map.put("token", jwt);
	LOGGER.info("END");
	return map;
}
private String generateJwt(String user) {
	JwtBuilder builder=Jwts.builder();
	builder.setSubject(user);
	builder.setIssuedAt(new Date());
	builder.setExpiration(new Date((new Date()).getTime()+120000));
	builder.signWith(SignatureAlgorithm.HS256,"secretkey");
	String token =builder.compact();
	return token;

}
private String getUser(String authHeader) {
	LOGGER.info("START");
	LOGGER.debug(authHeader);
	byte[] arr=Base64.getDecoder().decode("dXNlcjpwd2Q=");
	String str=new String(arr);
	String subString=str.substring(0,4);
	LOGGER.info("END");
	return subString;
	//return null;
}
}
