package com.blanchard.ovobio.tracoeuf.constantes;

/**
 * classe contenant les constantes publiques paramétrées dans constantes.properties
 */
public interface ConstExt {

    //syntaxe pour la récupération de prorpiétés
    //ConstantesUtil.getProperty(ConstExt.MA_PROPRIETE)
    String RESOURCE = "constantes.properties";

    String INPUT_PATH = "path.input";
    String OUTPUT_PATH = "path.output";
    String PATH_OUTPUT_DOCX = "path.output.docx";
    String PATH_OUTPUT_PDF = "path.output.pdf";
    String PATH_OUTPUT_FO = "path.output.fo";

    String PRINTER_NAME = "printer.name";

    String EXTENSION_ETIQUETTE_PALETTE = "extension.etiquette.palette";

    String CACHE_EVICT_CRON = "cache.evict.cron";

    String PATTERN = "date.pattern";

    String CODE_PREFIXE = "code.prefixe";
    String CODE_FOURNISSEUR_LONGUEUR = "code.fournisseur.longueur";

    String EXC_FOURNISSEUR = "exc.fournisseur";
    String EXC_CATEGORIE = "exc.categorie";
    String EXC_POIDS_VIDE = "exc.poids.vide";
    String EXC_POIDS_NON_INT = "exc.poids.non.int";
    String EXC_DATE_VIDE = "exc.date.vide";
    String EXC_TARE_VIDE="exc.tare.vide";

    String EXCEPTION_DATE_FORMAT = "exception.date.format";
    String EXCEPTION_SUB_ABOVE_ZERO="exception.sub.above.zero";
    String EXCEPTION_CHAMP_INT_EXPECTED="exception.champ.int.expected";
    String EXCEPTION_CHAMP_INT_EXPECTED_STRING="exception.champ.int.expected.string";
    String EXCEPTION_CHAMP_VIDE="exception.champ.vide";
    String EXCEPTION_CHAMP_VIDE_STRING="exception.champ.vide.string";

    String CHECK_TARE="check.tare";

    String CHECK_CONFORME="check.conforme";
}
