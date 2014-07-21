package com.mio.tiendas.controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mio.tiendas.modelo.TiendaProducto;
import com.mio.tiendas.repositorios.RepositorioTiendaProducto;

@Controller
@RequestMapping(value="/producto"/*aqui va el nombre con el que pusimos la variable en el jsp*/)
public class TiendasRestController {

	@Autowired
	RepositorioTiendaProducto daoTiendaProducto;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public @ResponseBody TiendaProducto tiendaProducto(@PathVariable int id){
		
		TiendaProducto tp=daoTiendaProducto.get(TiendaProducto.class, id);
		
		return tp;
	}
	@RequestMapping(value="/buscar/{nombre}",method=RequestMethod.GET)
	public @ResponseBody List<TiendaProducto> buscar(@PathVariable String texto){
	
		if(texto.equals("NoBuscoNada"))
			texto="";
		
		Map<String, Object> params=new HashMap<String, Object>();
		
		params.put("texto", "%"+texto+"%");
		
		List<TiendaProducto> l=daoTiendaProducto.find("producto.buscador", params);
		return l;
			
	}
	@RequestMapping(method=RequestMethod.DELETE)
	public @ResponseBody String borrar(@RequestBody	TiendaProducto producto){
		
		daoTiendaProducto.delete(producto);
		
		return "borrado";
	}
}
