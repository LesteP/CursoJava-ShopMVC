package com.mio.tiendas.controladores.viewforms;


import com.mio.tiendas.modelo.TiendaCategoria;
import com.mio.tiendas.modelo.TiendaProducto;

public class TiendaProductoViewForm {
	
	private Integer idProducto;
	private String nombre;
	private String descripcion;
	private int existencias;
	private double precio;
	private Integer idCategoria;
	
	public TiendaProductoViewForm() {
		
	}

	public TiendaProductoViewForm(Integer idProducto, String nombre,
			String descripcion, int existencias, double precio,
			Integer idCategoria) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.existencias = existencias;
		this.precio = precio;
		this.idCategoria = idCategoria;
	}
	
	public TiendaProducto getTiendaProducto(){
		TiendaProducto tipro=new TiendaProducto();
		tipro.setIdProducto(idProducto);
		tipro.setNombre(nombre);
		tipro.setDescripcion(descripcion);
		tipro.setExistencias(existencias);
		tipro.setPrecio(precio);
		//Departamento d=new Departamento();
		//d.setIdDepartamento(idDepartamento);
		//emple.setDepartamento(d);
		TiendaCategoria tc=new TiendaCategoria();
		tc.setIdCategoria(idCategoria);
		tipro.setTiendaCategoria(tc);
		
		return tipro;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getExistencias() {
		return existencias;
	}

	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	
	
	

}
