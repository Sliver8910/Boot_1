package com.ruda.b1.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;



@SpringBootTest
class memberTest {
	
	@Autowired
	private MemberMapper memberMepper;
	
	@Test
	public void memberJoinTest() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("iu3");
		memberVO.setName("iu3");
		memberVO.setEmail("iu3@iu3");
		memberVO.setPw("iu3");
		
		
		int result = memberMepper.memberJoin(memberVO);
	}
		
	}
