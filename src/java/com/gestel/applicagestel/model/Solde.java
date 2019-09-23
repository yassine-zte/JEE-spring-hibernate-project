/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestel.applicagestel.model;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;


/**
 *
 * @author Abroun
 */
@Entity
@Table(name="solde"
    ,catalog="maventelgest"
)
public class Solde  implements java.io.Serializable{
    
    @Id
     @GeneratedValue(strategy= GenerationType.IDENTITY)
     @Column(name="IDSOLDE", unique=true, nullable=false)
     private Integer idSolde;
    
    @Column(name="FORFAIT", length=30)
     private String forfait;
    @Column(name="DATESOLDEE", length=15)
     private String datesolde;
    
     @ManyToOne(fetch = FetchType.EAGER,cascade= CascadeType.PERSIST)
     @JoinColumn(name="numerotel")
    
     private Sim sim;

     public Solde() {
    }
    
    public Solde(Integer idSolde, String forfait, String datesolde) {
        this.idSolde = idSolde;
        this.forfait = forfait;
        this.datesolde = datesolde;
    }

    public String getDatesolde() {
        return datesolde;
    }

    public void setDatesolde(String datesolde) {
        this.datesolde = datesolde;
    }

    public String getForfait() {
        return forfait;
    }

    public void setForfait(String forfait) {
        this.forfait = forfait;
    }

    public Integer getIdSolde() {
        return idSolde;
    }

    public void setIdSolde(Integer idSolde) {
        this.idSolde = idSolde;
    }

    public Sim getSim() {
        return sim;
    }

    public void setSim(Sim sim) {
        this.sim = sim;
    }
    
    

    
     
     
    
    
    
}
