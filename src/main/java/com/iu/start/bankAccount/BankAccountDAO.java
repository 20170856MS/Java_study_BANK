package com.iu.start.bankAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.iu.start.util.DBConnector;

public class BankAccountDAO {
	
	public int add(BankAccountDTO bankAccountDTO) throws Exception {
		
		//1.DB연결
		Connection con = DBConnector.getConnection();
		//2.QUERY문 작성
		String sql = "INSERT INTO BANKACCOUNT VALUES (ACCOUNT_SEQ.NEXTVAL, ?, ?, SYSDATE)";
		//3.데이터미리전송	
		PreparedStatement st = con.prepareStatement(sql);
		//4.?값처리
		st.setString(1,bankAccountDTO.getUserName());
		st.setLong(2, bankAccountDTO.getBookNum());
		//5.최종전송 및 결과처리
		int result = st.executeUpdate();				
		//6.자원해제
		DBConnector.disConnect(st, con);
		return result;
	}
}
