package view;

import java.util.concurrent.Semaphore;

import controller.TransacaoController;

public class Main {

	public static void main(String[] args) {
		
		Semaphore semaforo = new Semaphore(1);
		
		for(int Id = 0; Id < 21; Id++){
			Thread Transacao = new TransacaoController(Id, semaforo);
			Transacao.start();
		}
		
	}
}
