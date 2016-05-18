package com.senac.cm.bean;

import java.io.Serializable;

/**
 *
 * @author Fabiano da Rosa Gomes
 */
public class Convenio implements Serializable, Comparable<Convenio>{
    private int id;
    private String nome;
    
    public Convenio(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Convenio(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Convenio other = (Convenio) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Convenio{" + "id=" + id + ", nome=" + nome + '}';
    }

    @Override
    public int compareTo(Convenio o) {
        return Integer.toString(id).compareTo(Integer.toString(o.getId()));
    }
}
