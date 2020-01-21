package controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.MessageException;
import lombok.var;
import model.dao.MemberDAO;
import model.dao.service;
import model.dto.AttachDTO;
import model.dto.MemberDTO;
import model.dto.ModiDTO;

@WebServlet("/control")
public class Controller extends HttpServlet {
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//command pattern
		String command = request.getParameter("command");
		try{
			if(command.equals("memberAll")){//모든 회원 검색
				memberAll(request, response);
			}else if(command.equals("member")){//특정 회원 정보 검색
				member(request, response);
			}else if(command.equals("memberInsert")){//회원 추가 등록
				memberInsert(request, response);
			}else if(command.equals("memberUpdateReq")){//회원 정보 수정요청
				memberUpdateReq(request, response);
			}else if(command.equals("memberUpdate")){//회원 정보 수정
				memberUpdate(request, response);
			}else if(command.equals("memberDelete")){//회원 탈퇴[삭제]
				memberDelete(request, response);
			}else if(command.equals("attachInsert")){//애착유형 정답 등록
				attachInsert(request, response);	
			}
//			else if(command.equals("attachTot")){//애착유형 총점 검색
//				attachTot(request, response);	
//			}else if(command.equals("attachGrade")){//애착유형 등급부여
//				attachGrade(request, response);	
//			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}
	

//	//모두 ProbonoProject 검색 메소드
//	public void probonoProjectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String url = "showError.jsp";
//		try {
//			request.setAttribute("probonoProjectAll", service.getAllProbonoProjects());
//			url = "probonoProjectList.jsp";
//		}catch(Exception s){
//			s.printStackTrace();
//			request.setAttribute("errorMsg", s.getMessage());
//		}
//		request.getRequestDispatcher(url).forward(request, response);
//	}
//	
	//???
	//모든 회원 검색 - 검색된 데이터 출력 화면[memberList.jsp]
	public void memberAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("memberAll", service.getAllMembers());
			url = "memberList.jsp";
		}catch(Exception s){
			s.printStackTrace();
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	
	}
	
	//회원 검색 
	public void member(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try { 
			HttpSession session = request.getSession();
			request.setAttribute("member", service.getMember((String) session.getAttribute("id")));
			url = "information.jsp";
			
		}catch(Exception s){
			s.printStackTrace();
			request.setAttribute("errorMsg", s.getMessage());
			System.out.println("----123------");
		}
		request.getRequestDispatcher(url).forward(request, response); 
	}
	

	//회원 가입 메소드
	protected void memberInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String address = request.getParameter("address");
		String job = request.getParameter("job");
		String height = request.getParameter("height");
		
		MemberDTO member = new MemberDTO(id, pw, name, age, sex, birthday, address, job, height);
		try{
			boolean result = service.addMember(member);
			if(result){
				request.setAttribute("member", member);
				request.setAttribute("successMsg", "가입 완료");
				url = "joinsuccess.jsp";
			}else{
				request.setAttribute("errorMsg", "다시 시도하세요");
			}
		}catch(Exception s){
			s.printStackTrace();
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	//회원 수정 요구
		public void memberUpdateReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "showError.jsp";
			try {
				HttpSession session = request.getSession();
				request.setAttribute("member", service.getMember((String)session.getAttribute("id")));
				url = "updatejoin.jsp";
			}catch(Exception s){
				s.printStackTrace();
				request.setAttribute("errorMsg", s.getMessage());
			}
			request.getRequestDispatcher(url).forward(request, response);
		}

		//회원 수정 
		public void memberUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String url = "showError.jsp";
			/*id pw name age sex birthday address job height*/
			String id =request.getParameter("id");
			String pw =request.getParameter("pw");
			String name =request.getParameter("name");
			String age =request.getParameter("age");
			String birthday =request.getParameter("birthday");
			String address =request.getParameter("address");
			String job =request.getParameter("job");
			String height =request.getParameter("height");
			if(pw == null || pw.trim().length() == 0 ||
			   name == null || name.trim().length() == 0 ||
			   age == null || age.trim().length() == 0 ||
			   birthday == null || birthday.trim().length() == 0 ||
			   address == null || address.trim().length() == 0 ||
			   job == null || job.trim().length() == 0 ||
			   height == null || height.trim().length() == 0 ){
					response.sendRedirect("showError.jsp");
					return;
			}
			boolean result = false;
			ModiDTO member = new ModiDTO(id, pw, name, age, birthday, address, job, height);
			
			try {
				result = service.updateMember(id, pw, name, age, birthday, address, job, height);
				System.out.println(result);
				
				
				if(result) {
					request.setAttribute("member", service.getMember(id));
					url = "updatejoin.jsp";
				} else {
					request.setAttribute("errorMsg", "다시 시도하세요");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMsg", e.getMessage());
			}
			
			request.getRequestDispatcher(url).forward(request, response);
		}
	
