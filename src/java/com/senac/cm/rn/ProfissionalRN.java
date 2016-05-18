package com.senac.cm.rn;

import com.senac.cm.bean.Profissional;
import com.senac.cm.bd.ProfissionalBD;
import com.senac.cm.infra.CrudGenerico;
import java.util.List;

/**
 *
 * @author Fabiano da Rosa Gomes
 */
public class ProfissionalRN implements CrudGenerico<Profissional>{
    private final ProfissionalBD profissionalBD;
    
    public ProfissionalRN() {
        this.profissionalBD = new ProfissionalBD();
    }

    @Override
    public Profissional consultar(Profissional bean) {
        return profissionalBD.consultar(bean);
    }

    @Override
    public boolean excluir(Profissional bean) {
        return profissionalBD.excluir(bean);
    }

    @Override
    public Profissional salvar(Profissional bean) {
        return profissionalBD.salvar(bean);
    }

    @Override
    public Profissional alterar(Profissional bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Profissional> pesquisar(Profissional bean) {
        return profissionalBD.pesquisar(bean);
    }
    
}
