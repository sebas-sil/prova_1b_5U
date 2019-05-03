package br.facet.atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Esta classe é responsável por toda a iteração com o banco de dados. Ela
 * adiquire uma conexão, insere, deleta, atualiza e pega informações.
 * 
 * @author Fábio Sebastian Silveira
 *
 */
public class Banco {

	private static final String SQL_UPDATE = "UPDATE cofre SET valor = ? WHERE cli_id = ?";
	private static final String SQL_SELECT = "SELECT valor FROM cofre WHERE cli_id = ?";
	private static final String SQL_DELETE = "DELETE FROM cofre WHERE cli_id = ?";
	private static final String SQL_INSERT = "INSERT INTO cofre (cli_id, valor) VALUES (?,?)";

	/**
	 * Pega uma conexao com o banco de dados
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Connection getConexao() throws ClassNotFoundException, SQLException {
		Connection connexao = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		connexao = DriverManager.getConnection("jdbc:mysql://localhost/facet", "fabio.silveira", "Welcome1!");
		return connexao;
	}

	/**
	 * Atualiza o saldo do cliente com o novo valor
	 * 
	 * @param id,    identificação única do cliente
	 * @param salvo, novo saldo que sobreescreverá o valor antigo
	 * @return verdadeiro se atualizou, falso se não conseguiu atualizar.
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	boolean atualizarSaldo(int id, int saldo) throws ClassNotFoundException, SQLException {
		boolean retorno = false;
		Connection conn = this.getConexao();
		PreparedStatement ps = conn.prepareStatement(SQL_UPDATE);
		ps.setInt(1, saldo);
		ps.setInt(2, id);
		int qtd = ps.executeUpdate();
		retorno = qtd == 1;
		conn.close();
		return retorno;
	}

	/**
	 * Retorna para o cliente o saldo atual dele
	 * 
	 * @param id, identificação única do cliente
	 * @return saldo do cliente
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	int verificaSaldo(int id) throws ClassNotFoundException, SQLException {
		int saldo = -1;
		Connection conn = this.getConexao();
		PreparedStatement ps = conn.prepareStatement(SQL_SELECT);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			saldo = rs.getInt(1);
		} else {
			throw new RuntimeException("Cliente não encontrado");
		}
		conn.close();
		return saldo;
	}

	/**
	 * Encerra a conta do cliente
	 * 
	 * @param id, identificação única do cliente
	 * @return verdadeiro se a conta foi encerrada, caso contrário falso
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean encerrarConta(int id) throws ClassNotFoundException, SQLException {
		boolean retorno = false;
		Connection conn = this.getConexao();
		PreparedStatement ps = conn.prepareStatement(SQL_DELETE);
		ps.setInt(1, id);
		int qtd = ps.executeUpdate();
		retorno = qtd == 1;
		conn.close();
		return retorno;
	}

	/**
	 * Abre a conta do cliente
	 * 
	 * @param saldo, saldo inicial do cliente
	 * @return verdadeiro se a conta foi aberta, caso contrário falso
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean abreConta(int id, int saldo) throws ClassNotFoundException, SQLException {
		boolean retorno = false;
		Connection conn = this.getConexao();
		PreparedStatement ps = conn.prepareStatement(SQL_INSERT);
		ps.setInt(1, id);
		ps.setInt(2, saldo);
		int qtd = ps.executeUpdate();
		retorno = qtd == 1;
		conn.close();
		return retorno;
	}
}
