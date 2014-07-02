package org.thwick.moneytracker.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDAO<T> {

	@PersistenceContext
    protected EntityManager em;
	
	protected Class<T> type;

    public AbstractDAO() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }
    
    public T create(T t) {
        em.persist(t);
        
        em.flush();
        return t;
    }

    public void delete(final Object id) {
        this.em.remove(this.em.getReference(type, id));
    }

    public void delete(final List<Object> ids) {

    	for (Object id : ids) {
    		em.remove(this.em.getReference(type, id));
    	}
    }
    
    public T find(final Object id) {
        return this.em.find(type, id);
    }
    
    @SuppressWarnings("unchecked")
	public List< T > findAll(){
        return em.createQuery( "from " + type.getName()).getResultList();
     }
    
    public T update(final T t) {
        return this.em.merge(t);    
    }
    
    
}
