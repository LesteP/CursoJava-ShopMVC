package com.mio.tiendas.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;




import com.mio.tiendas.modelo.TiendaCategoria;
import com.mio.tiendas.modelo.TiendaProducto;
import com.mio.tiendas.repositorios.RepositorioTiendaCategoria;
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
}