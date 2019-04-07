import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Class49 extends JFrame implements ActionListener{
	private JButton btn1,btn2,btn3,btn4,btn5;
	private JTextField val1,val2,resul;
	//
	public void Controles(){
		Container contenedor = getContentPane();
		contenedor.setLayout(new FlowLayout(FlowLayout.CENTER));
		Label lbl1 = new Label("Numero");
		contenedor.add(lbl1);
		val1 = new JTextField(10);
		contenedor.add(val1);
		Label lbl2 = new Label("Numero");
		contenedor.add(lbl2);
		val2 = new JTextField(10);
		contenedor.add(val2);
		btn1 = new JButton("+");
		contenedor.add(btn1);
		btn1.addActionListener(this);
		btn2 = new JButton("-");
		contenedor.add(btn2);
		btn2.addActionListener(this);
		btn3 = new JButton("x");
		contenedor.add(btn3);
		btn3.addActionListener(this);
		btn4 = new JButton("/");
		contenedor.add(btn4);
		btn4.addActionListener(this);
		btn5 = new JButton("Limpiar");
		contenedor.add(btn5);
		btn5.addActionListener(this);
		resul = new JTextField(10);
		contenedor.add(resul);
	}
	//
	public Class49(){
		super("Class49");
		Controles();
		setSize(380,150);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	//
	public void actionPerformed(ActionEvent e) {
		double  num1,num2,resu;
		String resultado;
		if (e.getSource()==btn1) {
			if(val1.getText().equals("") || val2.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Los datos Est�n Incompletos","Error",JOptionPane.ERROR_MESSAGE);
			}
			else{
				num1=Double.parseDouble(val1.getText());
				num2=Double.parseDouble(val2.getText());
				resu=num1+num2;
				resultado=String.valueOf(resu);
				resul.setText(resultado);
			}
		}
		if (e.getSource()==btn2) {
			if(val1.getText().equals("") || val2.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Los datos Est�n Incompletos","Error",JOptionPane.ERROR_MESSAGE);
			}
			else{
				num1=Double.parseDouble(val1.getText());
				num2=Double.parseDouble(val2.getText());
				resu=num1-num2;
				resultado=String.valueOf(resu);
				resul.setText(resultado);
			}
		} 
		if (e.getSource()==btn3) {
			if(val1.getText().equals("") || val2.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Los datos Est�n Incompletos","Error",JOptionPane.ERROR_MESSAGE); 
			}
			else{
				num1=Double.parseDouble(val1.getText());
				num2=Double.parseDouble(val2.getText());
				resu=num1*num2;
				resultado=String.valueOf(resu);
				resul.setText(resultado);
			}
		}
		if (e.getSource()==btn4) {
			if(val1.getText().equals("") || val2.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Los datos Est�n Incompletos","Error",JOptionPane.ERROR_MESSAGE);
			}
			else{
				num1=Double.parseDouble(val1.getText());
				num2=Double.parseDouble(val2.getText());
				try{
					resu=num1/num2;
					resultado=String.valueOf(resu);
					resul.setText(resultado);
				}
				catch(ArithmeticException ex){
					JOptionPane.showMessageDialog(null, "No se Puede Dividir Entre 0","Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
		if (e.getSource()==btn5){
			val1.setText("");
			val2.setText("");
			resul.setText("");
		}
	}
	//
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		Class49 calc = new Class49();
		calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
} 