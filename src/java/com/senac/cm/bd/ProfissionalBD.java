package com.senac.cm.bd;

import com.senac.cm.bean.Profissional;
import com.senac.cm.fake.BancoDadosProfissional;
import com.senac.cm.infra.CrudGenerico;
import java.util.List;

/**
 *
 * @author Fabiano da Rosa Gomes
 */
public class ProfissionalBD implements CrudGenerico<Profissional>{

    @Override
    public Profissional consultar(Profissional bean) {
        return BancoDadosProfissional.getInstance().consultar(bean);
    }

    @Override
    public boolean excluir(Profissional bean) {
        return BancoDadosProfissional.getInstance().excluir(bean);
    }

    @Override
    public Profissional salvar(Profissional bean) {
        return BancoDadosProfissional.getInstance().salvar(bean);
    }

    @Override
    public Profissional alterar(Profissional bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Profissional> pesquisar(Profissional bean) {
        return BancoDadosProfissional.getInstance().pesquisar(bean);
    }
    
}