		//회원 삭제
		public void memberDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url="showError.jsp";
			String id = request.getParameter("id");					
		
		try {
			HttpSession session = request.getSession();
			boolean result = service.deleteMember(((String) session.getAttribute("id")));
			if(result){
				request.setAttribute("id", id);
				request.setAttribute("successMsg", "삭제 완료");
				url ="index2.html";
			}else {
				request.setAttribute("errorMsg", "다시시도하세요");
			}
			} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	//등급메기기
/*	protected void attachGrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		
		String id = request.getParameter("id");
		int answer1 = Integer.parseInt(request.getParameter("answer1"));
		int answer2 = Integer.parseInt(request.getParameter("answer2"));
		int answer3 = Integer.parseInt(request.getParameter("answer3"));
		int answer4 = Integer.parseInt(request.getParameter("answer4"));
		int answer5 = Integer.parseInt(request.getParameter("answer5"));
		int answer6 = Integer.parseInt(request.getParameter("answer6"));
		int answer7 = Integer.parseInt(request.getParameter("answer7"));
		int answer8 = Integer.parseInt(request.getParameter("answer8"));
		int answer9 = Integer.parseInt(request.getParameter("answer9"));
		int answer10 = Integer.parseInt(request.getParameter("answer10"));
		int answer11 = Integer.parseInt(request.getParameter("answer11"));
		int answer12 = Integer.parseInt(request.getParameter("answer12"));
		int answer13 = Integer.parseInt(request.getParameter("answer13"));
		int answer14 = Integer.parseInt(request.getParameter("answer14"));
		int answer15 = Integer.parseInt(request.getParameter("answer15"));
		int answer16 = Integer.parseInt(request.getParameter("answer16"));
		int answer17 = Integer.parseInt(request.getParameter("answer17"));
		int answer18 = Integer.parseInt(request.getParameter("answer18"));
		int answer19 = Integer.parseInt(request.getParameter("answer19"));
		int answer20 = Integer.parseInt(request.getParameter("answer20"));
		int answer21 = Integer.parseInt(request.getParameter("answer21"));
		int answer22 = Integer.parseInt(request.getParameter("answer22"));
		int answer23 = Integer.parseInt(request.getParameter("answer23"));
		int answer24 = Integer.parseInt(request.getParameter("answer24"));
		int answer25 = Integer.parseInt(request.getParameter("answer25"));
		int answer26 = Integer.parseInt(request.getParameter("answer26"));
		int answer27 = Integer.parseInt(request.getParameter("answer27"));
		int answer28 = Integer.parseInt(request.getParameter("answer28"));
		int answer29 = Integer.parseInt(request.getParameter("answer29"));
		int answer30 = Integer.parseInt(request.getParameter("answer30"));
		int answer31 = Integer.parseInt(request.getParameter("answer31"));
		int answer32 = Integer.parseInt(request.getParameter("answer32"));
		int answer33 = Integer.parseInt(request.getParameter("answer33"));
		int answer34 = Integer.parseInt(request.getParameter("answer34"));
		int answer35 = Integer.parseInt(request.getParameter("answer35"));
		int answer36 = Integer.parseInt(request.getParameter("answer36"));
		
		int tot = answer1+answer2+answer3+answer4+answer5+answer6+answer7+answer8+answer9+answer10+answer11+answer12+answer13+answer14+answer15+answer16+answer17+answer18+answer19+answer20+answer21+answer22+answer23+answer24+answer25+answer26+answer27+answer28+answer29+answer30+answer31+answer32+answer33+answer34+answer35+answer36;
		
		String grade = null;
		
		if(tot>=1) {
			grade = "회피형";
		}else if(tot >=60) {
			grade = "불안형"; 
		}else if(tot < 140) { 
			grade = "안정형";
		}

	}*/
	
	
	
	//설문지체크
	protected void attachInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		
		String id = request.getParameter("id");
		int answer1 = Integer.parseInt(request.getParameter("answer1")); 
		int answer2 = Integer.parseInt(request.getParameter("answer2"));
		int answer3 = Integer.parseInt(request.getParameter("answer3"));
		int answer4 = Integer.parseInt(request.getParameter("answer4"));
		
