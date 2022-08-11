package com.iu.start.bankBook;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView delete(BankBookDTO bankBookDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		BankBookDAO bankBookDAO = new BankBookDAO();
		
		System.out.println(bankBookDTO.getBookNum());
		
		int result = bankBookDAO.setDelete(bankBookDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	
	
	@RequestMapping(value="update", method = RequestMethod.GET)
	public void update (BankBookDTO bankBookDTO, Model model) throws Exception{
		System.out.println("update GET 실행");
		BankBookDAO bankBookDAO = new BankBookDAO();
		System.out.println(bankBookDTO.getBookNum());
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		model.addAttribute("bankBookDTO", bankBookDTO);
			
	}
	
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String update (BankBookDTO bankBookDTO) throws Exception{
		System.out.println("update POST 실행");
		BankBookDAO bankBookDAO = new BankBookDAO();
		int result = bankBookDAO.setUpdate(bankBookDTO);
		
		return "redirect:./detail?bookNum="+bankBookDTO.getBookNum();
	}
	
	
	// /bankbook/add POST
		// name, rate
		@RequestMapping(value="add", method=RequestMethod.POST)
		public ModelAndView add(BankBookDTO bankBookDTO)throws Exception{
			ModelAndView mv = new ModelAndView();
			BankBookDAO bankBookDAO = new BankBookDAO();
			System.out.println("add POST 실행");
			int result = bankBookDAO.setBankBook(bankBookDTO);

			
			System.out.println(bankBookDTO.getBookName());
			System.out.println(bankBookDTO.getBookRate());
			//등록후 list 페이지로 이동
			mv.setViewName("redirect:./list");
			
			return mv;
		}
		
		// /bankbook/add GET /WEB-INF/views/bankbook/add.jsp
		@RequestMapping(value="add", method=RequestMethod.GET)
		public void add()throws Exception{
			System.out.println("add 실행");
			//return "bankbook/add";
		}
		
		@RequestMapping(value="list", method=RequestMethod.GET)
		public String list(Model model) throws Exception {
			//ModelAndView mv = new ModelAndView();
			System.out.println("list 실행");
			BankBookDAO bankBookDAO = new BankBookDAO();
			//DB 없으신 분들
			ArrayList<BankBookDTO> ar = bankBookDAO.getList();
			
			model.addAttribute("list", ar);
			return "bankbook/list";
		}
		
		@RequestMapping(value = "detail", method = RequestMethod.GET)
		public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception {
			ModelAndView mv = new ModelAndView();
			System.out.println("detail 실행");
			
			BankBookDAO bankBookDAO = new BankBookDAO();
			bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
			
			mv.setViewName("bankbook/detail");
			mv.addObject("bankBookDTO", bankBookDTO);
			
			return mv;
			
		}
	
}
