package com.mio.tiendas.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import com.mio.tiendas.modelo.TiendaProducto;
import com.mio.tiendas.repositorios.RepositorioTiendaProducto;

@Controller
public class TiendasController {
	@Autowired/*Conectar automaticamente con el 'root.context.xml*/
	RepositorioTiendaProducto daoTiendaProducto;
	//RepositorioTiendaCategoria daoTiendaCategoria;
	
	
	@RequestMapping(value="/listado.html")
	public String listado(Model modelo){
		
		List<TiendaProducto> ltp=daoTiendaProducto.get(TiendaProducto.class);
		modelo.addAttribute("tiendas", ltp);
		//List<TiendaCategoria> ltc=daoTiendaCategoria.get(TiendaCategoria.class);
		//modelo.addAttribute("tiendas", ltc);
		
		return "listado"/*Siempre son archivos .jsp*/;
	}
	@RequestMapping(value="detalle.html",method=RequestMethod.GET)
	public String detalle(Model modelo,HttpServletRequest request){
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		TiendaProducto e=daoTiendaProducto.get(TiendaProducto.class, id);
		
		
		
		modelo.addAttribute("producto", e);
		
		return "detalle";
	}
	
}