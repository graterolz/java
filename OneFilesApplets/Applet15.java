import java.applet.*;
import java.awt.*;

public class Applet15 extends Applet implements ActionListener {
	Button enableDisableButton = new Button("Enable/Disable");
	Label paintDemoLabel = new Label("Paint Demo");
	//
	public void init() {
		add(enableDisableButton);
		add(paintDemoLabel);
		enableDisableButton.addActionListener(this);
	}
	//
	public void paint(Graphics g) {
		paintDemoLabel.setEnabled(true);
	}
	//
	public void actionPerformed(ActionEvent e) {
		if (paintDemoLabel.isEnabled ())
			paintDemoLabel.setEnabled (false);
		else
			repaint();
	}
}