package controller;

import java.util.concurrent.Semaphore;

public class TransacaoController extends Thread {

	private int Id;
	private Semaphore semaforo;
	private int QtdTransacao;
	
	public TransacaoController(int Id, Semaphore semaforo){
		this.Id = Id;
		this.semaforo = semaforo;
	}
	
	public void run() {
		
		if(Id % 3 == 0 || Id % 3 == 2){
			QtdTransacao = 3;
		}else{
			QtdTransacao = 2;
		}
		
		for(int i=0; i<QtdTransacao; i++){
			Calc();
			try{
				semaforo.acquire();
				Transacao();
			}catch(InterruptedException e){
				e.printStackTrace();
			}finally{
				semaforo.release();
			}
			System.out.println("Thread: " + Id + " Finalizou");
		}
		
	}

	private void Calc() {
		
		System.out.println("Thread: " + Id + " Relizando Calculos");
		
		if(Id % 3 == 1){
			int Tempo = (int)(Math.random()*801+200);
			try{
				Thread.sleep(Tempo);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}else if(Id % 3 == 2){
			int Tempo = (int)(Math.random()*1000+500);
			try{
				Thread.sleep(Tempo);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}else {
			int Tempo = (int)(Math.random()*1000+1000);
			try{
				Thread.sleep(Tempo);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
	}
	
	private void Transacao() {
		
		System.out.println("Thread: " + Id + " Realizando Transação");
		
		if(Id % 3 == 0 || Id % 3 == 2){
			try{
				Thread.sleep(1500);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}else if(Id % 3 == 1){
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
	}
}
