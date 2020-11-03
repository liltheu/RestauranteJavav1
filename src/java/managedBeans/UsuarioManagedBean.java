/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entidade.TbCarne;
import entidade.TbMolho;
import entidade.TbPao;
import entidade.TbUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import sessao.TbCarneFacade;
import sessao.TbMolhoFacade;
import sessao.TbPaoFacade;
import sessao.TbUsuarioFacade;

/**
 *
 * @author mathe
 */
@Named(value = "usuarioManagedBean")
@ManagedBean
@SessionScoped
public class UsuarioManagedBean {

    
    @EJB
    private TbUsuarioFacade usuarioFacade;
    public TbUsuario tbusuario;
    
    private ListDataModel usuarios;
    
    public ListDataModel getUsuarios(){
        return usuarios;
    }
    
    public void setUsuarios(ListDataModel usuarios){
        this.usuarios = usuarios;
    }
    
    public void recuperarUsuarios(){
        this.usuarios = new ListDataModel(usuarioFacade.findAll());
    }

    public TbUsuario getUsuariotb(){
        if(tbusuario == null){
            tbusuario = new TbUsuario();
        }
        return tbusuario;
    }
    
    public void setUsuariotb(TbUsuario usuario){
        this.tbusuario = usuario;
    }
    public Integer pegaId(String nome){
        TbUsuarioFacade id = new TbUsuarioFacade();
        int id2 = id.retornaId(nome);
        return id2;
    }

    public void Salvar(){
        this.tbusuario.setAdm(false);
        this.usuarioFacade.salvar(tbusuario);
    }
    public List<TbUsuario> ListaUsuario(){
        List<TbUsuario> usuarios = new ArrayList<TbUsuario>();
        usuarios = this.usuarioFacade.findAll();
        return usuarios;
    }
    public String Login(){
     List  usuarios = this.usuarioFacade.getUsuario(this.tbusuario.getUsuario(),this.tbusuario.getSenha());
       
       if(usuarios.isEmpty()){
           FacesContext.getCurrentInstance().addMessage("loginmessage", new FacesMessage(FacesMessage.SEVERITY_INFO,"Login incorreto ou Inexistente","teste."));
           return null;
       }else{
     return "/homePage.xhtml";
       }
    }

  
   
    
    public UsuarioManagedBean() {
    }
    
}
