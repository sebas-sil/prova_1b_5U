package br.facet.atm;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Esta classe representa um ATM comum para que clientes de um banco possam
 * retirar dinheiro
 * 
 * @author Fábio Sebastian Silveira
 *
 */
public class CaixaEletronico extends ATM {

	Banco banco = new Banco();
	
	/**
	 * Verifica se o caixa eletronico tem capacidade de entregar o valor desejado
	 * 
	 * @param quantidade, valor em dinheiro que deve ser verificado
	 * @return verdadeiro se o caixa pode entregar a quantidade solicitada, falso se
	 *         não consegue
	 */
//	@Deprecated
//	private boolean verificaNotas(int quantidade) {
//		// Método desnecessário. A validação é feita no saque
//		throw new UnsupportedOperationException();
//	}

	/**
	 * Realiza um saque da conta do cliente
	 * @param id,         identificação unica do cliente
	 * @param quantidade, quantidade que será retirada
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Map<Integer, Integer> fazerSaque(int id, int quantidade) throws ClassNotFoundException, SQLException {
		Map<Integer, Integer> macoDeNotas = new HashMap<Integer, Integer>();
		
		// saldo atual do cliente
		int saldoAtual = banco.verificaSaldo(id);
		int novoSaldo = saldoAtual - quantidade;
		
		if(quantidade > saldoAtual) {
			throw new RuntimeException("Saldo do cliente insuficiente");
		}
		
		// verifica quantas notas de 50 são necessárias para pagar
		int qtd50 = quantidade / 50;
		// se o caixa não tem notas suficiente para entregar, entregue o que puder
		if(qtd50 > QTD_NOTAS_50) {
			qtd50 = QTD_NOTAS_50;
		}
		// coloque no maço a quantidade de notas
		macoDeNotas.put(50, qtd50);
		// abata do saldo o que será pago com notas de 50
		quantidade -= (qtd50 * 50);
		
		
		int qtd20 = quantidade / 20;
		if(qtd20 > QTD_NOTAS_20) {
			qtd20 = QTD_NOTAS_20;
		}
		macoDeNotas.put(20, qtd20);
		quantidade -= (qtd20 * 20);
		
		int qtd10 = quantidade / 10;
		// se o caixa não tem notas suficiente para entregar, entregue o que puder
		if(qtd10 > QTD_NOTAS_10) {
			qtd10 = QTD_NOTAS_10;
		}
		macoDeNotas.put(10, qtd10);
		quantidade -= (qtd10 * 10);
		
		int qtd5 = quantidade / 5;
		// se o caixa não tem notas suficiente para entregar, entregue o que puder
		if(qtd5 > QTD_NOTAS_5) {
			qtd5 = QTD_NOTAS_5;
		}
		macoDeNotas.put(5, qtd5);
		quantidade -= (qtd5 * 5);
		
		int qtd1 = quantidade;
		// se o caixa não tem notas suficiente para entregar, entregue o que puder
		if(qtd1 > QTD_NOTAS_1) {
			qtd1 = QTD_NOTAS_1;
		}
		macoDeNotas.put(1, qtd1);
		quantidade -= (qtd1 * 1);
		
		if(quantidade > 0) {
			throw new RuntimeException("Notas insuficientes para realizar o pagamento");
		}
		
		boolean resultado = banco.atualizarSaldo(id, novoSaldo);
		if(!resultado) {
			throw new RuntimeException("Erro ao atualziar saldo, por favor tente novamente mais tarde.");
		}
		
		// atualiza a quantidade de notas no caixa;
		QTD_NOTAS_50 -= qtd50;
		QTD_NOTAS_20 -= qtd20;
		QTD_NOTAS_10 -= qtd10;
		QTD_NOTAS_5 -= qtd5;
		QTD_NOTAS_1 -= qtd1;
		
		return macoDeNotas;
	}
	
	/**
	 * Realiza um deposito na conta do cliente
	 * 
	 * @param id,         identificação unica do cliente
	 * @param quantidade, quantidade que será depositada
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public boolean fazerDeposito(int id, int quantidade) throws ClassNotFoundException, SQLException {
		boolean retorno = false;
		int saldoAtual = banco.verificaSaldo(id);
		saldoAtual += quantidade;
		retorno = banco.atualizarSaldo(id, saldoAtual);
		return retorno;
	}
	
	/**
	 * Imprime na tela o saldo do cliente
	 * @param id
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void mostrarSaldo(int id) throws ClassNotFoundException, SQLException {
		int saldoAtual = banco.verificaSaldo(id);
		System.out.println(String.format("O saldo do cliente %d é R$%d BRL", id, saldoAtual));
	}

	public void mostrarSaldoCaixa() {
		
		System.out.println("O caixa ainda tem: ");
		System.out.println(QTD_NOTAS_50 + " notas de 50");
		System.out.println(QTD_NOTAS_20 + " notas de 20");
		System.out.println(QTD_NOTAS_10 + " notas de 10");
		System.out.println(QTD_NOTAS_5 + "  notas de  5");
		System.out.println(QTD_NOTAS_1 + "  notas de  1");
	}
}
