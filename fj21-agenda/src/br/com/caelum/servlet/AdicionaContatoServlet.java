package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

@SuppressWarnings("serial")
@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet{
		protected void service(HttpServletRequest request,
							HttpServletResponse response)  throws IOException, ServletException {

			PrintWriter out = response.getWriter();

			String nome = request.getParameter("nome");
			String endereco = request.getParameter("endereco");
			String email = request.getParameter("email");
			String dataEmTexto = request.getParameter("dataNascimento");
			Calendar dataNascimento = null;

			try {
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
				dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(date);
			} catch (ParseException e) {
				out.println("Erro de conversão da data");
				return;
			}

			Contato contato = new Contato();
			contato.setNome(nome);
			contato.setEmail(email);
			contato.setEndereco(endereco);
			contato.setDataNascimento(dataNascimento);

			Connection connection = (Connection) request.getAttribute("conexao");

			ContatoDao dao = new ContatoDao(connection);

			dao.adiciona(contato);

			out.println("<html>");
			out.println("<body>");
			out.println("Contato" + contato.getNome() + "adicionado com sucesso");
			out.println("</body>");
			out.println("</html>");

		}

}
