package com.senac.cm.bean;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Fabiano da Rosa Gomes
 */
public class Profissional implements Serializable, Comparable<Profissional>{
    private int cpf;
    private String nome;
    private String cod_categoria;
    private String senha;

    public Profissional(int cpf) {
        this.cpf = cpf;
    }

    public Profissional(int cpf, String nome, String cod_categoria, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.cod_categoria = cod_categoria;
        this.senha = senha;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCod_categoria() {
        return cod_categoria;
    }

    public void setCod_categoria(String cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.cpf);
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
        final Profissional other = (Profissional) obj;
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Profissional{" + "cpf=" + cpf + ", nome=" + nome + ", cod_categoria=" + cod_categoria + ", senha=" + senha + '}';
    }

    @Override
    public int compareTo(Profissional o) {
        return Integer.toString(cpf).compareTo(Integer.toString(o.getCpf()));
    }
    
}
