import java.lang.*;
import java.awt.*;

public class Otros1{
	static Frame ventana= new Frame();
	static Panel p1 = new Panel();
	static Label l1= new Label("clik derecho here");
	static TextField t1 = new TextField(10);
	static PopupMenu cambios = new PopupMenu();
	static MenuItem pd = new MenuItem("pes-dlr");
	static MenuItem dp = new MenuItem("dlr-pesos");
	static MenuItem exit=new MenuItem("Quit");
	//
	public static void main(String[] args) {
		ventana.setTitle("mi programa");
		cambios.add(pd);cambios.add(dp);cambios.add(exit);
		l1.add(cambios);
		l1.addMouseListener( new MouseAdapter(){ 
			public void mouseReleased( MouseEvent e ){
				if ( e.isPopupTrigger() ) 
					cambios.show(l1,100,0 ); 
			}
		});
		p1.add(l1);p1.add(t1);
		ventana.add(p1); ventana.pack(); ventana.setVisible(true);
		ventana.addWindowListener( new WindowAdapter(){ 
			public void windowClosing(WindowEvent e){
				ventana.dispose();
				System.exit(0);
			}
		});
		exit.addActionListener( new ActionListener(){ 
			public void actionPerformed( ActionEvent e ){ 
				System.exit(0);
			}
		});
		pd.addActionListener( new ActionListener(){ 
			public void actionPerformed( ActionEvent e ){ 
				t1.setText("pesos a dolares");
			} 
		});
		dp.addActionListener( new ActionListener(){ 
			public void actionPerformed(ActionEvent e){ 
				t1.setText("dolares a pesos");
			}
		});
	}
}