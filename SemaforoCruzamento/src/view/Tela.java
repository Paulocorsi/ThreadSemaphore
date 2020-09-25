package view;

import java.awt.EventQueue;
import java.util.concurrent.Semaphore;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ThreadController;

import javax.swing.JLabel;

public class Tela extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Semaphore semaforo = new Semaphore(1);
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCarro = new JLabel("Carro1");
		lblCarro.setBounds(120, 127, 46, 14);
		contentPane.add(lblCarro);
		
		JLabel lblCarro_1 = new JLabel("Carro2");
		lblCarro_1.setBounds(214, 164, 46, 14);
		contentPane.add(lblCarro_1);
		
		JLabel lblCarro_2 = new JLabel("Carro3");
		lblCarro_2.setBounds(260, 99, 46, 14);
		contentPane.add(lblCarro_2);
		
		JLabel lblCarro_3 = new JLabel("Carro4");
		lblCarro_3.setBounds(165, 65, 46, 14);
		contentPane.add(lblCarro_3);
		
		Thread threadcontroller = new ThreadController(lblCarro, lblCarro_1, lblCarro_2, lblCarro_3, semaforo );
		threadcontroller.start();
	}
}
