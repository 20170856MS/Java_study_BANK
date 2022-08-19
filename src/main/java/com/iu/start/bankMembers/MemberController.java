package com.iu.start.bankMembers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller   //이 클래스는 Controller역할, Container에게 이 클래스의 객체를 생성 위임
@RequestMapping(value="/member/*")
public class MemberController {
	
	// annotation  @:설명+실행
	@Autowired
	private BankMembersService bankMembersService;
	
	
	//	/member/login 실행해야하는 메서드
	@RequestMapping(value = "login.iu", method = RequestMethod.GET)
	public String login() {
		System.out.println("로그인 실행");
		
		return "member/login";
	}
	
	@RequestMapping(value = "login.iu", method = RequestMethod.POST)
	public String login(HttpSession session,BankMembersDTO bankMembersDTO, Model model) throws Exception {
		System.out.println("DB에 로그인 실행");
		bankMembersDTO = bankMembersService.getLogin(bankMembersDTO);
		System.out.println(bankMembersDTO); //로그인 됬는지 확인
		model.addAttribute("member", bankMembersDTO);
		//HttpSession session = request.getSession();
		session.setAttribute("member", bankMembersDTO);
		// "redirect:다시접속할URL주소(절대경로,상대경로)"
		return "redirect:../";
	}
	
	//join  /member/join       절대경로 작성
	@RequestMapping(value = "join.iu", method = RequestMethod.GET)
	public String join() {
		System.out.println("JOIN GET 실행");
		
		return "member/join";
	}
	
	//Post
	@RequestMapping(value = "join.iu", method = RequestMethod.POST)
	public String join(HttpServletRequest request) throws Exception {
		System.out.println("JOIN POST 실행");
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		System.out.println(result==1);
		return "redirect:./login.iu";
		
	}
	
	@RequestMapping(value="search.iu", method=RequestMethod.GET)
	public void getSearchByID()throws Exception{
		//ModelAndView mv = new ModelAndView();
		//mv.setViewName("member/search");
		//return mv;//"member/search";
	}

	@RequestMapping(value = "search.iu", method = RequestMethod.POST)
	public String getSearchByID(String search, Model model)throws Exception{
		List<BankMembersDTO> ar= bankMembersService.getSearchByID(search);
		model.addAttribute("list", ar);
		return "member/list";
	}
	
	@RequestMapping(value="logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		System.out.println("로그아웃 실행");
		session.invalidate();
		return "redirect:../";
		
	}

}
