package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Date;

public class Usuario implements Comparable<Usuario>{
	
	private String nombre;
	private String apellido;
	private String contraseña;
	private String contraseña2;
	private String mail;
	private Date fechaDeNacimiento;
	private tipoUsuario tipoUsuario;
	
	public Usuario()
	{
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
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
		Usuario other = (Usuario) obj;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		return true;
	}

	@Override
	public int compareTo(Usuario user) {
		
		return user.mail.compareTo(mail);
	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getContraseña2() {
		return contraseña2;
	}

	public void setContraseña2(String contraseña2) {
		this.contraseña2 = contraseña2;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public tipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(tipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	
	
	
	
	
	
	
	
}
