package dominio;

import java.util.Calendar;
import java.util.Date;

import dominio.repositorio.RepositorioProducto;
import dominio.repositorio.RepositorioGarantiaExtendida;
import dominio.excepcion.*;

public class Vendedor {
    public static final String EL_PRODUCTO_ES_NULL = "Codigo de producto NULL";
    public static final String EL_PRODUCTO_TIENE_GARANTIA = "El producto ya cuenta con una garantia extendida";
    public static final String EL_PRODUCTO_TIENE_3_VOCALES = "Este producto no cuenta con garantía extendida";
    public static final double LIMITE_PRECIO_PRODUCTO = 500000;
    //
    private RepositorioProducto repositorioProducto;
    private RepositorioGarantiaExtendida repositorioGarantia;
    private Date fechaActual;
    //
    public Vendedor(RepositorioProducto repositorioProducto, RepositorioGarantiaExtendida repositorioGarantia, Date fechaActual) {
        this.repositorioProducto = repositorioProducto;
        this.repositorioGarantia = repositorioGarantia;
        this.fechaActual = fechaActual;
    }
    //
    public void generarGarantia(String codigo, String nombreCliente) {
		this.validacionesGenerarGarantia(codigo);
		Producto producto = this.repositorioProducto.obtenerPorCodigo(codigo);
		Date fechaSolicitudGarantia = new Date();
		Date fechaFinGarantia = this.calcularFechaFinGarantia(producto);
		double precioGarantiaExt = this.calcularPrecioGarantia(producto);
		GarantiaExtendida garantiaExtendida = new GarantiaExtendida(producto, fechaSolicitudGarantia, fechaFinGarantia, precioGarantiaExt, nombreCliente);
		this.repositorioGarantia.agregar(garantiaExtendida);
    }
    //
    public boolean tieneGarantia(String codigo) {
		Producto garantiaProducto = this.repositorioGarantia.obtenerProductoConGarantiaPorCodigo(codigo);
		return garantiaProducto != null;
    }
    //
    public boolean validaVocales(String codigo) {
    	int contador = 0;
    	boolean resultado;
        for(int x=0;x<codigo.length();x++) {
            if ((codigo.charAt(x)=='a') || (codigo.charAt(x)=='e') || (codigo.charAt(x)=='i') || (codigo.charAt(x)=='o') || (codigo.charAt(x)=='u')){
              contador++;
            }
        }
        if(contador >=3 ) { resultado = true; }
        else { resultado = false; }
    	return resultado;
	}
    //
	public void validacionesGenerarGarantia(String codigo) {
		if (codigo == null) { throw new GarantiaExtendidaException(Vendedor.EL_PRODUCTO_ES_NULL); }
		if (this.tieneGarantia(codigo)) { throw new GarantiaExtendidaException(Vendedor.EL_PRODUCTO_TIENE_GARANTIA); }
		if (this.validaVocales(codigo)) { throw new GarantiaExtendidaException(Vendedor.EL_PRODUCTO_TIENE_3_VOCALES); }
	}
	//
	private double calcularPrecioGarantia(Producto producto) {
		double resultado;
		if(producto.getPrecio() > LIMITE_PRECIO_PRODUCTO) { resultado = producto.getPrecio() * 0.20; }
		else { resultado = producto.getPrecio() * 0.10; }
		return resultado;
	}
	//
	private Date calcularFechaFinGarantia(Producto producto) {
		Date resultado;
		//
		if(producto.getPrecio() > LIMITE_PRECIO_PRODUCTO) {
    		Calendar calendar = Calendar.getInstance();
    		calendar.setTime(fechaActual);
    		for(int i=0; i<200; i++) {
    			calendar.add(Calendar.DATE, 1);
    			if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.MONDAY) {
    				calendar.add(Calendar.DATE, 1);
    			}
    		}
    		if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY) {
    			calendar.add(Calendar.DATE, 1);
			}
    		resultado = calendar.getTime();
		}else {
    		Calendar calend = Calendar.getInstance();
    		calend.setTime(fechaActual);
    		for(int i=0; i<100; i++) {
    			calend.add(Calendar.DATE, 1);
    			if(calend.get(Calendar.DAY_OF_WEEK)==Calendar.MONDAY) {
    				calend.add(Calendar.DATE, 1);
    			}
    		}
    		if(calend.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY) {
    			calend.add(Calendar.DATE, 1);
			}
    		resultado = calend.getTime();
		}
		return resultado;
	}	
}