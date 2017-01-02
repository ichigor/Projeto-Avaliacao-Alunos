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
import csi.dao.UsuarioDAO;
import csi.modelo.Professor;
import csi.modelo.Usuario;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("Entrou no servidor ....");
		
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		Usuario user = new Usuario(usuario, senha);
		try{
			Professor logado = new UsuarioDAO().autenticadoP(user);
			
			RequestDispatcher despat;
				
			logado.getNome();
			
				if(logado!= null){
					String pagina = "/WEB-INF/jsp/professor.jsp";
					 HttpSession sessao = request.getSession(true);
					 sessao.setAttribute("logado", logado);
					
					 AlunoDAO dao = new AlunoDAO();		
					request.setAttribute("alunosNaoAvaliados", dao.getAlunosNaoAvaliados());
					
					AlunoDAO adao = new AlunoDAO();		
					request.setAttribute("alunos", adao.getAlunos());
					despat = request.getServletContext()
							.getRequestDispatcher(pagina);
					despat.forward(request, response);
					
				}else{
					
					String msg = "Usuariokjhgkhretos";
					String pagina = "/index.jsp";
					
					request.setAttribute("msgDoServidor", msg);
					
					despat = request.getServletContext()
							.getRequestDispatcher(pagina);
					despat.forward(request, response);
					
				}
				
		}catch(Exception e){
			e.printStackTrace();
			
		}	
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
