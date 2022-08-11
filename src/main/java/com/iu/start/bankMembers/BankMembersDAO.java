package com.iu.start.bankMembers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.start.util.DBConnector;

public class BankMembersDAO {
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception{
		//1.DB 연결
		Connection con = DBConnector.getConnection();
		//2.QUERY문 작성
		String sql = "SELECT USERNAME, NAME FROM BANKMEMBERS WHERE USERNAME = ? AND PASSWORD = ?";
		//3.데이터 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		//4.?값 처리
		st.setString(1, bankMembersDTO.getUsername());
		st.setString(2, bankMembersDTO.getPassword());
		//5.최종 전송 및 결과를 처리
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			bankMembersDTO = new BankMembersDTO();
			bankMembersDTO.setUsername(rs.getString("USERNAME"));
			bankMembersDTO.setName(rs.getString("NAME"));
		}else {
			bankMembersDTO = null;
			//return null;
		}
		
		//6.자원해제
		DBConnector.disConnect(rs, st, con);
		return bankMembersDTO;
	}
	
	
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception{
		
		//1.DB 연결
		Connection con = DBConnector.getConnection();
		//2.QUERY문 작성
		String sql = "INSERT INTO BANKMEMBERS VALUES (?,?,?,?,?)";
		//3.데이터 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		//4.?값 처리
		st.setString(1, bankMembersDTO.getUsername());
		st.setString(2, bankMembersDTO.getPassword());
		st.setString(3, bankMembersDTO.getName());
		st.setString(4, bankMembersDTO.getEmail());
		st.setString(5, bankMembersDTO.getPhone());
		
		//5.최종 전송 및 결과를 처리
		int result = st.executeUpdate();
		
		//6.자원해제
		DBConnector.disConnect(st, con);
		
		return result;
	}
	
	
	public ArrayList<BankMembersDTO> getSearchByID(String search) throws Exception{
		ArrayList<BankMembersDTO> ar = new ArrayList();
		
		//1.DB연결
		Connection con = DBConnector.getConnection();
		//2.QUERY문 작성
		String sql = "SELECT * FROM BANKMEMBERS WHERE USERNAME LIKE ? ORDER BY USERNAME ASC";
		//3.데이터미리전송												'%||?||%' 
		PreparedStatement st = con.prepareStatement(sql);
		//4.?값처리
		
		//5.최종전송 및 결과처리
		st.setString(1, "%"+search+"%");
		ResultSet rs = st.executeQuery();
		
		
		while(rs.next()) {
			BankMembersDTO bankMembersDTO = new BankMembersDTO();
			bankMembersDTO.setUsername(rs.getString("USERNAME"));
			bankMembersDTO.setPassword(rs.getString("PASSWORD"));
			bankMembersDTO.setName(rs.getString("NAME"));
			bankMembersDTO.setEmail(rs.getString("EMAIL"));
			bankMembersDTO.setPhone(rs.getString("PHONE"));
			ar.add(bankMembersDTO);
		}
		//6.자원해제
		DBConnector.disConnect(rs, st, con);
		return ar;
	}
	
}
