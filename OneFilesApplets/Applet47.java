import java.applet.*;
import java.awt.*;
public class Applet47 extends Applet {
	Font littleFont = new Font("Helvetica", Font.ITALIC, 6);
	//
	public void init() {
		setBackground(Color.pink);
	}
	//
	public void paint(Graphics gr) {
		int r, g, b, x = 0, y = 0;
		for(r=255; r>=0; r -= 20){
			for(g=255; g>=0; g -= 20){
				for(b=255; b>=0; b -= 20) {
					Color variety = new Color(r,g,b);
					gr.setColor(variety);
					gr.drawString("X",x,y);
					x += 5;
					if (x >= 400) {
						x = 0;
						y += 10;
					}
				}
			}
		}
	}
}