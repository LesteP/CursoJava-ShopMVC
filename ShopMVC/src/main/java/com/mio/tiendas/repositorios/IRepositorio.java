/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package com.mio.tiendas.repositorios;
 
import java.util.List;
import java.util.Map;

/**
 * Este tipo de repositorio valdra para toda aplicacion web siempre y cuando utilizemos 'Spring'
 * 
 * @author YO
 */
public interface IRepositorio<T> {
    
    public List<T> get(Class<T> tipo);
    public T get(Class<T> tipo,int id);
    public void add(T objeto);
    public void delete(T objeto);
    public void update(T objeto);
    public List<T> find(String consulta,Map<String,Object> params);
    
}