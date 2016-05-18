package com.senac.cm.rest;

import com.google.gson.Gson;
import com.senac.cm.bean.Paciente;
import com.senac.cm.infra.CrudGenericoRest;
import com.senac.cm.infra.RNException;
import com.senac.cm.rn.PacienteRN;
import java.net.URI;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author Fabiano da Rosa Gomes
 */

@Path("/pacientes")
public class PacienteRest extends CrudGenericoRest<Paciente>{
    private final PacienteRN pacienteRN;

    public PacienteRest() {
        this.pacienteRN = new PacienteRN();
    }

    @Override
    public Response consultarPK(String pk) {
        try {
            Paciente p = pacienteRN.consultar(new Paciente(Integer.parseInt(pk)));
            return Response.ok(new Gson().toJson(p)).build();
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response pesquisar(String json) {
        try {
            Gson g = new Gson();
            Paciente p = g.fromJson(json, Paciente.class);

            List<Paciente> ret = pacienteRN.pesquisar(p);

            return gerarResponseParaCollection(ret);    
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response listar(Integer offset, Integer limit) {
        try {
            List<Paciente> ret = pacienteRN.pesquisar(null);        
            return gerarResponseParaCollection(ret);
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response excluirPK(String pk) {
        try {
            pacienteRN.excluir(new Paciente(Integer.parseInt(pk)));
            return Response.ok().build();
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response salvar(Paciente obj) {
        try {
            Paciente p = pacienteRN.salvar(obj);
            URI uri = uriInfo.getAbsolutePathBuilder().path(Integer.toString(p.getCpf())).build();
            return Response.created(uri).build();      
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    protected Response gerarResponseParaCollection(List<Paciente> obj) {
        return Response.ok(new Gson().toJson(obj)).build();
    }
}
