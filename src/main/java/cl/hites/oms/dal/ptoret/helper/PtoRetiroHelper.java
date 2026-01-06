package cl.hites.oms.dal.ptoret.helper;

import cl.hites.oms.dal.ptoret.entity.PuntoRetiro;
import cl.hites.oms.dal.ptoret.repository.PuntoRetiroRepository;
import cl.hites.oms.dal.ptoret.vo.PtoRetirosEstados;
import cl.hites.oms.dal.ptoret.vo.PtosRetiroVO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PtoRetiroHelper {

    @Inject
    PuntoRetiroRepository puntoRetiroRepository;

    public PtoRetirosEstados obtenerPuntosTipoOneBlue() {
        List<PuntoRetiro> ptoRetiroActivos = puntoRetiroRepository.findByTipoIntegrador(2L, "S");

        List<PuntoRetiro> ptoRetiroInactivos = puntoRetiroRepository.findByTipoIntegrador(2L, "N");

        List<PtosRetiroVO> ptosRetiroActivos = ptoRetiroActivos.stream()
                .map(PtosRetiroVO::toVO)
                .toList();

        List<PtosRetiroVO> ptosRetiroInactivos = ptoRetiroInactivos.stream()
                .map(PtosRetiroVO::toVO)
                .toList();

        return new PtoRetirosEstados(ptosRetiroInactivos, ptosRetiroActivos);

    }

    @Transactional
    public void actualizarEstadoPuntoRetiro(PtoRetirosEstados ptosRetiro) {

        List<Long> ids = ptosRetiro.getActivos().stream()
                .map(PtosRetiroVO::getId)
                .toList();

        puntoRetiroRepository.actualizarEstadoPuntosRetiro("S", ids);

        ids = ptosRetiro.getInactivos().stream()
                .map(PtosRetiroVO::getId)
                .toList();

        puntoRetiroRepository.actualizarEstadoPuntosRetiro("N", ids);

    }

}
