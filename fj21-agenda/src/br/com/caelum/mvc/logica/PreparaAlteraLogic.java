package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class PreparaAlteraLogic implements Logica{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		long id = Long.parseLong(request.getParameter("id"));

		Contato contato = new Contato();
		contato.setId(id);

		Connection connection = (Connection) request.getAttribute("conexao");

		ContatoDao dao = new ContatoDao(connection);
		dao.getContatoId(contato);


		request.setAttribute("contatos", contato);


		return "/WEB-INF/jsp/altera-contato.jsp";

	}

}
