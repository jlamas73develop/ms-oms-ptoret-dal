package cl.hites.oms.dal.ptoret.controller;

import cl.hites.oms.dal.ptoret.helper.PtoRetiroHelper;
import cl.hites.oms.dal.ptoret.vo.PtoRetirosEstados;
import cl.hites.oms.dal.ptoret.vo.PuntosRetiroResponse;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

@Path("")
public class PtoRetiroController {

    private static final Logger LOG  =Logger.getLogger(PtoRetiroController.class);

    @Inject
    PtoRetiroHelper puntoRetiroHelper;

    @GET
    @Path("/puntosretiro/getByTipoOneBlue")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPtosRetiro() {

        try {
            PtoRetirosEstados ptosRetiro = puntoRetiroHelper.obtenerPuntosTipoOneBlue();
            PuntosRetiroResponse response = new PuntosRetiroResponse("0", "Success", ptosRetiro);

            return Response.ok(response).build();
        } catch (Exception e){
            LOG.error("Error no controlado getPtosRetiro: " + e.getMessage(),e);
            PuntosRetiroResponse response = new PuntosRetiroResponse("998", "Error interno al procesar obtención de puntos retiros externos.", null);
            return Response.ok(response).build();
        }
    }

    @POST
    @Path("/puntosretiro/status/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateStatusPtoRet(PtoRetirosEstados request) {

        try {
            puntoRetiroHelper.actualizarEstadoPuntoRetiro(request);
            PuntosRetiroResponse response = new PuntosRetiroResponse("0", "Success", null);

            return Response.ok(response).build();
        } catch (Exception e){
            LOG.error("Error no controlado actualizacion puntos de retiro : " + e.getMessage(),e);
            PuntosRetiroResponse response = new PuntosRetiroResponse("998", "Error interno al procesar actualizacion de estados de puntos retiros externos.", null);
            return Response.ok(response).build();
        }
    }
}
