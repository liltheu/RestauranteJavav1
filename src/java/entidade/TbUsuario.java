/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mathe
 */
@Entity
@Table(name = "tb_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbUsuario.findAll", query = "SELECT t FROM TbUsuario t"),
    @NamedQuery(name = "TbUsuario.findById", query = "SELECT t FROM TbUsuario t WHERE t.id = :id"),
    @NamedQuery(name = "TbUsuario.findByUsuario", query = "SELECT t FROM TbUsuario t WHERE t.usuario = :usuario"),
    @NamedQuery(name = "TbUsuario.findBySenha", query = "SELECT t FROM TbUsuario t WHERE t.senha = :senha"),
    @NamedQuery(name = "TbUsuario.findByNome", query = "SELECT t FROM TbUsuario t WHERE t.nome = :nome"),
    @NamedQuery(name = "TbUsuario.findByCpf", query = "SELECT t FROM TbUsuario t WHERE t.cpf = :cpf"),
    @NamedQuery(name = "TbUsuario.findByCep", query = "SELECT t FROM TbUsuario t WHERE t.cep = :cep"),
    @NamedQuery(name = "TbUsuario.findByAdm", query = "SELECT t FROM TbUsuario t WHERE t.adm = :adm")})
public class TbUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 32)
    @Column(name = "usuario")
    private String usuario;
    @Size(max = 32)
    @Column(name = "senha")
    private String senha;
    @Size(max = 60)
    @Column(name = "nome")
    private String nome;
    @Size(max = 60)
    @Column(name = "cpf")
    private String cpf;
    @Size(max = 60)
    @Column(name = "cep")
    private String cep;
    @Column(name = "adm")
    private Boolean adm;

    public TbUsuario() {
    }

    public TbUsuario(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Boolean getAdm() {
        return adm;
    }

    public void setAdm(Boolean adm) {
        this.adm = adm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbUsuario)) {
            return false;
        }
        TbUsuario other = (TbUsuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.TbUsuario[ id=" + id + " ]";
    }
    
}
