package br.facet.teste;

import java.sql.SQLException;
import java.util.Map;

import br.facet.atm.Banco;
import br.facet.atm.CaixaEletronico;

public class TesteCliente {
	/**
	 * Instancia para lidar com a interface do CaixaEletronico
	 */
	CaixaEletronico caixaEletronico = new CaixaEletronico();

	/**
	 * Instancia para lidar com o banco e seu cofre
	 */
	Banco banco = new Banco();

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		TesteCliente teste = new TesteCliente();
		
		try {
			// I. teste, diretamente no banco do cliente, a criação de uma nova conta para o cliente de id 9, com R$2000 na conta
			boolean resultado = teste.banco.abreConta(9, 2000);
			System.out.println("A abertura da conta funcionou? " + resultado);
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		
		try {
			// III. teste, pelo caixa eletronico, o saque de R$389 do cliente 10
			Map<Integer, Integer> resultado = teste.caixaEletronico.fazerSaque(10, 389);
			System.out.println(String.format("O cliente sacou as notas %s.", resultado));
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		try {
			// VI. teste, pelo caixa eletrono, o saque de R$1058 do cliente 3
			Map<Integer, Integer> resultado = teste.caixaEletronico.fazerSaque(3, 1058);
			System.out.println(String.format("O cliente sacou as notas %s.", resultado));
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		try {
			// V. teste, pelo caixa eletronico, o saque de R$10.000 do cliente 2
			Map<Integer, Integer> resultado = teste.caixaEletronico.fazerSaque(2, 10000);
			System.out.println(String.format("O cliente sacou as notas %s.", resultado));
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		try {
			// II. teste, diretamente no banco do cliente, o encerramento da conta do cliente 2
			boolean resultado = teste.banco.encerrarConta(2);
			System.out.println("O encerramento da conta funcionou? " + resultado);
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		try {
			// VIII. teste, pelo caixa eletronico, o saldo do cliente 2
			teste.caixaEletronico.mostrarSaldo(2);
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		try {
			// VI. teste, pelo caixa eletronico, o saque de R$12 do cliente 8
			Map<Integer, Integer> resultado = teste.caixaEletronico.fazerSaque(8, 12);
			System.out.println(String.format("O cliente sacou as notas %s.", resultado));
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		
		try {
			// VII. teste, pelo caixa eletronico, o deposito de R$20 para o cliente 3
			Map<Integer, Integer> resultado = teste.caixaEletronico.fazerSaque(3, 20);
			System.out.println(String.format("O cliente sacou as notas %s.", resultado));
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		try {
			// XI. teste, pelo caixa eletronico, o saldo do cliente 3
			teste.caixaEletronico.mostrarSaldo(3);
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		try {
			// XII. mostre, pelo caixa eletronico, quanto de dinheiro ele ainda tem.
			// XIII. mostre, pelo caixa eletronico, quantas notas sobraram no caixa eletronico apos este dia de movimentação
			teste.caixaEletronico.mostrarSaldoCaixa();
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
