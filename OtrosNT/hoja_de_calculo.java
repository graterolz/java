import java.awt.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.text.html.*;
import javax.swing.border.*;
import javax.accessibility.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class info {
	static Frame my= new Frame();
	//
	public info ( Frame frame, boolean modal ) {
		Label Us =new Label  ("Universidad de San Carlos de Guatemala");
		Label FI =new Label  ("Facultad de Ingenieria");
		Label ECS=new Label  ("Escuela de Ciencias y Sistemas");
		Label Se =new Label  ("Segundo Semestre 2005");
		Label Cur=new Label  ("Introduccion a la Programacion 1");
		Label Prg=new Label  ("");
		Label Id =new Label  ("");
		Us.setFont(new Font("SansSerif",Font.PLAIN,25));
		FI.setFont(new Font("SansSerif",Font.PLAIN,20));
		ECS.setFont(new Font("SansSerif",Font.PLAIN,20));
		Se.setFont(new Font("SansSerif",Font.PLAIN,20));
		Cur.setFont(new Font("SansSerif",Font.PLAIN,20));
		Prg.setFont(new Font("SansSerif",Font.PLAIN,20));
		Id.setFont(new Font("SansSerif",Font.PLAIN,20));
		Us.setBounds (50,50,500,30);
		FI.setBounds (50,80,500,30);
		ECS.setBounds(50,110,500,30);
		Se.setBounds (50,140,500,30);
		Cur.setBounds (50,170,500,30);
		Prg.setBounds(50,200,500,30);
		Id.setBounds (50,230,500,30);
		Us.setVisible(true);
		FI.setVisible(true);
		ECS.setVisible(true);
		Se.setVisible(true);
		Cur.setVisible(true);
		Prg.setVisible(true);
		Id.setVisible(true);
		my.setTitle("Acerca de...");
		my.setLayout(null);
		my.add(Us);
		my.add(FI);
		my.add(ECS);
		my.add(Se);
		my.add(Cur);
		my.add(Prg);
		my.add(Id);
		my.pack(); 
		my.setSize(600,300);
		my.setResizable(false);
		my.addWindowListener( new WindowAdapter(){ 
			public void windowClosing(WindowEvent e){
				my.dispose();
				my.setVisible(false);
			}
		});
	}
}
//
class myDataModel extends DefaultTableModel implements TableCellRenderer {
	public myDataModel() {
		super(100, 100);
		nuevo();
	}
	//
	public void nuevo() {
		int i, j;
		for (i = 0; i <= super.getColumnCount() - 1; i++) {
			for (j = 0; j <= super.getRowCount() - 1; j++) {
				super.setValueAt(new CellData(), i, j);
			}
		}
	}
	//
	public void setvect(Vector c) {
		dataVector = null;
		dataVector = c;
	}
	//
	public void setColorAt(Color val, int r, int c) {
		CellData b = (CellData)super.getValueAt(r, c);
		b.b = val;
	}
	//
	public void setFColorAt(Color val, int r, int c) {
		CellData b = (CellData)super.getValueAt(r, c);
		b.f = val;
	}
	//
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		if (aValue instanceof CellData) {
			super.setValueAt(aValue, rowIndex, columnIndex);
		} else {
			CellData b = (CellData)super.getValueAt(rowIndex, columnIndex);
			b.s = aValue.toString();
			super.setValueAt(b, rowIndex, columnIndex);
		}
	}
	//
	public Component getTableCellRendererComponent(JTable tabla, Object value,boolean isSelected,boolean hasFocus, int row,int column) {
		DefaultTableCellRenderer f = new DefaultTableCellRenderer();
		if (value instanceof CellData && !isSelected) {
			CellData b = (CellData)super.getValueAt(row, column);
			f.setBackground(b.b);
			f.setForeground(b.f);
			f.setText(b.s);
			return (Component)f;
		}
		else if (hasFocus) {
			CellData b = (CellData)super.getValueAt(row, column);
			Color t = new Color(255 - b.b.getRed(), 255 - b.b.getGreen(), 255 - b.b.getBlue());
			f.setBackground(t);
			f.setForeground(new Color(255 - t.getRed(), 255 - t.getGreen(),255 - t.getBlue()));
			f.setText(b.s);
			return (Component)f;
		}
		else {
			return f.getTableCellRendererComponent(tabla, value, isSelected,hasFocus, row, column);
		}
	}
}
//
class CellData extends Object implements Serializable, Cloneable {
	public String s = new String("");
	public Color b = Color.white;
	public Color f = Color.black;
	//
	public CellData() {}
	//
	public String toString() {
		return s;
	}
	//
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
//
public class P2 extends Frame {
	myDataModel data = new myDataModel();
	JTable tabla = new JTable(data);
	JScrollPane panelScroll = new JScrollPane(tabla);
	CellData[][] clipboard;
	info in = new info(P2.this, true);
	Screen Scr = new Screen(P2.this, true);
	User us = new User(P2.this, true);
	//
	public class Calc extends JPanel {
		public Calc() {
			setLayout(new BorderLayout());
			tabla.setDefaultRenderer(Object.class, data);
			tabla.setRowSelectionAllowed(true);
			tabla.setColumnSelectionAllowed(true);
			tabla.setSelectionForeground(Color.blue);
			tabla.setSelectionBackground(Color.green);
			tabla.setAutoResizeMode(0);
			tabla.getTableHeader().setReorderingAllowed(false);
			tabla.setDoubleBuffered(true);
			add(panelScroll);
		}
	}
	//
	public P2() {
		MenuBar menuBar = new MenuBar();
		Menu menuFile = new Menu("Archivo");
		Menu menuEdit = new Menu("Edicion");
		Menu menuForm = new Menu("Formato");
		Menu menuHelp = new Menu("Ayuda");
		MenuItem menuFileNew = new MenuItem("Nuevo");
		MenuItem menuFileOpen = new MenuItem("Abrir");
		MenuItem menuFileSave = new MenuItem("Guardar");
		MenuItem menuFileClos = new MenuItem("Cerrar");
		MenuItem menuFileExit = new MenuItem("Salir");
		MenuItem menuEditCopy = new MenuItem("Copiar");
		MenuItem menuEditPaste = new MenuItem("Pegar");
		MenuItem menuEditCut = new MenuItem("Cortar");
		MenuItem menuEditSelec = new MenuItem("Seleccionar Todo");
		MenuItem menuFormCF = new MenuItem("Color De Fondo");
		MenuItem menuFormCB = new MenuItem("Color De Letra");
		MenuItem menuHelpSc = new MenuItem("Ayuda En Pantalla");
		MenuItem menuHelpMU = new MenuItem("Manual Del Usuario");
		MenuItem menuHelpMy = new MenuItem("Acerca de...");
		menuFileNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				P2.this.panelScroll.show(true);
				P2.this.tabla.setVisible(true);
				P2.this.data.nuevo();
				panelScroll.repaint();
				P2.this.repaint();
			}
		});
		menuFileOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result =
				JOptionPane.showConfirmDialog(P2.this, "DESEA ABRIR UN ARCHIVO");
				if (result == JOptionPane.YES_OPTION) {
					JFileChooser fil = new JFileChooser();
					int i = fil.showOpenDialog(P2.this);
					if (i == JFileChooser.APPROVE_OPTION) {
						File f = fil.getSelectedFile();
						fil = null;
						try {
							FileInputStream in = new FileInputStream(f);
							ObjectInputStream s = new ObjectInputStream(in);
							data.setvect((Vector)s.readObject());
							panelScroll.setVisible(true);
							tabla.setVisible(true);
							P2.this.repaint();
						}
						catch (Exception xx) {}
					}
				}
				else if (result == JOptionPane.NO_OPTION) {}
			}
		});
		menuFileSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(P2.this, "DESEA GUARDAR EL TRABAJO ACTUAL");
				if (result == JOptionPane.YES_OPTION) {
					JFileChooser fil = new JFileChooser();
					int i = fil.showSaveDialog(null);
					if (i == JFileChooser.APPROVE_OPTION) {
						File f = fil.getSelectedFile();
						fil = null;
						try {
							FileOutputStream in = new FileOutputStream(f);
							ObjectOutputStream s = new ObjectOutputStream(in);
							s.writeObject(data.getDataVector());
							s.flush();
						}
						catch (Exception xx) {
							xx.printStackTrace();
						}
					}
				}
				else if (result == JOptionPane.NO_OPTION) {}
			}
		});
		menuFileClos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelScroll.setVisible(false);
				tabla.setVisible(false);
				P2.this.repaint();
			}
		});
		menuFileExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(P2.this, "DESEA SALIR DEL PROGRAMA");
				if (result == JOptionPane.YES_OPTION) {
					P2.this.windowClosed();
				} else if (result == JOptionPane.NO_OPTION) {}
			}
		});
		menuEditCut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] a = tabla.getSelectedColumns(), b = tabla.getSelectedRows();
				clipboard = new CellData[b.length][a.length];
				CellData temp;
				int i, j;
				for (i = 0; i <= a.length - 1; i++) {
					for (j = 0; j <= b.length - 1; j++) {
						temp = (CellData)data.getValueAt(b[j], a[i]);
						try {
							clipboard[j][i] = (CellData)temp.clone();
						}
						catch (CloneNotSupportedException ex) {}
						data.setValueAt(new CellData(), b[j], a[i]);
					}
				}
			}
		});
		menuEditCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] a = tabla.getSelectedColumns(), b = tabla.getSelectedRows();
				clipboard = new CellData[b.length][a.length];
				CellData temp;
				int i, j;
				for (i = 0; i <= a.length - 1; i++) {
					for (j = 0; j <= b.length - 1; j++) {
						temp = (CellData)data.getValueAt(b[j], a[i]);
						try {
							clipboard[j][i] = (CellData)temp.clone();
						}
						catch (CloneNotSupportedException ex) {}
					}
				}
			}
		});
		menuEditPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = tabla.getSelectedColumn(), b = tabla.getSelectedRow();
				if (clipboard != null) {
					int i, j;
					for (i = 0; i <= clipboard[0].length - 1; i++) {
						if (a + i <= tabla.getColumnCount() - 1) {
							for (j = 0; j <= clipboard.length - 1; j++) {
								if (b + j <= tabla.getRowCount() - 1) {
									data.setValueAt(clipboard[j][i], b + j, a + i);
								}
							}
						}
					}
				}
			}
		});
		menuEditSelec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabla.selectAll();
			}
		});
		menuFormCF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color c = JColorChooser.showDialog(P2.this, "Selector de Color", Color.black);
				int[] a = tabla.getSelectedColumns(), b = tabla.getSelectedRows();
				int i, j;
				for (i = 0; i <= a.length - 1; i++) {
					for (j = 0; j <= b.length - 1; j++) {
						data.setColorAt(c, b[j], a[i]);
					}
				}
				tabla.clearSelection();
			}
		});
		menuFormCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color c = JColorChooser.showDialog(P2.this, "Selector de Color", Color.black);
				int[] a = tabla.getSelectedColumns(), b = tabla.getSelectedRows();
				int i, j;
				for (i = 0; i <= a.length - 1; i++) {
					for (j = 0; j <= b.length - 1; j++) {
						data.setFColorAt(c, b[j], a[i]);
					}
				}
				tabla.clearSelection();
			}
		});
		menuHelpMy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				P2.this.in.my.setVisible(true);
			}
		});
		menuHelpSc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				P2.this.Scr.SC.setVisible(true);
			}
		});
		menuHelpMU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				P2.this.us.UM.setVisible(true);
			}
		});
		menuFile.add(menuFileNew);
		menuFile.addSeparator();
		menuFile.add(menuFileOpen);
		menuFile.add(menuFileSave);
		menuFile.addSeparator();
		menuFile.add(menuFileClos);
		menuFile.addSeparator();
		menuFile.add(menuFileExit);
		menuEdit.add(menuEditCut);
		menuEdit.add(menuEditCopy);
		menuEdit.add(menuEditPaste);
		menuEdit.addSeparator();
		menuEdit.add(menuEditSelec);
		menuForm.add(menuFormCF);
		menuForm.add(menuFormCB);
		menuHelp.add(menuHelpSc);
		menuHelp.add(menuHelpMU);
		menuHelp.addSeparator();
		menuHelp.add(menuHelpMy);
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuForm);
		menuBar.add(menuHelp);
		add(new Calc());
		setTitle("Proyecto 2");
		setMenuBar(menuBar);
		setSize(new Dimension(600, 500));
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(P2.this, "DESEA SALIR DEL PROGRAMA");
				if (result == JOptionPane.YES_OPTION) {
					P2.this.windowClosed();
				} else if (result == JOptionPane.NO_OPTION) {}
			}
		});
	}
	//
	protected void windowClosed() {
		System.exit(0);
	}
}
//
public class Screen {
	static Frame SC= new Frame();
	//
	public Screen ( Frame frame, boolean modal ){
		Label a =new Label ("AYUDA EN PANTALLA");
		Label b =new Label ("* PARA CREAR UN NUEVO ARCHIVO,EN LA BARRA DE MENU SE DA CLICK  EN");
		Label c =new Label ("  ARCHIVO Y LUEGO SE SELECCIONA LA OPCION DE NUEVO");
		Label d =new Label ("* PARA ABRIR UN ARCHIVO, EN LA BARRA DE MENU SE DA CLICK EN ARCHIVO");
		Label e =new Label ("  Y LUEGO SELECCIONE LA OPCION DE ABRIR, DESPUES EN EL CUADRO DE");
		Label f =new Label ("  DIALOGO SELECCIONE LA CARPETA DONDE SE ENCUENTRA EL ARCHIVO Y SE");
		Label g =new Label ("  SELECIONA EL ARCHIVO QUE SE ACONSEJA SEA EXTENCION '.fcx'");
		Label h =new Label ("* PARA GUARDAR UN ARCHIVO, EN LA BARRA DE MENU SE DA CLICK EN ARCHIVO Y");
		Label i =new Label ("  LUEGO SELECCIONE LA OPCION DE GUARDAR, DESUES EN EL CUADRO DE DIALOGO" );
		Label j =new Label ("  SELECCIONE LA CARPETA DONDE DESEA GUARDAR EL ARCHIVO Y LUEGO ASIGNELE");
		Label k =new Label ("  UN NOMBRE Y EXTENCION AL ARCHIVO, QUE LA EXTENCION SEA '.fcx'");
		Label l =new Label ("* PARA CAMBIAR COLOR AL FONDO DE LA CELDA, EN LA BARRA DE MENU SE DA");
		Label m =new Label ("  CLICK EN FORMATO Y LUEGO EN LA OPCION COLOR DE FONDO Y SE ");
		Label n =new Label ("  SELECCION EL COLOR DESEADO");
		Label o =new Label ("* PARA CAMBIAR COLOR A LAS LETRAS DE LA CELDA, EN LA BARRA DE MENU SE DA");
		Label p =new Label ("  CLICK EN FORMATO Y LUEGO EN LA OPCION COLOR DE LETRA Y SE ");
		Label q =new Label ("  SELECCION EL COLOR DESEADO");
		JScrollPane panelsc = new JScrollPane();
		a.setFont(new Font("SansSerif",Font.PLAIN,25));
		b.setFont(new Font("SansSerif",Font.PLAIN,10));
		c.setFont(new Font("SansSerif",Font.PLAIN,10));
		d.setFont(new Font("SansSerif",Font.PLAIN,10));
		e.setFont(new Font("SansSerif",Font.PLAIN,10));
		f.setFont(new Font("SansSerif",Font.PLAIN,10));
		g.setFont(new Font("SansSerif",Font.PLAIN,10));
		h.setFont(new Font("SansSerif",Font.PLAIN,10));
		i.setFont(new Font("SansSerif",Font.PLAIN,10));
		j.setFont(new Font("SansSerif",Font.PLAIN,10));
		k.setFont(new Font("SansSerif",Font.PLAIN,10));
		l.setFont(new Font("SansSerif",Font.PLAIN,10));
		m.setFont(new Font("SansSerif",Font.PLAIN,10));
		n.setFont(new Font("SansSerif",Font.PLAIN,10));
		o.setFont(new Font("SansSerif",Font.PLAIN,10));
		p.setFont(new Font("SansSerif",Font.PLAIN,10));
		q.setFont(new Font("SansSerif",Font.PLAIN,10));
		a.setBounds (150,25, 800,30);
		b.setBounds (30,80, 800,15);
		c.setBounds (30,95, 800,15);
		d.setBounds (30,120,800,15);
		e.setBounds (30,135,800,15);
		f.setBounds (30,150,800,15);
		g.setBounds (30,165,800,15);
		i.setBounds (30,180,800,15);
		h.setBounds (30,210,800,15);
		j.setBounds (30,225,800,15);
		k.setBounds (30,240,800,15);
		l.setBounds (30,265,800,15);
		m.setBounds (30,280,800,15);
		n.setBounds (30,295,800,15);
		o.setBounds (30,320,800,15);
		p.setBounds (30,335,800,15);
		q.setBounds (30,350,800,15);
		a.setVisible(true);
		b.setVisible(true);
		c.setVisible(true);
		d.setVisible(true);
		e.setVisible(true);
		f.setVisible(true);
		g.setVisible(true);
		h.setVisible(true);
		i.setVisible(true);
		j.setVisible(true);
		k.setVisible(true);
		l.setVisible(true);
		m.setVisible(true);
		n.setVisible(true);
		o.setVisible(true);
		p.setVisible(true);
		q.setVisible(true);
		SC.setTitle("Ayuda En Pantalla");
		SC.setLayout(new BorderLayout());
		panelsc.add(a);
		panelsc.add(b);
		panelsc.add(c);
		panelsc.add(d);
		panelsc.add(e);
		panelsc.add(f);
		panelsc.add(g);
		panelsc.add(h);
		panelsc.add(i);
		panelsc.add(j);
		panelsc.add(k);
		panelsc.add(l);
		panelsc.add(m);
		panelsc.add(n);
		panelsc.add(o);
		panelsc.add(p);
		panelsc.add(q);
		panelsc.setAutoscrolls(true);
		SC.add(panelsc);
		SC.pack(); 
		SC.setSize(600,450);
		SC.setResizable(false);
		SC.addWindowListener( new WindowAdapter(){ 
			public void windowClosing(WindowEvent e){
				SC.dispose(); 
				SC.setVisible(false);
			}
		});
	}
}
//
public class User {
	static Frame UM= new Frame();
	JEditorPane html;
	//
	public HyperlinkListener createHyperLinkListener() {
		return new HyperlinkListener() {
			public void hyperlinkUpdate(HyperlinkEvent e) {
				if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
					if (e instanceof HTMLFrameHyperlinkEvent) {
						((HTMLDocument)html.getDocument()).processHTMLFrameHyperlinkEvent((HTMLFrameHyperlinkEvent));
					}
					else {
						try {
							html.setPage(e.getURL());
						}
						catch (IOException ioe) {
							System.out.println("IOE: " + ioe);
						}
					}
				}
			}
		};
	}
	//
	public User ( Frame frame, boolean modal ){
		UM.setTitle("MANUAL DEL USUARIO");
		UM.setLayout(new BorderLayout());
		JScrollPane scroller = new JScrollPane();
		UM.add(scroller);
		try {
			URL url = null;
			String path = null;
			try {
				path = "USUARIO.htm";
				url = getClass().getResource(path);
			}
			catch (Exception e) {
				url = null;
			}
			if(url != null) {
				html = new JEditorPane(url);
				html.setEditable(false);
				html.addHyperlinkListener(createHyperLinkListener());
				JViewport vp = scroller.getViewport();
				vp.add(html);
			}
		}
		catch ( Exception c ){}
		UM.pack(); 
		UM.setSize(600,450);
		UM.addWindowListener( new WindowAdapter(){ 
			public void windowClosing(WindowEvent e){
				UM.dispose();
				UM.setVisible(false);
			}
		});
	}
}
//
public class hoja_de_calculo {
	public static void main(String[] args) {
		P2 frame = new P2();
		frame.setVisible(true);
	}
}