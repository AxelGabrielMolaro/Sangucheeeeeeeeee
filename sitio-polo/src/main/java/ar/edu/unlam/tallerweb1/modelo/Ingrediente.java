package ar.edu.unlam.tallerweb1.modelo;

public class Ingrediente implements Comparable<Ingrediente> {
	
	private String nombre;
	
	private TipoIngrediente tipo;
	private Integer cantidad=0;
	private Integer precio;
	
	
	
	
	//constructor
	public Ingrediente()
	{
		
		
	}

	//funcion cantidad
	public void aumentarStock(Integer cantidad2)
	{
		this.cantidad= this.cantidad+cantidad2;
	}
	
	public void disminuirStock(Integer cantidad2)
	{
		this.cantidad= this.cantidad-cantidad2;
	}
	public void resetearStock()
	{
		this.cantidad=0;
	}
	
	
	///
	
	
	
	public void cambiarNombre(String nuevoNombre)
	{
		this.nombre=nuevoNombre;
	}
	
	public void cambiarTipoDeIngrediente(TipoIngrediente nuevoTipo)
	{
		this.tipo=nuevoTipo;
	}
	
	
	//-----------
	
	
	
	
	
	
	//geters and setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoIngrediente getTipo() {
		return tipo;
	}

	public void setTipo(TipoIngrediente tipo) {
		this.tipo = tipo;
	}

	
	// equals

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingrediente other = (Ingrediente) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public int compareTo(Ingrediente ingrediente) {
		return ingrediente.nombre.compareTo(nombre);
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	
	
	
	
	
}
