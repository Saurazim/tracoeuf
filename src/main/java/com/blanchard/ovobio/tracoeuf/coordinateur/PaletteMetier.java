package com.blanchard.ovobio.tracoeuf.coordinateur;

import com.blanchard.ovobio.tracoeuf.constantes.ConstInt;
import com.blanchard.ovobio.tracoeuf.dto.LivraisonForm;
import com.blanchard.ovobio.tracoeuf.dto.PaletteDto;
import com.blanchard.ovobio.tracoeuf.exceptions.ChampVideException;
import com.blanchard.ovobio.tracoeuf.exceptions.IntExpectedException;
import com.blanchard.ovobio.tracoeuf.exceptions.SubAboveZeroFalseException;
import com.blanchard.ovobio.tracoeuf.model.Livraison;
import com.blanchard.ovobio.tracoeuf.model.Palette;
import com.blanchard.ovobio.tracoeuf.service.LivraisonService;
import com.blanchard.ovobio.tracoeuf.service.PaletteService;
import com.blanchard.ovobio.tracoeuf.util.Validation;
import com.blanchard.ovobio.tracoeuf.util.MathsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PaletteMetier {
    @Autowired
    PaletteService paletteService;

    @Autowired
    LivraisonService livraisonService;

    private Map<String, String> erreurs = new HashMap<>();
    private String resultat;

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public void setErreurs(Map<String, String> erreurs) {
        this.erreurs = erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    @SuppressWarnings("Unused")
    public void savePalettes(LivraisonForm form){
        List<Palette> palettes = new ArrayList<>();
        Livraison l = livraisonService.getById(form.getId()).orElse(new Livraison());
        int poidsTotal =0;
        for(PaletteDto dto : form.getList()) {
            Palette palette = new Palette();

            try {
                checkPoids(dto.getPoids(),dto.getTare(),dto.getNet());
                palette.setNet(Integer.parseInt(dto.getNet()));
                poidsTotal +=palette.getNet();
            }catch (Exception e){
                e.printStackTrace();
            }

            palette.setCode(form.getPrefix().concat(Integer.toString(dto.getIdColumn())));

            try {
                palette.setConforme(dto.isConforme());
            } catch (NullPointerException npe){
                palette.setConforme(ConstInt.FALSE);
            }
            if (!dto.isConforme() && dto.getCommentaires().isBlank()){
                erreurs.put("comment","Merci de laisser un commentaire");
            }
            palette.setCommentaires(dto.getCommentaires());
            palette.setLivraison(l);
            palettes.add(palette);
        }

        try{
            Validation.checkValeurVide(form.getBon());
        } catch(ChampVideException cve){
            erreurs.put("bon",cve.getMessage());
        }

        if (!erreurs.isEmpty() || l.getId()!=null){
            resultat = "Succès";
            l.setCompte(form.getList().size());
            l.setNetTotal(poidsTotal);
            l.setBonLivraison(form.getBon());
            paletteService.saveAll(palettes);
        }else{
            resultat = "Echec";
        }
    }

    private void checkPoids(String brut, String tare, String net) throws Exception{
        boolean issueNet = false;
        Exception e = null;
        try {
            Validation.checkInt(net);
        } catch (ChampVideException cve){
            erreurs.put("net", cve.getMessage());
            e = cve;
        } catch (IntExpectedException iee){
            issueNet=true;
        }
        if(issueNet){
            try{
                MathsUtil.subWithCheck(brut,tare);
            } catch (ChampVideException cve){
                erreurs.put("brut",cve.getMessage());
                e = cve;
            } catch (SubAboveZeroFalseException | IntExpectedException ae) {
                erreurs.put("tare", ae.getMessage());
                e = ae;
            }

        }
        if(e!=null){
            throw e;
        }
    }
}
