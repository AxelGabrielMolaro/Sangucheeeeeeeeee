package test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.TipoIngrediente;
import junit.framework.Assert;

public class TestIngrediente {

	@Test
	public void testQueAgregoCantidadIngrediente() {
		 Ingrediente miIngrediente=new Ingrediente();
		 miIngrediente.aumentarStock(12);
		 Integer valorEsperado=12;
		 Assert.assertEquals(valorEsperado, miIngrediente.getCantidad());
	}
	
	@Test
	public void testQueQuitoCantidadIngrediente() {
		 Ingrediente miIngrediente=new Ingrediente();
		 miIngrediente.aumentarStock(12);
		 miIngrediente.disminuirStock(6);
		 Integer valorEsperado=6;
		 Assert.assertEquals(valorEsperado, miIngrediente.getCantidad());
	}	
	
	@Test
	public void testQueReseteoCantidadIngrediente() {
		 Ingrediente miIngrediente=new Ingrediente();
		 miIngrediente.aumentarStock(12);
		 miIngrediente.resetearStock();
		 Integer valorEsperado=0;
		 Assert.assertEquals(valorEsperado, miIngrediente.getCantidad());
	}	
	@Test
	public void cambioElNombreDeUnIngrediente() {
		 Ingrediente miIngrediente=new Ingrediente();
		 miIngrediente.setNombre("Lechuga");
		 miIngrediente.cambiarNombre("Tomate");
		 String valorEsperado="Tomate";
		 Assert.assertEquals(valorEsperado, miIngrediente.getNombre());
	}	
	@Test
	public void cambioElTipoDeUnIngrediente() {
		 Ingrediente miIngrediente=new Ingrediente();
		 miIngrediente.setTipo(TipoIngrediente.CONDIMENTO);
		 miIngrediente.cambiarTipoDeIngrediente(TipoIngrediente.INGREDIENTE);
		 TipoIngrediente valorEsperado= TipoIngrediente.INGREDIENTE;
		 Assert.assertEquals(valorEsperado, miIngrediente.getTipo());
	}	
}
