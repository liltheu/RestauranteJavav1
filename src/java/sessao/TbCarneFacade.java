/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessao;

import entidade.TbCarne;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mathe
 */
@Stateless
public class TbCarneFacade extends AbstractFacade<TbCarne> {

    @PersistenceContext(unitName = "RestauranteJavaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbCarneFacade() {
        super(TbCarne.class);
    }
    
}
