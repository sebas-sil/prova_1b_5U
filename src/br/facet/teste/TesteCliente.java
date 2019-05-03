package br.facet.teste;

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

	public static void main(String[] args) {
		
		// TODO I. teste, diretamente no banco do cliente, a criação de uma nova conta para o cliente de id 9, com R$2000 na conta
		// TODO II. teste, diretamente no banco do cliente, o encerramento da conta do cliente 2
		// TODO III. teste, pelo caixa eletronico, o saque de R$389 do cliente 10
		// TODO VI. teste, pelo caixa eletrono, o saque de R$1058 do cliente 3
		// TODO V. teste, pelo caixa eletronico, o saque de R$10.000 do cliente 2
		// TODO VI. teste, pelo caixa eletronico, o saque de R$12 do cliente 8
		// TODO VII. teste, pelo caixa eletronico, o deposito de R$20 para o cliente 3
		// TODO VIII. teste, pelo caixa eletronico, o saldo do cliente 2
		// TODO XI. teste, pelo caixa eletronico, o saldo do cliente 3
		// TODO X. teste
		// TODO XI. teste
		// TODO XII. mostre, pelo caixa eletronico, quanto de dinheiro ele ainda tem.
		// TODO XIII. mostre, pelo caixa eletronico, quantas notas sobraram no caixa eletronico apos este dia de movimentação
	}
}
