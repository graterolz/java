import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

public class GenCoder extends JFrame{
	int Bandera = 0;
	public String Seleccion_CODIGOS,Seleccion_LENGUAJES;
	public String Codigo_Bienvenido_Java = "//Nombre del Programa: Imprimir por Pantalla en Java.\nclass Bienvenido{\n\tpublic static void main (String[] args){\n\t\tSystem.out.println(\"Bienvenido a GenCoder.\");\n\t}\n}";
	public String Codigo_Bienvenido_C = "//Nombre del Programa: Imprimir por Pantalla en C/C++.\n#include <stdio.h>\n#include <conio.h>\n\tmain(){\n\t\tprintf(\"Bienvenido a GenCoder.\");\n\t\tgetch();\n\t}";
	public String Codigo_IF_Else_Java = "//Nombre del Programa: Sentencia IF/Else en Java.\nimport java.io.*;\n\tclass IF_Else{\n\tpublic static void main (String[] args){\n\n\tBufferedReader br = null;\n\tString Dato_Ingresado = \"\";\n\n\tbr = new BufferedReader(new InputStreamReader(System.in));\n\tSystem.out.print(\"Ingrese Numero a Validar: \");\n\n\ttry{\n\tDato_Ingresado = br.readLine();\n\t\tif (Dato_Ingresado.equals(\"1\")){\n\t\tDato_Ingresado = \"1\";\n\t\t}\n\t\telse if(Dato_Ingresado.equals(\"2\")){\n\t\tDato_Ingresado = \"2\";\n\t\t}\n\t\telse if(Dato_Ingresado.equals(\"3\")){\n\t\tDato_Ingresado = \"3\";\n\t\t}\n\t\telse if(Dato_Ingresado.equals(\"4\")){\n\t\tDato_Ingresado = \"4\";\n\t\t}\n\t\telse if(Dato_Ingresado.equals(\"5\")){\n\t\tDato_Ingresado = \"5\";\n\t\t}\n\t\telse{\n\tSystem.out.println(\"Dato Ingresado no esta dentro de los Parametros.\");\n\t\tSystem.exit(0);\n\t\t}\n\tSystem.out.println(\"El numero Ingresado es \"+Dato_Ingresado+\".\");\n\t}\n\tcatch(IOException e){\n\n\t}\n\t}\n}";
	public String Codigo_IF_Else_C = "//Nombre del Programa: Sentencia IF/Else en C/C++.\n#include <stdio.h>\n#include <conio.h>\n\tmain(){\n\tprintf(\"Ingrese Numero a Validar: \");\n\tchar A;\n\tscanf(\"%s\",&A);\n\n\t\tif (A=='1')\n\t\tA=1;\n\t\telse if (A=='2')\n\t\tA=2;\n\t\telse if (A=='3')\n\t\tA=3;\n\t\telse if(A=='4')\n\t\tA=4;\n\t\telse if(A=='5')\n\t\tA=5;\n\t\telse{\n\t\tprintf(\"Dato Ingresado no esta dentro de los Parametros.\");\n\t\tgetch();\n\t\treturn 0;\n\t\t}\n\n\t\tprintf(\"El numero Ingresado es %i.\",A);\n\tgetch();\n\t}";
	public String Codigo_FOR_Java = "//Nombre del Programa: Sentencia FOR en Java.\nclass FOR{\n\tpublic static void main (String[] args){\n\t\tSystem.out.println(\"Empezemos a Contar..\");\n\n\t\tfor(int i=1;i<=100;i=i+1){\n\t\tSystem.out.println(\"Numero: \"+i+\".\");\n\t\t}\n\t}\n}";
	public String Codigo_FOR_C = "//Nombre del Programa: Sentencia FOR en C/C++.\n#include <stdio.h>\n#include <conio.h>\nmain(){\n\n\tprintf(\"Empezemos a Contar..\");\n\tgetch();\n\n\tfor(int i=1;i<=100;i=i+1){\n\tprintf(\"Numero: %d.\\n\",i);\n\t}\n\tgetch();\n}";
	public String Codigo_WHILE_Java = "//Nombre del Programa: Sentencia While en Java.\nclass WHILE{\n\tpublic static void main (String[] args){\n\tSystem.out.println(\"Empezemos a Contar..\");\n\n\tint i=1;\n\twhile(i<=100){\n\t\tSystem.out.println(\"Numero: \"+i+\".\");\n\t\ti = i+1;\n\t}\n\t}\n}";
	public String Codigo_WHILE_C = "//Nombre del Programa: Sentencia While en C/C++.\n#include <stdio.h>\n#include <conio.h>\n\tmain(){\n\tprintf(\"Empezemos a Contar..\\n\");\n\n\tint i=1;\n\twhile(i<=100){\n\tprintf(\"Numero: %d.\\n\",i);\n\ti = i+1;\n\t}\n\tgetch();\n}";
	public String Codigo_DOWHILE_Java = "//Nombre del Programa: Sentencia DO While en Java.\nclass DO_WHILE{\n\tpublic static void main (String[] args){\n\tSystem.out.println(\"Empezemos a Contar..\");\n\n\tint i=1;\n\t\tdo{\n\t\tSystem.out.println(\"Numero: \"+i+\".\");\n\t\ti = i+1;\n\t\t} while(i<=100);\n\t}\n}";
	public String Codigo_DOWHILE_C = "//Nombre del Programa: Sentencia DO While en C/C++.\n#include <stdio.h>\n#include <conio.h>\n\tmain(){\n\tprintf(\"Empezemos a Contar..\\n\");\n\n\tint i=1;\n\tdo{\n\tprintf(\"Numero: %d.\\n\",i);\n\ti = i+1;\n\t} while(i<=100);\n\tgetch();\n}";
	public String Codigo_JBUTTON = "//Nombre del Programa: JButton en Java.\nimport java.awt.*;\nimport java.awt.event.*;\nimport javax.swing.*;\n\tclass JButton_GenCoder extends JFrame{\n\n\tpublic JButton Boton;\n\n\tpublic JButton_GenCoder(){\n\tsuper(\"JButton\");\n\tContainer Contenedor = getContentPane();\n\tContenedor.setLayout(new FlowLayout());\n\n\tBoton = new JButton(\"Presione\");\n\tBoton.addActionListener(new ActionListener(){\n\tpublic void actionPerformed(ActionEvent Evento){\n\t\t//Ingrese Evento.\n\t}\n\t});\n\n\tContenedor.add(Boton);\n\tsetSize(150,70);\n\tsetVisible(true);\n\tsetLocationRelativeTo(null);\n\tsetResizable(false);\n\n\t}\n\n\tpublic static void main(String[] args){\n\tJButton_GenCoder Inicio_Aplicacion = new JButton_GenCoder();\n\tInicio_Aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);\n\t}\n}";
	public String Codigo_JFRAME = "//Nombre del Programa: JFrame en Java.\nimport javax.swing.*;\n\tclass JFrame_GenCoder extends JFrame{\n\n\tpublic JFrame_GenCoder(){\n\tsuper(\"JFrame\");\n\tsetSize(200,200);\n\tsetResizable(false);\n\tsetLocationRelativeTo(null);\n\tsetVisible(true);\n\t}\n\n\tpublic static void main (String[] args){\n\tJFrame_GenCoder Inicio_Aplicacion = new JFrame_GenCoder();\n\tInicio_Aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);\n\t}\n}";
	public String Codigo_JLIST = "//Nombre del Programa: JList en Java.\nimport java.awt.*;\nimport javax.swing.*;\nimport javax.swing.event.*;\nclass JList_GenCoder extends JFrame{\n\n\tpublic String JList_Elementos[] = {\"JList 1\",\n\t\t\t\t\t   \"JList 2\",\n\t\t\t\t\t   \"JList 3\",\n\t\t\t\t\t   \"JList N\"};\n\tpublic JList_GenCoder(){\n\tsuper(\"JList\");\n\n\tContainer Contenedor = getContentPane();\n\tContenedor.setLayout(new FlowLayout());\n\n\tfinal JList JList_Lista = new JList(JList_Elementos);\n\tJList_Lista.setVisibleRowCount(3);\n\tJList_Lista.addListSelectionListener(new ListSelectionListener(){\n\tpublic void valueChanged(ListSelectionEvent evento){\n\t\t//Ingrese Evento.\n\t}\n\t});\n\tJScrollPane JScroll_Lenguajes = new JScrollPane(JList_Lista);\n\tContenedor.add(JScroll_Lenguajes);\n\n\tsetSize(150,100);\n\tsetVisible(true);\n\tsetLocationRelativeTo(null);\n\tsetResizable(false);\n\t}\n\n\tpublic static void main(String[] args){\n\tJList_GenCoder Inicio_Aplicacion = new JList_GenCoder();\n\tInicio_Aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);\n\t}\n}";
	public String Codigo_JTEXTF = "//Nombre del Programa: JTextField en Java.\nimport java.awt.*;\nimport javax.swing.*;\n\tclass JTextField_GenCoder extends JFrame{\n\tpublic JTextField JTextField_TEXT;\n\tpublic String Mensaje = \"<Mensaje Predeterminado>\";\n\n\tpublic JTextField_GenCoder(){\n\tsuper(\"JTextField\");\n\n\tContainer Contenedor = getContentPane();\n\tContenedor.setLayout(new FlowLayout());\n\n\tJTextField JTextField_TEXT = new JTextField(Mensaje,14);\n\n\tContenedor.add(JTextField_TEXT);\n\n\tsetSize(200,60);\n\tsetVisible(true);\n\tsetLocationRelativeTo(null);\n\tsetResizable(false);\n\t}\n\n\tpublic static void main(String[] args){\n\tJTextField_GenCoder Inicio_Aplicacion = new JTextField_GenCoder();\n\tInicio_Aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);\n\t}\n}";
	public String Codigo_JTEXTA = "//Nombre del Programa: JTextArea en Java.\nimport java.awt.*;\nimport java.awt.event.*;\nimport javax.swing.*;\nimport javax.swing.event.*;\n\tclass JTextArea_GenCoder extends JFrame{\n\n\tpublic JTextArea JTextArea_TEXT;\n\tpublic String Mensaje = \"<Mensaje Predeterminado>\";\n\n\tpublic JTextArea_GenCoder(){\n\tsuper(\"JTextArea\");\n\tContainer Contenedor = getContentPane();\n\tContenedor.setLayout(new FlowLayout());\n\n\tJTextArea JTextArea_TEXT = new JTextArea(5,23);\n\tJTextArea_TEXT.setText(Mensaje);\n\n\tJScrollPane JScroll = new JScrollPane(JTextArea_TEXT);\n\tContenedor.add(JScroll);\n\n\tsetSize(270,125);\n\tsetVisible(true);\n\tsetLocationRelativeTo(null);\n\tsetResizable(false);\n\t}\n\n\tpublic static void main(String[] args){\n\tJTextArea_GenCoder Inicio_Aplicacion = new JTextArea_GenCoder();\n\tInicio_Aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);\n\t}\n}";
	public String Direccion_BAT;
	public String Codigo_Generado = "";
	public String J_List_Codigos[] = {
		"Bienvenido a GenCoder!",
		"IF/Else",
		"FOR",
		"While",
		"Do While",
		"JButton - (Java)",
		"JFrame - (Java)",
		"JList - (Java)",
		"JTextField - (Java)",
		"JTextArea - (Java)"
	};
	public String J_List_Lenguajes[] = {"Java","C/C++"};
	Impresora Imp;
	public JPanel JPanel_Superior;
	public JPanel JPanel_Inferior;
	public JPanel JPanel_Izquierdo;
	public JPanel JPanel_Derecho;
	public JTextArea JTextArea_Ejecucion;
	public JTextArea JTextArea_Descripcion;
	//
	public GenCoder(){
		super("GenCoder para Windows 1.0 - Generador de Codigo");
		setSize(600,600);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		Add_Panel(getContentPane());
		JMenuBar Barra_Menu = new JMenuBar();
		Barra_Menu.setBackground(Color.BLACK);
		setJMenuBar(Barra_Menu);
		ImageIcon Imagen = new ImageIcon("src/Fondo.jpg");
		JLabel Img = new JLabel(Imagen);
		add(Img);
		Img.setOpaque(false);
		//
		JMenu Archivo = new JMenu("Archivo");
		Archivo.setForeground(Color.WHITE);
		Archivo.setMnemonic('A');
		Barra_Menu.add(Archivo);
		Archivo.addSeparator();
		JMenuItem Salir = new JMenuItem("Salir");
		//Salir.setIcon(new ImageIcon(getClass().getResource("Iconos\\door_out.png")));
		Salir.setMnemonic('S');
		Archivo.add(Salir);
		Archivo.addSeparator();
		Salir.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent Evento){
				JOptionPane.showMessageDialog(null, "Gracias por usar la Aplicacion!","Salir", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		});
		//
		JMenu Utilitarios = new JMenu("Utilidades S.O");
		Utilitarios.setForeground(Color.WHITE);
		Utilitarios.setMnemonic('U');
		Barra_Menu.add(Utilitarios);
		Utilitarios.addSeparator();
		JMenu Accesorios = new JMenu("Accesorios");
		//Accesorios.setIcon(new ImageIcon(getClass().getResource("Iconos\\box.png")));
		Accesorios.setMnemonic('C');
		Utilitarios.add(Accesorios);
		Utilitarios.addSeparator();
		Accesorios.addSeparator();
		JMenuItem Calculadora = new JMenuItem("Calculadora");
		//Calculadora.setIcon(new ImageIcon(getClass().getResource("Iconos\\calc.png")));
		Calculadora.setMnemonic('C');
		Accesorios.add(Calculadora);
		Accesorios.addSeparator();
		Calculadora.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent Evento){
				Runtime Ejecutar_Aplicacion = Runtime.getRuntime();
				try{
					Ejecutar_Aplicacion.exec("C:\\WINDOWS\\system32\\calc.exe");
				}
				catch(Exception E){
					JOptionPane.showMessageDialog(null,"Aplicacion No Encontrada.","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		//
		JMenuItem BlogDeNotas = new JMenuItem("Editor de Texto");
		//BlogDeNotas.setIcon(new ImageIcon(getClass().getResource("Iconos\\book.png")));
		BlogDeNotas.setMnemonic('T');
		Accesorios.add(BlogDeNotas);
		Accesorios.addSeparator();
		BlogDeNotas.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent Evento){
				Runtime Ejecutar_Aplicacion = Runtime.getRuntime();
				try{
					Ejecutar_Aplicacion.exec("C:\\WINDOWS\\system32\\notepad.exe");
				}
				catch(Exception E){
					JOptionPane.showMessageDialog(null,"Aplicacion No Encontrada.","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		//
		JMenu Juegos = new JMenu("Juegos");
		//Juegos.setIcon(new ImageIcon(getClass().getResource("Iconos\\game.png")));
		Juegos.setMnemonic('J');
		Utilitarios.add(Juegos);
		Utilitarios.addSeparator();
		//
		Juegos.addSeparator();
		JMenuItem Solitario_Spider = new JMenuItem("Solitario Spider");
		//Solitario_Spider.setIcon(new ImageIcon(getClass().getResource("Iconos\\cup.png")));
		Solitario_Spider.setMnemonic('o');
		Juegos.add(Solitario_Spider);
		Solitario_Spider.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent Evento){
				Runtime Ejecutar_Aplicacion = Runtime.getRuntime();
				try{
					Ejecutar_Aplicacion.exec("C:\\WINDOWS\\system32\\spider.exe");
				}
				catch(Exception E){
					JOptionPane.showMessageDialog(null,"Aplicacion No Encontrada.","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		//
		Juegos.addSeparator();
		JMenu Ayuda = new JMenu("Ayuda");
		Ayuda.setForeground(Color.WHITE);
		Ayuda.setMnemonic('Y');
		Barra_Menu.add(Ayuda);
		Ayuda.addSeparator();
		JMenuItem Acerca = new JMenuItem("Acerca De");
		//Acerca.setIcon(new ImageIcon(getClass().getResource("Iconos\\info.png")));
		Acerca.setMnemonic('D');
		Ayuda.add(Acerca);
		Ayuda.addSeparator();
		Acerca.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent Evento){
				JOptionPane.showMessageDialog(null,"GenCoder para Windows 1.0\n<l Conocimiento es PODER!>","Acerca de",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		//
		Archivo.updateUI();
		Salir.updateUI();
		Utilitarios.updateUI();
		Accesorios.updateUI();
		Calculadora.updateUI();
		BlogDeNotas.updateUI();
		Juegos.updateUI();
		Solitario_Spider.updateUI();
		Ayuda.updateUI();
		Acerca.updateUI();
		Barra_Menu.updateUI();
	}
	//
	public void Panel_Superior(){
		JPanel_Superior = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel_Superior.setBackground(Color.BLACK);
		JPanel_Superior.setVisible(true);
		JLabel J_Label = new JLabel("<Entorno de Usario>");
		J_Label.setForeground(Color.GREEN);
		J_Label.setToolTipText("Entorno de Usuario");
		JPanel_Superior.add(J_Label);
		JPanel_Superior.updateUI();
	}
	//
	public void Panel_Inferior(){
		JPanel_Inferior = new JPanel(new FlowLayout());
		JPanel_Inferior.setLayout(new BoxLayout(JPanel_Inferior,BoxLayout.Y_AXIS));
		JPanel_Inferior.setBackground(Color.BLACK);
		JTextArea_Ejecucion = new JTextArea("<GenCoder - Output>",7,5);
		JTextArea_Ejecucion.setEditable(false);
		JTextArea_Ejecucion.setFont(new Font("Consolas",Font.ITALIC,12));
		JTextArea_Ejecucion.setToolTipText("Area de Ejecucion");
		JScrollPane JScroll_Pane = new JScrollPane(JTextArea_Ejecucion);
		JPanel_Inferior.add(JScroll_Pane);
		JLabel J_Label2 = new JLabel("<Area de Ejecucion>");
		J_Label2.setForeground(Color.GREEN);
		J_Label2.setToolTipText("Area de Ejecucion");
		JPanel_Inferior.add(J_Label2);
		JPanel_Inferior.updateUI();
	}
	//
	public void Panel_Izquierdo(){
		JPanel_Izquierdo = new JPanel(new FlowLayout());
		JPanel_Izquierdo.setLayout(new BoxLayout(JPanel_Izquierdo,BoxLayout.X_AXIS));
		JPanel_Izquierdo.setBackground(Color.WHITE);
		JPanel_Izquierdo.updateUI();
	}
	//
	public void Panel_Derecho(){
		JPanel_Derecho = new JPanel(new FlowLayout());
		JPanel_Derecho.setLayout(new GridLayout(7,0));
		JPanel_Derecho.setBackground(Color.BLACK);
		JPanel_Derecho.updateUI();
	}
	//
	public void Add_Panel(Container Agregar){
		Panel_Superior();
		Panel_Izquierdo();
		Panel_Inferior();
		Panel_Derecho();
		//
		JLabel JL_Descripcion = new JLabel("Descripcion del Codigo:");
		JL_Descripcion.setForeground(Color.WHITE);
		JL_Descripcion.setBounds(50,210,150,80);
		final JTextArea JTextArea_Descripcion = new JTextArea(5,5);
		JTextArea_Descripcion.setToolTipText("Descripcion del Codigo");
		JTextArea_Descripcion.setEditable(false);
		JTextArea_Descripcion.setText(" Bienvenido a GenCoder!!\n\n Seleccione un codigo a\n Generar para visalizar \n su Descripcion.");
		JScrollPane JScroll_Descripcion = new JScrollPane(JTextArea_Descripcion);
		JScroll_Descripcion.setBounds(50,270,180,120);
		JTextArea_Descripcion.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,12));
		JScroll_Descripcion.updateUI();
		//
		JLabel JL_Codigo = new JLabel("Codigos Disponibles:");
		JL_Codigo.setForeground(Color.WHITE);
		JL_Codigo.setBounds(50,10,120,80);
		final JList JList_Codigos = new JList(J_List_Codigos);
		JList_Codigos.setToolTipText("Codigos Disponibles");
		JList_Codigos.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent evento){
				Seleccion_CODIGOS = (String)JList_Codigos.getSelectedValue();
				String Descripcion = "";
				if (Seleccion_CODIGOS == "Bienvenido a GenCoder!"){
					Descripcion = " Bienvenido a GenCoder!:\n\n Ejemplo basico que muestra\n salidas de mensajes\n por pantalla.";
				}
				else if(Seleccion_CODIGOS == "IF/Else"){
					Descripcion = " IF/Else:\n\n Esta Sentencia permite\n solventar problemas electivos\n mediante cumplimento de\n condiciones referente\n a variables y Operaciones.";
				}
				else if(Seleccion_CODIGOS == "FOR"){
					Descripcion = " FOR:\n\n Esta Sentencia cuya funcion\n Principal es la Ejecucion de\n Acciones bajo estructuras\n ciclicas o repetitivas\n mediante variables de Control.";
				}
				else if(Seleccion_CODIGOS == "While"){
					Descripcion = " While:\n\n Cuya funcion sirve para\n realizar una acci贸n\n sucesivamente mientras se\n cumpla una determinada\n Condici贸n.";
				}
				else if(Seleccion_CODIGOS == "Do While"){
					Descripcion = " Do While:\n\n Es similar al bucle While,\n La unica diferencia es la\n evaluaci贸n que se realiza\n al final.";
				}
				else if(Seleccion_CODIGOS == "JButton - (Java)"){
					Descripcion = " JButton:\n\n Es un Boton conocido en Java\n cuya funcion principal\n es darle una apariencia\n mas presentable\n a las Aplicaciones.";
				}
				else if(Seleccion_CODIGOS == "JFrame - (Java)"){
					Descripcion = " JFrame - (Java):\n\n Es un contenedor que tiene\n como tarea guardar nuestros\n componentes y darles un\n sentido gr谩fico.";
				}
				else if(Seleccion_CODIGOS == "JList - (Java)"){
					Descripcion = " JList - (Java):\n\n Componente cuya funcion \n permite crear una lista de\n opciones para agregar a\n diferentes Aplicaciones. ";
				}
				else if(Seleccion_CODIGOS == "JTextField - (Java)"){
					Descripcion = " JTextField - (Java):\n\n Simplemente es un Area\n donde se pueden realizar\n introduccion de datos de\n manera mas Grafica.";
				}
				else if(Seleccion_CODIGOS == "JTextArea - (Java)"){
					Descripcion = " JTextArea - (Java):\n\n Se define como un control\n para pedir varias l铆neas\n de texto de manera mas\n Amplia.";
				}
				JTextArea_Descripcion.setText("");
				JTextArea_Descripcion.append (Descripcion);
			}
		});
		JScrollPane JScroll_Codigos =new JScrollPane(JList_Codigos);
		JScroll_Codigos.setBounds(50,80,160,150);
		//
		JLabel JL_Ejecutar = new JLabel("Ejecutar en Lenguaje:");
		JL_Ejecutar.setForeground(Color.WHITE);
		JL_Ejecutar.setBounds(250,10,150,80);
		//
		final JList JList_Lenguajes = new JList(J_List_Lenguajes);
		JList_Lenguajes.setVisibleRowCount(3);
		JList_Lenguajes.setToolTipText("Ejecutar en Lenguajes");
		JList_Lenguajes.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent evento){
				Seleccion_LENGUAJES = (String)JList_Lenguajes.getSelectedValue();
				if (Seleccion_LENGUAJES == "HTML"){
					JOptionPane.showMessageDialog(null,"Lenguaje HTML no disponible.\nActualmente en Desarrollo.","Informacion",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		JScrollPane JScroll_Lenguajes =new JScrollPane(JList_Lenguajes);
		JScroll_Lenguajes.setBounds(275,80,60,37);	//Tamano Lista.
		//
		JButton JB_EjecutarCMD = new JButton("Codigo en Ejecucion");
		//JB_EjecutarCMD.setIcon(new ImageIcon(getClass().getResource("Iconos\\cmd.png")));
		JB_EjecutarCMD.setToolTipText("Codigo en Ejecucion");
		JB_EjecutarCMD.setBounds(400,80,170,40);
		JB_EjecutarCMD.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent evt){
				if (Seleccion_CODIGOS == null){
					JOptionPane.showMessageDialog(null,"No se puede ejecutar.\nSeleccione un codigo a Generar","Error",JOptionPane.ERROR_MESSAGE);
					Seleccion_CODIGOS = null;
				}
				else if (Seleccion_LENGUAJES == null){
					JOptionPane.showMessageDialog(null,"No se puede ejecutar.\nSeleccione un Lenguaje","Error",JOptionPane.ERROR_MESSAGE);
					Seleccion_LENGUAJES = null;
				}
				else{
					Direccion_BAT = "";
					if (Seleccion_CODIGOS == "Bienvenido a GenCoder!" && Seleccion_LENGUAJES == "Java"){
						Direccion_BAT = "cd execute/Java\nstart Bienvenido.exe";
					}
					else if(Seleccion_CODIGOS == "Bienvenido a GenCoder!" && Seleccion_LENGUAJES == "C/C++"){
						Direccion_BAT = "cd execute/C\nstart Bienvenido.exe";
					}
					else if (Seleccion_CODIGOS == "IF/Else" && Seleccion_LENGUAJES == "Java"){
						Direccion_BAT = "cd execute/Java\nstart IF_Else.exe";
					}
					else if (Seleccion_CODIGOS == "IF/Else" && Seleccion_LENGUAJES == "C/C++"){
						Direccion_BAT = "cd execute/C\nstart IF_Else.exe";
					}
					else if (Seleccion_CODIGOS == "FOR" && Seleccion_LENGUAJES == "Java"){
						Direccion_BAT = "cd execute/Java\nstart FOR.exe";
					}
					else if (Seleccion_CODIGOS == "FOR" && Seleccion_LENGUAJES == "C/C++"){
						Direccion_BAT = "cd execute/C\nstart FOR.exe";
					}
					else if (Seleccion_CODIGOS == "While" && Seleccion_LENGUAJES == "Java"){
						Direccion_BAT = "cd execute/Java\nstart WHILE.exe";
					}
					else if (Seleccion_CODIGOS == "While" && Seleccion_LENGUAJES == "C/C++"){
						Direccion_BAT = "cd execute/C\nstart WHILE.exe";
					}
					else if (Seleccion_CODIGOS == "Do While" && Seleccion_LENGUAJES == "Java"){
						Direccion_BAT = "cd execute/Java\nstart DO_WHILE.exe";
					}
					else if (Seleccion_CODIGOS == "Do While" && Seleccion_LENGUAJES == "C/C++"){
						Direccion_BAT = "cd execute/C\nstart DO_WHILE.exe";
					}
					else if(Seleccion_CODIGOS == "JButton - (Java)" && Seleccion_LENGUAJES == "Java"){
						Direccion_BAT = "cd execute/Java\nstart JButton.jar";
					}
					else if(Seleccion_CODIGOS == "JFrame - (Java)" && Seleccion_LENGUAJES == "Java"){
						Direccion_BAT = "cd execute/Java\nstart JFrame_Ventana.jar";
					}
					else if(Seleccion_CODIGOS == "JList - (Java)" && Seleccion_LENGUAJES == "Java"){
						Direccion_BAT = "cd execute/Java\nstart JList_GenCoder.jar";
					}
					else if(Seleccion_CODIGOS == "JTextField - (Java)" && Seleccion_LENGUAJES == "Java"){
						Direccion_BAT = "cd execute/Java\nstart JTextField_GenCoder.jar";
					}
					else if(Seleccion_CODIGOS == "JTextArea - (Java)" && Seleccion_LENGUAJES == "Java"){
						Direccion_BAT = "cd execute/Java\nstart JTextArea_GenCoder.jar";
					}

					try{
						String lineaArchivo;
						BufferedReader fuenteSalida;
						fuenteSalida = new BufferedReader(new StringReader(Direccion_BAT));
						PrintWriter archivoSalida;
						archivoSalida = new PrintWriter(new BufferedWriter(new FileWriter("Execute.bat")));
						while ((lineaArchivo = fuenteSalida.readLine()) != null)
							archivoSalida.println(lineaArchivo);
						archivoSalida.close();
					}
					catch (IOException e){
						System.out.println("Excepcion Entrada/Salida");
					}

					try{
						Runtime Ejecutar_Aplicacion = Runtime.getRuntime();
						Ejecutar_Aplicacion.exec("Execute.bat");
					}
					catch(Exception E){
						if (Seleccion_LENGUAJES == "HTML"){
							JOptionPane.showMessageDialog(null,"Lenguaje HTML no disponible.\nActualmente en Desarrollo.","Informacion",JOptionPane.INFORMATION_MESSAGE);
						}
						else if(Seleccion_LENGUAJES == "C/C++"){
							JOptionPane.showMessageDialog(null,"Este Objeto no es valido en Lenguaje C/C++","Informacion",JOptionPane.INFORMATION_MESSAGE);
						}
						else
							JOptionPane.showMessageDialog(null,"Aplicacion No Encontrada.","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		//
		JButton JB_GeneraCodigo = new JButton("Generar Codigo");
		//JB_GeneraCodigo.setIcon(new ImageIcon(getClass().getResource("Iconos\\gen.png")));
		JB_GeneraCodigo.setToolTipText("Generar Codigo");
		JB_GeneraCodigo.setBounds(400,130,170,40);
		JB_GeneraCodigo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent Evento){
				if (Seleccion_CODIGOS == null){
					JOptionPane.showMessageDialog(null,"Seleccione un codigo a Generar","Error",JOptionPane.ERROR_MESSAGE);
					Seleccion_CODIGOS = null;
				}
				else if (Seleccion_LENGUAJES == "HTML"){
					JOptionPane.showMessageDialog(null,"Lenguaje HTML no disponible.\nActualmente en Desarrollo.","Informacion",JOptionPane.INFORMATION_MESSAGE);
				}
				else if (Seleccion_LENGUAJES == null){
					JOptionPane.showMessageDialog(null,"Seleccione un Lenguaje","Error",JOptionPane.ERROR_MESSAGE);
					Seleccion_LENGUAJES = null;
				}
				else{
					Codigo_Generado ="<SinCodigoProgramado>";
					if (Seleccion_CODIGOS == "Bienvenido a GenCoder!" && Seleccion_LENGUAJES == "Java"){
						Codigo_Generado = Codigo_Bienvenido_Java;
						Bandera = 0;
					}
					else if (Seleccion_CODIGOS == "Bienvenido a GenCoder!" && Seleccion_LENGUAJES == "C/C++"){
						Codigo_Generado = Codigo_Bienvenido_C;
						Bandera = 0;
					}
					else if (Seleccion_CODIGOS == "IF/Else" && Seleccion_LENGUAJES == "Java"){
						Codigo_Generado = Codigo_IF_Else_Java;
						Bandera = 0;
					}
					else if (Seleccion_CODIGOS == "IF/Else" && Seleccion_LENGUAJES == "C/C++"){
						Codigo_Generado = Codigo_IF_Else_C;
						Bandera = 0;
					}
					else if (Seleccion_CODIGOS == "FOR" && Seleccion_LENGUAJES == "Java"){
						Codigo_Generado = Codigo_FOR_Java;
						Bandera = 0;
					}
					else if (Seleccion_CODIGOS == "FOR" && Seleccion_LENGUAJES == "C/C++"){
						Codigo_Generado = Codigo_FOR_C;
						Bandera = 0;
					}
					else if (Seleccion_CODIGOS == "While" && Seleccion_LENGUAJES == "Java"){
						Codigo_Generado = Codigo_WHILE_Java;
						Bandera = 0;
					}
					else if (Seleccion_CODIGOS == "While" && Seleccion_LENGUAJES == "C/C++"){
						Codigo_Generado = Codigo_WHILE_C;
						Bandera = 0;
					}
					else if (Seleccion_CODIGOS == "Do While" && Seleccion_LENGUAJES == "Java"){
						Codigo_Generado = Codigo_DOWHILE_Java;
						Bandera = 0;
					}
					else if (Seleccion_CODIGOS == "Do While" && Seleccion_LENGUAJES == "C/C++"){
						Codigo_Generado = Codigo_DOWHILE_C;
						Bandera = 0;
					}
					else if (Seleccion_CODIGOS == "JButton - (Java)" && Seleccion_LENGUAJES == "Java"){
						Codigo_Generado = Codigo_JBUTTON;
						Bandera = 0;
					}
					else if (Seleccion_CODIGOS == "JFrame - (Java)" && Seleccion_LENGUAJES == "Java"){
						Codigo_Generado = Codigo_JFRAME;
						Bandera = 0;
					}
					else if (Seleccion_CODIGOS == "JList - (Java)" && Seleccion_LENGUAJES == "Java"){
						Codigo_Generado = Codigo_JLIST;
						Bandera = 0;
					}
					else if (Seleccion_CODIGOS == "JTextField - (Java)" && Seleccion_LENGUAJES == "Java"){
						Codigo_Generado = Codigo_JTEXTF;
						Bandera = 0;
					}
					else if (Seleccion_CODIGOS == "JTextArea - (Java)" && Seleccion_LENGUAJES == "Java"){
						Codigo_Generado = Codigo_JTEXTA;
						Bandera = 0;
					}
					else if(Seleccion_LENGUAJES == "C/C++"){
						JOptionPane.showMessageDialog(null,"Este Objeto no es valido en Lenguaje C/C++","Informacion",JOptionPane.INFORMATION_MESSAGE);
						Bandera = 1;
					}
					//
					try{
						if (Bandera!=1){
							Runtime Ejecutar_Aplicacion = Runtime.getRuntime();
							Ejecutar_Aplicacion.exec("JBProceso.bat");
							JTextArea_Ejecucion.setText("");
							Thread.currentThread();
							Thread.sleep(2800);
							JTextArea_Ejecucion.append (Codigo_Generado);
							JTextArea_Ejecucion.repaint();
							Bandera = 1;
						}
					}
					catch(Exception E){
						JOptionPane.showMessageDialog(null,"Aplicacion No Encontrada.","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		//
		JButton JB_Imprimir = new JButton("Imprimir Codigo");
		//JB_Imprimir.setIcon(new ImageIcon(getClass().getResource("Iconos\\printer.png")));
		JB_Imprimir.setToolTipText("Imprimir Codigo");
		JB_Imprimir.setBounds(400,180,170,40);
		JB_Imprimir.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent evt){
				if (!Codigo_Generado.equals("")){
					Imp = new Impresora();
					Imp.Imprimir(Codigo_Generado);
				}
				else
					JOptionPane.showMessageDialog(null,"No se puede Imprimir en blanco\nGenere el Codigo.","Error",JOptionPane.ERROR_MESSAGE);
			}
		});
		//
		JButton JB_Limpiar = new JButton("Limpiar Pantalla");
		//JB_Limpiar.setIcon(new ImageIcon(getClass().getResource("Iconos\\image.png")));
		JB_Limpiar.setToolTipText("Limpiar Pantalla");
		JB_Limpiar.setBounds(400,230,170,40);
		JB_Limpiar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent Evento){
				JTextArea_Ejecucion.setText("");
				JTextArea_Ejecucion.setText("<GenCoder - Output> - <Pantalla Limpia>");
				JOptionPane.showMessageDialog( null, "Pantalla Limpia","Pantalla", JOptionPane.INFORMATION_MESSAGE);
				Codigo_Generado = "";
			}
		});
		//
		JButton JB_Guardar = new JButton("Guardar Codigo");
		//JB_Guardar.setIcon(new ImageIcon(getClass().getResource("Iconos\\disk.png")));
		JB_Guardar.setToolTipText("Guardar Codigo");
		JB_Guardar.setBounds(400,280,170,40);
		JB_Guardar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent Evento){
				if(Codigo_Generado.equals("")){
					JOptionPane.showMessageDialog(null,"Genere un codigo para luego Guardar","Error",JOptionPane.ERROR_MESSAGE);
				}
				else{
					JFileChooser Selector_Archivo = new JFileChooser();
					Selector_Archivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
					int Tipo_Selector  = Selector_Archivo.showSaveDialog(null);
					File Direccion_Selector = Selector_Archivo.getSelectedFile();
					if (Direccion_Selector == null || Direccion_Selector.getName().equals("")){
						JOptionPane.showMessageDialog(null,"Archivo no Guardado","Guardar",JOptionPane.ERROR_MESSAGE);
					}
					else{
						try{
							String lineaArchivo;
							BufferedReader fuenteSalida;
							fuenteSalida = new BufferedReader(new StringReader(Codigo_Generado));
							PrintWriter archivoSalida;
							archivoSalida = new PrintWriter(new BufferedWriter(new FileWriter(Direccion_Selector)));
							while ((lineaArchivo = fuenteSalida.readLine()) != null)
								archivoSalida.println(lineaArchivo);
							archivoSalida.close();
							JOptionPane.showMessageDialog(null,"Se cre贸 el archivo en "+Direccion_Selector,"Guardar",JOptionPane.INFORMATION_MESSAGE);
						}
						catch (IOException e){
							JOptionPane.showMessageDialog(null,"Error al procesar el archivo","Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		//
		JButton JB_Salir = new JButton("Salir");
		//JB_Salir.setIcon(new ImageIcon(getClass().getResource("Iconos\\door_out.png")));
		JB_Salir.setToolTipText("Salir de la Aplicacion");
		JB_Salir.setBounds(400,360,170,30);
		JB_Salir.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent Evento){
				JOptionPane.showMessageDialog(null,"Gracias por usar la Aplicacion!","Salir",JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		});
		//
		add(JL_Ejecutar);
		add(JL_Codigo);
		add(JL_Descripcion);
		add(JScroll_Lenguajes);
		add(JScroll_Codigos);
		add(JScroll_Descripcion);
		add(JB_EjecutarCMD);
		add(JB_GeneraCodigo);
		add(JB_Imprimir);
		add(JB_Limpiar);
		add(JB_Guardar);
		add(JB_Salir);
		//
		Agregar.add(JPanel_Superior,BorderLayout.NORTH);
		Agregar.add(JPanel_Derecho,BorderLayout.EAST);
		Agregar.add(JPanel_Inferior,BorderLayout.SOUTH);
		Agregar.add(JPanel_Izquierdo,BorderLayout.WEST);
	}
	//
	public static void main(String[] args){
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		GenCoder Inicio_Aplicacion = new GenCoder();
		Inicio_Aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Login Inicio_Login = new Login();
		//Inicio_Login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}