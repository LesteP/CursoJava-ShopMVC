package com.mio.tiendas.repositorios;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class Repositorio<T> extends HibernateDaoSupport implements IRepositorio<T>{
	
	/*' HibernateDaoSupport' Es una clase de SpringFrameWork
	 * - Esta clase enlaza Spring con hibernate y ya no hace falta crear la clase 'HibernatiUtil.java'*/
	
	Session sesion=null;
	@Override
	public List<T> get(Class<T> tipo) {
		
		
		if(sesion==null || !sesion.isOpen())
			sesion=getSessionFactory().getCurrentSession();//Con esto obtendremos la sesion actual
		
		Query q=sesion.createQuery("from "+tipo.getName());//con la dos lineas siguientes sacaremos la lista
		List<T> l=(List<T>)q.list();
				
		return l;
	}

	@Override
	public T get(Class<T> tipo, int id) {
		
		if(sesion==null || !sesion.isOpen())
			sesion=getSessionFactory().getCurrentSession();
		
		T obj=(T) sesion.get(tipo, id);//Aqui obtendremos un objeto porque le damos un operador con valor unico
				
		return obj;
	}/*Ya tenemos los dos 'Get' listos*/

	@Override
	public void add(T objeto) {
		
		if(sesion==null || !sesion.isOpen())
			sesion=getSessionFactory().getCurrentSession();
		
		sesion.save(objeto);
		//Con Spring no hace falta que pongamos transacciones porque el ya se encarga
	}

	@Override
	public void delete(T objeto) {
		
		if(sesion==null || !sesion.isOpen())
			sesion=getSessionFactory().getCurrentSession();
		
		sesion.delete(objeto);
		
	}

	@Override
	public void update(T objeto) {
		
		if(sesion==null || !sesion.isOpen())
			sesion=getSessionFactory().getCurrentSession();
				
		sesion.update(objeto);
		
	}

	@Override
	public List<T> find(String consulta, Map<String, Object> params) {
		
		if(sesion==null || !sesion.isOpen())
			sesion=getSessionFactory().getCurrentSession();
		
		Query q=sesion.getNamedQuery(consulta);
		for (String param : params.keySet()){
			q.setParameter(param, params.get(param));
		}
		List<T> l=q.list();//Ejecuta el resultado de la consulta
		return l;
	
	}
	/*Ya tenemos el Repositorio perfectamente adaptado para que sea utilizado por Spring*/

}
