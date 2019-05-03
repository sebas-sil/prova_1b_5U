package br.facet.atm;

/**
 * Classe que comanda todos os caixas eletronicos do banco. Você não deve mexer
 * nesta classe. Existe apenas um caixa eletronico disponivel no momento
 * 
 * @author Fábio Sebastian Silveira
 *
 */
abstract class ATM {

	static Banco BANCO = new Banco();
	
	/**
	 * Quantidade máxima de notas de R$50 neste ATM
	 */
	static int QTD_NOTAS_50 = 100;

	/**
	 * Quantidade máxima de notas de R$20 neste ATM
	 */
	static int QTD_NOTAS_20 = 100;

	/**
	 * Quantidade máxima de notas de R$10 neste ATM
	 */
	static int QTD_NOTAS_10 = 100;

	/**
	 * Quantidade máxima de notas de R$5 neste ATM
	 */
	static int QTD_NOTAS_5 = 100;

	/**
	 * Quantidade máxima de notas de R$1 neste ATM
	 */
	static int QTD_NOTAS_1 = 100;
}
