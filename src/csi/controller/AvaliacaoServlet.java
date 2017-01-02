package csi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import csi.dao.AlunoDAO;
import csi.dao.AvaliacaoDAO;
import csi.modelo.Aluno;
import csi.modelo.Avaliacao;

/**
 * Servlet implementation class AvaliacaoServlet
 */
@WebServlet("/AvaliacaoServlet")
public class AvaliacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AvaliacaoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idAlunoAvaliado = request.getParameter("idAlunoAvaliado");
		String comentario = request.getParameter("comentario");
		String nota = request.getParameter("nota");
		String idAvaliador = request.getParameter("idAlunoAvaliador");
		
		System.out.println("idAlunoAvaliado: "+idAlunoAvaliado);
		System.out.println("comentario: "+comentario);
		System.out.println("nota: "+nota);
		System.out.println("idAlunoAvaliador: "+idAvaliador);
		
		try{
		
			String pagina = "";
			if(idAlunoAvaliado.equals(idAvaliador)){
				pagina = "/WEB-INF/jsp/avaliacao.jsp";
				request.setAttribute("msgDoServidor", "não é permitido fazer auto-avaliação");
				request.setAttribute("alunos", new AlunoDAO().getAlunos());
				
				
			}else{
				Aluno alAvaliado = new AlunoDAO().getAluno(Integer.parseInt(idAlunoAvaliado));
				Aluno alAvaliador = new AlunoDAO().getAluno(Integer.parseInt(idAvaliador));
				
				Avaliacao av = 
						new Avaliacao(alAvaliado, comentario, Float.parseFloat(nota));
				
							 
				AvaliacaoDAO dao = new AvaliacaoDAO();				
				boolean retorno = dao.fezAvalizacao(alAvaliador, av);
				
				if(!retorno){
					request.setAttribute("msg", "lsdjkflks");
					pagina = "/WEB-INF/jsp/avaliacao.jsp";
					request.setAttribute("alunos", new AlunoDAO().getAlunos());
				}else{
					pagina = "/WEB-INF/jsp/principal.jsp";
				}
				
				
			}
			
		
		
		RequestDispatcher despat = request.getServletContext()
				.getRequestDispatcher(pagina);
		despat.forward(request, response);
		
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
