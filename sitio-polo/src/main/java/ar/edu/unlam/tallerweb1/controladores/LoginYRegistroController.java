package ar.edu.unlam.tallerweb1.controladores;

import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.AlmacenDeUsuarios;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Sanguche;
import ar.edu.unlam.tallerweb1.modelo.Stock;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.tipoUsuario;

@Controller
public class LoginYRegistroController {
	
	@RequestMapping("/home2" )
	public void agregaUsuario3()
	{
		ModelMap modeloRegiistro= new ModelMap();
		modeloRegiistro.put("usuario", new Usuario());
		modeloRegiistro.put("exepcion", "");
		modeloRegiistro.put("RegistroSatisfactorio", "Registro completado correctamente");
		new ModelAndView("home",modeloRegiistro);
	}
	
	@RequestMapping(value="/crearUsuario", method=RequestMethod.POST)
	public ModelAndView agregaUsuario(
			@RequestParam ("nombre") String nombre,
			@RequestParam ("apellido")String apellido,
			@RequestParam ("mail")String mail,
			@RequestParam ("contraseña")String contraseña,
			@RequestParam ("contraseña2")String contraseña2,
			@RequestParam ("fechaDeNacimiento")Date fechaDeNacimiento,
			@RequestParam ("tipoUsuario")tipoUsuario tipo
			)
	{
		ModelMap modeloRegiistro= new ModelMap();
		modeloRegiistro.put("usuario",new Usuario());
		AlmacenDeUsuarios almUser=AlmacenDeUsuarios.getSingletonInstance();
		try {
			almUser.agregarUsuario(nombre, apellido, mail, contraseña, contraseña2, fechaDeNacimiento, tipo);
			
			modeloRegiistro.put("exepcion", "");
			modeloRegiistro.put("exepcionLogin", "");
			modeloRegiistro.put("RegistroSatisfactorio", "Registro completado correctamente");
			new ModelAndView("home",modeloRegiistro);
		} catch (Exception e) {
			
			modeloRegiistro.put("usuario",new Usuario());
			modeloRegiistro.put("exepcion", e.getMessage());
			modeloRegiistro.put("exepcionLogin", "");
			modeloRegiistro.put("RegistroSatisfactorio", "");
			new ModelAndView("home",modeloRegiistro);
		}
		
		return new ModelAndView("home",modeloRegiistro);
		
	}
	
	//para tener disponible direccion
	@ModelAttribute("direccion")
	public Direccion createModelDireccion() {
	    return new Direccion();
	}
	
	@RequestMapping(value="/login" ,method=RequestMethod.POST)
	public ModelAndView login(
			@RequestParam ("mail") String mail,
			@RequestParam ("contraseña") String contraseña
			)
	{
		ModelMap modeloLogin= new ModelMap();
		modeloLogin.put("usuario",new Usuario());
		modeloLogin.put("exepcion","");
		modeloLogin.put("RegistroSatisfactorio", "");
		
	
		AlmacenDeUsuarios alm= AlmacenDeUsuarios.getSingletonInstance();
		try {
			Usuario user = alm.login(mail, contraseña);
			if(user.getTipoUsuario().equals(tipoUsuario.CLIENTE))
			{
				
				Stock miStock=Stock.getSingletonInstance();
				Sanguche miSanguche=Sanguche.getSingletonInstance();
				modeloLogin.put("listaDeIngredientesStock",miStock.mostrarIngredientesQueTenganStockMayorA0());
				modeloLogin.put("listaDeIngredientesSanguche", miSanguche.getListaSanguche());
				modeloLogin.put("ingrediente", new Ingrediente());
				modeloLogin.put("precioTotal", miSanguche.getPrecioTotal());
				modeloLogin.put("direccion", new Direccion());
				return new ModelAndView("armarSanguche",		modeloLogin);
			}
			else if(user.getTipoUsuario().equals(tipoUsuario.STOCKADMIN))
			{
				ModelMap abmIngredienteModelo=new ModelMap();
				abmIngredienteModelo.put("ingrediente",new Ingrediente());
				Stock miStock= Stock.getSingletonInstance();
				abmIngredienteModelo.put("listaDeIngredientesStock",miStock.getListaDeIngredientesEnStock() );
				
				return new ModelAndView("agregarIngrediente",abmIngredienteModelo);
			}
			else
			{
				modeloLogin.put("direccion", new Direccion());
		
				modeloLogin.put("usuario", new Usuario());
				AlmacenDeUsuarios almU=AlmacenDeUsuarios.getSingletonInstance();
				modeloLogin.put("listaDeusuarios", almU.getListaDeUsuarios());
				return new ModelAndView("AdminMasterPanelDePermisos",modeloLogin);
			}
		} catch (Exception e) {
			modeloLogin.put("usuario",new Usuario());
			modeloLogin.put("direccion", new Direccion());
			modeloLogin.put("exepcionLogin", e.getMessage());
			
			new ModelAndView("home",modeloLogin);
		}
		return new ModelAndView("home",modeloLogin);
		
	}


	
}

