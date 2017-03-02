package ar.edu.unlam.tallerweb1.modelo;

public class Pedido implements Comparable<Pedido>{
	
	private Integer numeroDePedido = 0;
	private Sanguche sanguche = new Sanguche();
	private Direccion direccion;
	
	public Pedido()
	{
		numeroDePedido++;
	
		Sanguche s2=sanguche.getSingletonInstance();
		for(Ingrediente each:s2.getListaSanguche())
		{
			sanguche.getListaSanguche().add(each);
		}
		sanguche.setPrecioTotal(s2.getPrecioTotal());
	
	}
	
	public Integer getNumeroDePedido() {
		return numeroDePedido;
	}
	public void setNumeroDePedido(Integer numeroDePedido) {
		this.numeroDePedido = numeroDePedido;
	}
	public Sanguche getSanguche() {
		return sanguche;
	}
	public void setSanguche(Sanguche sanguche) {
		this.sanguche = sanguche;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroDePedido == null) ? 0 : numeroDePedido.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (numeroDePedido == null) {
			if (other.numeroDePedido != null)
				return false;
		} else if (!numeroDePedido.equals(other.numeroDePedido))
			return false;
		return true;
	}

	@Override
	public int compareTo(Pedido pedido) {
		return pedido.numeroDePedido.compareTo(numeroDePedido);
	}
	
	
}
