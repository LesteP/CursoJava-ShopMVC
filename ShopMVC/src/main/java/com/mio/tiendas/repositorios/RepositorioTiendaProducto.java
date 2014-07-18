package com.mio.tiendas.repositorios;

import org.hibernate.Hibernate;

import com.mio.tiendas.modelo.TiendaProducto;

public class RepositorioTiendaProducto extends Repositorio<TiendaProducto> {
	
	@Override
	public TiendaProducto get(Class<TiendaProducto> tipo, int id){
		
		TiendaProducto tp= super.get(tipo, id);

		Hibernate.initialize(tp.getNombre());
		Hibernate.initialize(tp.getDescripcion());
		Hibernate.initialize(tp.getExistencias());
		Hibernate.initialize(tp.getPrecio());
		
		return tp;
	}

}
