package com.ruda.b1.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;



@SpringBootTest
@Transactional
@Rollback
class memberTest {
	
	@Autowired
	private MemberMapper memberMepper;
	
	@Test
	public void memberJoinTest() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("iu13");
		memberVO.setName("iu13");
		memberVO.setEmail("iu13@iu13");
		memberVO.setPw("iu13");
		
		
		int result = memberMepper.memberJoin(memberVO);
	}
		
	}
