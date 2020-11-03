/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entidade.TbPedido;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import sessao.TbPedidoFacade;

/**
 *
 * @author User
 */
@Named(value = "pedidoManagedBean")
@ManagedBean
@SessionScoped
public class PedidoManagedBean {

    
    @EJB
    private TbPedidoFacade pedidoFacade;
    public TbPedido tbpedido;
    
    private ListDataModel pedidos;
    
    public ListDataModel getPedidos(){
        return pedidos;
    }
    
    public void setPedidos(ListDataModel pedidos){
        this.pedidos = pedidos;
    }
    
    public void recuperarPedidos(){
        this.pedidos = new ListDataModel(pedidoFacade.findAll());
    }

    public TbPedido getPedidotb(){
        if(tbpedido == null){
            tbpedido = new TbPedido();
        }
        return tbpedido;
    }
    
    public void setPedidotb(TbPedido pedido){
        this.tbpedido = pedido;
    }
    public String Salvar(){
       java.util.Date data = new java.util.Date();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(data.getTime()); 
        this.tbpedido.setDescricao("Pao: "+this.tbpedido.getPao()+" Carne: "+this.tbpedido.getCarne()+" Salada: "+this.tbpedido.getSalada()+" Molho: "+this.tbpedido.getMolho());
        this.tbpedido.setHorario(timestamp);
        this.pedidoFacade.salvar(tbpedido);
        return "/finalizapedido.html";
    }
    
    public PedidoManagedBean() {
    }
    
}