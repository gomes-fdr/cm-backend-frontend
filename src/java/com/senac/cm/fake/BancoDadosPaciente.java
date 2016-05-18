package com.senac.cm.fake;

import com.senac.cm.bean.Paciente;
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
public class BancoDadosPaciente implements CrudGenerico<Paciente>{
    
    private static Set<Paciente> listagem = new TreeSet<>();

    public BancoDadosPaciente() {
        listagem = new TreeSet<>();
        
        SimpleDateFormat ft =  new SimpleDateFormat ("dd-MM-yyyy");
        
        // Adicionar pacientes fakes aqui.
        try {   
            listagem.add(new Paciente(1,"pierre hendricks",ft.parse("23-05-1986")));
            listagem.add(new Paciente(2,"tobias horn",ft.parse("07-11-1986")));
            listagem.add(new Paciente(3,"izabella peters",ft.parse("29-09-1949")));
            listagem.add(new Paciente(4,"ella langley",ft.parse("12-05-1951")));
            listagem.add(new Paciente(5,"blake faulkner",ft.parse("04-12-1996")));
            listagem.add(new Paciente(6,"tinley howard",ft.parse("0-04-1999")));
            listagem.add(new Paciente(7,"erry gill",ft.parse("06-05-1971")));
            listagem.add(new Paciente(8,"emily lloyd",ft.parse("12-07-1988")));
            listagem.add(new Paciente(9,"marlene burris",ft.parse("29-03-1984")));
            listagem.add(new Paciente(10,"casen kane",ft.parse("08-10-1985")));
            
        } catch (ParseException ex) {
            Logger.getLogger(BancoDadosPaciente.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println(ex.getMessage());
        }
    }
    
    public static BancoDadosPaciente getInstance() {
        return BancoDadosHolder.INSTANCE;
    }
    
     private static class BancoDadosHolder {
        private static final BancoDadosPaciente INSTANCE = new BancoDadosPaciente();
    }
    
    @Override
    public Paciente consultar(Paciente bean) {
        for (Paciente p : listagem) {
            if (p.equals(bean)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean excluir(Paciente bean) {
        return listagem.remove(bean);
    }

    @Override
    public Paciente salvar(Paciente bean) {
        listagem.remove(bean);
        listagem.add(bean);
        return bean;
    }

    @Override
    public Paciente alterar(Paciente bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Paciente> pesquisar(Paciente bean) {
        
        if(bean==null) {
            return new ArrayList<>(listagem);
        }
        TreeSet<Paciente> lista = new TreeSet<>();
        for (Paciente p : listagem) {
            if (p.getCpf() == bean.getCpf()
                    || (bean.getNome()!=null && p.getNome().contains(bean.getNome()))) {
                lista.add(p);
            }
        }
        return new ArrayList<>(lista);
    }
    
}
