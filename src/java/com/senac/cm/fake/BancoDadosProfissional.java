package com.senac.cm.fake;

import com.senac.cm.bean.Profissional;
import com.senac.cm.infra.CrudGenerico;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Fabiano da Rosa Gomes
 */
public class BancoDadosProfissional implements CrudGenerico<Profissional> {
    
    private static Set<Profissional> profissional = new TreeSet<>();

    public BancoDadosProfissional() {
        profissional = new TreeSet<>();
        
        profissional.add(new Profissional(1,"pierre hendricks","AA234", "123"));
        
    }
    
    public static BancoDadosProfissional getInstance() {
        return BancoDadosHolder.INSTANCE;
    }
     
    private static class BancoDadosHolder {
        private static final BancoDadosProfissional INSTANCE = new BancoDadosProfissional();
    }
    
    @Override
    public Profissional consultar(Profissional bean) {
        for (Profissional p : profissional) {
            if (p.equals(bean)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean excluir(Profissional bean) {
        return profissional.remove(bean);
    }

    @Override
    public Profissional salvar(Profissional bean) {
        profissional.remove(bean);
        profissional.add(bean);
        return bean;
    }

    @Override
    public Profissional alterar(Profissional bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Profissional> pesquisar(Profissional bean) {
        if (bean == null) {
            return new ArrayList<>(profissional);
        }
        TreeSet<Profissional> lista = new TreeSet<>();
        for (Profissional p : profissional) {
            if (p.getCpf() == bean.getCpf()) {
                lista.add(p);
            }
        }
        return new ArrayList<>(lista);
    }
}
