package com.mio.tiendas.modelo;
// Generated 15-jul-2014 18:39:44 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TiendaCategoria generated by hbm2java
 */
@Entity
@Table(name="tienda_categoria"
    ,catalog="teide2014"
)
public class TiendaCategoria  implements java.io.Serializable {


     private Integer idCategoria;
     private String nombre;
     private String icono;
     private String descripcion;
     private Set<TiendaProducto> tiendaProductos = new HashSet<TiendaProducto>(0);

    public TiendaCategoria() {
    }

	
    public TiendaCategoria(String nombre) {
        this.nombre = nombre;
    }
    public TiendaCategoria(String nombre, String icono, String descripcion, Set<TiendaProducto> tiendaProductos) {
       this.nombre = nombre;
       this.icono = icono;
       this.descripcion = descripcion;
       this.tiendaProductos = tiendaProductos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idCategoria", unique=true, nullable=false)
    public Integer getIdCategoria() {
        return this.idCategoria;
    }
    
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    
    @Column(name="nombre", nullable=false, length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="icono", length=450)
    public String getIcono() {
        return this.icono;
    }
    
    public void setIcono(String icono) {
        this.icono = icono;
    }

    
    @Column(name="descripcion", length=65535)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tiendaCategoria")
    public Set<TiendaProducto> getTiendaProductos() {
        return this.tiendaProductos;
    }
    
    public void setTiendaProductos(Set<TiendaProducto> tiendaProductos) {
        this.tiendaProductos = tiendaProductos;
    }




}


