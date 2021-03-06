package br.com.caelum.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

@SuppressWarnings("serial")
@WebServlet("/alteraAdicionaContato")
public class AlteraAdicionaContatoServlet extends HttpServlet{
		protected void service(HttpServletRequest req,
							HttpServletResponse res)  throws IOException, ServletException {

		if (req.getParameter("id") == null) {

			String nome               = req.getParameter("nome");
			String email              = req.getParameter("email");
			String endereco       	  = req.getParameter("endereco");
			String dataEmTexto        = req.getParameter("dataNascimento");
			Calendar dataNascimento = null;

			Date date = null;
			try {
				date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);



			Contato contato = new Contato();

			contato.setNome(nome);
			contato.setEmail(email);
			contato.setEndereco(endereco);
			contato.setDataNascimento(dataNascimento);

			Connection connection = (Connection) req.getAttribute("conexao");

			ContatoDao dao = new ContatoDao(connection);

			dao.adiciona(contato);

			System.out.println("Adicionando contato...");

			 RequestDispatcher rd = req.getRequestDispatcher("mvc?logica=ListaContatoLogic");
		     rd.forward(req, res);

		} else {


			long id 				  = Long.parseLong(req.getParameter("id"));
			String nome               = req.getParameter("nome");
			String email              = req.getParameter("email");
			String endereco       	  = req.getParameter("endereco");
			String dataEmTexto        = req.getParameter("dataNascimento");
			Calendar dataNascimento = null;

			Date date = null;
			try {
				date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);



			Contato contato = new Contato();

			contato.setId(id);
			contato.setNome(nome);
			contato.setEmail(email);
			contato.setEndereco(endereco);
			contato.setDataNascimento(dataNascimento);

			Connection connection = (Connection) req.getAttribute("conexao");

			ContatoDao dao = new ContatoDao(connection);
			dao.altera(contato);


			System.out.println("Alterando contato...");



			 RequestDispatcher rd = req.getRequestDispatcher("mvc?logica=ListaContatoLogic");
		     rd.forward(req, res);
		}





	}

}
