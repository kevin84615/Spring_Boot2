package com.tuyano.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2Conifg {

	@Bean
	MyDataBean myDataBean(){
		return new MyDataBean();
	}
}