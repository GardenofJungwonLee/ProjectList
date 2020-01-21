package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.MemberDAO;
import model.dto.MemberDTO;


@WebServlet("/check")
public class IdCheck extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "showError.jsp";
		String id = request.getParameter("id");
        String pw = request.getParameter("pw");
       
        MemberDAO dao = MemberDAO.getInstance();
        
        int result = dao.loginCheck(id, pw);
        
        if(result == 1) {
        	url = "main2.jsp";
        
        	HttpSession session = request.getSession();
        	session.setAttribute("id", id);
        	request.setAttribute("message", "로그인 - 환영합니다");
        }else if(result == 0) {
        	request.setAttribute("message", "비밀번호를 확인해주세요");
        }else if(result == -1) {
        	request.setAttribute("message", "존재하지 않는 회원입니다");
        }
     /*   request.getRequestDispatcher(url).forward(request, response);*/
        response.sendRedirect(url);
	}    
}	
	
