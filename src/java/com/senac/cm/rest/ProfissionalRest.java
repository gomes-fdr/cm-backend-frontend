package com.senac.cm.rest;

import com.google.gson.Gson;
import com.senac.cm.bean.Profissional;
import com.senac.cm.infra.CrudGenericoRest;
import com.senac.cm.infra.RNException;
import com.senac.cm.rn.ProfissionalRN;
import java.net.URI;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author Fabiano da Rosa Gomes
 */
@Path("/profissionais")
public class ProfissionalRest extends CrudGenericoRest<Profissional>{
    private final ProfissionalRN profissionalRN;
    
    public ProfissionalRest() {
        this.profissionalRN = new ProfissionalRN();
    }

    @Override
    public Response consultarPK(String pk) {
        try {
            Profissional p = profissionalRN.consultar(new Profissional(Integer.parseInt(pk)));
            return Response.ok(new Gson().toJson(p)).build();
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response pesquisar(String json) {
        try {
            Gson g = new Gson();
            Profissional p = g.fromJson(json, Profissional.class);

            List<Profissional> ret = profissionalRN.pesquisar(p);

            return gerarResponseParaCollection(ret);    
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response listar(Integer offset, Integer limit) {
        try {
            List<Profissional> ret = profissionalRN.pesquisar(null);        
            return gerarResponseParaCollection(ret);
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response excluirPK(String pk) {
        try {
            profissionalRN.excluir(new Profissional(Integer.parseInt(pk)));
            return Response.ok().build();
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response salvar(Profissional obj) {
        try {
            Profissional p = profissionalRN.salvar(obj);
           URI uri = uriInfo.getAbsolutePathBuilder().path(Integer.toString(p.getCpf())).build();
            return Response.created(uri).build();      
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    protected Response gerarResponseParaCollection(List<Profissional> obj) {
        return Response.ok(new Gson().toJson(obj)).build();
    }
    
}
