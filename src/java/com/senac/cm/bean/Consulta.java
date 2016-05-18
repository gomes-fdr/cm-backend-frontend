package com.senac.cm.bean;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Fabiano da Rosa Gomes
 */
public class Consulta implements Serializable, Comparable<Consulta>{
    private int id;
    private Paciente paciente;
    private Profissional recepcionista;
    private Profissional medico;
    private Date dt_consulta;
    private Date dt_agendamento;

    public Consulta(int id, Paciente paciente, Profissional recepcionista, Profissional medico, Date dt_consulta, Date dt_agendamento) {
        this.id = id;
        this.paciente = paciente;
        this.recepcionista = recepcionista;
        this.medico = medico;
        this.dt_consulta = dt_consulta;
        this.dt_agendamento = dt_agendamento;
    }


    public Consulta(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getDt_consulta() {
        return dt_consulta;
    }

    public void setDt_consulta(Date dt_consulta) {
        this.dt_consulta = dt_consulta;
    }

    public Date getDt_agendamento() {
        return dt_agendamento;
    }

    public void setDt_agendamento(Date dt_agendamento) {
        this.dt_agendamento = dt_agendamento;
    }

    public Profissional getRecepcionista() {
        return recepcionista;
    }

    public void setRecepcionista(Profissional recepcionista) {
        this.recepcionista = recepcionista;
    }

    public Profissional getMedico() {
        return medico;
    }

    public void setMedico(Profissional medico) {
        this.medico = medico;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
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
        final Consulta other = (Consulta) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consulta{" + "id=" + id + ", paciente=" + paciente + ", recepcionista=" + recepcionista + ", medico=" + medico + ", dt_consulta=" + dt_consulta + ", dt_agendamento=" + dt_agendamento + '}';
    }

    @Override
    public int compareTo(Consulta o) {
        return Integer.toString(id).compareTo(Integer.toString(o.getId()));
    }
}
