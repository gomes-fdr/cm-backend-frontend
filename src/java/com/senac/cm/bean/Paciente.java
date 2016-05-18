package com.senac.cm.bean;


import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author Fabiano da Rosa Gomes
 */
public class Paciente  implements Serializable, Comparable<Paciente>{
    private int cpf;
    private String nome;
    private Date dt_nascimento;

    public Paciente(int cpf) {
        this.cpf = cpf;
    }

    public Paciente(int cpf, String nome, Date dt_nascimento) {
        this.cpf = cpf;
        this.nome = nome;
        this.dt_nascimento = dt_nascimento;
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

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.cpf;
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
        final Paciente other = (Paciente) obj;
        if (this.cpf != other.cpf) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Paciente{" + "cpf=" + cpf + ", nome=" + nome + ", dt_nascimento=" + dt_nascimento + '}';
    }

    @Override
    public int compareTo(Paciente o) {
        return Integer.toString(cpf).compareTo(Integer.toString(o.getCpf()));
    }
}
