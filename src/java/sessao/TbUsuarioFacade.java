/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessao;

import entidade.TbUsuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mathe
 */
@Stateless
public class TbUsuarioFacade extends AbstractFacade<TbUsuario> {

    @PersistenceContext(unitName = "RestauranteJavaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public Integer retornaId(String nome){       
        String id = em.createQuery("SELECT t FROM TbUsuario t WHERE t.usuario = '"+ nome+ "'").getSingleResult().toString();
        int id2 = Integer.valueOf(id);
        return id2;
    }
        public List getUsuario(String usuario, String senha){
          List usuarios = null;
       try{
          usuarios = em.createQuery("SELECT t FROM TbUsuario t WHERE t.usuario = '"+ usuario +"' AND t.senha = '"+ senha + "'").getResultList();
           return usuarios;
       }catch(NoResultException E){
          return null; 
       }
    }

    public TbUsuarioFacade() {
        super(TbUsuario.class);
    }
    
}
