package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;

public class HistorialDeVentas {
	
	private ArrayList<Pedido> listaDeVentas=new ArrayList<Pedido>();
	private static HistorialDeVentas instance;
	Integer cantidadDeVentas=0;
	
	public Pedido buscarUnPedido(Integer numeroPedido)
	{
		for(Pedido each :listaDeVentas)
		{
			if(each.getNumeroDePedido().equals(numeroPedido))
			{
				return each;
			}
			
		}
		return null;
	}
	//agregar Un Pedido
	public void agregarVentaAlHistorial(Pedido pedido)
	{
		listaDeVentas.add(pedido);
		cantidadDeVentas++;
		Sanguche s1= Sanguche.getSingletonInstance();
		s1.vaciarSanguche();
	}
	//constructor single
		public static HistorialDeVentas getSingletonInstance() {
	        if (instance == null){
	            instance = new HistorialDeVentas();
	            
	        }
	        
	        return instance;
	    }

		public ArrayList<Pedido> getListaDeVentas() {
			return listaDeVentas;
		}

		public void setListaDeVentas(ArrayList<Pedido> listaDeVentas) {
			this.listaDeVentas = listaDeVentas;
		}

		public static HistorialDeVentas getInstance() {
			return instance;
		}

		public static void setInstance(HistorialDeVentas instance) {
			HistorialDeVentas.instance = instance;
		}
		
	
	
}
