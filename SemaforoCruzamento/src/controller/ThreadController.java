package controller;

import java.util.concurrent.Semaphore;
import javax.swing.JLabel;

public class ThreadController extends Thread {

	private JLabel lblCarro;
	private JLabel lblCarro_1;
	private JLabel lblCarro_2;
	private JLabel lblCarro_3;
	private Semaphore semaforo;
	
	public ThreadController(JLabel lblCarro, JLabel lblCarro_1, JLabel lblCarro_2, JLabel lblCarro_3,Semaphore semaforo){
		this.lblCarro = lblCarro;
		this.lblCarro_1 = lblCarro_1;
		this.lblCarro_2 = lblCarro_2;
		this.lblCarro_3 = lblCarro_3;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		Start();
	}

	private void Start() {
		Thread ThreadCarro = new ThreadCarros(lblCarro, semaforo);
		Thread ThreadCarro_1= new ThreadCarros(lblCarro_1,semaforo);
		Thread ThreadCarro_2= new ThreadCarros(lblCarro_2,semaforo);
		Thread ThreadCarro_3= new ThreadCarros(lblCarro_3,semaforo);
		ThreadCarro.start();
		ThreadCarro_1.start();
		ThreadCarro_2.start();
		ThreadCarro_3.start();
	}
}
