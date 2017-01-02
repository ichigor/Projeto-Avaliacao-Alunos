package csi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import csi.dao.AlunoDAO;

/**
 * Servlet implementation class PrincipalServlet
 */
@WebServlet("/principalServlet")
public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrincipalServlet() {
        super();
        // TODO Auto-generated constructor stub
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
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher despachante;
		String pagina = "";
		if(request.getSession().getAttribute("logado") != null){
			
			String opcao = request.getParameter("opcao");					
			
			if(opcao.equals("aluno")){
				
				pagina = "/WEB-INF/jsp/aluno.jsp";
				AlunoDAO dao = new AlunoDAO();			
				request.setAttribute("alunos", dao.getAlunos());
				
			}else if(opcao.equals("avaliacao")){
				if(request.getSession().getAttribute("permissao").equals("liberado")){
					pagina = "/WEB-INF/jsp/avaliacao.jsp";
					AlunoDAO dao = new AlunoDAO();			
					request.setAttribute("alunos", dao.getAlunos());
				}
				else{
					pagina = "/WEB-INF/jsp/principal.jsp";
				}
			}else if(opcao.equals("logout")){
				request.getSession().invalidate();
				pagina = "/index.jsp";				
			}
			
		}else{
			pagina = "/index.jsp";
		}
		
		
		despachante = request.getServletContext()
						.getRequestDispatcher(pagina);
		despachante.forward(request, response);
		
	}

}
