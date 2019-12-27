package com.ruda.b1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberSerivce {

		@Autowired
		private MemberMapper memberMapper;
		
		public int memberJoin(MemberVO memberVO)throws Exception{
			return memberMapper.memberJoin(memberVO);
			
		}
}
