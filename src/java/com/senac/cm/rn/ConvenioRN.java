package com.senac.cm.rn;

import com.senac.cm.bd.ConvenioBD;
import com.senac.cm.bean.Convenio;
import com.senac.cm.infra.CrudGenerico;
import java.util.List;

/**
 *
 * @author Fabiano da Rosa Gomes
 */
public class ConvenioRN implements CrudGenerico<Convenio>{
    private final ConvenioBD convenioBD;

    public ConvenioRN() {
        this.convenioBD = new ConvenioBD();
    }
    
    @Override
    public Convenio consultar(Convenio bean) {
        return convenioBD.consultar(bean);
    }

    @Override
    public boolean excluir(Convenio bean) {
        return convenioBD.excluir(bean);
    }

    @Override
    public Convenio salvar(Convenio bean) {
        return convenioBD.salvar(bean);
    }

    @Override
    public Convenio alterar(Convenio bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Convenio> pesquisar(Convenio bean) {
        return convenioBD.pesquisar(bean);
    }

    
    
}
