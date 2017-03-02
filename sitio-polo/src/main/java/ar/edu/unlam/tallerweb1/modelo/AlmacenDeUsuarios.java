package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlmacenDeUsuarios {
		
	HashSet<Usuario> listaDeUsuarios= new  HashSet<Usuario>();
	private static AlmacenDeUsuarios instance;
	
	
		public static AlmacenDeUsuarios getSingletonInstance() {
	        if (instance == null){
	            instance = new AlmacenDeUsuarios();
	            
	        }
	        
	        return instance;
	    }
		
		
		
	//--
		//buscar usuario en web
		public HashSet<Usuario> buscarUsuarioWeb(String mail) throws Exception
		{
			HashSet<Usuario> listaDeBuscados=new HashSet<Usuario>();
				for(Usuario each:listaDeUsuarios)
				{
					if(each.getMail().indexOf(mail)!=-1)
					{
						listaDeBuscados.add(each);
					}
					else
					{
						throw new Exception("El usuario que quieres buscar no existe");
					}
				}
			
			return listaDeBuscados;
		}
		//busca 2
		public Usuario buscarUsuario2(String mail) 
		{
			
			Usuario usu2= new Usuario();
			usu2.setMail(mail);
			if (listaDeUsuarios.contains(usu2))
			{
				for(Usuario each:listaDeUsuarios)
				{
					if(each.getMail().equals(usu2.getMail()))
					{
						return each;
					}
				}
			}
			return null;
		}
		//cambiar permiso
		public void cambiarPermisoDeUnUsuario(String mail,tipoUsuario tipo)
		{
			buscarUsuario(mail).setTipoUsuario(tipo);
		}
		//elimiinar
		public void EliminarUsuario(String mail)
		{
			listaDeUsuarios.remove(buscarUsuario(mail));
		}
		
		public Usuario login(String mail,String contrase�a) throws Exception
		{
			Usuario user= new Usuario();
			user.setMail(mail);
System.out.println("entro en login");
			if(listaDeUsuarios.contains(user))
			{
				for(Usuario each:listaDeUsuarios)
				{
					if(each.getMail().equals(user.getMail()))
					{
						if(each.getContrase�a().equals(contrase�a))
						{
System.out.println("retorno");
							return each;
						}
						else
						{
							throw new Exception("Error : contrase�a err�nea");
						}
					}
					
				}
			}
			else
			{
				throw new Exception("Error : mail incorrecto");
			}
			return null;
				
			
		}
		//buscar 
		public Usuario buscarUsuario (String mail)
		{
			Usuario UsuarioBusacado=new Usuario();
			UsuarioBusacado.setMail(mail);
			
			for(Usuario each:listaDeUsuarios)
			{
				if(each.getMail().equals(UsuarioBusacado.getMail()))
				{
					return each;
				}
			}
			return null;
		}

		
		//registro
		public void agregarUsuario(
				String nombre,
				String apellido,
				String mail,
				String contrase�a,
				String contrase�a2,
				Date fechaDeNacimiento,
				tipoUsuario tipo
				)
			 throws Exception
		{
			Usuario nuevoUser=new Usuario();
			nuevoUser.setNombre(nombre);
			nuevoUser.setApellido(apellido);
			nuevoUser.setContrase�a(contrase�a);
			nuevoUser.setContrase�a2(contrase�a2);
			nuevoUser.setMail(mail);
			nuevoUser.setFechaDeNacimiento(fechaDeNacimiento);
			nuevoUser.setTipoUsuario(tipo);
			//-- VALIDAR FECHA
			
//			Calendar fecha= Calendar.getInstance();
//			Integer a�o= fecha.get(Calendar.YEAR);
//			Integer mes= fecha.get(Calendar.MONTH);
//			Integer dia= fecha.get(Calendar.DAY_OF_MONTH);
//			fecha.add(Calendar.YEAR,-fechaDeNacimiento.getYear());
//			//
			if(nombre.length()==0||nombre==""||nombre.equals(""))
			{
				throw new  Exception("Error: El nombre est� vacio");
			}
			else if(apellido.length()==0||apellido==""||apellido.equals(""))
			{
				throw new  Exception("Error: El apellido est� vacio");
			}
			else if(mail.length()==0||mail==""||mail.equals(""))
			{
				throw new  Exception("Error: El mail est� vacio");
			}
			
			else if(contrase�a.length()==0||contrase�a==""||contrase�a.equals(""))
			{
				throw new  Exception("Error: La contrase�a no puede estar vacia");
			}
			else if(contrase�a.length()<3)
			{
				throw new  Exception("Error:La contrase�a debe tener mas de 3 car�cteres");
			}
			else if(!contrase�a.equals(contrase�a2))
			{
				throw new  Exception("Error:Las contrase�as no coinciden");

			}
////			else if(fechaDeNacimiento==null)
////			{
////				throw new  Exception("Error: La fecha de nacimiento no puede estar vacia");
////			}
////			else if(fecha.get(Calendar.DATE)-fechaDeNacimiento.getDate()<=0)
////			{
////				throw new  Exception("Error: Debes ser mayor de 18 a�os");
////
////			}
			else if(listaDeUsuarios.contains(nuevoUser))
			{
				throw new  Exception("Error: El mail que quieres utilizar ya esta en uso");

			}
			else
			{
				this.listaDeUsuarios.add(nuevoUser);
			}
			
		}
	//--
		
		
	public AlmacenDeUsuarios() {
		// TODO Auto-generated constructor stub
	}

	public HashSet<Usuario> getListaDeUsuarios() {
		return listaDeUsuarios;
	}

	public void setListaDeUsuarios(HashSet<Usuario> listaDeUsuarios) {
		this.listaDeUsuarios = listaDeUsuarios;
	}
	
	
}
