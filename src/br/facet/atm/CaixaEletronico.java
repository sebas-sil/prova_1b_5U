package br.facet.atm;

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

	/**
	 * Verifica se o caixa eletronico tem capacidade de entregar o valor desejado
	 * 
	 * @param quantidade, valor em dinheiro que deve ser verificado
	 * @return verdadeiro se o caixa pode entregar a quantidade solicitada, falso se
	 *         não consegue
	 */
	private boolean verificaNotas(int quantidade) {
		boolean retorno = false;
		/*
		 * TODO adicione a logica para verificar se o caixa eletronico tem quantidade de
		 * notas suficientes para entregar
		 */

		return retorno;
	}

	/**
	 * Realiza um saque da conta do cliente
	 * @param id,         identificação unica do cliente
	 * @param quantidade, quantidade que será retirada
	 * @return
	 */
	public Map<Integer, Integer> fazerSaque(int id, int quantidade) {
		Map<Integer, Integer> macoDeNotas = new HashMap<Integer, Integer>();
		/*
		 * TODO A. adicione a lógica para contar quantas notas de cada são necessárias para
		 * pagar a quantia informada
		 * 
		 * o map deve contar na chave o valor da nota e no valor a quantidade de notas:
		 * ex: para pagar R$1234 reais sao necessárias:
		 * 24 notas de 50
		 * 01 nota  de 20
		 * 01 nota  de 10
		 * 04 notas de  1
		 * 
		 * O map conterá
		 * map.put(50, 24);
		 * map.put(20, 1);
		 * map.put(10, 1);
		 * map.put(1, 4);
		 */
		// TODO O metodo {@link #verificaNotas(int)} deve ser chamado neste metodo
		// TODO B. atualizar o saldo do usuário no cofre do banco
		// TODO C. atualizar a quantidade de notas do caixa eletronico
		return macoDeNotas;
	}
	
	/**
	 * Realiza um deposito na conta do cliente
	 * 
	 * @param id,         identificação unica do cliente
	 * @param quantidade, quantidade que será depositada
	 * @return
	 */
	public boolean fazerDeposito(int id, int quantidade) {
		boolean retorno = false;
		
		return retorno;
	}
	
	/**
	 * Imprime na tela o saldo do cliente
	 * @param id
	 */
	public void mostrarSaldo(int id) {
		
	}
}
