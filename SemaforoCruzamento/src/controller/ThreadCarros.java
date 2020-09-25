package controller;

import java.awt.Rectangle;
import java.util.concurrent.Semaphore;

import javax.swing.JLabel;

public class ThreadCarros extends Thread {

	private Semaphore semaforo;	
	private JLabel lblCarro;
	public ThreadCarros(JLabel lblCarro, Semaphore semaforo){
		this.semaforo = semaforo;
		this.lblCarro = lblCarro;
	}
	
	@Override
	public void run() {
	try {
		semaforo.acquire();
		Andar();
		carroParado();
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		semaforo.release();
	}
	}

	private void Andar() {

	Rectangle posicao;
	posicao = lblCarro.getBounds();
	lblCarro.setBounds(posicao);
	
	int TotalTela = 150;
	int distPercorrida = 0;
	int Mexeu;
	
	while(distPercorrida < TotalTela){
		Mexeu = (int)(Math.random()*5)+1;
		distPercorrida += Mexeu;
		
		if(lblCarro.getText() == "Carro1"){
			posicao.x += Mexeu;
			lblCarro.setBounds(posicao);
		}else if(lblCarro.getText() == "Carro3"){
			posicao.x -= Mexeu;
			lblCarro.setBounds(posicao);
		}else if(lblCarro.getText() == "Carro2"){
			posicao.y -= Mexeu;
			lblCarro.setBounds(posicao);
		}else if(lblCarro.getText() == "Carro4"){
			posicao.y += Mexeu;
			lblCarro.setBounds(posicao);
		}
		carroParado();
	}
}
	
	private void carroParado() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}
