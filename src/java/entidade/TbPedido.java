/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mathe
 */
@Entity
@Table(name = "tb_pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPedido.findAll", query = "SELECT t FROM TbPedido t"),
    @NamedQuery(name = "TbPedido.findByIdPedido", query = "SELECT t FROM TbPedido t WHERE t.idPedido = :idPedido"),
    @NamedQuery(name = "TbPedido.findByIdComprador", query = "SELECT t FROM TbPedido t WHERE t.idComprador = :idComprador"),
    @NamedQuery(name = "TbPedido.findByDescricao", query = "SELECT t FROM TbPedido t WHERE t.descricao = :descricao"),
    @NamedQuery(name = "TbPedido.findByPreco", query = "SELECT t FROM TbPedido t WHERE t.preco = :preco"),
    @NamedQuery(name = "TbPedido.findByHorario", query = "SELECT t FROM TbPedido t WHERE t.horario = :horario"),
    @NamedQuery(name = "TbPedido.findByPao", query = "SELECT t FROM TbPedido t WHERE t.pao = :pao"),
    @NamedQuery(name = "TbPedido.findByCarne", query = "SELECT t FROM TbPedido t WHERE t.carne = :carne"),
    @NamedQuery(name = "TbPedido.findByMolho", query = "SELECT t FROM TbPedido t WHERE t.molho = :molho"),
    @NamedQuery(name = "TbPedido.findBySalada", query = "SELECT t FROM TbPedido t WHERE t.salada = :salada"),
    @NamedQuery(name = "TbPedido.findByNCartao", query = "SELECT t FROM TbPedido t WHERE t.nCartao = :nCartao"),
    @NamedQuery(name = "TbPedido.findByDataCartao", query = "SELECT t FROM TbPedido t WHERE t.dataCartao = :dataCartao"),
    @NamedQuery(name = "TbPedido.findByCcv", query = "SELECT t FROM TbPedido t WHERE t.ccv = :ccv")})
public class TbPedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pedido")
    private Integer idPedido;
    @Column(name = "id_comprador")
    private Integer idComprador;
    @Size(max = 100)
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco")
    private BigDecimal preco;
    @Column(name = "horario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horario;
    @Column(name = "pao")
    private Integer pao;
    @Column(name = "carne")
    private Integer carne;
    @Column(name = "molho")
    private Integer molho;
    @Column(name = "salada")
    private Integer salada;
    @Column(name = "n_cartao")
    private Integer nCartao;
    @Size(max = 2147483647)
    @Column(name = "data_cartao")
    private String dataCartao;
    @Column(name = "ccv")
    private Integer ccv;

    public TbPedido() {
    }

    public TbPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(Integer idComprador) {
        this.idComprador = idComprador;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public Integer getPao() {
        return pao;
    }

    public void setPao(Integer pao) {
        this.pao = pao;
    }

    public Integer getCarne() {
        return carne;
    }

    public void setCarne(Integer carne) {
        this.carne = carne;
    }

    public Integer getMolho() {
        return molho;
    }

    public void setMolho(Integer molho) {
        this.molho = molho;
    }

    public Integer getSalada() {
        return salada;
    }

    public void setSalada(Integer salada) {
        this.salada = salada;
    }

    public Integer getNCartao() {
        return nCartao;
    }

    public void setNCartao(Integer nCartao) {
        this.nCartao = nCartao;
    }

    public String getDataCartao() {
        return dataCartao;
    }

    public void setDataCartao(String dataCartao) {
        this.dataCartao = dataCartao;
    }

    public Integer getCcv() {
        return ccv;
    }

    public void setCcv(Integer ccv) {
        this.ccv = ccv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPedido)) {
            return false;
        }
        TbPedido other = (TbPedido) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.TbPedido[ idPedido=" + idPedido + " ]";
    }
    
}
