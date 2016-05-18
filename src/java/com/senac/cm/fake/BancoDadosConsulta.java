package com.senac.cm.fake;

import com.senac.cm.bean.Consulta;
import com.senac.cm.bean.Paciente;
import com.senac.cm.bean.Profissional;
import com.senac.cm.infra.CrudGenerico;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fabiano da Rosa Gomes
 */
public class BancoDadosConsulta implements CrudGenerico<Consulta>{
    private static Set<Consulta> consultas = new TreeSet<>();
    
    public BancoDadosConsulta() {
        try {
            consultas = new TreeSet<>();
            
            SimpleDateFormat ft =  new SimpleDateFormat ("dd-MM-yyyy");
            
            // Adicionar consultas aqui!!
            consultas.add(new Consulta(1, new Paciente(1), new Profissional(1), new Profissional(1), ft.parse("12-12-2016"), ft.parse("16-05-2016")));
        } catch (ParseException ex) {
            Logger.getLogger(BancoDadosConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static BancoDadosConsulta getInstance() {
        return BancoDadosHolder.INSTANCE;
    }
     
    private static class BancoDadosHolder {
        private static final BancoDadosConsulta INSTANCE = new BancoDadosConsulta();
    }

    @Override
    public Consulta consultar(Consulta bean) {
        for (Consulta c : consultas) {
            if (c.equals(bean)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public boolean excluir(Consulta bean) {
        return consultas.remove(bean);
    }

    @Override
    public Consulta salvar(Consulta bean) {
        consultas.remove(bean);
        consultas.add(bean);
        return bean;
    }

    @Override
    public Consulta alterar(Consulta bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Consulta> pesquisar(Consulta bean) {
        if (bean == null) {
            return new ArrayList<>(consultas);
        }
        TreeSet<Consulta> lista = new TreeSet<>();
        for (Consulta m : consultas) {
            if (m.getId() == bean.getId()) {
                lista.add(m);
            }
        }
        return new ArrayList<>(lista);
    }
    
}
