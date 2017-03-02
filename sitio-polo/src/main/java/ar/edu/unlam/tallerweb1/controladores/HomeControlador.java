package ar.edu.unlam.tallerweb1.controladores;

import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.AlmacenDeUsuarios;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Stock;
import ar.edu.unlam.tallerweb1.modelo.TipoIngrediente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.tipoUsuario;

@Controller
public class HomeControlador {
	
	@RequestMapping("/home")
	public ModelAndView mostrarHome() 
	{
		ModelMap modeloHome= new ModelMap();
		modeloHome.put("usuario",new Usuario());	
		
		AlmacenDeUsuarios alm= AlmacenDeUsuarios.getSingletonInstance();
		try {
			alm.agregarUsuario("axel", "molaro", "adminmaster", "adminmaster", "adminmaster", new Date(2001-02-01) , tipoUsuario.ADMINMASTER);
			alm.agregarUsuario("carcaman", "carcaman", "stockadmin", "stockadmin", "stockadmin", new Date(2001-02-01) , tipoUsuario.STOCKADMIN);
			alm.agregarUsuario("carqui", "carqui", "cliente", "cliente", "cliente", new Date(2001-02-01) , tipoUsuario.CLIENTE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("home",modeloHome);
	}
	
}