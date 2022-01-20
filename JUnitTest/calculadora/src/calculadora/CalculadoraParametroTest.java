package calculadora;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class CalculadoraParametroTest {
	//
	@Parameters
	public static Iterable<Object[]> getData(){
		List<Object[]> obj = new ArrayList<>();
		obj.add(new Object[] {3,1,4});
		obj.add(new Object[] {2,3,5});
		obj.add(new Object[] {3,3,6});
		return obj;
	}
	//
	private int a, b, esperado;
	//
	public CalculadoraParametroTest(int a, int b, int esperado) {
		this.a = a;
		this.b = b;
		this.esperado = esperado;
	}
	//
	@Test
	public void testAdd() {
		CalculadoraV2 calc2 = new CalculadoraV2();
		int resultado = calc2.add(a,b);
		assertEquals(esperado, resultado);
	}
}