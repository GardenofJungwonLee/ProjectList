
package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import exception.MessageException;
import exception.NotExistException;
import model.dto.MemberDTO;
import model.dto.AttachDTO;

public class service {
	//Member - CRUD
		public static void notExistMember(String id) throws NotExistException, SQLException{
			MemberDTO Member = MemberDAO.getMember(id);
			if(Member == null){
				throw new NotExistException("검색하는 사용자가 미 존재합니다.");
			}
		}
		public static boolean addMember(MemberDTO member) throws MessageException{
			boolean result = false;
			try{
				result = MemberDAO.addMember(member);
			}catch(SQLException s){
				throw new MessageException("이미 존재하는 ID입니다 다시 시도 하세요");
			}
			return result;
		}
		

		//회원 수정 메소드[MemberDAO의 updateMember()]
		public static boolean updateMember(String id,String pw,String name,String age, String birthday,String address, String job,String height) throws SQLException, NotExistException{		
			notExistMember(id);
			boolean result = MemberDAO.updateMember(id, pw, name, age, birthday, address, job, height);
					
					
			if(!result){
				throw new NotExistException("회원 정보 갱신 실패");
			}
			return result;
		}
		
//		회원 삭제 메소드[ MemberDAO.deleteMember()]
		public static boolean deleteMember(String id) throws SQLException, NotExistException{
			notExistMember(id);
			boolean result = MemberDAO.deleteMember(id);
			if(!result){
				throw new NotExistException("회원 정보 삭제 실패하였습니다");
			}
			return result;
		}
		
		public static MemberDTO getMember(String id) throws SQLException, NotExistException{
			MemberDTO Member = MemberDAO.getMember(id);
			if(Member == null){
				throw new NotExistException("검색하는 회원이 미 존재합니다.");
			}
			return Member;
		}
		
		public static ArrayList<MemberDTO> getAllMembers() throws SQLException{
			return MemberDAO.getAllMembers();
		}
	
		
//	//attach답 삽입
//		public static void notExistMember2(String id) throws NotExistException, SQLException{
//			AttachDTO Attach = AttachDAO.getAttach(id);
//			if(Attach == null){
//				throw new NotExistException("검색하는 정답기입자가 미 존재합니다.");
//			}
//		}
		public static boolean addAttach(AttachDTO attach) throws MessageException{
			boolean result = false;
			try{
				result = AttachDAO.addAttach(attach);
				System.out.println("seeeervice1234");
			}catch(SQLException s){
				s.printStackTrace();
				System.out.println("seeeervice12345");
				throw new MessageException("오류가 발생하였습니다, 다시 시도 하세요");
			}
			return result;
		}
		
//		//attach총점 검색
//		public static ArrayList<AttachDTO> getScore throws SQLException{
//			return AttachDAO.getScore();
//		}
//		
//		//id로 총점검색
//		public static AttachDTO getScore(String id) throws SQLException, NotExistException{
//			AttachDTO attach = AttachDAO.getScore(id);
//			if(attach == null){
//				throw new NotExistException("검색하신 총점 정보가 없습니다.");
//			}
//			return attach;
//		}
}
