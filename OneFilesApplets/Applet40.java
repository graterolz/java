import java.awt.*;
import java.applet.*;

public class Applet40 extends Applet {
	Scrollbar R=new Scrollbar(Scrollbar.VERTICAL, 0, 1, 0, 255);
	Scrollbar G=new Scrollbar(Scrollbar.VERTICAL, 0, 1, 0, 255);
	Scrollbar B=new Scrollbar(Scrollbar.VERTICAL, 0, 1, 0, 255);
	Choice FN=new Choice();
	Choice GR=new Choice();
	Checkbox F=new Checkbox("Figuras cerradas llenas",false);
	int [] puntosX={1,100,200,300,399,300,200,100};
	int [] puntosY={200,150,50,150,200,100,250,130};
	int puntos=8;
	//
	public void init() {
		String [] NOMBRES=Toolkit.getDefaultToolkit().getFontList();
		try {
			int índice=0;
			while (true)
				FN.addItem(NOMBRES[índice++]);
		}
		catch (ArrayIndexOutOfBoundsException e){

		};
		setLayout(new BorderLayout());
		Panel np=new Panel(new GridLayout(1,3));
		Panel rojo=new Panel(new FlowLayout());
		rojo.add(new Label("Rojo"));
		rojo.add(R);
		np.add(rojo);
		Panel verde=new Panel(new FlowLayout());
		verde.add(new Label("Verde"));
		verde.add(G);
		np.add(verde);
		Panel azul=new Panel(new FlowLayout());
		azul.add(new Label("Azul"));
		azul.add(B);
		np.add(azul);
		R.setUnitIncrement(10);
		R.setValue(255);
		G.setUnitIncrement(10);
		G.setValue(255);
		B.setUnitIncrement(10);
		B.setValue(255);
		add(np,BorderLayout.SOUTH);
		GR.addItem("Línea");
		GR.addItem("Rectángulo");
		GR.addItem("Rectángulo 3D");
		GR.addItem("Rectángulo Redondeado");
		GR.addItem("Círculo");
		GR.addItem("Elípses");
		GR.addItem("Polígono genérico");
		GR.addItem("Texto");
		GR.addItem("Arco");
		Panel up=new Panel(new GridLayout(1,3));
		up.add(GR);
		up.add(FN);
		up.add(F);
		add(up,BorderLayout.NORTH);
		R.addAdjustmentListener(new AL());
		G.addAdjustmentListener(new AL());
		B.addAdjustmentListener(new AL());
		GR.addItemListener(new IL());
		FN.addItemListener(new IL());
		F.addItemListener(new IL());
	}
	//
	public void paint(Graphics g) {
		g.setColor(new Color(255-R.getValue(),255-G.getValue(),255-B.getValue()));
		g.setFont(new Font(FN.getSelectedItem(),0,40));
		boolean filled=F.getState();
		int pg=GR.getSelectedIndex();
		g.drawString(GR.getSelectedItem(),1,300);
		if (pg==0) {
			g.drawLine(1,100,399,300);
			return;
		}
		if (pg==1) {
			g.drawRect(50,100,250,100);
			if (filled) g.fillRect(50,100,250,100);
			return;
		}
		if (pg==2) {
			g.draw3DRect(50,100,250,100,true);
			return;
		}
		if (pg==3) {
			g.drawRoundRect(50,100,300,100,20,20);
			if (filled) g.fillRoundRect(50,100,300,100,20,20);
			return;
		}
		if (pg==4) {
			g.drawOval(100,100,200,200);
			if (filled) g.fillOval(100,100,200,200);
			return;
		}
		if (pg==5) {
			g.drawOval(100,100,200,100);
			if (filled) g.fillOval(100,100,200,100);
			return;
		}
		if (pg==6) {
			g.drawPolygon(puntosX,puntosY,puntos);
			if (filled) g.fillPolygon(puntosX,puntosY,puntos);
			return;
		}
		if (pg==7){
			g.drawString("Ésta es una cadena",1,200);
			return;
		}
		if (pg==8) {
			g.drawArc(1,50,398,200,10,270);
			if (filled) g.fillArc(1,50,398,200,10,270);
			return;
		}
	}
	//
	public class IL implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			repaint();
		}
	}
	//
	public class AL implements AdjustmentListener {
		public void adjustmentValueChanged(AdjustmentEvent e) {
			repaint();
		}
	}
}