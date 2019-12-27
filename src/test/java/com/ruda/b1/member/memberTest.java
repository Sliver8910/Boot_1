package com.ruda.b1.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;



@SpringBootTest
class memberTest {
	
	@Autowired
	private MemberMapper membermapper;
	

	@Test
	void test() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("iu2");
		memberVO.setEmail("iu2@iu.com");
		memberVO.setName("iu2");
		memberVO.setPw("iu2");
		int result = membermapper.memberJoin(memberVO);
		
		
		assertEquals(1, result);
		
		
	}

}
