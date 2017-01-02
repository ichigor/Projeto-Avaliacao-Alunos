package csi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import csi.dao.AlunoDAO;
import csi.modelo.Aluno;

/**
 * Servlet implementation class ProfessorServlet
 */
@WebServlet("/ProfessorServlet")
public class ProfessorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfessorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entrou no professorServlet ....");
		
		String acesso = request.getParameter("avaliacao");
		String alunoAvaliado = request.getParameter("alunoAvaliado");
		Aluno aluno = new Aluno();
		try{
			aluno = new AlunoDAO().getAluno(Integer.parseInt(alunoAvaliado));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		RequestDispatcher despat;
		
		String pagina = "/WEB-INF/jsp/professor.jsp";
		 HttpSession sessao = request.getSession(true);
		 sessao.setAttribute("permissao", acesso);
		 sessao.setAttribute("avaliar", aluno);
		 AlunoDAO dao = new AlunoDAO();		
		request.setAttribute("alunosNaoAvaliados", dao.getAlunosNaoAvaliados());
		
		AlunoDAO adao = new AlunoDAO();		
		request.setAttribute("alunos", adao.getAlunos());
		despat = request.getServletContext()
				.getRequestDispatcher(pagina);
		despat.forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
