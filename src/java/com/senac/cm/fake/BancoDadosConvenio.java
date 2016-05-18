package com.senac.cm.fake;

import com.senac.cm.bean.Convenio;
import com.senac.cm.infra.CrudGenerico;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Fabiano da Rosa Gomes
 */
public class BancoDadosConvenio implements CrudGenerico<Convenio>{
    
    private static Set<Convenio> convenios = new TreeSet<>();

    public BancoDadosConvenio() {
        convenios = new TreeSet<>();
        
        // Adicionar convenios fakes aqui.
        convenios.add(new Convenio(1, "Unimed"));
        convenios.add(new Convenio(2, "Bradesco saúde"));
        convenios.add(new Convenio(3, "Amil"));
        
    }
    
     public static BancoDadosConvenio getInstance() {
        return BancoDadosHolder.INSTANCE;
    }
     
    private static class BancoDadosHolder {
        private static final BancoDadosConvenio INSTANCE = new BancoDadosConvenio();
    }

    @Override
    public Convenio consultar(Convenio bean) {
        for (Convenio m : convenios) {
            if (m.equals(bean)) {
                return m;
            }
        }
        return null; 
    }

    @Override
    public boolean excluir(Convenio bean) {
        return convenios.remove(bean);
    }

    @Override
    public Convenio salvar(Convenio bean) {
        convenios.remove(bean);
        convenios.add(bean);
        return bean;
    }

    @Override
    public Convenio alterar(Convenio bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Convenio> pesquisar(Convenio bean) {
        if (bean == null) {
            return new ArrayList<>(convenios);
        }
        TreeSet<Convenio> lista = new TreeSet<>();
        for (Convenio m : convenios) {
            if (m.getId() == bean.getId()) {
                lista.add(m);
            }
        }
        return new ArrayList<>(lista);
    }
}
