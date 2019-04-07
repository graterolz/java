import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class Edit2 extends JFrame {
	JFileChooser fileChooser = null;
	JEditorPane editPane;
	JScrollPane scrollPaneRight;
	JScrollPane scrollPaneLeft;
	JPanel leftPanel;
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenuItem newMenu;
	JMenuItem openMenu;
	JMenuItem saveMenu;
	JMenuItem exitMenu;
	JRadioButtonMenuItem editModeButton;
	JRadioButtonMenuItem browseModeButton;
	ButtonGroup modeButtons;
	JMenu modeMenu;
	JSplitPane splitPane;
	JPanel statusPanel;
	JLabel statusMsg1;
	JLabel statusMsg2;
	JToolBar toolBar;
	JTextField urlTextField;
	JButton goUrlButton;
	JButton openButton;
	JButton saveButton;
	JButton cutButton;
	JButton pasteButton;
	JButton copyButton;
	JButton openSelectedButton;
	JList list;
	Vector fileVector = new Vector();
	String fileName;
	boolean isSaved = false;
	//
	class Hyperactive implements HyperlinkListener {
		public void hyperlinkUpdate(HyperlinkEvent e) {
			if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED && e.getSource()==editPane) {
				try {
					editPane.setPage(e.getURL());
					urlTextField.setText(e.getURL().toString());
				}
				catch (Exception ex) {
					statusMsg2.setText(ex.getMessage());
				}
			}
		}
	}
	//
	HyperlinkListener hyper= new Hyperactive();
	class EventHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == exitMenu) {
				if (!isSaved && !editPane.getText().equals(""))
					askSave();
				System.exit(0);
			}
			if (e.getSource() == openMenu || e.getSource() == openButton) {
				if (!isSaved && !editPane.getText().equals(""))
					askSave();
				openFile();
			}
			if (e.getSource() == newMenu) {
				if (!isSaved && !editPane.getText().equals(""))
					askSave();
				newFile();
			}
			if (e.getSource() == saveMenu || e.getSource() == saveButton){
				saveFile();
			}
			if (e.getSource() == copyButton){
				editPane.copy();
			}
			if (e.getSource() == cutButton){
				editPane.cut();
			}
			if (e.getSource() == pasteButton){
				editPane.paste();
			}
			if (e.getSource() == openSelectedButton){
				openSelectedFile();
			}
			if (e.getSource() == goUrlButton) {
				try {
					goUrl(new java.net.URL(urlTextField.getText()));
				} 
				catch (Exception ex) {
					statusMsg2.setText(ex.getMessage());
				}
			}
			if (e.getSource() == editModeButton) {
				editPane.setEditable(true);
			}
			if (e.getSource() == browseModeButton) {
				editPane.setEditable(false);
			}
		};
	};
	ActionListener eventHandler = new EventHandler();
	//
	public Edit2(String title) {
		super(title);
	}
	//
	public void agregaLista(String file) {
		if (fileVector.contains(file))
			return;
		fileVector.add(file);
		Collections.sort(fileVector);
		list.setListData(fileVector);
	}
	//
	public void askSave() {
		JOptionPane optionPane=new JOptionPane();
		Object[] opciones={"Sí","No"};
		int ret=optionPane.showOptionDialog(this,"Desea guardar? ","Pregunta",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opciones,opciones[0]);
		if(ret==JOptionPane.YES_OPTION)
			saveFile();
	}
	//
	public void goUrl(java.net.URL url) {
		try {
			editPane.setPage(url);
		}
		catch (Exception e)
		{
			statusMsg2.setText(e.getMessage());
		}
	}
	//
	public void initConnections() {
		newMenu.addActionListener(eventHandler);
		openMenu.addActionListener(eventHandler);
		saveMenu.addActionListener(eventHandler);
		exitMenu.addActionListener(eventHandler);
		openButton.addActionListener(eventHandler);
		saveButton.addActionListener(eventHandler);
		copyButton.addActionListener(eventHandler);
		cutButton.addActionListener(eventHandler);
		pasteButton.addActionListener(eventHandler);
		openSelectedButton.addActionListener(eventHandler);
		goUrlButton.addActionListener(eventHandler);
		editPane.addHyperlinkListener(hyper);
		editModeButton.addActionListener(eventHandler);
		browseModeButton.addActionListener(eventHandler);
	}
	//
	public void initialize() {
		this.getContentPane().setLayout(new BorderLayout());
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (!isSaved && !editPane.getText().equals(""))
					askSave();
				System.exit(0);
			}
		});
		//
		menuBar = new JMenuBar();
		fileMenu = new JMenu("Archivo");
		newMenu = new JMenuItem("Nuevo");
		openMenu = new JMenuItem("Abrir");
		saveMenu = new JMenuItem("Guardar");
		exitMenu = new JMenuItem("Salir");
		modeMenu = new JMenu("Modo");
		editModeButton = new JRadioButtonMenuItem("Editar");
		browseModeButton = new JRadioButtonMenuItem("Navegar");
		modeButtons = new ButtonGroup();
		modeButtons.add(editModeButton);
		modeButtons.add(browseModeButton);
		//
		fileMenu.add(newMenu);
		fileMenu.add(openMenu);
		fileMenu.add(saveMenu);
		fileMenu.addSeparator();
		fileMenu.add(exitMenu);
		modeMenu.add(editModeButton);
		modeMenu.add(browseModeButton);
		//
		menuBar.add(fileMenu);
		menuBar.add(modeMenu);
		this.setJMenuBar(menuBar);
		//
		toolBar = new JToolBar();
		openButton = new JButton();
		openButton.setIcon(new ImageIcon(getClass().getResource("/open.gif")));
		openButton.setMargin(new Insets(0, 0, 0, 0));
		toolBar.add(openButton);
		saveButton = new JButton();
		saveButton.setIcon(new ImageIcon(getClass().getResource("/save.gif")));
		saveButton.setMargin(new Insets(0, 0, 0, 0));
		toolBar.add(saveButton);
		toolBar.addSeparator();
		copyButton = new JButton();
		copyButton.setIcon(new ImageIcon(getClass().getResource("/copy.gif")));
		copyButton.setMargin(new Insets(0, 0, 0, 0));
		toolBar.add(copyButton);
		cutButton = new javax.swing.JButton();
		cutButton.setIcon(new ImageIcon(getClass().getResource("/cut.gif")));
		cutButton.setMargin(new Insets(0, 0, 0, 0));
		toolBar.add(cutButton);
		pasteButton = new javax.swing.JButton("ASDF");
		pasteButton.setIcon(new ImageIcon(getClass().getResource("/paste.gif")));
		pasteButton.setMargin(new Insets(0, 0, 0, 0));
		toolBar.add(pasteButton);
		toolBar.addSeparator();
		urlTextField = new JTextField();
		toolBar.add(urlTextField);
		goUrlButton = new JButton("Ir");
		toolBar.add(goUrlButton);
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		//
		statusPanel = new JPanel();
		statusPanel.setLayout(new BorderLayout());
		statusMsg1 = new JLabel("Estado: ");
		statusMsg2 = new JLabel();
		statusPanel.add(statusMsg1, BorderLayout.WEST);
		statusPanel.add(statusMsg2, BorderLayout.CENTER);
		this.getContentPane().add(statusPanel, BorderLayout.SOUTH);
		//
		editPane = new JEditorPane();
		editPane.setEditable(true);
		editPane.setText("");
		scrollPaneRight = new JScrollPane(editPane);
		//
		list=new JList();
		scrollPaneLeft=new JScrollPane(list);
		openSelectedButton=new JButton("Abrir");
		//
		leftPanel=new JPanel(new BorderLayout());
		leftPanel.add(scrollPaneLeft,BorderLayout.CENTER);
		leftPanel.add(openSelectedButton,BorderLayout.SOUTH);
		//
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setRightComponent(scrollPaneRight);
		splitPane.setLeftComponent(leftPanel);
		this.getContentPane().add(splitPane, BorderLayout.CENTER);
	}
	//
	public static void main(java.lang.String[] args) {
		Edit2 aplication = new Edit2("Editor simple 2.0 (Con navegador)");
		aplication.initialize();
		aplication.initConnections();
		aplication.pack();
		aplication.setSize(500, 400);
		aplication.setLocation(100, 100);
		aplication.setVisible(true);
	}
	//
	public void newFile() {
		editPane.setText("");
		isSaved=false;
	}
	//
	public void openFile() {
		if (fileChooser == null) {
			fileChooser = new JFileChooser();
		}
		int retVal = fileChooser.showOpenDialog(this);
		if (retVal == fileChooser.APPROVE_OPTION) {
			fileName = fileChooser.getSelectedFile().getAbsolutePath();
			try {
				java.net.URL url = fileChooser.getSelectedFile().toURL();
				statusMsg2.setText("abriendo " + fileName);
				editPane.setPage(url);
				isSaved = false;
				agregaLista("" + fileName);
				urlTextField.setText(((new java.io.File(fileName)).toURL()).toString());
			}
			catch (Exception ioe) {
				statusMsg2.setText(ioe.getMessage());
			}
		}
	}
	//
	public void openSelectedFile() {
		if(list.getSelectedIndex()==-1)
			return;
		int ndx=list.getSelectedIndex();
		try {
			String name=(String)fileVector.get(ndx);
			java.net.URL url=(new java.io.File(name)).toURL();
			editPane.setPage(url);
		}
		catch(Exception e) {
			statusMsg2.setText(e.getMessage());
		}
	}
	//
	public void saveFile() {
		if (fileChooser == null) {
			fileChooser = new JFileChooser();
		}
		int retVal = fileChooser.showSaveDialog(this);
		if (retVal == fileChooser.APPROVE_OPTION) {
			fileName = fileChooser.getSelectedFile().getAbsolutePath();
			try {
				statusMsg2.setText("Guardando "+fileName);
				String text=editPane.getText();
				java.io.FileWriter fileWriter=new java.io.FileWriter(fileName);
				java.io.BufferedWriter br = new java.io.BufferedWriter(fileWriter);
				br.write(text);
				br.close();
				isSaved=true;
				agregaLista(""+fileName);
				urlTextField.setText(((new java.io.File(fileName)).toURL()).toString());
			}
			catch (Exception ioe) {
				statusMsg2.setText(ioe.getMessage());
			}
		}
	}
}