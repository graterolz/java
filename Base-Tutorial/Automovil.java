public class Automovil {
    // Atributos
    private String marca;
    private String modelo;
    private int anio;
    public String color;
    private int velocidad;

    // Enciende Automovil
    private void encender(){
        System.out.println("El Automovil esta encendido.");
    }

    private void apagar(){
        System.out.println("El Automovil esta apagado.      ");
    }

    // Acelera Automovil
    public void acelerar(int incremento){
        velocidad = incremento;
        System.out.println("El Automovil aceleró.");
        System.out.println("Velocidad Actual: " + velocidad + " km/H");
    }

    // Frena Automovil
    public void frenar(int decremento){
        velocidad = decremento;
        System.out.println("El Automovil frenó.");
        System.out.println("Velocidad Actual: " + velocidad + " km/H");
    }

    // Metodo Principal
    public static void main(String[] args) {
       Automovil miAuto = new Automovil();

       miAuto.encender();
       miAuto.acelerar(20);
       miAuto.frenar(10);
       miAuto.apagar();

    }
}
