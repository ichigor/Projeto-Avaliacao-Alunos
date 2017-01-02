package csi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSeparatorUI;

import csi.dao.UsuarioDAO;
import csi.modelo.Aluno;
import csi.modelo.Avaliacao;
import csi.modelo.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
			Aluno logado = new UsuarioDAO().autenticado(user);
		
			System.out.println("teste...");
			for(Avaliacao v: logado.getAvaliado()){
				System.out.println("comentário: "+v.getComentario());
			}
			
			RequestDispatcher despat;
				
			logado.getNome();
			
				if(logado!= null){
					String pagina = "/WEB-INF/jsp/principal.jsp";
					 HttpSession sessao = request.getSession(true);
					 sessao.setAttribute("logado", logado);
					
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
