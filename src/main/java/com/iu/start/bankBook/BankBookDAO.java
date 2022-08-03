package com.iu.start.bankBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.start.util.DBConnector;

public class BankBookDAO {

	public int setBankBook(BankBookDTO bankBookDTO)throws Exception{
		
		//1.DB연결
		Connection con = DBConnector.getConnection();
		//2.QUERY문 작성
		String sql = "INSERT INTO BANKBOOK VALUES(?, ? , ?, ?)";
		//3.데이터미리전송	
		PreparedStatement st = con.prepareStatement(sql);
		//4.?값처리
		
		//5.최종전송 및 결과처리
		int result = st.executeUpdate();
		BankBookDTO bankbookDTO = new BankBookDTO();
		bankbookDTO.getBookName();
		//6.자원해제
		DBConnector.disConnect(st, con);
		
		return result;
	}
	
	public ArrayList<BankBookDTO> getList()throws Exception{
		ArrayList<BankBookDTO> ar = new ArrayList();
		//1.DB연결
		Connection con = DBConnector.getConnection();
		//2.QUERY문 작성
		String sql = "SELECT * FROM BANKBOOK ORDER BY BOOKRATE ASC";
		//3.데이터미리전송	
		PreparedStatement st = con.prepareStatement(sql);
		//4.?값처리
		
		//5.최종전송 및 결과처리
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			BankBookDTO bankBookDTO = new BankBookDTO();
			
			bankBookDTO.setBookRate(rs.getDouble((int) 3.5));
			bankBookDTO.setBookSale(rs.getInt(1));
		}
		//6.자원해제
		DBConnector.disConnect(rs, st, con);
		return ar;
	}
	
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception{
		//1.DB연결
		Connection con = DBConnector.getConnection();
		//2.QUERY문 작성
		String sql = "UPDATE BANKBOOK SET BOOKSALE = ? WHERE BOOKNUM = ?";
		//3.데이터미리전송	
		PreparedStatement st = con.prepareStatement(sql);
		//4.?값처리
		
		//5.최종전송 및 결과처리
		int result = st.executeUpdate();
		//6.자원해제
		DBConnector.disConnect(st, con);
		return result;
	}
	
	
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception{
		BankBookDTO bankBookDTO2 = null; //리턴할 데이터 준비
		
		//1.DB연결
		Connection con = DBConnector.getConnection();
		//2.QUERY문 작성
		String sql = "SELECT * FROM BANKBOOK WHERE BOOKNUM = ?";
		//3.데이터미리전송	
		PreparedStatement st = con.prepareStatement(sql);
		//4.?값처리
		st.setLong(1, bankBookDTO.getBookNum());
		//5.최종전송 및 결과처리
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			bankBookDTO2 = new BankBookDTO();
			bankBookDTO2.setBookNum(rs.getLong("BOOKNUM"));
			bankBookDTO2.setBookName(rs.getString("BOOKNAME"));
			bankBookDTO2.setBookRate(rs.getDouble("BOOKRATE"));
			bankBookDTO2.setBookSale(rs.getInt("BOOKSALE"));
		}
		//6.자원해제
		DBConnector.disConnect(rs, st, con);

		return bankBookDTO2;
	}
	
}
