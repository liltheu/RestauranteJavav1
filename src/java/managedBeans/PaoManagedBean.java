/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entidade.TbPao;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import sessao.TbPaoFacade;

/**
 *
 * @author User
 */
@Named(value = "paoManagedBean")
@ManagedBean
@SessionScoped
public class PaoManagedBean {

    
    @EJB
    private TbPaoFacade paoFacade;
    public TbPao tbpao;
    
    private ListDataModel paos;
    
    public ListDataModel getPaos(){
        return paos;
    }
    
    public void setPaos(ListDataModel paos){
        this.paos = paos;
    }
    
    public void recuperarPaos(){
        this.paos = new ListDataModel(paoFacade.findAll());
    }

    public TbPao getPaotb(){
        if(tbpao == null){
            tbpao = new TbPao();
        }
        return tbpao;
    }
    
    public void setPaotb(TbPao pao){
        this.tbpao = pao;
    }
    
    public void Salvar(){
        this.paoFacade.salvar(tbpao);
    }
    
    
    public PaoManagedBean() {
    }
    
}