		int tot = 0;			
		String type = request.getParameter("type");
		/*
		int answer5 = Integer.parseInt(request.getParameter("answer5"));
		int answer6 = Integer.parseInt(request.getParameter("answer6"));
		int answer7 = Integer.parseInt(request.getParameter("answer7"));
		int answer8 = Integer.parseInt(request.getParameter("answer8"));
		int answer9 = Integer.parseInt(request.getParameter("answer9"));
		int answer10 = Integer.parseInt(request.getParameter("answer10"));
		int answer11 = Integer.parseInt(request.getParameter("answer11"));
		int answer12 = Integer.parseInt(request.getParameter("answer12"));
		int answer13 = Integer.parseInt(request.getParameter("answer13"));
		int answer14 = Integer.parseInt(request.getParameter("answer14"));
		int answer15 = Integer.parseInt(request.getParameter("answer15"));
		int answer16 = Integer.parseInt(request.getParameter("answer16"));
		int answer17 = Integer.parseInt(request.getParameter("answer17"));
		int answer18 = Integer.parseInt(request.getParameter("answer18"));
		int answer19 = Integer.parseInt(request.getParameter("answer19"));
		int answer20 = Integer.parseInt(request.getParameter("answer20"));
		int answer21 = Integer.parseInt(request.getParameter("answer21"));
		int answer22 = Integer.parseInt(request.getParameter("answer22"));
		int answer23 = Integer.parseInt(request.getParameter("answer23"));
		int answer24 = Integer.parseInt(request.getParameter("answer24"));
		int answer25 = Integer.parseInt(request.getParameter("answer25"));
		int answer26 = Integer.parseInt(request.getParameter("answer26"));
		int answer27 = Integer.parseInt(request.getParameter("answer27"));
		int answer28 = Integer.parseInt(request.getParameter("answer28"));
		int answer29 = Integer.parseInt(request.getParameter("answer29"));
		int answer30 = Integer.parseInt(request.getParameter("answer30"));
		int answer31 = Integer.parseInt(request.getParameter("answer31"));
		int answer32 = Integer.parseInt(request.getParameter("answer32"));
		int answer33 = Integer.parseInt(request.getParameter("answer33"));
		int answer34 = Integer.parseInt(request.getParameter("answer34"));
		int answer35 = Integer.parseInt(request.getParameter("answer35"));
		int answer36 = Integer.parseInt(request.getParameter("answer36"));
		int tot = 0;
		String grade = null;*/
		
		AttachDTO attach = new AttachDTO(id, answer1, answer2, answer3, answer4, tot, type);
//		AttachDTO attach = new AttachDTO(id, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10, answer11, answer12, answer13, answer14, answer15, answer16, answer17, answer18, answer19, answer20, answer21, answer22, answer23, answer24, answer25, answer26, answer27, answer28, answer29, answer30, answer31, answer32, answer33, answer34, answer35, answer36, tot, grade);
		System.out.println("--------------123456");
		try{
			System.out.println("--------------123456777");
			boolean result = service.addAttach(attach);
			System.out.println("--------------12345677");
			if(result){
				System.out.println("--------------1234567");
				request.setAttribute("attach", attach);
				System.out.println("--------------123457");
				request.setAttribute("successMsg", "입력 완료");
				System.out.println("--------------12345678");
//				url = "attachintroduce.html";
				System.out.println("--------------123456789");
				url = "suAttach.jsp";
			}else{
				request.setAttribute("errorMsg", "다시 시도하세요");
			}
		}catch(Exception s){
			s.printStackTrace();
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	

	/*//모든 총점 검색 - 검색된 데이터 출력 화면[scoreList.jsp]
		public void attachTot(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "showError.jsp";
			try {
				request.setAttribute("attachTot", service.getScore();
				url = "scoreList.jsp";
			}catch(Exception s){
				s.printStackTrace();
				request.setAttribute("errorMsg", s.getMessage());
			}
			request.getRequestDispatcher(url).forward(request, response);
		
		}*/
		
/*		//회원id로 총점 검색 
		public void attachTot(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "showError.jsp";
			try {
				request.setAttribute("attachTot", service.getScore(request.getParameter("id")));
				url = "scoreList.jsp";
			}catch(Exception s){
				s.printStackTrace();
				request.setAttribute("errorMsg", s.getMessage());
			}
			request.getRequestDispatcher(url).forward(request, response);
		}	
}*/

	
//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	String id = request.getParameter("id");
//	String pw = request.getParameter("pw");
//	String name = request.getParameter("name");
//	String age = request.getParameter("age");
//	String sex = request.getParameter("sex");
//	String birthday = request.getParameter("birthday");
//	String address = request.getParameter("address");
//	String job = request.getParameter("job");
//	String height = request.getParameter("height");
//
//	MemberDTO Member = new MemberDTO(id,pw,name,age,sex,birthday,address,job,height);
//	
//	boolean result = service.add(Member);
//	
//	if(result) {
//		request.getRequestDispatcher("success").forward(request, response);
//	}else {
//		response.sendRedirect("fail");
//	}
//}
//
}
