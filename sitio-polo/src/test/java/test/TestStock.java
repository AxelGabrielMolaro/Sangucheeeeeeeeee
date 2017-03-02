package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Stock;
import ar.edu.unlam.tallerweb1.modelo.TipoIngrediente;
import jdk.Exported;
import junit.framework.Assert;

public class TestStock {

	
//	@Before
//	public void inicializar()
//	{
//		Stock miStock=Stock.getSingletonInstance();
//		Integer valorEsperadoInteger;
//		Integer valorRealInteger;
//		Integer valorEsperadoString;
//		Integer valorRealString;
//	}
	
	@Test
	public void testQueAgregoBien() throws Exception {
		
			
		Stock miStock=Stock.getSingletonInstance();
		Ingrediente i1=new Ingrediente();
		i1.setNombre("lechuga");
		i1.setCantidad(12);
		
		i1.setTipo(TipoIngrediente.CONDIMENTO);
		Ingrediente i2=new Ingrediente();
		i2.setNombre("lechuga");
		i2.setCantidad(12);
		i2.setTipo(TipoIngrediente.INGREDIENTE);
		
		miStock.agregarIngrediente(i1);
		miStock.agregarIngrediente(i2);
	
		Integer valorRealCantidad=miStock.buscarUnIngrediente("lechuga").getCantidad();
		Integer valorEsperadoCantidad=24;
		Assert.assertEquals(valorEsperadoCantidad,valorRealCantidad);
		
		TipoIngrediente valorRealTipo=miStock.buscarUnIngrediente("lechuga").getTipo();
		TipoIngrediente valorEsperadoTipo=TipoIngrediente.INGREDIENTE;
		Assert.assertEquals(valorRealTipo,valorEsperadoTipo);
		
		
	}
	
	@Test(expected=Exception.class)
	
	public void testQueAgregoMalYSaltaExepcion() throws Exception {
		
			
		Stock miStock=Stock.getSingletonInstance();
		Ingrediente i1=new Ingrediente();
		i1.setNombre("");
		i1.setCantidad(0);
		
		i1.setTipo(TipoIngrediente.CONDIMENTO);
		
		
		miStock.agregarIngrediente(i1);

		
	}
	
	@Test
	
	public void testQueEliminaBien() throws Exception {
		
		
		Stock miStock=Stock.getSingletonInstance();
		miStock.EliminarTodosLosIngredientes();
		Ingrediente i1=new Ingrediente();
		i1.setNombre("lechuga");
		i1.setCantidad(3);
		i1.setTipo(TipoIngrediente.CONDIMENTO);
		miStock.agregarIngrediente(i1);
	
		miStock.disminuirElStockDeUnIngrediente("lechuga", 3);
		Integer valorRealCantidad=miStock.buscarUnIngrediente("lechuga").getCantidad();
		Integer valorEsperadoCantidad=0;
		Assert.assertEquals(valorEsperadoCantidad,valorRealCantidad);

		
	}
	

}
