package com.senac.cm.rest;

import com.google.gson.Gson;
import com.senac.cm.bean.Convenio;
import com.senac.cm.infra.CrudGenericoRest;
import com.senac.cm.rn.ConvenioRN;
import com.senac.cm.infra.RNException;
import java.net.URI;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author Fabiano da Rosa Gomes
 */

@Path("/convenios")
public class ConvenioRest extends CrudGenericoRest<Convenio>{
    private final ConvenioRN convenioRN;

    public ConvenioRest() {
        this.convenioRN = new ConvenioRN();
    }
    
    @Override
    public Response consultarPK(String pk) {
        try {
            Convenio c = convenioRN.consultar(new Convenio(Integer.parseInt(pk)));
            return Response.ok(new Gson().toJson(c)).build();
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response pesquisar(String q) {
        try {
            Gson g = new Gson();
            Convenio c = g.fromJson(q, Convenio.class);

            List<Convenio> ret = convenioRN.pesquisar(c);

            return gerarResponseParaCollection(ret);    
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response excluirPK(String pk) {
        try {
            convenioRN.excluir(new Convenio(Integer.parseInt(pk)));
            return Response.ok().build();
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response salvar(Convenio obj) {
        try {
            Convenio c = convenioRN.salvar(obj);
            URI uri = uriInfo.getAbsolutePathBuilder().path(Integer.toString(c.getId())).build();
            return Response.created(uri).build();      
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response alterar(Convenio obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response listar(Integer offset, Integer limit) {
        try {
            List<Convenio> ret = convenioRN.pesquisar(null);        
            return gerarResponseParaCollection(ret);
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    protected Response gerarResponseParaCollection(List<Convenio> obj) {
        return Response.ok(new Gson().toJson(obj)).build();
    }
    
}
