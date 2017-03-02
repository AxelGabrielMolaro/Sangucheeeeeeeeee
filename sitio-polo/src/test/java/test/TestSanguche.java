package test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Sanguche;
import ar.edu.unlam.tallerweb1.modelo.Stock;
import ar.edu.unlam.tallerweb1.modelo.TipoIngrediente;
import junit.framework.Assert;

public class TestSanguche {

	
	
	@Test
	public void testQueArmoBienElSanguche() throws Exception {
	
		Stock miStock=Stock.getSingletonInstance();
		miStock.EliminarTodosLosIngredientes();

		Ingrediente i1=new Ingrediente();
		i1.setNombre("tomate");
		i1.setCantidad(10);
		i1.setTipo(TipoIngrediente.CONDIMENTO);
		miStock.agregarIngrediente(i1);
		
		Ingrediente i2=new Ingrediente();
		i2.setNombre("lechuga");
		i2.setCantidad(20);
		i2.setTipo(TipoIngrediente.CONDIMENTO);
		miStock.agregarIngrediente(i2);
		
		Sanguche miSanguche=Sanguche.getSingletonInstance();
		
		miSanguche.agregarIngrediente(miStock.buscarUnIngrediente("tomate").getNombre(), 2);
		
		
		Integer cantidadDeTomateEsperada=2;
		Integer cantidadRealDeTomate=miSanguche.buscarIngrediente("tomate").getCantidad();
		Assert.assertEquals(cantidadDeTomateEsperada, cantidadRealDeTomate);
		
		miSanguche.comprar();
		Integer cantidadDeTomateEsperadaStock=8;
		Integer cantidadRealDeTomateStock=miStock.buscarUnIngrediente("tomate").getCantidad();
		Assert.assertEquals(cantidadDeTomateEsperada, cantidadRealDeTomate);
	}
	
	
	
	

}
