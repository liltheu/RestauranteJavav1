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
@Table(name = "tb_molho")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbMolho.findAll", query = "SELECT t FROM TbMolho t"),
    @NamedQuery(name = "TbMolho.findByIdMolho", query = "SELECT t FROM TbMolho t WHERE t.idMolho = :idMolho"),
    @NamedQuery(name = "TbMolho.findByQuantidade", query = "SELECT t FROM TbMolho t WHERE t.quantidade = :quantidade"),
    @NamedQuery(name = "TbMolho.findByPreco", query = "SELECT t FROM TbMolho t WHERE t.preco = :preco"),
    @NamedQuery(name = "TbMolho.findByDescricao", query = "SELECT t FROM TbMolho t WHERE t.descricao = :descricao")})
public class TbMolho implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_molho")
    private Integer idMolho;
    @Column(name = "quantidade")
    private Integer quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco")
    private BigDecimal preco;
    @Size(max = 100)
    @Column(name = "descricao")
    private String descricao;

    public TbMolho() {
    }

    public TbMolho(Integer idMolho) {
        this.idMolho = idMolho;
    }

    public Integer getIdMolho() {
        return idMolho;
    }

    public void setIdMolho(Integer idMolho) {
        this.idMolho = idMolho;
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
        hash += (idMolho != null ? idMolho.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbMolho)) {
            return false;
        }
        TbMolho other = (TbMolho) object;
        if ((this.idMolho == null && other.idMolho != null) || (this.idMolho != null && !this.idMolho.equals(other.idMolho))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.TbMolho[ idMolho=" + idMolho + " ]";
    }
    
}
