package com.senac.cm.bd;

import com.senac.cm.bean.Paciente;
import com.senac.cm.fake.BancoDadosPaciente;
import com.senac.cm.infra.CrudGenerico;
import java.util.List;

/**
 *
 * @author Fabiano da Rosa Gomes
 */
public class PacienteBD implements CrudGenerico<Paciente>{
       
    @Override
    public Paciente consultar(Paciente bean) {
        return BancoDadosPaciente.getInstance().consultar(bean);
    }

    @Override
    public boolean excluir(Paciente bean) {
        return BancoDadosPaciente.getInstance().excluir(bean);
    }

    @Override
    public Paciente salvar(Paciente bean) {
        return BancoDadosPaciente.getInstance().salvar(bean);
    }

    @Override
    public Paciente alterar(Paciente bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Paciente> pesquisar(Paciente bean) {
        return BancoDadosPaciente.getInstance().pesquisar(bean);
    }

    
    
}
