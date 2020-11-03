/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "tb_pao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPao.findAll", query = "SELECT t FROM TbPao t"),
    @NamedQuery(name = "TbPao.findByIdPao", query = "SELECT t FROM TbPao t WHERE t.idPao = :idPao"),
    @NamedQuery(name = "TbPao.findByQuantidade", query = "SELECT t FROM TbPao t WHERE t.quantidade = :quantidade"),
    @NamedQuery(name = "TbPao.findByPreco", query = "SELECT t FROM TbPao t WHERE t.preco = :preco"),
    @NamedQuery(name = "TbPao.findByDescricao", query = "SELECT t FROM TbPao t WHERE t.descricao = :descricao")})
public class TbPao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pao")
    private Integer idPao;
    @Column(name = "quantidade")
    private Integer quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco")
    private BigDecimal preco;
    @Size(max = 100)
    @Column(name = "descricao")
    private String descricao;

    public TbPao() {
    }

    public TbPao(Integer idPao) {
        this.idPao = idPao;
    }

    public Integer getIdPao() {
        return idPao;
    }

    public void setIdPao(Integer idPao) {
        this.idPao = idPao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPao != null ? idPao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPao)) {
            return false;
        }
        TbPao other = (TbPao) object;
        if ((this.idPao == null && other.idPao != null) || (this.idPao != null && !this.idPao.equals(other.idPao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.TbPao[ idPao=" + idPao + " ]";
    }
    
}
