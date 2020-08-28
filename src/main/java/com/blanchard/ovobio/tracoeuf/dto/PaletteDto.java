package com.blanchard.ovobio.tracoeuf.dto;

import com.blanchard.ovobio.tracoeuf.constantes.Constantes;
import com.blanchard.ovobio.tracoeuf.util.ConstantesUtil;

public class PaletteDto {
    private Integer idColumn;
    private Integer poids;
    private Integer tare = ConstantesUtil.getPropertyToInt(Constantes.ZERO);
    private Integer net;
    private boolean conforme = ConstantesUtil.getPropertyToBool(Constantes.FALSE);
    private String commentaires;
}
