package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.HistorialDeVentas;
import ar.edu.unlam.tallerweb1.modelo.Pedido;

@Controller
public class HistorialDeVentasController {
		
	@RequestMapping("/historialDeVentas")
	public ModelAndView listaDeVentas()
	{
		
		ModelMap historialModelo= new ModelMap();
		HistorialDeVentas miHistorial=HistorialDeVentas.getSingletonInstance();
		for(Pedido each:miHistorial.getListaDeVentas())
		{
			System.out.println(each.getNumeroDePedido());
		}
		historialModelo.put("listaDeVentas", miHistorial.getListaDeVentas());
		return new ModelAndView("historialDeVentas",historialModelo);
	}
}
