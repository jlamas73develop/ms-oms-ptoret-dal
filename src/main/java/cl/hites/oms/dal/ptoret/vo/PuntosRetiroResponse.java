package cl.hites.oms.dal.ptoret.vo;

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
public class PuntosRetiroResponse {

    String code;
    String message;
    PtoRetirosEstados ptosRetiro;
}
