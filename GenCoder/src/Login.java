import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Login extends JFrame{
	public Login(){
		super("Login ADMINISTRADOR");
		setSize(250,200);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		Contenedor(getContentPane());
		ImageIcon Imagen = new ImageIcon("src/Fondo.jpg");
		JLabel Img = new JLabel(Imagen);
		add(Img);
		Img.setOpaque(false);
		Img.updateUI();
	}
	//
	public void Contenedor(Container Add_JFrame){
		//JLabel ESPACIO = new JLabel("");
		//JL_Codigo.setForeground(Color.BLACK);
		//JL_Codigo.setBounds(50,210,180,80);
		//JL_Codigo.updateUI();
		JLabel JL_Titulo = new JLabel("Ingrese Usuario y Contraseña");
		JL_Titulo.setForeground(Color.WHITE);
		JL_Titulo.setBounds(30,10,180,20);
		JL_Titulo.updateUI();
		//
		JLabel JL_User = new JLabel("User :");
		JL_User.setForeground(Color.WHITE);
		JL_User.setBounds(30,50,180,20);
		JL_User.updateUI();
		final JTextField JT_User = new JTextField();
		JT_User.setBounds(90,50,100,20);
		JT_User.updateUI();
		//
		JLabel JL_Pass = new JLabel("Pass :");
		JL_Pass.setForeground(Color.WHITE);
		JL_Pass.setBounds(30,80,180,20);
		JL_Pass.updateUI();
		final JPasswordField JP_Pass = new JPasswordField();
		JP_Pass.setBounds(90,80,100,20);
		JP_Pass.updateUI();
		JP_Pass.addKeyListener(new KeyAdapter(){
			@Override
			public void keyTyped (KeyEvent e){
				String KEY = KeyEvent.getKeyText(e.getKeyChar());
				if (KEY.equals("Introduzca")){
					final String S_USER = JT_User.getText();
					final String S_PASS = JP_Pass.getText();
					if (S_USER.equals("ADMIN") && S_PASS.equals("gencoder20660429")){
						GenCoder Inicio_Aplicacion = new GenCoder();
						Inicio_Aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						setVisible(false);
					}
					else if (S_USER.equals("admin") && S_PASS.equals("GENCODER20660429")){
						GenCoder Inicio_Aplicacion = new GenCoder();
						Inicio_Aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						setVisible(false);
					}
					else{
						JOptionPane.showMessageDialog(null,"Usuario/Contraseña Invalida.\nIntente Nuevamente.","GenCoder",JOptionPane.ERROR_MESSAGE);
						JT_User.setText("");
						JP_Pass.setText("");
						JT_User.grabFocus();
					}
				}
			}
		});
		//
		final JButton LOGIN = new JButton("Entrar");
		LOGIN.setBounds(30,130,80,20);
		LOGIN.updateUI();
		LOGIN.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent evt){
				final String S_USER = JT_User.getText();
				final String S_PASS = JP_Pass.getText();
				if (S_USER.equals("ADMIN") || S_USER.equals("admin") && S_PASS.equals("GENCODER20660429")||S_PASS.equals("gencoder20660429")){
					GenCoder Inicio_Aplicacion = new GenCoder();
					Inicio_Aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(null,"Usuario/Contraseña Invalida.\nIntente Nuevamente.","GenCoder",JOptionPane.ERROR_MESSAGE);
					JT_User.setText("");
					JP_Pass.setText("");
					JT_User.grabFocus();
				}
			}
		});
		//
		JButton SALIR = new JButton("Salir");
		SALIR.setBounds(120,130,80,20);
		SALIR.updateUI();
		SALIR.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent evt){
				System.exit(0);
			}
		});
		//
		add(JL_Titulo);
		add(JL_User);
		add(JL_Pass);
		add(JT_User);
		add(JP_Pass);
		add(LOGIN);
		add(SALIR);
		//add(ESPACIO);
	}
}