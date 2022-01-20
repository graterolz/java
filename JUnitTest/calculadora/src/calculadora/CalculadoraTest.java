package calculadora;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class CalculadoraTest {
	//
	static CalculadoraV2 calc2;
	//
	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass()");
		calc2 = new CalculadoraV2();
	}
	//
	@Before
	public void before() {
		System.out.println("before()");
		calc2.clear();
	}
	//
	@After
	public void after() {
		System.out.println("after()");
	}
	//
	@AfterClass
	public static void afterClass() {
		System.out.println("afterClass()");
	}
	//
	@Test
	public void testSuma() {
		int resultado = Calculadora.suma(2, 3);
		int esperado = 5; // 2 + 3 = 5
		assertEquals(esperado, resultado);
		//fail("Not yet implemented");
	}
	//
	@Test
	public void testResta(){
		int resultado = Calculadora.resta(3, 2);
		int esperado = 1; // 3 - 2 = 1
		assertEquals(esperado, resultado);
	}
	//
	@Test
	public void testSum_V2(){
		int resultado = calc2.add(3,2);
		int esperado = 5;
		assertEquals(esperado, resultado);
	}
	//
	@Test
	public void testAnsSum_V2() {
		calc2.add(3,2);
		int resultado = calc2.ans();
		int esperado = 5;
		assertEquals(esperado,resultado);
	}
	//
	@Test
	public void testDiv() {
		calc2.div(5, 2);
	}
	//
	@Test(expected = ArithmeticException.class)
	public void testDivPorCero() {
		calc2.div(5, 0);
	}
	//
	@Test(timeout = 100)
	public void testOperacionOptima() {
		//calc2.operacionOptima();
	}
}