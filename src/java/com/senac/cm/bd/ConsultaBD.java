package com.senac.cm.bd;

import com.senac.cm.bean.Consulta;
import com.senac.cm.fake.BancoDadosConsulta;
import com.senac.cm.infra.CrudGenerico;
import java.util.List;

/**
 *
 * @author Fabiano da Rosa Gomes
 */
public class ConsultaBD implements CrudGenerico<Consulta>{

    @Override
    public Consulta consultar(Consulta bean) {
        return BancoDadosConsulta.getInstance().consultar(bean);
    }

    @Override
    public boolean excluir(Consulta bean) {
        return BancoDadosConsulta.getInstance().excluir(bean);
    }

    @Override
    public Consulta salvar(Consulta bean) {
        return BancoDadosConsulta.getInstance().salvar(bean);
    }

    @Override
    public Consulta alterar(Consulta bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Consulta> pesquisar(Consulta bean) {
        return BancoDadosConsulta.getInstance().pesquisar(bean);
    }

    
    
}
