/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entidade.TbMolho;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import sessao.TbMolhoFacade;

/**
 *
 * @author User
 */
@Named(value = "molhoManagedBean")
@ManagedBean
@SessionScoped
public class MolhoManagedBean {

    
    @EJB
    private TbMolhoFacade molhoFacade;
    public TbMolho tbmolho;
    
    private ListDataModel molhos;
    
    public ListDataModel getMolhos(){
        return molhos;
    }
    
    public void setMolhos(ListDataModel molhos){
        this.molhos = molhos;
    }
    
    public void recuperarMolhos(){
        this.molhos = new ListDataModel(molhoFacade.findAll());
    }

    public TbMolho getMolhotb(){
        if(tbmolho == null){
            tbmolho = new TbMolho();
        }
        return tbmolho;
    }
    
    public void setMolhotb(TbMolho molho){
        this.tbmolho = molho;
    }
    
    public void Salvar(){
        this.molhoFacade.salvar(tbmolho);
    }
    
    public MolhoManagedBean() {
    }
    
}
