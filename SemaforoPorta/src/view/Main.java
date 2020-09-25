package view;

import java.util.concurrent.Semaphore;
import controller.ThreadPessoas;

public class Main {

	public static void main(String[] args) {
		int Corredor =200;
		int Permissoes = 1;
		Semaphore semaforo = new Semaphore(Permissoes);
		for(int pessoa=0; pessoa<3; pessoa++){
			Thread threadPessoas = new ThreadPessoas(pessoa, Corredor,semaforo);
			threadPessoas.start();
		}
	}
}
