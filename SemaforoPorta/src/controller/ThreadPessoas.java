package controller;

import java.util.concurrent.Semaphore;

public class ThreadPessoas extends Thread{

	private int Pessoa;
	private Semaphore semaforo;
	private int Corredor;
	
	public ThreadPessoas(int pessoa, int Corredor, Semaphore semaforo){
		this.Pessoa = pessoa;
		this.semaforo = semaforo;
		this.Corredor = Corredor;
	}
	
	@Override
	public void run() {
		Andar();
		try{
			semaforo.acquire();
			Espera();
			Disponivel();
		}catch(InterruptedException e){
			
		}finally{
			semaforo.release();
		}
	}

	private void Andar() {
		int QtdAndada = 0;
		while(QtdAndada < Corredor){
			int Andou =(int) (Math.random() * (3) + 4);
			QtdAndada += Andou;
			if(QtdAndada > 200){
				int Max = QtdAndada;
				QtdAndada -= Max - 200;
			}
			System.out.println("PESSOA: " + Pessoa + " ANDOU " + QtdAndada);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("PESSOA: " + Pessoa + " CHEGOU");
	}
	
	private void Espera(){
		int Tempo = (int)(Math.random()*(2001)+1000);
		System.out.println("PESSOA " + Pessoa + " CRUZANDO A PORTA");
		try {
			Thread.sleep(Tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void Disponivel(){
		System.out.println("PORTA DISPONÍVEL");
	}
}
