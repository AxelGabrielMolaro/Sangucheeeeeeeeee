package ar.edu.unlam.tallerweb1.modelo;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;



public class Sanguche {
	

	private HashSet<Ingrediente> listaSanguche= new HashSet<Ingrediente>(); 
	private static Sanguche instance;
	private Stock mistock=Stock.getSingletonInstance();
	private Integer precioTotal = 0;
	
	//single
	
	//constructor
	public static Sanguche getSingletonInstance() {
        if (instance == null){
            instance = new Sanguche();
            
        }
        
        return instance;
    }
	 public void aumentarPrecio(Integer valor,Integer cantidad)
	 {
		 this.precioTotal = this.precioTotal + valor * cantidad;
	 }
	 public void disminuirPrecio(Integer valor,Integer cantidad)
	 {
		 this.precioTotal = this.precioTotal - valor * cantidad;
	 }
	 public void resetearPrecio()
	 {
		 this.precioTotal=0;
	 }
//	public void comprar() throws Exception
//	{
//		Stock miStock=Stock.getSingletonInstance();
//		if(this.listaSanguche.size()>0)
//		{
//			for(Ingrediente each:this.listaSanguche)
//			{
//				mistock.buscarUnIngrediente(each.getNombre()).disminuirStock(each.getCantidad());
//			}
//			vaciarSanguche();
//		}
//		else
//		{
//			throw new Exception("Sanguche vacio");
//		}
//	}
	 public void comprar(String calle,String numero) throws Exception
		{
			if (calle.length() == 0)
			{
				
				throw new Exception("Error: Introduce la calle");
			}
			else if(numero.length() == 0)
			{
				throw new Exception("Error: Introduce la numeracion");
			}
			else
			{
				if(this.listaSanguche.size()>0)
				{
					for(Ingrediente each:this.listaSanguche)
					{
						mistock.buscarUnIngrediente(each.getNombre()).disminuirStock(each.getCantidad());
						
						
					}
					
				}
				else
				{
					throw new Exception("Sanguche vacio");
				}
			}
		}
	
	public void vaciarSanguche()
	{
		this.listaSanguche.clear();
		resetearPrecio();
	}
	public void eliminarIngrediente(String nombre)
	{
		disminuirPrecio(buscarIngrediente(nombre).getPrecio(),buscarIngrediente(nombre).getCantidad());
		this.listaSanguche.remove(buscarIngrediente(nombre));
	}
	//para validar
	public Integer siEsNullDaCantidad0Ingrediente(Ingrediente ingrediente)
	{
		
		if (ingrediente!=null)
		{
		
			return ingrediente.getCantidad();
		}
		else
		{
			
			return 0;
		}
	}
	
	public Integer SiEsNullDa0(String nombre)
	{
		Ingrediente ingrediente=buscarIngrediente(nombre);
		if (ingrediente!=null)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	//--
	public Ingrediente buscarIngrediente(String nombre)
	{
		Ingrediente IngredienteBuscado=new Ingrediente();
		IngredienteBuscado.setNombre(nombre);
		
		for(Ingrediente each:this.listaSanguche)
		{
			if(each.getNombre().equals(IngredienteBuscado.getNombre()))
			{
				return each;
			}
		}
		return null;
	}

	public void agregarIngrediente(String nombre,Integer cantidad) throws Exception
	{

		
		Ingrediente nuevoIngrediente= new Ingrediente();
		nuevoIngrediente.setNombre(nombre);
		nuevoIngrediente.setCantidad(cantidad);
		Integer valor1=siEsNullDaCantidad0Ingrediente(mistock.buscarUnIngrediente(nombre));
		Integer valor2=cantidad;
		Integer valor3=siEsNullDaCantidad0Ingrediente(buscarIngrediente(nombre));
		Integer valor4=valor2+valor3;
		Integer resultado=valor1-valor2-valor3 ;
	
		if(nuevoIngrediente.getNombre().equals("ninguno000")||nombre == "ninguno000")
		{
			throw new Exception("Error : Nombre ingrediente vacio");
		}
		
		else if(cantidad<=0)
		{
			throw new Exception("Error : Por favor Ingrese una Cantidad mayor a 0");
		}
		
		else if(valor1<valor4)
		{
			resultado=0;
			valor1=0;
			valor2=0;
			valor3=0;
			valor4=0;
			System.out.println(resultado);
			throw new Exception("Error : no hay cantidad suficiente de stock lo sentimos");
		}
		else
		{
				if(buscarIngrediente(nombre)== null )
				{
					Stock miStock= Stock.getSingletonInstance();
					Ingrediente ingreAAgregar=new Ingrediente();
					ingreAAgregar.setNombre(miStock.buscarUnIngrediente(nombre).getNombre());
					ingreAAgregar.setPrecio(miStock.buscarUnIngrediente(nombre).getPrecio());
					ingreAAgregar.setTipo(miStock.buscarUnIngrediente(nombre).getTipo());
					ingreAAgregar.setCantidad(cantidad);
					this.listaSanguche.add(ingreAAgregar);
					aumentarPrecio(buscarIngrediente(nombre).getPrecio(),cantidad);
				}
				else
				{
					buscarIngrediente(nombre).setCantidad(
							buscarIngrediente(nombre).getCantidad()+cantidad
							
							);
					aumentarPrecio(buscarIngrediente(nombre).getPrecio(),cantidad);
					
				}
		}
		
		
		
//		if(reultado<0)
//		{
//			throw new Exception("Error : no hay cantidad suficiente de stock lo sentimos");
//		}
//		
//		
//		if (cantidad>0)
//		{
//			
//			
//			
//		}
//		else
//		{
//			throw new Exception("Error : Por favor Ingrese una Cantidad mayor a 0");
//		}
//	}
}	
	

	public HashSet<Ingrediente> getListaSanguche() {
		return listaSanguche;
	}


	public void setListaSanguche(HashSet<Ingrediente> listaSanguche) {
		this.listaSanguche = listaSanguche;
	}


	public static Sanguche getInstance() {
		return instance;
	}


	public static void setInstance(Sanguche instance) {
		Sanguche.instance = instance;
	}

	public Integer getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Integer precioTotal) {
		this.precioTotal = precioTotal;
	}
	

	}	
