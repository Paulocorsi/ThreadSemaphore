package controller;

import java.util.concurrent.Semaphore;

public class PratosController extends Thread{

	private int Id;
	private Semaphore semaforo;
	
	public PratosController(int Id, Semaphore semaforo){
		this.Id = Id;
		this.semaforo = semaforo;
	}
	
	public void run() {
		Cozinhar();
		try{
			semaforo.acquire();
			Entregar();
		}catch(InterruptedException e){
			e.printStackTrace();
		}finally{
			semaforo.release();
		}
	}

	private void Cozinhar() {
		
		String Prato = "";
		int Cozinha = 0;
		
		if(Id % 2 == 1){
			
			Prato = "Sopa de Cebola";
			int Tempo = (int)(Math.random()*500+300);
			System.out.println("Prato : "+ Prato + " Sendo Preparado");
			
			while(Cozinha < Tempo){
				try{
					Thread.sleep(100);
					Cozinha += 100; 
					int Progresso = (Cozinha*100)/Tempo;
					if(Progresso > 100){
						Progresso = 100;
					}
					System.out.println("Prato: " + Prato + " Em Progresso " + Progresso + "%");
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			System.out.println("Id " + Id + " Prato: " + Prato + " Finalizado Aguardando Entrega");
		}
		else{
			Prato = "Lasanha a Bolonhesa";
			int Tempo = (int)(Math.random()*600+600);
			System.out.println("Prato : "+ Prato + " Sendo Preparado");
			
			while(Cozinha < Tempo){
				try{
					Thread.sleep(100);
					Cozinha += 100; 
					int Progresso = (Cozinha*100)/Tempo;
					if(Progresso > 100){
						Progresso = 100;
					}
					System.out.println("Prato: " + Prato + " Em Progresso " + Progresso + "%");
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			System.out.println("Id " + Id + " Prato: " + Prato + " Finalizado Aguardando Entrega");
		}
	}
	
	private void Entregar() {
		try{
			System.out.println("Entregando Prato: " + Id);
			Thread.sleep(500);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
}