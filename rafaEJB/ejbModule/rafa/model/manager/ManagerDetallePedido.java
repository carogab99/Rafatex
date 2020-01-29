package rafa.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import rafa.model.entities.DetallePedido;


/**
 * Session Bean implementation class ManagerDetallePedido
 */
@Stateless
@LocalBean
public class ManagerDetallePedido {

	@PersistenceContext 
    EntityManager em;
    /**
     * Default constructor. 
     */
    public ManagerDetallePedido() {
        // TODO Auto-generated constructor stub
    }

    public List<DetallePedido> FindAllDetalleP()
    {
    	String consulta = "SELECT d FROM DetallePedido d";
    	Query q = em.createQuery(consulta, DetallePedido.class);
    	return q.getResultList();
    }
}
