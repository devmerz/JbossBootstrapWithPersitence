/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jboss.entidades;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author devmerz
 */
@Entity
@Table(name = "test2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Test2.findAll", query = "SELECT t FROM Test2 t"),
    @NamedQuery(name = "Test2.findByIdTest2", query = "SELECT t FROM Test2 t WHERE t.idTest2 = :idTest2"),
    @NamedQuery(name = "Test2.findByNombre", query = "SELECT t FROM Test2 t WHERE t.nombre = :nombre")})
public class Test2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_test2")
    private Integer idTest2;
    @Column(name = "nombre")
    private String nombre;

    public Test2() {
    }

    public Test2(Integer idTest2) {
        this.idTest2 = idTest2;
    }

    public Integer getIdTest2() {
        return idTest2;
    }

    public void setIdTest2(Integer idTest2) {
        this.idTest2 = idTest2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTest2 != null ? idTest2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Test2)) {
            return false;
        }
        Test2 other = (Test2) object;
        if ((this.idTest2 == null && other.idTest2 != null) || (this.idTest2 != null && !this.idTest2.equals(other.idTest2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jboss.entidades.Test2[ idTest2=" + idTest2 + " ]";
    }
    
}
