/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entidade.TbCarne;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;
import sessao.TbCarneFacade;

/**
 *
 * @author User
 */
@Named(value = "carneManagedBean")
@ManagedBean
@SessionScoped
public class CarneManagedBean {

    
    @EJB
    private TbCarneFacade carneFacade;
    public TbCarne tbcarne;
    
    private ListDataModel carnes;
    
    public ListDataModel getCarnes(){
        return carnes;
    }
    
    public void setCarnes(ListDataModel carnes){
        this.carnes = carnes;
    }
    
    public void recuperarCarnes(){
        this.carnes = new ListDataModel(carneFacade.findAll());
    }

    public TbCarne getCarnetb(){
        if(tbcarne == null){
            tbcarne = new TbCarne();
        }
        return tbcarne;
    }
    
    public void setCarnetb(TbCarne carne){
        this.tbcarne = carne;
    }
    
    public void Salvar(){
        this.carneFacade.salvar(tbcarne);
    }
    
    public CarneManagedBean() {
    }
    public List<TbCarne> Listacarneid(){
        List<TbCarne> Carnes = new ArrayList<TbCarne>();
        Carnes = this.carneFacade.findAll();
        return Carnes;
    }
    
    
}
