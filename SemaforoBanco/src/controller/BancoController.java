package controller;

import java.util.concurrent.Semaphore;

public class BancoController extends Thread {
	
	private int IdConta;
	private int Saldo;
	private int VTransf;
	private int Tipo;
	private Semaphore Saque;
	private Semaphore Deposito;
	
	public BancoController(int IdConta, int Saldo, int VTransf, int Tipo, Semaphore Saque, Semaphore Deposito){
		this.IdConta = IdConta;
		this.Saldo = Saldo;
		this.VTransf = VTransf;
		this.Tipo = Tipo;
		this.Saque = Saque;
		this.Deposito = Deposito;
	}
	
	@Override
	public void run() {
		switch(Tipo){
		case 1:
			try{
				Saque.acquire();
				Sacar();
			}catch(InterruptedException e){
				e.printStackTrace();
			}finally{
				Saque.release();
			}
		case 2:
			try{
				Deposito.acquire();
				Depositar();
			}catch(InterruptedException e){
				e.printStackTrace();
			}finally{
				Deposito.release();
			}
		}
	}

	private void Depositar() {
		Saldo += VTransf;
		System.out.println("CONTA: "+IdConta+ " DEPOSITOU " + VTransf + " SALDO " + Saldo);
	}

	private void Sacar() {
		Saldo -= VTransf;
		System.out.println("CONTA: "+IdConta+ " SACOU " + VTransf + " SALDO " + Saldo);
	}
}
