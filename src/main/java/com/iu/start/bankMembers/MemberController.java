package com.iu.start.bankMembers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller   //이 클래스는 Controller역할, Container에게 이 클래스의 객체를 생성 위임
@RequestMapping(value="/member/*")
public class MemberController {
	
	// annotation  @:설명+실행
	
	//	/member/login 실행해야하는 메서드
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		System.out.println("로그인 실행");
		
		return "member/login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(BankMembersDTO bankMembersDTO) {
		System.out.println("DBd에 로그인 실행");
		// "redirect:다시접속할URL주소(절대경로,상대경로)"
		return "redirect:../";
	}
	
	//join  /member/join       절대경로 작성
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() {
		System.out.println("JOIN GET 실행");
		
		return "member/join";
	}
	
	//Post
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(HttpServletRequest request) throws Exception {
		System.out.println("JOIN POST 실행");
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		
		String username = request.getParameter("username");
		bankMembersDTO.setUsername(username);
		bankMembersDTO.setPassword(request.getParameter("password"));
		bankMembersDTO.setName(request.getParameter("name"));
		bankMembersDTO.setEmail(request.getParameter("email"));
		bankMembersDTO.setPhone(request.getParameter("phone"));
		
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		System.out.println(result==1);
		return "redirect:./login";
		
	}
	
	@RequestMapping(value="search", method=RequestMethod.GET)
	public void getSearchByID()throws Exception{
		//ModelAndView mv = new ModelAndView();
		//mv.setViewName("member/search");
		//return mv;//"member/search";
	}

	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String getSearchByID(String search, Model model)throws Exception{
//		BankMembersDAO bankMembersDAO = new BankMembersDAO();
//		ArrayList<BankMembersDTO> ar= bankMembersDAO.getSearchByID(search);

		ArrayList<BankMembersDTO> ar = new ArrayList<BankMembersDTO>();

		model.addAttribute("list", ar);
		return "member/list";
	}
	//post
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO) throws Exception {
		System.out.println("JOIN POST 실행");
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		System.out.println(result==1);
		return "member/join";
	}

}
