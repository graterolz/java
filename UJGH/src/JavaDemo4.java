import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.border.*;
import java.awt.*;
import javax.swing.*;
public class JavaDemo4 {
	public void J016_TablaMultiplicarDel1Al9() {
		for(int i=1;i<10;i++){
			for(int j=1;j<=10;j++){
				System.out.println(i + " * " + j + " = " + (i*j));
			}
		}
	}
	//
	public void J017_CadenaMinuscula() throws Exception{
		BufferedReader EntradaTeclado = new BufferedReader (new InputStreamReader(System.in));
		String mensaje;
		System.out.print("Ingresa cadena de caracteres: ");
		mensaje = EntradaTeclado.readLine();
		mensaje = mensaje.toLowerCase();
		System.out.print("Cadena en minuscula: " + mensaje);
	}
	//
	public void J018_CadenaMayuscula() throws Exception{
		BufferedReader EntradaTeclado = new BufferedReader (new InputStreamReader(System.in));
		String mensaje;
		System.out.print("Ingresa cadena de caracteres: ");
		mensaje = EntradaTeclado.readLine();
		mensaje = mensaje.toUpperCase();
		System.out.print("Cadena en mayuscula: " + mensaje);
	}
	//
	public void J019_PromedioDeNNumeros() throws Exception {
		BufferedReader EntradaTeclado = new BufferedReader (new InputStreamReader(System.in));
		System.out.print("Ingrese cuantos numeros se van a promediar: ");
		int num_prom;
		num_prom = Integer.parseInt(EntradaTeclado.readLine());		
		int[] numeros = new int[num_prom];
		float promedio = 0;
		for(int i=0;i<num_prom;i++){
			System.out.print("Ingrese numero " + (i+1) + ": ");
			numeros[i] = Integer.parseInt(EntradaTeclado.readLine());
			promedio = promedio + numeros[i];
		}
		promedio = promedio / num_prom;
		System.out.print("El promedio es: " + promedio);
	}
	//
	public void J020_ShowMessageDialog(){
		JOptionPane.showMessageDialog(null, "Contenido");
		System.exit(0);
	}
	//
	public void J021_ShowMessageCadena(){
		String primerNumero;
		primerNumero=JOptionPane.showInputDialog("Ingrese cadena de texto");		
		JOptionPane.showMessageDialog(null, primerNumero, "Titulo",JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);	 
	}
	//
	public void J022_BarraProceso() throws Exception{
		JFrame JVentana = new JFrame("Frame");
		JVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JVentana.setLocationRelativeTo(null);
		JVentana.setResizable(false);
		
		Container Contenedor = JVentana.getContentPane();
		
		JProgressBar JBarra = new JProgressBar();
		JBarra.setStringPainted(true);
		
		Border border = BorderFactory.createTitledBorder("Cargando..");
		JBarra.setBorder(border);
		
		Contenedor.add(JBarra,BorderLayout.NORTH);
		
		JVentana.setSize(300,70);
		JVentana.setVisible(true);
		
		for(int i=0;i<=100;i=i+1){
			Thread.currentThread().sleep(100);
			JBarra.setValue(i);
			if (i==100){
				System.exit(0);	
			}
		}
	}
	//
	public void J023_InformacionSO() {
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("os.version"));
		System.out.println(System.getProperty("os.arch"));
		System.out.println("***********************************************");
		System.out.println(System.getProperty("java.version"));
		System.out.println(System.getProperty("java.vendor"));
		System.out.println(System.getProperty("java.vendor.url"));
		System.out.println(System.getProperty("java.home"));
		System.out.println("***********************************************");
		System.out.println(System.getProperty("java.vm.specification.version"));
		System.out.println(System.getProperty("java.vm.specification.vendor"));
		System.out.println(System.getProperty("java.vm.specification.name"));
		System.out.println(System.getProperty("java.vm.version"));
		System.out.println(System.getProperty("java.vm.name"));
		System.out.println("***********************************************");
		System.out.println(System.getProperty("java.specification.version"));
		System.out.println(System.getProperty("java.specification.vendor"));
		System.out.println(System.getProperty("java.specification.name"));
		System.out.println(System.getProperty("java.class.version"));
		System.out.println(System.getProperty("java.class.path"));
		System.out.println("***********************************************");
		System.out.println(System.getProperty("java.library.path"));
		System.out.println(System.getProperty("java.io.tmpdir"));
		System.out.println(System.getProperty("java.compiler"));
		System.out.println(System.getProperty("java.ext.dirs"));
		System.out.println("***********************************************");
		System.out.println(System.getProperty("file.separator"));
		System.out.println(System.getProperty("path.separator"));
		System.out.println(System.getProperty("line.separator"));
		System.out.println("***********************************************");
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("user.home"));
		System.out.println(System.getProperty("user.dir"));
	}
}