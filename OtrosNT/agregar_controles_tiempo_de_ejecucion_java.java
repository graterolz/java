import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame implements ActionListener {
	private JButton jButton1 = new JButton();
	private LinkedList<JButton> mBotones = new LinkedList<JButton>();
	//
	public MainFrame() {
		try {
			jbInit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	//
	private void jbInit() throws Exception {
		this.getContentPane().setLayout( new FlowLayout() );
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize( new Dimension(400, 300) );
		jButton1.setText("Agregar");
		jButton1.setBounds(new Rectangle(15, 15, 81, 22));
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton1_actionPerformed(e);
			}
		});
		this.getContentPane().add(jButton1, null);
	}
	//
	public void actionPerformed(ActionEvent e) {
		JButton temp = (JButton) e.getSource();
		JOptionPane.showMessageDialog(this, "Click en el boton " + temp.getText() );
	}
	//
	private void jButton1_actionPerformed(ActionEvent e) {
		JButton temp = new JButton("boton " + (mBotones.size()+1) );
		mBotones.add(temp);
		this.add(temp);
		temp.addActionListener(this);
		this.validateTree();
	}
}
//
public class Main {
	public Main() {
		super();
	}
	//
	public static void main(String[] args) {
		System.out.println("prueba");
		MainFrame f = new MainFrame();
		f.setVisible(true);
	}
}