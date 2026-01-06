package cl.hites.oms.dal.ptoret.vo;

import cl.hites.oms.dal.ptoret.entity.PuntoRetiro;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class PtosRetiroVO {

    private Long id;
    private String nombre;
    private Long cotaEntrega;
    private String tipo;
    private Long idComuna;
    private Long IdRegion;
    private Long idLocalidad;
    private String direccion;
    private String diasLaborablesRecep;
    private String diasLaborables;
    private Long leadtimeEntrega;
    private String urlMapa;
    private String flagActivo;
    private String horarioAtencion;
    private Boolean transmitted;

    private String idPtroRetiroIntegradorLog;
    private Long idTipoIntegradorLog;

    public static PtosRetiroVO toVO(PuntoRetiro e) {
        if (e == null) return null;

        return new PtosRetiroVO(
                e.getId(),
                e.getNombre(),
                e.getCotaEntrega(),
                e.getTipo(),
                e.getIdComuna(),
                e.getIdRegion(),
                e.getIdLocalidad(),
                e.getDireccion(),
                e.getDiasLaborablesRecep(),
                e.getDiasLaborables(),
                e.getLeadtimeEntrega(),
                e.getUrlMapa(),
                e.getFlagActivo(),
                e.getHorarioAtencion(),
                e.getTransmitted(),
                e.getIdPtoRetiroIntegLog(),
                e.getIdTipoIntegLog()
        );
    }
}
