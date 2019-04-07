import processing.core.*; 
import processing.xml.*; 
import processing.opengl.*; 
import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class triangulos_opengl_processing extends PApplet {
	ArrayList arcos = new ArrayList();
	int fondo = color(255,255,255);
	boolean clearScreen = true ; 
	//
	public void setup() {
		size(600,600, OPENGL);
		frameRate(60);
		noSmooth();
		//noStroke();
		for( int i = 0 ; i < 20 ; i ++ ) {
			Arco b = new Arco( (int)( random(width)/2.0f ) );
			b.randSpeed();
			b.randColor();
			b.offsetX = (int)(width / 2);
			b.offsetY = (int)(height / 2);
			arcos.add( b );     
		}
	}
	//
	public void draw() {
		background( fondo );  
		lights();
		if( mousePressed ) {
			translate( mouseX , mouseY ) ;
		}
		else {
			translate(width / 2, height / 2);
		}
		noStroke();
		beginShape(TRIANGLES);
		for( int i = 0 ; i < arcos.size(); i++ ) {
			Arco b = (Arco)arcos.get(i);
			b.actualizarPosicion();     
			b.dibujar();
		}
		endShape();
	}
	//
	public void mousePressed() {
		fondo = color(255,255,255);
	}
	//
	public void setRandColors() {
		for( int i = 0 ; i < arcos.size(); i++ ) {
			Arco b = (Arco)arcos.get(i);
			b.randColor();
		}
	}
	//
	public void setRandRadiosGiro() {
		for( int i = 0 ; i < arcos.size(); i++ ) {
			Arco b = (Arco)arcos.get(i);
			b.randRadioGiro();
		}
	}
	//
	public void setRandRadios() {
		for( int i = 0 ; i < arcos.size(); i++ ) {
			Arco b = (Arco)arcos.get(i);
			b.randRadio();
		}
	}
	//
	public void setRandSpeeds() {
		for( int i = 0 ; i < arcos.size(); i++ ) {
			Arco b = (Arco)arcos.get(i);
			b.randSpeed();
		}
	}
	//
	public void keyPressed() {
		if( keyCode == KeyEvent.VK_C ) {
			setRandColors();
		}
		else if( keyCode == KeyEvent.VK_B ) {
			fondo = color( random(255), random(255), random(255) );
		}
		else if( keyCode == KeyEvent.VK_V ) {
			setRandSpeeds();
		}
		else if ( keyCode == KeyEvent.VK_A ) {
			Arco b = new Arco((int)( random(width)/2.0f ));
			b.offsetX = (int)(width / 2);
			b.offsetY = (int)(height / 2);
			b.randSpeed();
			b.randColor();
			b.randRadioGiro();
			b.randRadio();
			arcos.add( b );
		}
		else if ( keyCode == KeyEvent.VK_Z ) {
			if( arcos.size() > 1 ) {
				arcos.remove( arcos.get(0) );
			}
		}
		else if ( keyCode == KeyEvent.VK_T ) {
		}
		else if ( keyCode == KeyEvent.VK_G ) {
			setRandRadiosGiro();
		}
		else if ( keyCode == KeyEvent.VK_R ) {
			setRandRadios();
		}
	}
	//
	class Arco {
		float anguloActual = 0.0f;
		float anguloCentral = PI / 30.0f; 
		float velocidad = 0.001f;
		int radio = 10 ;
		int radioDeGiro = 50 ; 
		int x = 0 ; 
		int y = 0 ;
		int x1 = 0 ;
		int y1 = 0 ;
		int offsetX = 0 ;
		int offsetY = 0 ;
		int frente = color(125,125,125);
		//
		public void randRadioGiro() {
			radioDeGiro = (int)( random(width)/2.0f ) ;
		}
		//
		public void randRadio() {
			//radio = (int)( random(width)/25.0 ) ; 
			anguloCentral = PI / 30.0f + random( PI / 4.0f ); 
		}
		//
		void Arco( int pRadio ) {
			radioDeGiro = pRadio ;
		}
		//
		public void randColor() {
			frente = color( random(255), random(255), random(255) );
		}
		//
		public void randSpeed() {
			setVelocidad( random( 50 * 0.001f ) * pow( -1 , (int)random(100) ) );
		}
		//
		public void setVelocidad( float pV ) {
			velocidad = pV ; 
		}
		//
		public void dibujar() {
			fill( frente );
			vertex( 0 , 0 , 0 );
			vertex( x , y , 0 ) ;
			vertex( x1 , y1 , 0 ) ;
		}
		//
		public void actualizarPosicion() {    
			anguloActual += velocidad ;
			x = PApplet.parseInt( radioDeGiro * cos( anguloActual ) ) ;
			y = PApplet.parseInt( radioDeGiro * sin( anguloActual ) ) ;
			x1 = PApplet.parseInt( radioDeGiro * cos( anguloActual + anguloCentral ) ) ;
			y1 = PApplet.parseInt( radioDeGiro * sin( anguloActual + anguloCentral ) ) ;
		}
	}
	//
	static public void main(String args[]) {
		PApplet.main(new String[] { "--present", "--bgcolor=#666666", "--stop-color=#cccccc", "triangulos_opengl_processing" });
	}
}