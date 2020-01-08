package com.ruda.b1.notice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class noticeTest {

	@Autowired
	private NoticeMapper noticeMapper;
	@Test
	public void test() throws Exception{
		for(int i=0; i<30 ; i++) {
			NoticeVO noticeVO = new NoticeVO();
			noticeVO.setTitle("title"+i);
			noticeVO.setWriter("writer"+i);
			noticeVO.setContents("contents"+i);
			int result = noticeMapper.noticeWrite(noticeVO);
		}
		
	}

}
