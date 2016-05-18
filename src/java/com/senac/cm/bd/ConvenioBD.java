package com.senac.cm.bd;

import com.senac.cm.bean.Convenio;
import com.senac.cm.fake.BancoDadosConvenio;
import com.senac.cm.infra.CrudGenerico;
import java.util.List;

/**
 *
 * @author Fabiano da Rosa Gomes
 */
public class ConvenioBD implements CrudGenerico<Convenio>{

    @Override
    public Convenio consultar(Convenio bean) {
        return BancoDadosConvenio.getInstance().consultar(bean);
    }

    @Override
    public boolean excluir(Convenio bean) {
        return BancoDadosConvenio.getInstance().excluir(bean);
    }

    @Override
    public Convenio salvar(Convenio bean) {
        return BancoDadosConvenio.getInstance().salvar(bean);
    }

    @Override
    public Convenio alterar(Convenio bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Convenio> pesquisar(Convenio bean) {
        return BancoDadosConvenio.getInstance().pesquisar(bean);
    }

    
    
}
