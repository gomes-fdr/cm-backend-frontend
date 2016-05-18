package com.senac.cm.rest;

import com.google.gson.Gson;
import com.senac.cm.bean.Consulta;
import com.senac.cm.infra.CrudGenericoRest;
import com.senac.cm.infra.RNException;
import com.senac.cm.rn.ConsultaRN;
import java.net.URI;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author Fabiano da Rosa Gomes
 */

@Path("/consultas")
public class ConsultaRest extends CrudGenericoRest<Consulta>{
    private final ConsultaRN consultaRN;
    
    public ConsultaRest() {
        this.consultaRN = new ConsultaRN();
    }

    @Override
    public Response consultarPK(String pk) {
        try {
            Consulta c = consultaRN.consultar(new Consulta(Integer.parseInt(pk)));
            return Response.ok(new Gson().toJson(c)).build();
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response pesquisar(String json) {
        try {
            Gson g = new Gson();
            Consulta c = g.fromJson(json, Consulta.class);

            List<Consulta> ret = consultaRN.pesquisar(c);

            return gerarResponseParaCollection(ret);    
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response listar(Integer offset, Integer limit) {
        try {
            List<Consulta> ret = consultaRN.pesquisar(null);        
            return gerarResponseParaCollection(ret);
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response excluirPK(String pk) {
        try {
            consultaRN.excluir(new Consulta(Integer.parseInt(pk)));
            return Response.ok().build();
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response salvar(Consulta obj) {
        try {
            Consulta c = consultaRN.salvar(obj);
            URI uri = uriInfo.getAbsolutePathBuilder().path(Integer.toString(c.getId())).build();
            return Response.created(uri).build();      
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    protected Response gerarResponseParaCollection(List<Consulta> obj) {
        return Response.ok(new Gson().toJson(obj)).build();
    }
    
}
