package com.ruda.b1.notice;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ruda.b1.member.MemberFilesVO;
import com.ruda.b1.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	@ModelAttribute(name = "noticeVO")
	public NoticeVO getNoticeVO() {
		return new NoticeVO();
	}

	@GetMapping("noticeWrite")
	public String noticeWrite(Model model) throws Exception {
		model.addAttribute("noticeVO", new NoticeVO());
		return "notice/noticeWrite";
	}

	@PostMapping("noticeWrite")
	public ModelAndView noticeWrite(@Valid NoticeVO noticeVO,MultipartFile [] files ,BindingResult bindingResult) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			mv.setViewName("notice/noticeWrite");
		}else {
			int result = noticeService.noticeWrite(noticeVO, files);
			String message="Write fail";
			String path="../"; 
			if(result == 1 ) {
				message="Write Success"; 
			} 
			mv.setViewName("common/result");
			mv.addObject("message", message);
			mv.addObject("path", path);
			
		}
		return mv;
	}
	
	@GetMapping("noticeList")
	public ModelAndView noticeList(Pager pager)throws Exception{
		ModelAndView mv= new ModelAndView();
		
		List<NoticeVO> ar= noticeService.noticeList(pager);
		
		
		mv.addObject("list", ar);
		mv.addObject("pager" ,pager);
		mv.setViewName("notice/noticeList");
		
		return mv;
	}
	
	@GetMapping("noticeSelect")
	public ModelAndView noticeSelect(NoticeVO noticeVO, NoticeFilesVO noticeFilesVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		noticeVO = noticeService.noticeSelect(noticeVO);
		noticeFilesVO.setNum(noticeVO.getNum());
		List<NoticeFilesVO> ar = noticeService.noticeFilesSelect(noticeFilesVO);
		
		mv.addObject("files", ar);
		mv.addObject("notice", noticeVO);
		mv.setViewName("notice/noticeSelect");
		return mv;
	}
	
	@GetMapping("noticeFileDown")
	public ModelAndView noticeFileDown(NoticeFilesVO noticeFilesVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		noticeFilesVO = noticeService.noticeFilesDown(noticeFilesVO);
		if(noticeFilesVO!= null) {
			mv.addObject("noticeFiles", noticeFilesVO);
			mv.addObject("path", "notice");
			mv.setViewName("fileDown"); // 파일 다운로드
		}else {
			mv.addObject("message","No Image");
			mv.addObject("path", "./noticeSelect");
			mv.setViewName("common/result");
		}
		return mv;
	}
}
