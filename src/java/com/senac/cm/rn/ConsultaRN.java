package com.senac.cm.rn;

import com.senac.cm.bd.ConsultaBD;
import com.senac.cm.bean.Consulta;
import com.senac.cm.infra.CrudGenerico;
import java.util.List;

/**
 *
 * @author Fabiano da Rosa Gomes
 */
public class ConsultaRN implements CrudGenerico<Consulta>{
    
    private final ConsultaBD consultaBD;

    public ConsultaRN() {
        this.consultaBD = new ConsultaBD();
    }

    @Override
    public Consulta consultar(Consulta bean) {
        return consultaBD.consultar(bean);
    }

    @Override
    public boolean excluir(Consulta bean) {
        return consultaBD.excluir(bean);
    }

    @Override
    public Consulta salvar(Consulta bean) {
        return consultaBD.salvar(bean);
    }

    @Override
    public Consulta alterar(Consulta bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Consulta> pesquisar(Consulta bean) {
        return consultaBD.pesquisar(bean);
    }

    
    
}
