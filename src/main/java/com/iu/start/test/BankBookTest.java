package com.iu.start.test;

import com.iu.start.bankBook.BankBookDAO;
import com.iu.start.bankBook.BankBookDTO;

public class BankBookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankBookDTO bankBookDTO = new BankBookDTO();
		BankBookDAO bankBookDAO = new BankBookDAO();
		
		bankBookDTO.setBookNum(11L);
		try {
			bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
			System.out.println(bankBookDTO != null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
