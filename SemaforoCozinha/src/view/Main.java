package view;

import java.util.concurrent.Semaphore;

import controller.PratosController;

public class Main {

	public static void main(String[] args) {
		
		Semaphore semaforo = new Semaphore(1);
		
		for(int Id = 0; Id < 5; Id++){
			Thread Pratos = new PratosController (Id, semaforo);
			Pratos.start();
		}
	}

}
