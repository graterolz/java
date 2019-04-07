import javax.swing.*;
import java.awt.event.*;
public class Class42 extends JFrame{
	public Class42 (){
		super("Menu example");
		JMenu file = new JMenu("File");
		file.setMnemonic('F');
		JMenuItem newItem = new JMenuItem("New");
		newItem.setMnemonic('N');
		file.add(newItem);
		JMenuItem openItem = new JMenuItem("Open");
		openItem.setMnemonic('O');
		file.add(openItem);	
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.setMnemonic('x');
		file.add(exitItem);
		newItem.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					JOptionPane.showMessageDialog(null, "Contenido");
					System.out.println("New is pressed");
				}
			}
		);
		openItem.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("Open is pressed");
				}
			}
		);
		exitItem.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("Exit is pressed");
					System.exit(0);
				}
			}
		);
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(file);
		getContentPane();
		setSize(300,300);
		setVisible(true);
	}
	//
	public static void main(String[] args){
		Class42  app = new Class42 ();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}