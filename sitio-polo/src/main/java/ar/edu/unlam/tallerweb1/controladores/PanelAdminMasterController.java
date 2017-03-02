package ar.edu.unlam.tallerweb1.controladores;

import java.sql.Date;
import java.util.HashSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.AlmacenDeUsuarios;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.tipoUsuario;

@Controller
public class PanelAdminMasterController {

		@RequestMapping("/panelDePermisosAdminMaster")
		public ModelAndView panelDePermisos()
		{
			ModelMap modeloAdminMaster=new ModelMap();
			modeloAdminMaster.put("usuario", new Usuario());
			AlmacenDeUsuarios almU=AlmacenDeUsuarios.getSingletonInstance();
			modeloAdminMaster.put("listaDeusuarios", almU.getListaDeUsuarios());
			return new ModelAndView("AdminMasterPanelDePermisos",modeloAdminMaster);
		}
		@RequestMapping("/eliminarTodosLosUsuarios")
		public ModelAndView eliminarTodosLosUsuarios()
		{
			ModelMap modeloAdminMaster=new ModelMap();
			modeloAdminMaster.put("usuario", new Usuario());
			AlmacenDeUsuarios almU=AlmacenDeUsuarios.getSingletonInstance();
			almU.getListaDeUsuarios().clear();
			modeloAdminMaster.put("listaDeusuarios", almU.getListaDeUsuarios());
			return new ModelAndView("AdminMasterPanelDePermisos",modeloAdminMaster);
		}
		
		
		@RequestMapping("/eliminarUsuario/{mail}")
		public ModelAndView eliminarUsuario(
				@PathVariable("mail") String mail
				)
		{
			AlmacenDeUsuarios almU= AlmacenDeUsuarios.getSingletonInstance();
			almU.EliminarUsuario(mail);
			ModelMap modeloAdminMaster=new ModelMap();
			modeloAdminMaster.put("usuario", new Usuario());
			modeloAdminMaster.put("listaDeusuarios", almU.getListaDeUsuarios());

			return new ModelAndView("AdminMasterPanelDePermisos",modeloAdminMaster);
		}
		
  		@RequestMapping("/modificarUsuario/{mail}")
		public ModelAndView modificarUsuario2(
				@PathVariable("mail") String mail
				) 
		{
			AlmacenDeUsuarios almU= AlmacenDeUsuarios.getSingletonInstance();
			
			ModelMap modeloAdminMaster=new ModelMap();
			modeloAdminMaster.put("usuario", new Usuario());
			
			modeloAdminMaster.put("usuarioAModificar", almU.buscarUsuario2(mail));
			
			modeloAdminMaster.put("listaDeusuarios", almU.getListaDeUsuarios());

			return new ModelAndView("modificaarUsuario",modeloAdminMaster);
				
				
			
		}
  		
  		@RequestMapping(value="modificarUsuario2",method=RequestMethod.POST)
  		public ModelAndView modificarUsuario2(
  				@RequestParam ("nombre") String nombre,
  				@RequestParam ("apellido")String apellido,
  				@RequestParam ("mail")String mail,
  				@RequestParam ("contraseña")String contraseña,
  				
  				@RequestParam ("fechaDeNacimiento")Date fechaDeNacimiento,
  				@RequestParam ("tipoUsuario")tipoUsuario tipo
  				)
  		{
			
  			AlmacenDeUsuarios almU= AlmacenDeUsuarios.getSingletonInstance();
  			almU.buscarUsuario2(mail).setNombre(nombre);
  			almU.buscarUsuario2(mail).setApellido(apellido);
  			almU.buscarUsuario2(mail).setContraseña(contraseña);
  			
  			almU.buscarUsuario2(mail).setTipoUsuario(tipo);
  			almU.buscarUsuario2(mail).setFechaDeNacimiento(fechaDeNacimiento);
  			ModelMap modeloAdminMaster=new ModelMap();
  			modeloAdminMaster.put("usuario", new Usuario());			
			modeloAdminMaster.put("listaDeusuarios", almU.getListaDeUsuarios());
			return new ModelAndView("AdminMasterPanelDePermisos",modeloAdminMaster);

  		}
  		
  		@RequestMapping (value="buscarUsuario",method=RequestMethod.POST)//ver el metodo buscar por web q no anda
  		public ModelAndView buscarUsuario(
  				@RequestParam("mail") String mail
  				)
  		{
  			ModelMap modeloAdminMaster=new ModelMap();
  			AlmacenDeUsuarios almU= AlmacenDeUsuarios.getSingletonInstance();
  			modeloAdminMaster.put("usuario", new Usuario());			
			try {
				modeloAdminMaster.put("listaDeUsuariosBuscados", almU.buscarUsuarioWeb(mail));
				modeloAdminMaster.put("exepcion", "");

			} catch (Exception e) {
				modeloAdminMaster.put("listaDeUsuariosBuscados", new HashSet<Usuario>());
				modeloAdminMaster.put("exepcion", e.getMessage());

			}
			
			return new ModelAndView("AdminMasterPanelDePermisos",modeloAdminMaster);
  		}
}
