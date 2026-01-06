package cl.hites.oms.dal.ptoret.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "dom_puntos_retiro")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PuntoRetiro {
    @Id
    private Long id;
    private String nombre;
    @Column(name="cota_entrega")
    private Long cotaEntrega;
    private String tipo;
    @Column(name="id_comuna")
    private Long idComuna;
    @Column(name="id_region")
    private Long IdRegion;
    @Column(name="id_localidad")
    private Long idLocalidad;
    private String direccion;
    @Column(name = "dias_laborables_recep")
    private String diasLaborablesRecep;
    @Column(name = "dias_laborables")
    private String diasLaborables;
    @Column(name = "leadtime_entrega")
    private Long leadtimeEntrega;
    @Column(name="url_mapa")
    private String urlMapa;
    @Column(name="flag_activo")
    private String flagActivo;
    @Column(name="horario_atencion")
    private String horarioAtencion;
    private Boolean transmitted;

    @Column(name="id_pto_retiro_integ_log")
    private String idPtoRetiroIntegLog;
    @Column(name="id_tipo_integ_log")
    private Long idTipoIntegLog;

}
