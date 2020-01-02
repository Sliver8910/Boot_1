package com.ruda.b1.member;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ruda.b1.util.FilePathGenerator;
import com.ruda.b1.util.FileSaver;

@Service
public class MemberSerivce {

		@Autowired
		private MemberMapper memberMapper;
		@Autowired
		private FilePathGenerator filePathGenerator;
		@Autowired
		private FileSaver fileSaver;
		@Autowired MemberFilesMapper memberFilesMapper;
		
		
		public int memberJoin(MemberVO memberVO, MultipartFile files)throws Exception{
			//파일을 저장할 폴더
			File file = filePathGenerator.getUseClasspathResource("upload");
			
			String fileName = fileSaver.save(file, files);
			System.out.println(fileName);
			
			int result = memberMapper.memberJoin(memberVO);
			
			MemberFilesVO memberFilesVO = new MemberFilesVO();
			memberFilesVO.setId(memberVO.getId());
			memberFilesVO.setFname(fileName);
			memberFilesVO.setOname(files.getOriginalFilename());
			
			result = memberFilesMapper.memberFilesInsert(memberFilesVO);
			
			
			return result;
			
		}
		
		//member Login
		public MemberVO memberLogin(MemberVO memberVO)throws Exception{
			return memberMapper.memberLogin(memberVO);
		}
		
		//memberPage
		public MemberFilesVO memberFilesSelect(MemberFilesVO memberFilesVO)throws Exception{
			return memberFilesMapper.memberFilesSelect(memberFilesVO);
		}
		
		public MemberFilesVO memberFilesSelect2(MemberFilesVO memberFilesVO)throws Exception{
			return memberFilesMapper.memberFilesSelect2(memberFilesVO);
		}
}
