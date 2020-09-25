package view;

import java.util.concurrent.Semaphore;

import controller.BancoController;

public class Main {

	public static void main(String[] args) {
		
		int permissoes = 1;
		int IdConta;
		int Saldo;
		int VTransf;
		
		Semaphore Saque = new Semaphore(permissoes);
		Semaphore Deposito = new Semaphore(permissoes);
		
		for(IdConta=1; IdConta<21; IdConta++){
			int Tipo = (int)(Math.random()*2)+1;
			VTransf = (int)(Math.random()*2001)+1000;
			Saldo = (int)(Math.random()*5001)+2000;
			Thread bancoController = new BancoController(IdConta, Saldo, VTransf, Tipo, Saque, Deposito);
			bancoController.start();
		}
	}
}
