package ar.edu.unlam.tallerweb1.modelo;

import java.util.HashSet;
import java.util.TreeSet;

public class Stock {
	
	private TreeSet<Ingrediente> listaDeIngredientesEnStock = new TreeSet<Ingrediente>();
	private static Stock instance;
		
	
	//--Funciones---//
	
	public Ingrediente buscarUnIngrediente(String nombre)
	{
		Ingrediente ingredienteBuscado = new Ingrediente();
		ingredienteBuscado.setNombre(nombre);
		for(Ingrediente each:this.listaDeIngredientesEnStock)
		{
			if(each.getNombre().equals(ingredienteBuscado.getNombre()))
			{
				return each;
			}
			
				
		}
		return null;
	}
	
	public void agregarIngrediente(Ingrediente ingrediente) throws Exception
	{
		if(ingrediente.getNombre().equals(null)||ingrediente.getNombre().length()==0)
		{
			throw new Exception("Error : Nombre de ingrediente vacio");
		}
		if(buscarUnIngrediente(ingrediente.getNombre())!=null)
		{
			aumentarElStockDeUnIngrediente(ingrediente.getNombre(), ingrediente.getCantidad());
			buscarUnIngrediente(ingrediente.getNombre()).setTipo(ingrediente.getTipo());
		}
		else
		{
			this.listaDeIngredientesEnStock.add(ingrediente);
		}
	}
	//creo q no anda
	public HashSet<Ingrediente> mostrarIngredientesQueTenganStockMayorA0()
	{
		HashSet<Ingrediente> lista= new HashSet<Ingrediente>();
		for(Ingrediente each:this.listaDeIngredientesEnStock)
		{
			if(each.getCantidad()>0)
			{
				lista.add(each);
			}
		}
		return lista;
	}
	
	public void quitarIngrediente(Ingrediente ingrediente)
	{
		this.listaDeIngredientesEnStock.remove(ingrediente);
	}
	
	public void aumentarElStockDeUnIngrediente(String nombre,Integer cantidad)
	{
		buscarUnIngrediente(nombre).aumentarStock(cantidad);
		
	}
	public void disminuirElStockDeUnIngrediente(String nombre,Integer cantidad)
	{
		buscarUnIngrediente(nombre).disminuirStock(cantidad);
		
	}
	public void reseteoElStockDeUnIngrediente(String nombre)
	{
		buscarUnIngrediente(nombre).resetearStock();
		
	}
	public void EliminarTodosLosIngredientes()
	{
		this.listaDeIngredientesEnStock.clear();
		
	}
	public void ponerEn0LasCantidadesDeIngredientesEnStock()
	{
		for(Ingrediente each:this.listaDeIngredientesEnStock)
		{
			each.setCantidad(0);
		}
	}
	
	
	//funciones//
	
	
		
		
		public static Stock getSingletonInstance() {
	        if (instance == null){
	            instance = new Stock();
	        }
	        
	        return instance;
	    }
		


		public TreeSet<Ingrediente> getListaDeIngredientesEnStock() {
			return listaDeIngredientesEnStock;
		}


		public void setListaDeIngredientesEnStock(TreeSet<Ingrediente> listaDeIngredientesEnStock) {
			this.listaDeIngredientesEnStock = listaDeIngredientesEnStock;
		}

		public static Stock getInstance() {
			return instance;
		}

		public static void setInstance(Stock instance) {
			Stock.instance = instance;
		}
		
		
		
		
		
}
