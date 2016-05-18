package com.senac.cm.rn;

import com.senac.cm.bd.PacienteBD;
import com.senac.cm.bean.Paciente;
import com.senac.cm.infra.CrudGenerico;
import java.util.List;

/**
 *
 * @author Fabiano da Rosa Gomes
 */
public class PacienteRN implements CrudGenerico<Paciente>{
    
    private final PacienteBD pacienteBD;

    public PacienteRN() {
        this.pacienteBD = new PacienteBD();
    }
    
    
    @Override
    public Paciente consultar(Paciente bean) {
        return pacienteBD.consultar(bean);
    }

    @Override
    public boolean excluir(Paciente bean) {
        return pacienteBD.excluir(bean);
    }

    @Override
    public Paciente salvar(Paciente bean) {
        return pacienteBD.salvar(bean);
    }

    @Override
    public Paciente alterar(Paciente bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Paciente> pesquisar(Paciente bean) {
        return pacienteBD.pesquisar(bean);
    }
}
