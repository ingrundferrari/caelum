package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contato contato = new Contato();
		contato.setNome("MarcoDAo");
		contato.setEmail("email@dao.com");
		contato.setEndereco("endereço dao");
		contato.setDataNascimento(Calendar.getInstance());

		ContatoDao dao = new ContatoDao();

		dao.adiciona(contato);

		System.out.println("gravado dao");
	}

}
