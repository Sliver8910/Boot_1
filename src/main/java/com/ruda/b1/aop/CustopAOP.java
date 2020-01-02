package com.ruda.b1.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CustopAOP {
	
	@Before("execution(* com.ruda.b1.member.*.memberLogin(..))")
	public void before()throws Exception{
		System.out.println("Before Member Join");
		
	}
}
