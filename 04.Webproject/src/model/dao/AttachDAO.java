package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.AttachDTO;
import model.util.DBUtil;

public class AttachDAO {
	
		private AttachDAO() {}
		
		private static AttachDAO instance = new AttachDAO();
		
		static public AttachDAO getInstance() {
			return instance;
		}
	
		public static boolean addAttach(AttachDTO attach) throws SQLException{
			Connection con = null;
			PreparedStatement pstmt = null;
			try{
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("insert into attach values(?, ?, ?, ?, ?, ?, ?)");
//				pstmt = con.prepareStatement("insert into attachanswer values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, null, null)");
				pstmt.setString(1, attach.getId());
				pstmt.setInt(2, attach.getAnswer1());
				pstmt.setInt(3, attach.getAnswer2());
				pstmt.setInt(4, attach.getAnswer3());
				pstmt.setInt(5, attach.getAnswer4());
				pstmt.setInt(6, attach.getTot());
				pstmt.setString(7, attach.getType());
				/*
				pstmt.setInt(6, attach.getAnswer5());
				pstmt.setInt(7, attach.getAnswer6());
				pstmt.setInt(8, attach.getAnswer7());
				pstmt.setInt(9, attach.getAnswer8());
				pstmt.setInt(10, attach.getAnswer9());
				pstmt.setInt(11, attach.getAnswer10());
				pstmt.setInt(12, attach.getAnswer11());
				pstmt.setInt(13, attach.getAnswer12());
				pstmt.setInt(14, attach.getAnswer13());
				pstmt.setInt(15, attach.getAnswer14());
				pstmt.setInt(16, attach.getAnswer15());
				pstmt.setInt(17, attach.getAnswer16());
				pstmt.setInt(18, attach.getAnswer17());
				pstmt.setInt(19, attach.getAnswer18());
				pstmt.setInt(20, attach.getAnswer19());
				pstmt.setInt(21, attach.getAnswer20());
				pstmt.setInt(22, attach.getAnswer21());
				pstmt.setInt(23, attach.getAnswer22());
				pstmt.setInt(24, attach.getAnswer23());
				pstmt.setInt(25, attach.getAnswer24());
				pstmt.setInt(26, attach.getAnswer25());
				pstmt.setInt(27, attach.getAnswer26());
				pstmt.setInt(28, attach.getAnswer27());
				pstmt.setInt(29, attach.getAnswer28());
				pstmt.setInt(30, attach.getAnswer29());
				pstmt.setInt(31, attach.getAnswer30());
				pstmt.setInt(32, attach.getAnswer31());
				pstmt.setInt(33, attach.getAnswer32());
				pstmt.setInt(34, attach.getAnswer33());
				pstmt.setInt(35, attach.getAnswer34());
				pstmt.setInt(36, attach.getAnswer35());
				pstmt.setInt(37, attach.getAnswer36());
					*/
				int result = pstmt.executeUpdate();
			
				if(result == 1){
					return true;
				}
			}finally{
				DBUtil.close(con, pstmt);
			}
			return false;
		}
	
//		//유형테이블에 총점 저장
//		public static boolean saveAttach(AttachDTO attach) throws SQLException{
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			try{
//				con = DBUtil.getConnection();
//			pstmt = con.prepareStatement("insert into attach(tot) values((select sum(answer1+answer2+answer3+answer4) from attach where id=?))");
//
////				pstmt = con.prepareStatement("insert into attach values((select sum(answer1+answer2+answer3+answer4+answer5+answer6+answer7+answer8+answer9+answer10+answer11+answer12+answer13+answer14+answer15+answer16+answer17+answer18+answer19+answer20+answer21+answer22+answer23+answer24+answer25+answer26+answer27+answer28+answer29+answer30+answer31+answer32+answer33+answer34+answer35+answer36) from attachanswer where id='?'))");
//				pstmt.setString(1, attach.getId());
//					
//				int result = pstmt.executeUpdate();
//			
//				if(result == 1){
//					return true;
//				}
//			}finally{
//				DBUtil.close(con, pstmt);
//			}
//			return false;
//		}
//		
//	
//		//id로 해당 회원의 모든 정보 반환
//		public static AttachDTO getattach(String id) throws SQLException{
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			ResultSet rset = null;
//			AttachDTO attach = null;
//			
//			try{
//				con = DBUtil.getConnection();
//				pstmt = con.prepareStatement("select * from attach where id=?");
//				pstmt.setString(1, id);
//				rset = pstmt.executeQuery();
//				if(rset.next()){
//					attach = new AttachDTO(rset.getString(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5), rset.getInt(6), rset.getInt(7), rset.getInt(8), rset.getInt(9), rset.getInt(10), rset.getInt(11), rset.getInt(12), rset.getInt(13), rset.getInt(14), rset.getInt(15), rset.getInt(16), rset.getInt(17), rset.getInt(18), rset.getInt(19), rset.getInt(20), rset.getInt(21), rset.getInt(22), rset.getInt(23), rset.getInt(24), rset.getInt(25), rset.getInt(26), rset.getInt(27), rset.getInt(28), rset.getInt(29), rset.getInt(30), rset.getInt(31), rset.getInt(32), rset.getInt(33), rset.getInt(34), rset.getInt(35), rset.getInt(36), rset.getInt(37), rset.getInt(38), rset.getString(39));
//				}
//			}finally{
//				DBUtil.close(con, pstmt, rset);
//			}
//			return attach;
//		}
//
//		//모든 회원 검색해서 반환
//		//sql - select * from attach
//		public static ArrayList<AttachDTO> getAllattachs() throws SQLException{
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			ResultSet rset = null;
//			ArrayList<AttachDTO> list = null;
//			try{
//				con = DBUtil.getConnection();
//				pstmt = con.prepareStatement("select * from attach");
//				rset = pstmt.executeQuery();
//				
//				list = new ArrayList<AttachDTO>();
//				while(rset.next()){
//					list.add(new AttachDTO(rset.getString(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5), rset.getInt(6), rset.getInt(7), rset.getInt(8), rset.getInt(9), rset.getInt(10), rset.getInt(11), rset.getInt(12), rset.getInt(13), rset.getInt(14), rset.getInt(15), rset.getInt(16), rset.getInt(17), rset.getInt(18), rset.getInt(19), rset.getInt(20), rset.getInt(21), rset.getInt(22), rset.getInt(23), rset.getInt(24), rset.getInt(25), rset.getInt(26), rset.getInt(27), rset.getInt(28), rset.getInt(29), rset.getInt(30), rset.getInt(31), rset.getInt(32), rset.getInt(33), rset.getInt(34), rset.getInt(35), rset.getInt(36), rset.getInt(37), rset.getInt(38), rset.getString(39)) ); 
//				}
//			}finally{
//				DBUtil.close(con, pstmt, rset);
//			}
//			return list;
//		}
//		
//		
//	    
//	  //id로 해당 회원의 모든 애착유형 정답 정보 반환
//	  		public static AttachDTO getAttach(String id) throws SQLException{
//	  			Connection con = null;
//	  			PreparedStatement pstmt = null;
//	  			ResultSet rset = null;
//	  			AttachDTO Attach = null;
//	  			
//	  			try{
//	  				con = DBUtil.getConnection();
//	  				pstmt = con.prepareStatement("select * from attachanswer where id=?");
//	  				pstmt.setString(1, id);
//	  				rset = pstmt.executeQuery();
//	  				if(rset.next()){
//	  					Attach = new AttachDTO(rset.getString(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5), rset.getInt(6), rset.getInt(7), rset.getInt(8), rset.getInt(9), rset.getInt(10), rset.getInt(11), rset.getInt(12), rset.getInt(13), rset.getInt(14), rset.getInt(15), rset.getInt(16), rset.getInt(17), rset.getInt(18), rset.getInt(19), rset.getInt(20), rset.getInt(21), rset.getInt(22), rset.getInt(23), rset.getInt(24), rset.getInt(25), rset.getInt(26), rset.getInt(27), rset.getInt(28), rset.getInt(29), rset.getInt(30), rset.getInt(31), rset.getInt(32), rset.getInt(33), rset.getInt(34), rset.getInt(35), rset.getInt(36), rset.getInt(37), rset.getInt(38), rset.getString(39));
//	  				}
//	  			}finally{
//	  				DBUtil.close(con, pstmt, rset);
//	  			}
//	  			return Attach;
//	  		}	    
//
//	  	//id로 총점 반환
//			public static AttachDTO getScore(String id) throws SQLException{
//				Connection con = null;
//				PreparedStatement pstmt = null;
//				ResultSet rset = null;
//				AttachDTO attach = null;
//				String sql;
//				
//				try{
//					sql = "select id, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10, answer11, answer12, answer13, answer14, answer15, answer16, answer17, answer18, answer19, answer20, answer21, answer22, answer23, answer24, answer25, answer26, answer27, answer28, answer29, answer30, answer31, answer32, answer33, answer34, answer35, answer36, ";
//					sql += "(answer1+answer2+answer3+answer4+answer5+answer6+answer7+answer8+answer9+answer10+answer11+answer12+answer13+answer14+answer15+answer16+answer17+answer18+answer19+answer20+answer21+answer22+answer23+answer24+answer25+answer26+answer27+answer28+answer29+answer30+answer31+answer32+answer33+answer34+answer35+answer36)tot, grade ";
//					sql += "from attachanswer where id=?";
//					con = DBUtil.getConnection();
//					pstmt = con.prepareStatement(sql);
//					pstmt.setString(1, id);
//					rset = pstmt.executeQuery();
//					if(rset.next()){
//						attach = new AttachDTO(rset.getString(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5), rset.getInt(6), rset.getInt(7), rset.getInt(8), rset.getInt(9), rset.getInt(10), rset.getInt(11), rset.getInt(12), rset.getInt(13), rset.getInt(14), rset.getInt(15), rset.getInt(16), rset.getInt(17), rset.getInt(18), rset.getInt(19), rset.getInt(20), rset.getInt(21), rset.getInt(22), rset.getInt(23), rset.getInt(24), rset.getInt(25), rset.getInt(26), rset.getInt(27), rset.getInt(28), rset.getInt(29), rset.getInt(30), rset.getInt(31), rset.getInt(32), rset.getInt(33), rset.getInt(34), rset.getInt(35), rset.getInt(36), rset.getInt(37), rset.getInt(38), rset.getString(39));
//					}
//				}finally{
//					DBUtil.close(con, pstmt, rset);
//				}
//				return attach;
//			}
	  		
	  /*	//총점계산조회
	  		public static ArrayList<AttachDTO> getScore(String id) throws SQLException{
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				ArrayList<AttachDTO> list = null;
				String sql;
				
				try{
					sql = "select id, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10, answer11, answer12, answer13, answer14, answer15, answer16, answer17, answer18, answer19, answer20, answer21, answer22, answer23, answer24, answer25, answer26, answer27, answer28, answer29, answer30, answer31, answer32, answer33, answer34, answer35, answer36, ";
					sql += "(answer1+answer2+answer3+answer4+answer5+answer6+answer7+answer8+answer9+answer10+answer11+answer12+answer13+answer14+answer15+answer16+answer17+answer18+answer19+answer20+answer21+answer22+answer23+answer24+answer25+answer26+answer27+answer28+answer29+answer30+answer31+answer32+answer33+answer34+answer35+answer36)tot ";
					sql += "from attachanswer";
					con = DBUtil.getConnection();
					pstmt = con.prepareStatement(sql);
					rset = pstmt.executeQuery();
					
					list = new ArrayList<AttachDTO>();
					while(rset.next()){
						AttachDTO dto = new AttachDTO();
						dto.setId(rset.getString("id"));
						dto.setTot(rset.getInt("tot"));
						list.add(dto);
					}

				}finally{
					DBUtil.close(con, pstmt, rset);
				}
				return list;
			}*/
	  		
}
