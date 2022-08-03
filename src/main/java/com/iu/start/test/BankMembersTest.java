package com.iu.start.test;

import java.util.ArrayList;

import com.iu.start.bankMembers.BankMembersDAO;
import com.iu.start.bankMembers.BankMembersDTO;

public class BankMembersTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		
		//bankMembersDTO.setUsername("ID4");
		//bankMembersDTO.setPassword("PW4");
		//bankMembersDTO.setName("A4");
		//bankMembersDTO.setEmail("DDD");
		//bankMembersDTO.setPhone("0104444");
		
		int result;
		try {
			//result = bankMembersDAO.setJoin(bankMembersDTO);
			//System.out.println(result == 1);
			ArrayList<BankMembersDTO> ar = bankMembersDAO.getSearchByID("D");
			System.out.println(ar.size()>0); //true면 값이 있음, false면 값이 없음
			
			for(int i=0;i<ar.size();i++) {
				System.out.println(ar);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
