package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.HistorialDeVentas;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Sanguche;
import ar.edu.unlam.tallerweb1.modelo.Stock;
import ar.edu.unlam.tallerweb1.modelo.TipoIngrediente;

@Controller
public class SangucheController {
	
//	public  SangucheController() throws Exception  {
//		Stock miStock=Stock.getSingletonInstance();
//		Ingrediente i1=new Ingrediente();
//		i1.setNombre("ingre1");
//		i1.setCantidad(10);
//		i1.setTipo(TipoIngrediente.CONDIMENTO);
//		
//		Ingrediente i2=new Ingrediente();
//		i2.setNombre("ingre2");
//		i2.setCantidad(2);
//		i2.setTipo(TipoIngrediente.CONDIMENTO);
//		
//		Ingrediente i3=new Ingrediente();
//		i3.setNombre("ingre3");
//		i3.setCantidad(122);
//		i3.setTipo(TipoIngrediente.CONDIMENTO);
//		
//		miStock.agregarIngrediente(i1);
//		miStock.agregarIngrediente(i2);
//		miStock.agregarIngrediente(i3);
//		
//	}
	@RequestMapping("/armarSanguche")
	public ModelAndView listaDeIngredientes()
	{
		ModelMap modeloSanguche= new ModelMap();
		Stock miStock=Stock.getSingletonInstance();
		Sanguche miSanguche=Sanguche.getSingletonInstance();
		modeloSanguche.put("listaDeIngredientesStock",miStock.mostrarIngredientesQueTenganStockMayorA0());
		modeloSanguche.put("listaDeIngredientesSanguche", miSanguche.getListaSanguche());
		modeloSanguche.put("ingrediente", new Ingrediente());
		modeloSanguche.put("precioTotal", miSanguche.getPrecioTotal());
		modeloSanguche.put("direccion", new Direccion());
		System.out.println(miSanguche.getPrecioTotal());
		return new ModelAndView("armarSanguche",modeloSanguche);
	}
	
	@RequestMapping(value="agregarIngredienteSanguche",method=RequestMethod.POST)
	public ModelAndView agregrarIngredienteSanguche(
			@RequestParam("nombre")String nombre,
			@RequestParam("cantidad")Integer cantidad
			
			)
	{
		ModelMap modeloSanguche= new ModelMap();
		Stock miStock=Stock.getSingletonInstance();
		Sanguche miSanguche=Sanguche.getSingletonInstance();
		try {
			miSanguche.agregarIngrediente(nombre, cantidad);
			modeloSanguche.put("listaDeIngredientesStock",miStock.mostrarIngredientesQueTenganStockMayorA0());
			modeloSanguche.put("listaDeIngredientesSanguche", miSanguche.getListaSanguche());
			modeloSanguche.put("ingrediente", new Ingrediente());
			modeloSanguche.put("exepcion","");
			modeloSanguche.put("direccion", new Direccion());

			modeloSanguche.put("precioTotal", miSanguche.getPrecioTotal());

			return new ModelAndView("armarSanguche",modeloSanguche);
		} catch (Exception e) {
			modeloSanguche.put("listaDeIngredientesStock",miStock.mostrarIngredientesQueTenganStockMayorA0());
			modeloSanguche.put("listaDeIngredientesSanguche", miSanguche.getListaSanguche());
			modeloSanguche.put("ingrediente", new Ingrediente());
			modeloSanguche.put("direccion", new Direccion());
			modeloSanguche.put("exepcion", e.getMessage());
			modeloSanguche.put("precioTotal", miSanguche.getPrecioTotal());

			return new ModelAndView("armarSanguche",modeloSanguche);
		}
		
		
	}
	
	@RequestMapping("eliminarSanguche/{nombre}")
	public ModelAndView eliminarIngredienteSanguche(
			@PathVariable("nombre")String nombre
			
			)
	{
		ModelMap modeloSanguche= new ModelMap();
		Stock miStock=Stock.getSingletonInstance();
		Sanguche miSanguche=Sanguche.getSingletonInstance();
		miSanguche.eliminarIngrediente(nombre);
		modeloSanguche.put("exepcion","");
		modeloSanguche.put("listaDeIngredientesStock",miStock.mostrarIngredientesQueTenganStockMayorA0());
		modeloSanguche.put("listaDeIngredientesSanguche", miSanguche.getListaSanguche());
		modeloSanguche.put("precioTotal", miSanguche.getPrecioTotal());
		modeloSanguche.put("direccion", new Direccion());

		modeloSanguche.put("ingrediente", new Ingrediente());
		return new ModelAndView("armarSanguche",modeloSanguche);
	}
	
	@RequestMapping("vaciarSanguche")
	public ModelAndView vaciarSanguche(
			
			
			)
	{
		ModelMap modeloSanguche= new ModelMap();
		Stock miStock=Stock.getSingletonInstance();
		Sanguche miSanguche=Sanguche.getSingletonInstance();
		miSanguche.vaciarSanguche();
		modeloSanguche.put("direccion", new Direccion());
		
		modeloSanguche.put("listaDeIngredientesStock",miStock.mostrarIngredientesQueTenganStockMayorA0());
		modeloSanguche.put("listaDeIngredientesSanguche", miSanguche.getListaSanguche());
		modeloSanguche.put("precioTotal", miSanguche.getPrecioTotal());
		modeloSanguche.put("ingrediente", new Ingrediente());
		return new ModelAndView("armarSanguche",modeloSanguche);
	}
	
	
	@RequestMapping(value="/comprarSanguche",method=RequestMethod.POST)
	public ModelAndView comprar(
			@RequestParam("calle") String calle,
			@RequestParam("numero") String numero
			
			
			)
	{
		
		ModelMap modeloSanguche= new ModelMap();
		Sanguche miSanguche= Sanguche.getSingletonInstance();
		
		
		try {
			miSanguche.comprar(calle,numero);
			Direccion direccion=new Direccion();
			direccion.setCalle(calle);
			direccion.setNumero(numero);
			Pedido pedido=new Pedido();
			pedido.setDireccion(direccion);
			HistorialDeVentas miHistorial=HistorialDeVentas.getSingletonInstance();
			miHistorial.agregarVentaAlHistorial(pedido);
			
		} catch (Exception e) {
			modeloSanguche.put("exepcion", "");
			modeloSanguche.put("exepcion2", e.getMessage());
			Stock miStock=Stock.getSingletonInstance();
			modeloSanguche.put("listaDeIngredientesStock",miStock.mostrarIngredientesQueTenganStockMayorA0());
			modeloSanguche.put("listaDeIngredientesSanguche", miSanguche.getListaSanguche());
			modeloSanguche.put("ingrediente", new Ingrediente());
			modeloSanguche.put("precioTotal", miSanguche.getPrecioTotal());
			modeloSanguche.put("direccion", new Direccion());
			return new ModelAndView("armarSanguche",modeloSanguche);
		}
		
		
		
		return new ModelAndView("gracias",modeloSanguche);
	}
	
	
	
	
}
