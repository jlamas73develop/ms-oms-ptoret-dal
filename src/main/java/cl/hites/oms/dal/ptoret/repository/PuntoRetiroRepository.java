package cl.hites.oms.dal.ptoret.repository;

import cl.hites.oms.dal.ptoret.entity.PuntoRetiro;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@ApplicationScoped
public class PuntoRetiroRepository  implements PanacheRepository<PuntoRetiro> {

    @PersistenceContext
    EntityManager em;

    public List<PuntoRetiro> findByTipoIntegrador(Long tipo, String flagActivo) {
        return list(
                "idTipoIntegLog = ?1 and flagActivo = ?2",
                tipo,
                flagActivo
        );
    }


    public int actualizarEstadoPuntosRetiro(String flagActivo, List<Long> ids) {

        if (ids == null || ids.isEmpty()) {
            return 0;
        }

        return em.createQuery(
        "UPDATE PuntoRetiro p " +
        " SET p.flagActivo = :estadoActivo " +
         " WHERE p.id IN :ids " )
                .setParameter("estadoActivo", flagActivo)
                .setParameter("ids", ids)
                .executeUpdate();
    }
}
