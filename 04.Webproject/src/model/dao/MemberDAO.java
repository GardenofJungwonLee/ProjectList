package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.MemberDTO;
import model.util.DBUtil;

public class MemberDAO {
	
		private MemberDAO() {}
		
		private static MemberDAO instance = new MemberDAO();
		
		static public MemberDAO getInstance() {
			return instance;
		}
	
		public static boolean addMember(MemberDTO member) throws SQLException{
			Connection con = null;
			PreparedStatement pstmt = null;
			try{
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("insert into member values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
				pstmt.setString(1, member.getId());
				pstmt.setString(2, member.getPw());
				pstmt.setString(3, member.getName());
				pstmt.setString(4, member.getAge());
				pstmt.setString(5, member.getSex());
				pstmt.setString(6, member.getBirthday());
				pstmt.setString(7, member.getAddress());
				pstmt.setString(8, member.getJob());
				pstmt.setString(9, member.getHeight());
					
				int result = pstmt.executeUpdate();
			
				if(result == 1){
					return true;
				}
			}finally{
				DBUtil.close(con, pstmt);
			}
			return false;
		}
	
		//수정  
		public static boolean updateMember(String id ,String pw ,String name ,String age ,String birthday ,String address ,String job ,String height
) throws SQLException{
			Connection con = null;
			PreparedStatement pstmt = null;
			try{
				con = DBUtil.getConnection();
				
				pstmt = con.prepareStatement("update Member set pw=?,  name=?,  age=? ,birthday=?  ,address=? , job=? , height=? where id=?");
				pstmt.setString(1, pw);
				pstmt.setString(2, name);
				pstmt.setString(3, age);
				pstmt.setString(4, birthday);
				pstmt.setString(5, address);
				pstmt.setString(6, job);
				pstmt.setString(7, height);
				pstmt.setString(8, id);
				
				int result = pstmt.executeUpdate();
				if(result == 1){
					return true;
				}
			}finally{
				DBUtil.close(con, pstmt);
			}
			return false;
		}

	
		//삭제
		//sql - delete from Member where Member_id=?
		public static boolean deleteMember(String id) throws SQLException{
			Connection con = null;
			PreparedStatement pstmt = null;
			try{
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("delete from member where id=?");
				pstmt.setString(1, id);
				
				int result = pstmt.executeUpdate();
				if(result == 1){
					return true;
				}
			}finally{
				DBUtil.close(con, pstmt);
			}
			return false;
		}
	
		//id로 해당 회원의 모든 정보 반환
		public static MemberDTO getMember(String id) throws SQLException{
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			MemberDTO Member = new MemberDTO();
			
			try{
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from member where id=?");
				pstmt.setString(1, id);
				rset = pstmt.executeQuery();
				if(rset.next()){
					Member = new MemberDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8), rset.getString(9));
				}
			}finally{
				DBUtil.close(con, pstmt, rset);
			}
			return Member;
		}

		//모든 회원 검색해서 반환
		//sql - select * from Member
		public static ArrayList<MemberDTO> getAllMembers() throws SQLException{
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<MemberDTO> list = null;
			try{
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from Member");
				rset = pstmt.executeQuery();
				
				list = new ArrayList<MemberDTO>();
				while(rset.next()){
					list.add(new MemberDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8), rset.getString(9)) );
				}
			}finally{
				DBUtil.close(con, pstmt, rset);
			}
			return list;
		}
		
		// 로그인시 아이디, 비밀번호 체크 메서드
	    // 아이디, 비밀번호를 인자로 받는다.
	    public int loginCheck(String id, String pw){
	    	int result = -1;
	    	String sql = "select pw from member where id=?";
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rset = null;
	        try {
	        	conn = DBUtil.getConnection();
	        	pstmt = conn.prepareStatement(sql);
	        	pstmt.setString(1, id);
	        	
	        	rset = pstmt.executeQuery();
	        	if(rset.next()) {
	        		if(rset.getString("pw") != null && rset.getString("pw").equals(pw)) {
	        			result = 1;
	        		}else {
	        			result = 0;
	        		}
	        	}else {
	        		result = -1;
	        	}
	        }catch(Exception e) {
	        	
	        }finally {
	        	try {
	        		if(rset != null) rset.close();
	        		if(pstmt != null) pstmt.close();
	        		if(conn != null) conn.close();
	        	}catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        }
	        return result;
	       
	    } 

}