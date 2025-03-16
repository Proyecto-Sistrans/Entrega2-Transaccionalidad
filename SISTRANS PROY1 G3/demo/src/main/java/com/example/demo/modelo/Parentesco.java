package com.example.demo.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="parentescos")
public class Parentesco {
    @EmbeddedId
    private ParentescoPK pk;

    public Parentesco(Afiliado afiliado, Afiliado familiar) {
        this.pk = new ParentescoPK(afiliado, familiar);
    }

    public Parentesco() 
    {;} 

    //Getters   
    public ParentescoPK getpk() {
        return pk;
    }

    //Setters
    public void setpk(ParentescoPK pk) {
        this.pk = pk;
    }

    
}
