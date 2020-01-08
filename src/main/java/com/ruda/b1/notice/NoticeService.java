package com.ruda.b1.notice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ruda.b1.util.FilePathGenerator;
import com.ruda.b1.util.FileSaver;
import com.ruda.b1.util.Pager;

@Service
public class NoticeService {
	@Autowired
	private NoticeMapper noticeMapper;
	@Autowired
	private FilePathGenerator filePathGenerator;
	@Autowired
	private FileSaver fileSaver;
	@Autowired
	 NoticeFilesMapper noticeFilesMapper;
	
	
	public NoticeFilesVO noticeFilesDown(NoticeFilesVO noticeFilesVO)throws Exception{
		return noticeFilesMapper.noticeFilesDown(noticeFilesVO);
	}
	
	public NoticeVO noticeSelect(NoticeVO noticeVO)throws Exception{
		
		return noticeMapper.noticeSelect(noticeVO);
	}
	
	public List<NoticeFilesVO> noticeFilesSelect(NoticeFilesVO noticeFilesVO)throws Exception{
		
		List<NoticeFilesVO> ar = noticeFilesMapper.noticeFilesSelect(noticeFilesVO);
		return ar;
	}
	
	public List<NoticeVO> noticeList(Pager pager) throws Exception{
		System.out.println(pager.getKind());
		System.out.println(pager.getSearch());
		pager.makeRow();
		pager.makePage(noticeMapper.noticeCount(pager));
		return noticeMapper.noticeList(pager);
	}
	
	
	 @Transactional
	public int noticeWrite(NoticeVO noticeVO, MultipartFile [] files)throws Exception{
		File file = filePathGenerator.getUseClasspathResource("notice");
		int result = noticeMapper.noticeWrite(noticeVO);
		
		for (int i=1; i<files.length; i ++) {
			String fileName = fileSaver.save(file, files[i]);
			NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
			noticeFilesVO.setNum(noticeVO.getNum());
			noticeFilesVO.setFname(fileName);
			noticeFilesVO.setOname(files[i].getOriginalFilename());
			//mapper 호출 저장
			result = noticeFilesMapper.noticeFilesInsert(noticeFilesVO);
		}
		
		return result;
	} 
	
	 /*@Transactional
	public int noticeWrite(NoticeVO noticeVO, MultipartFile [] files)throws Exception{
		File file = filePathGenerator.getUseClasspathResource("notice");
		int result = noticeMapper.noticeWrite(noticeVO);
		
		List<NoticeFilesVO> noticeFilesVOs = new ArrayList<>();
		for (int i=1; i<files.length; i ++) {
			String fileName = fileSaver.save(file, files[i]);
			NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
			noticeFilesVO.setNum(noticeVO.getNum());
			noticeFilesVO.setFname(fileName);
			noticeFilesVO.setOname(files[i].getOriginalFilename());
			//mapper 호출 저장
			result = noticeFilesMapper.noticeFilesInsert(noticeFilesVOs);
		}
		
		return result;
	}*/

}
