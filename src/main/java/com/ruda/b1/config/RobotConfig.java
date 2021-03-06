package com.ruda.b1.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ruda.b1.robot.LeftArm;
import com.ruda.b1.robot.RightArm;

@Configuration
public class RobotConfig {
	@Bean("left")
	public LeftArm getLeftArm()throws Exception{
		LeftArm leftArm = new LeftArm();
		
		return leftArm;
	}
	
	@Bean
	public RightArm getRightArm() throws Exception{
		return new RightArm();
	}
	
}
