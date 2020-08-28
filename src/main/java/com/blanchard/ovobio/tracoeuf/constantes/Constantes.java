package com.blanchard.ovobio.tracoeuf.constantes;

/**
 * classe contenant les constantes publiques paramétrées dans constantes.properties
 */
public interface Constantes {

    //syntaxe pour la récupération de prorpiétés
    //ConstantesUtil.getProperty(Constantes.MA_PROPRIETE)
    String RESOURCE = "constantes.properties";

    String LIVRAISON_URL = "livraison.url";
    String LIVRAISON_JSP = "livraison.jsp";
    String PDF_PATH = "pdf.path";

    String CACHE_EVICT_CRON = "cache.evict.cron";

    String PATTERN = "date.pattern";
    String ZERO="zero";
    String TRUE = "true";
    String FALSE = "false";

    String CODE_PREFIXE = "code.prefixe";
    String CODE_FOURNISSEUR_LONGUEUR = "code.fournisseur.longueur";

    String CHAMP_DATE = "champ.date";
    String CHAMP_FOURNISSEUR = "champ.fournisseur";
    String CHAMP_CATEGORIE = "champ.categorie";
    String CHAMP_POIDS = "champ.poids";
    String CHAMP_TARE_NB="champ.tare.nb";

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


    String CATEGORIE_TYPE_BIO="categorie.type.bio";
    String CATEGORIE_TYPE_PA="categorie.type.pa";
    String CATEGORIE_TYPE_PAS="categorie.type.pas";
    String CATEGORIE_TYPE_CAGE="categorie.type.cage";

    String CATEGORIE_TYPE_ID_BIO="categorie.type.id.bio";
    String CATEGORIE_TYPE_ID_PA="categorie.type.id.pa";
    String CATEGORIE_TYPE_ID_PAS="categorie.type.id.pas";
    String CATEGORIE_TYPE_ID_CAGE="categorie.type.id.cage";

    String POIDS_TYPE_BRUT="poids.type.brut";
    String POIDS_TYPE_NET="poids.type.net";

    String TARE_TYPE_PLASTIQUE="tare.type.plastique";
    String TARE_TYPE_CARTON="tare.type.carton";
    String TARE_NB_ALVEOLE_DEFAULT="tare.nb.alveole.default";

    String FOURNISSEUR_ID_DEFAULT="fournisseur.id.default";
    String FOURNISSEUR_AUTRE="fournisseur.autre";
    String FOURNISSEUR_AUTRE_BOOLEAN="fournisseur.autre.boolean";
}
