/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juandiego
 */
@Entity
@Table(name = "investigador_trabajo_investigacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvestigadorTrabajoInvestigacion.findAll", query = "SELECT i FROM InvestigadorTrabajoInvestigacion i"),
    @NamedQuery(name = "InvestigadorTrabajoInvestigacion.findById", query = "SELECT i FROM InvestigadorTrabajoInvestigacion i WHERE i.id = :id")})
public class InvestigadorTrabajoInvestigacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "investigador_identificacion", referencedColumnName = "identificacion")
    @ManyToOne(optional = false)
    private Investigador investigadorIdentificacion;
    @JoinColumn(name = "trabajo_investigacion_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TrabajoInvestigacion trabajoInvestigacionId;

    public InvestigadorTrabajoInvestigacion() {
    }

    public InvestigadorTrabajoInvestigacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Investigador getInvestigadorIdentificacion() {
        return investigadorIdentificacion;
    }

    public void setInvestigadorIdentificacion(Investigador investigadorIdentificacion) {
        this.investigadorIdentificacion = investigadorIdentificacion;
    }

    public TrabajoInvestigacion getTrabajoInvestigacionId() {
        return trabajoInvestigacionId;
    }

    public void setTrabajoInvestigacionId(TrabajoInvestigacion trabajoInvestigacionId) {
        this.trabajoInvestigacionId = trabajoInvestigacionId;
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
        if (!(object instanceof InvestigadorTrabajoInvestigacion)) {
            return false;
        }
        InvestigadorTrabajoInvestigacion other = (InvestigadorTrabajoInvestigacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.InvestigadorTrabajoInvestigacion[ id=" + id + " ]";
    }
    
}
