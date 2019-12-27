package com.ruda.b1.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
public interface MemberMapper {
	
	public int memberJoin(MemberVO memberVO)throws Exception;
	
}
