package cl.hites.oms.dal.ptoret.vo;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class PtoRetirosEstados {

    List<PtosRetiroVO> inactivos;
    List<PtosRetiroVO> activos;
}
