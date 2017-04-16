package org.youssbanque.web;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.youssbanque.YoussBanqueApplication;

public class WebInitializer extends SpringBootServletInitializer{
 @Override
protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	// TODO Auto-generated method stub
	return builder.sources(YoussBanqueApplication.class);
}
}
