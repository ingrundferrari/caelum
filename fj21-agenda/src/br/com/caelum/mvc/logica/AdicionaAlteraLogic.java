package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class AdicionaAlteraLogic implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {

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

		if (req.getParameter("id").isEmpty()) {

			contato.setNome(nome);
			contato.setEmail(email);
			contato.setEndereco(endereco);
			contato.setDataNascimento(dataNascimento);

			Connection connection = (Connection) req.getAttribute("conexao");

			ContatoDao dao = new ContatoDao(connection);

			dao.adiciona(contato);

			System.out.println("Alterando contato...");

			return "mvc?logica=ListaContatoLogic";
		} else {
			contato.setId(id);
			contato.setNome(nome);
			contato.setEmail(email);
			contato.setEndereco(endereco);
			contato.setDataNascimento(dataNascimento);

			Connection connection = (Connection) req.getAttribute("conexao");

			ContatoDao dao = new ContatoDao(connection);
			dao.altera(contato);


			System.out.println("Alterando contato...");



			// TODO Auto-generated method stub
			return "mvc?logica=ListaContatoLogic";
		}
	}



}
