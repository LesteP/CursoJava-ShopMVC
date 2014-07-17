package com.mio.tiendas.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



import com.mio.tiendas.modelo.TiendaProducto;
import com.mio.tiendas.repositorios.RepositorioTiendaProducto;

@Controller
@RequestMapping(value="/producto"/*aqui va el nombre con el que pusimos la variable en el jsp*/)
public class TiendasRestController {

	@Autowired
	RepositorioTiendaProducto dao;
	
	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	public @ResponseBody TiendaProducto tiendaProducto(@PathVariable int id){
		
		TiendaProducto tp=dao.get(TiendaProducto.class, id);
		
		return tp;
	}
}
