package com.blanchard.ovobio.tracoeuf.constantes;

/**
 * classe contenant les constantes publiques internes
 */
public interface ConstInt {
    String LIVRAISON_URL ="livraison";
    String LIVRAISON_JSP="1_livraison";

    String PALETTES_URL = "palettes";
    String PALETTES_URL_SAVE = "save_palettes";
    String PALETTES_JSP = "1a_palettes";

    String FORWARD = "forward:/";
    String REDIRECT = "redirect:/";

    Integer ZERO=0;
    Boolean TRUE=true;
    Boolean FALSE=false;

    String CHAMP_DATE="date";
    String CHAMP_FOURNISSEUR="fournisseur";
    String CHAMP_CATEGORIE="categorie";
    String CHAMP_POIDS="poids";
    String CHAMP_TARE_NB="nb_tare";

    String CATEGORIE_TYPE_BIO="BIO";
    String CATEGORIE_TYPE_PA="PA";
    String CATEGORIE_TYPE_PAS="PAS";
    String CATEGORIE_TYPE_CAGE="CAGE";

    int CATEGORIE_TYPE_ID_BIO=1;
    int CATEGORIE_TYPE_ID_PA=2;
    int CATEGORIE_TYPE_ID_PAS=3;
    int CATEGORIE_TYPE_ID_CAGE=4;

    String POIDS_TYPE_BRUT="brut";
    String POIDS_TYPE_NET="net";
    Boolean POIDS_TYPE=true;

    String TARE_TYPE_PLASTIQUE="plastique";
    String TARE_TYPE_CARTON="carton";
    int TARE_NB_ALVEOLE_DEFAULT=5;

    Integer FOURNISSEUR_ID_DEFAULT=1;
    Integer FOURNISSEUR_ID_AUTRE=0;
    String FOURNISSEUR_AUTRE="Autre fournisseur";
    Boolean FOURNISSEUR_AUTRE_BOOLEAN=true;

    String ATT_FORM = "form";
}
