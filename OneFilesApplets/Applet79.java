import javax.swing.*;
import java.awt.*;

public class Applet79 extends JApplet implements ActionListener {
	JFrame fFrame;
	JMenuItem fMenuClose ;
	JMenuItem fMenuOpen;
	//
	public void init () {
		JMenuBar mb = new JMenuBar ();
		JMenu m = new JMenu ("File");
		fMenuOpen= new JMenuItem ("Open");
		m.add (fMenuOpen);
		fMenuOpen.addActionListener (this);
		fMenuClose = new JMenuItem ("Close");
		m.add (fMenuClose);
		fMenuClose.addActionListener (this);
		mb.add (m);
		setJMenuBar (mb);
		fFrame = new ParticleFrame (this);
		fFrame.setVisible (true);
		fMenuOpen.setEnabled (false);
		fMenuClose.setEnabled (true);
	}
	//
	public void actionPerformed (ActionEvent e) {
		String command = e.getActionCommand ();
		if (command.equals ("Close")) {
			close ();
		}
		else {
			if (fFrame == null) {
				fFrame = new ParticleFrame (this);
				fFrame.setVisible (true);
				fMenuOpen.setEnabled (false);
				fMenuClose.setEnabled (true);
			}
		}
	}
	//
	void close () {
		fFrame.dispose ();
		fFrame = null;
		fMenuOpen.setEnabled (true);
		fMenuClose.setEnabled (false);
	}
}
//
class ParticleFrame extends JFrame implements ActionListener, ItemListener {
	JLabel fLabelA;
	JLabel fLabelB;
	FrameApplet fApplet;
	//
	void ParticleFrame (FrameApplet applet) {
		super ("Frame Test");
		fApplet = applet;
		Container content_pane = getContentPane ();
		content_pane.setLayout (new GridLayout (1,3));
		JPanel choice_panel = new JPanel ();
		choice_panel.add (new JLabel ("Quark", JLabel.RIGHT) );
		JComboBox c = new JComboBox ();
		c.addItem ("Up");
		c.addItem ("Down");
		c.addItem ("Strange");
		c.addItem ("Charm");
		c.addItem ("Top");
		c.addItem ("Bottom");
		c.addItemListener (this);
		choice_panel.add (c);
		content_pane.add (choice_panel);
		fLabelA =new JLabel ("Quark: Up");
		content_pane.add (fLabelA);
		fLabelB =new JLabel ("Lepton: Electron");
		content_pane.add (fLabelB);
		JMenu m = new JMenu ("Lepton");
		m.add (makeMenuItem ("electron"));
		m.add (makeMenuItem ("muon"));
		m.add (makeMenuItem ("tau"));
		JMenu sm = new JMenu ("Neutrino");
		sm.add (makeMenuItem ("e Neutrino"));
		sm.add (makeMenuItem ("mu Neutrino"));
		sm.add (makeMenuItem ("tau Neutrino"));
		m.add (sm);
		m.add (makeMenuItem ("Quit"));
		JMenuBar mb = new JMenuBar ();
		mb.add (m);
		setJMenuBar (mb);
		setSize (200,200);
		pack ();
		setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
	}
	//
	public void itemStateChanged (ItemEvent e) {
		String command = e.getItem ().toString ();
		if (command.equals ("Quit") )
			dispose ();
		else
			fLabelA.setText ("Quark: " + command);
	}
	//
	public void actionPerformed (ActionEvent e) {
		String command = e.getActionCommand ();
		if (command.equals ("Quit")) {
			fApplet.close ();
		}
		else {
			fLabelB.setText ("Lepton: " + command);
		}
	}
	//
	private JMenuItem makeMenuItem (String name) {
		JMenuItem m = new JMenuItem (name);
		m.addActionListener (this);
		return m;
	}
}