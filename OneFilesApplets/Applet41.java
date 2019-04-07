import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Applet41 extends JApplet {
	JPanel pbotones;
	ArrayList botones;
	int contador=0;
	String usuarioganador="";
	boolean ganador=false;
	//
	public void init(){
		colocarSkin();
		pbotones=new JPanel();
		pbotones.setLayout(new GridLayout(3,3));
		botones=new ArrayList();
		inicializarBotones();
		add(pbotones);
	}
	//
	public void colocarSkin(){
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (InstantiationException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
	//
	public void inicializarBotones(){
		for(int i=0;i<9;i++){
			final JButton b=new JButton("");
			b.setFont(new Font("Arial",Font.BOLD,40));
			b.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					if(!b.getText().equalsIgnoreCase("X") && !b.getText().equalsIgnoreCase("O")){
						b.setText("X");
						contador++;
						try {
							if(contador<=4 && ganador==false){
								Thread.sleep(200);
								colocarRespuestaCPU();
							}
							verificarGanador();
							if(contador==5 && ganador==false){
								int r=JOptionPane.showConfirmDialog(null, "Desea volver a jugar?");
								if(r==JOptionPane.OK_OPTION){
									for(JButton b:botones){
										b.setText("");
									}
									ganador=false;
									contador=0;
								}
							}
						}
						catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			if(i!=8){
				if(i==2 || i==5){
					b.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.BLACK));
				}
				else{
					if(i==6 || i==7){
						b.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, Color.BLACK));
					}
					else{
						b.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 3, Color.BLACK));
					}
				}
			}
			pbotones.add(b);
			botones.add(b);
		}
	}
	//
	public void colocarRespuestaCPU(){
		int r=(int) (Math.random()*9);
		while(botones.get(r).getText()!=""){
			r=(int) (Math.random()*9);
		}
		botones.get(r).setText("O");
	}
	//
	public void verificarGanador(){
		if(comparar()){
			this.ganador=true;
			int r=JOptionPane.showConfirmDialog(null, "El Jugador "+usuarioganador+" es el GANADOR, desea volver a jugar?");
			if(r==JOptionPane.OK_OPTION){
				for(JButton b:botones){
					b.setText("");
				}
				ganador=false;
				contador=0;
			}
			else{
				for(JButton b:botones){
					b.setEnabled(false);
				}
			}
		}
	}
	//
	public boolean comparar(){
		boolean ganador=false;
		if(!botones.get(0).getText().equalsIgnoreCase("") || !botones.get(1).getText().equalsIgnoreCase("") || !botones.get(2).getText().equalsIgnoreCase("")){
			if(botones.get(0).getText().equalsIgnoreCase(botones.get(1).getText()) && botones.get(0).getText().equalsIgnoreCase(botones.get(2).getText())){
				ganador=true;
				usuarioganador=botones.get(0).getText();
			}
		}
		if(!botones.get(3).getText().equalsIgnoreCase("") || !botones.get(4).getText().equalsIgnoreCase("") || !botones.get(5).getText().equalsIgnoreCase("")){
			if(botones.get(3).getText().equalsIgnoreCase(botones.get(4).getText()) && botones.get(3).getText().equalsIgnoreCase(botones.get(5).getText())){
				ganador=true;
				usuarioganador=botones.get(3).getText();
			}
		}
		if(!botones.get(6).getText().equalsIgnoreCase("") || !botones.get(7).getText().equalsIgnoreCase("") || !botones.get(8).getText().equalsIgnoreCase("")){
			if(botones.get(6).getText().equalsIgnoreCase(botones.get(7).getText()) && botones.get(6).getText().equalsIgnoreCase(botones.get(8).getText())){
				ganador=true;
				usuarioganador=botones.get(6).getText();
			}
		}
		if(!botones.get(0).getText().equalsIgnoreCase("") || !botones.get(3).getText().equalsIgnoreCase("") || !botones.get(6).getText().equalsIgnoreCase("")){
			if(botones.get(0).getText().equalsIgnoreCase(botones.get(3).getText()) && botones.get(0).getText().equalsIgnoreCase(botones.get(6).getText())){
				ganador=true;
				usuarioganador=botones.get(0).getText();
			}
		}
		if(!botones.get(1).getText().equalsIgnoreCase("") || !botones.get(4).getText().equalsIgnoreCase("") || !botones.get(7).getText().equalsIgnoreCase("")){
			if(botones.get(1).getText().equalsIgnoreCase(botones.get(4).getText()) && botones.get(1).getText().equalsIgnoreCase(botones.get(7).getText())){
				ganador=true;
				usuarioganador=botones.get(1).getText();
			}
		}
		if(!botones.get(2).getText().equalsIgnoreCase("") || !botones.get(5).getText().equalsIgnoreCase("") || !botones.get(8).getText().equalsIgnoreCase("")){
			if(botones.get(2).getText().equalsIgnoreCase(botones.get(5).getText()) && botones.get(2).getText().equalsIgnoreCase(botones.get(8).getText())){
				ganador=true;
				usuarioganador=botones.get(2).getText();
			}
		}
		if(!botones.get(0).getText().equalsIgnoreCase("") || !botones.get(4).getText().equalsIgnoreCase("") || !botones.get(8).getText().equalsIgnoreCase("")){
			if(botones.get(0).getText().equalsIgnoreCase(botones.get(4).getText()) && botones.get(0).getText().equalsIgnoreCase(botones.get(8).getText())){
				ganador=true;
				usuarioganador=botones.get(0).getText();
			}
		}
		if(!botones.get(2).getText().equalsIgnoreCase("") || !botones.get(4).getText().equalsIgnoreCase("") || !botones.get(6).getText().equalsIgnoreCase("")){
			if(botones.get(2).getText().equalsIgnoreCase(botones.get(4).getText()) && botones.get(2).getText().equalsIgnoreCase(botones.get(6).getText())){
				ganador=true;
				usuarioganador=botones.get(2).getText();
			}
		}
		return ganador;
	}
}