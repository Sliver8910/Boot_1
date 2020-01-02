package com.ruda.b1.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	@Autowired
	private MemberSerivce memberSerivce;
	
	@GetMapping("memberJoin")
	public String memberJoin()throws Exception{
		return "member/memberJoin";
	}
	
	@PostMapping("memberJoin")
	public ModelAndView memberJoin(MemberVO memberVO, MultipartFile files)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = memberSerivce.memberJoin(memberVO, files);
		String message="Join fail";
		String path="../";
		if(result>0) {
			message="Join Success";
		}
		mv.setViewName("common/result");
		mv.addObject("message", message);
		mv.addObject("path", path);
		return mv;
	}
	
	@GetMapping("memberLogin")
	public String memberLogin()throws Exception{
		return "member/memberLogin";
	}
	
	@PostMapping("memberLogin")
	public ModelAndView memberLogin(MemberVO memberVO, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		memberVO = memberSerivce.memberLogin(memberVO);
		String message="Login fail";
		String path="../";
		if(memberVO !=null ) {
			message="Login Success";
			session.setAttribute("member", memberVO);
		}
		mv.setViewName("common/result");
		mv.addObject("message", message);
		mv.addObject("path", path);
		return mv;
	}
	
	@GetMapping("memberPage")
	public ModelAndView memberPage(MemberFilesVO memberFilesVO, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		
		System.out.println(memberVO.getId());
		memberFilesVO.setId(memberVO.getId());
		memberFilesVO = memberSerivce.memberFilesSelect(memberFilesVO);
		System.out.println(memberFilesVO.getFname());
		mv.addObject("fnum", memberFilesVO.getFnum());
		mv.addObject("fname", memberFilesVO.getFname());
		mv.setViewName("member/memberPage");
		return mv;
	}
	
	@GetMapping("memberFileDown")
	public ModelAndView memberFileDown(MemberFilesVO memberFilesVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		memberFilesVO = memberSerivce.memberFilesSelect2(memberFilesVO);
		if(memberFilesVO != null) {
			mv.addObject("memberfiles", memberFilesVO);
			mv.addObject("path", "upload");
			mv.setViewName("fileDown"); //util의 파일 다운로드
		}else {
			mv.addObject("message","No Image");
			mv.addObject("path", "./memberPage");
			mv.setViewName("common/result");
		}
		return mv;
	}
	
	@GetMapping("memberLogout")
	public String memberLogout(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:../";
	};

}
