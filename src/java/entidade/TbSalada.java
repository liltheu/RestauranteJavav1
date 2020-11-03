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
@Table(name = "tb_salada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbSalada.findAll", query = "SELECT t FROM TbSalada t"),
    @NamedQuery(name = "TbSalada.findByIdSalada", query = "SELECT t FROM TbSalada t WHERE t.idSalada = :idSalada"),
    @NamedQuery(name = "TbSalada.findByQuantidade", query = "SELECT t FROM TbSalada t WHERE t.quantidade = :quantidade"),
    @NamedQuery(name = "TbSalada.findByPreco", query = "SELECT t FROM TbSalada t WHERE t.preco = :preco"),
    @NamedQuery(name = "TbSalada.findByDescricao", query = "SELECT t FROM TbSalada t WHERE t.descricao = :descricao")})
public class TbSalada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_salada")
    private Integer idSalada;
    @Column(name = "quantidade")
    private Integer quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco")
    private BigDecimal preco;
    @Size(max = 100)
    @Column(name = "descricao")
    private String descricao;

    public TbSalada() {
    }

    public TbSalada(Integer idSalada) {
        this.idSalada = idSalada;
    }

    public Integer getIdSalada() {
        return idSalada;
    }

    public void setIdSalada(Integer idSalada) {
        this.idSalada = idSalada;
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
        hash += (idSalada != null ? idSalada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbSalada)) {
            return false;
        }
        TbSalada other = (TbSalada) object;
        if ((this.idSalada == null && other.idSalada != null) || (this.idSalada != null && !this.idSalada.equals(other.idSalada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.TbSalada[ idSalada=" + idSalada + " ]";
    }
    
}
