package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Stock;
import ar.edu.unlam.tallerweb1.modelo.TipoIngrediente;

@Controller
public class ABMIngredienteControlador {
	
	@RequestMapping("listaDeIngredientes")
	public ModelAndView listaDeIngredientes()
	{
		ModelMap abmIngredienteModelo=new ModelMap();
		abmIngredienteModelo.put("ingrediente",new Ingrediente());
		Stock miStock= Stock.getSingletonInstance();
		abmIngredienteModelo.put("listaDeIngredientesStock",miStock.getListaDeIngredientesEnStock() );
		
		return new ModelAndView("agregarIngrediente",abmIngredienteModelo);
	}
	
	@RequestMapping(value="agregarIngrediente",method=RequestMethod.POST)
	public ModelAndView agregarIngrediente(
			@RequestParam("nombre") String nombre,
			@RequestParam("cantidad") Integer cantidad,
			@RequestParam("tipo") TipoIngrediente tipo,
			@RequestParam("precio") Integer precio
			)
	{
		ModelMap abmIngredienteModelo=new ModelMap();
		abmIngredienteModelo.put("ingrediente",new Ingrediente());
		Ingrediente nuevoIngrediente=new Ingrediente();
		nuevoIngrediente.setNombre(nombre);
		nuevoIngrediente.setCantidad(cantidad);
		nuevoIngrediente.setTipo(tipo);
		nuevoIngrediente.setPrecio(precio);
		Stock miStock=Stock.getSingletonInstance();
		try {
			miStock.agregarIngrediente(nuevoIngrediente);
			abmIngredienteModelo.put("exepcion","");
		} catch (Exception e) {
			abmIngredienteModelo.put("exepcion",e.getMessage());
		}
		
		abmIngredienteModelo.put("stock", miStock);
		abmIngredienteModelo.put("listaDeIngredientesStock", miStock.getListaDeIngredientesEnStock());
		return new ModelAndView("agregarIngrediente",abmIngredienteModelo);
	}
	
	@RequestMapping("modificarStock/{nombreIngrediente}")
	public ModelAndView modificarIngredienteStockForm(
			@PathVariable("nombreIngrediente") String nombreIngrediente
			)
	{
		ModelMap abmIngredienteModelo=new ModelMap();
		Stock miStock=Stock.getSingletonInstance();
		abmIngredienteModelo.put("ingredienteAModificar",miStock.buscarUnIngrediente(nombreIngrediente));
		abmIngredienteModelo.put("ingrediente", new Ingrediente());
		return new ModelAndView("modificarStock",abmIngredienteModelo);
	}
	
	@RequestMapping(value="modificarStock2/{nombre}",method= RequestMethod.POST)
	public ModelAndView modificarIngredienteStock(
			
			@PathVariable("nombre") String nombreIngrediente,
			@RequestParam("cantidad") Integer cantidadIngrediente,
			@RequestParam("tipo") TipoIngrediente tipoIngrediente,
			@RequestParam("precio") Integer precio
			)
	{
		ModelMap abmIngredienteModelo=new ModelMap();
		Stock miStock=Stock.getSingletonInstance();
		
		miStock.buscarUnIngrediente(nombreIngrediente).setCantidad(cantidadIngrediente);
		miStock.buscarUnIngrediente(nombreIngrediente).setTipo(tipoIngrediente);
		miStock.buscarUnIngrediente(nombreIngrediente).setNombre(nombreIngrediente);
		miStock.buscarUnIngrediente(nombreIngrediente).setPrecio(precio);;

		abmIngredienteModelo.put("ingrediente", new Ingrediente());
		abmIngredienteModelo.put("stock", miStock);
		abmIngredienteModelo.put("listaDeIngredientesStock", miStock.getListaDeIngredientesEnStock());
		System.out.println(miStock.getListaDeIngredientesEnStock());
		return new ModelAndView("agregarIngrediente",abmIngredienteModelo);
	}
	
	@RequestMapping("eliminarStock/{nombre}")
	public ModelAndView eliminarIngrediente(
			
			@PathVariable("nombre") String nombreIngrediente
			
			)
	{
		ModelMap abmIngredienteModelo=new ModelMap();
		Stock miStock=Stock.getSingletonInstance();
		
		miStock.quitarIngrediente(miStock.buscarUnIngrediente(nombreIngrediente));
		abmIngredienteModelo.put("ingrediente", new Ingrediente());
		abmIngredienteModelo.put("stock", miStock);
		abmIngredienteModelo.put("listaDeIngredientesStock", miStock.getListaDeIngredientesEnStock());
		System.out.println(miStock.getListaDeIngredientesEnStock());
		return new ModelAndView("agregarIngrediente",abmIngredienteModelo);
	}
	
	@RequestMapping("eliminarTodoElStock")
	public ModelAndView eliminarTodoElStock()
	{
		ModelMap abmIngredienteModelo=new ModelMap();
		Stock miStock=Stock.getSingletonInstance();
		
		miStock.EliminarTodosLosIngredientes();
		
		abmIngredienteModelo.put("ingrediente", new Ingrediente());
		abmIngredienteModelo.put("stock", miStock);
		abmIngredienteModelo.put("listaDeIngredientesStock", miStock.getListaDeIngredientesEnStock());
		System.out.println(miStock.getListaDeIngredientesEnStock());
		return new ModelAndView("agregarIngrediente",abmIngredienteModelo);
	}
	
	@RequestMapping("vaciarStock")
	public ModelAndView vaciarStock()
	{
		ModelMap abmIngredienteModelo=new ModelMap();
		Stock miStock=Stock.getSingletonInstance();
		
		miStock.ponerEn0LasCantidadesDeIngredientesEnStock();
		
		abmIngredienteModelo.put("ingrediente", new Ingrediente());
		abmIngredienteModelo.put("stock", miStock);
		abmIngredienteModelo.put("listaDeIngredientesStock", miStock.getListaDeIngredientesEnStock());
		System.out.println(miStock.getListaDeIngredientesEnStock());
		return new ModelAndView("agregarIngrediente",abmIngredienteModelo);
	}
	
	
}

