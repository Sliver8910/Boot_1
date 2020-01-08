package com.ruda.b1.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.ruda.b1.member.MemberFilesVO;
import com.ruda.b1.notice.NoticeFilesVO;

@Component
public class FileDown extends AbstractView{
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String filePath = (String)model.get("path");
		System.out.println(filePath);
		if(filePath.equals("upload")) {
		MemberFilesVO memberFilesVO =(MemberFilesVO) model.get("memberfiles");
		filePath ="/static/"+filePath;
		ClassPathResource classPathResource = new ClassPathResource(filePath);
		
		File file = new File(classPathResource.getFile(), memberFilesVO.getFname());
		//파일명이 한글일떄 처리
		response.setCharacterEncoding("UTF-8");
		
		//파일 크기
		response.setContentLengthLong(file.length());
		
		//파일을 다운로드시 인코딩 처리
		String fileName = URLEncoder.encode(memberFilesVO.getOname(),"UTF-8");
		
		//header 설정
		response.setHeader("Content-disposition", "attachment;filename=\""+fileName+"\"");
		response.setHeader("Content-transfer-Encoding", "binary");
		
		//outputStream    Stream은 연결까지만 해줌
		FileInputStream fi = new FileInputStream(file);
		// 파일을 출력하는 stream
		OutputStream os = response.getOutputStream();
		
		//파일 출력
		FileCopyUtils.copy(fi, os);
		
		//Stream Close
		
		os.close();
		fi.close();
		}else if(filePath.equals("notice")) {
			NoticeFilesVO noticeFilesVO =(NoticeFilesVO)model.get("noticeFiles");
			filePath ="/static/"+filePath;
			ClassPathResource classPathResource = new ClassPathResource(filePath);
			
			File file = new File(classPathResource.getFile(), noticeFilesVO.getFname());
			//파일명이 한글일떄 처리
			response.setCharacterEncoding("UTF-8");
			
			//파일 크기
			response.setContentLengthLong(file.length());
			
			//파일을 다운로드시 인코딩 처리
			String fileName = URLEncoder.encode(noticeFilesVO.getOname(),"UTF-8");
			
			//header 설정
			response.setHeader("Content-disposition", "attachment;filename=\""+fileName+"\"");
			response.setHeader("Content-transfer-Encoding", "binary");
			
			//outputStream    Stream은 연결까지만 해줌
			FileInputStream fi = new FileInputStream(file);
			// 파일을 출력하는 stream
			OutputStream os = response.getOutputStream();
			
			//파일 출력
			FileCopyUtils.copy(fi, os);
			
			//Stream Close
			
			os.close();
			fi.close();
		}
		
		
	}
	
	

}