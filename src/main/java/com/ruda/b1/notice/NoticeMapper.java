package com.ruda.b1.notice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ruda.b1.util.Pager;

@Mapper
public interface NoticeMapper {
	
	public int noticeWrite(NoticeVO noticeVO)throws Exception;
	
	public List<NoticeVO> noticeList(Pager pager)throws Exception;
	
	public int noticeCount(Pager pager)throws Exception;
	
	public NoticeVO noticeSelect(NoticeVO noticeVO)throws Exception;
}
