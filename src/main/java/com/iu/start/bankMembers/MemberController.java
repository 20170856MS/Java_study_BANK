package com.iu.start.bankMembers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller   //이 클래스는 Controller역할, Container에게 이 클래스의 객체를 생성 위임
@RequestMapping(value="/member/*")
public class MemberController {
	
	// annotation  @:설명+실행
	
	//	/member/login 실행해야하는 메서드
	@RequestMapping(value = "/member/login")
	public String login() {
		System.out.println("로그인 실행");
		
		return "member/login";
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
		return "member/join";
	}
	
	//post
//	@RequestMapping(value = "join", method = RequestMethod.POST)
//	public String join(BankMembersDTO bankMembersDTO) throws Exception {
//		System.out.println("JOIN POST 실행");
//		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		
//		int result = bankMembersDAO.setJoin(bankMembersDTO);
//		System.out.println(result==1);
//		return "member/join";
//	}

}
