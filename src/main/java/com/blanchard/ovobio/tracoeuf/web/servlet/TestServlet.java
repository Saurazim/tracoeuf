package com.blanchard.ovobio.tracoeuf.web.servlet;

import com.blanchard.ovobio.tracoeuf.dto.LivraisonForm;
import com.blanchard.ovobio.tracoeuf.service.DocumentMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class TestServlet {
    public static final String ATT_MESSAGES = "messages";
    public static final String VUE = "test";
    private static final String NOM = "helloworld.pdf";

    @Autowired
    TestService test;

//    @GetMapping("/testjdbc")
//    public String doGet(Model model) throws Exception {
//        List<String> messages = test.executerTests(model);
//
//
//        model.addAttribute(ATT_MESSAGES,messages);
//        return VUE;
//    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping("/testdto")
    public String testDto(Model model){

        return "test";
    }

    @SuppressWarnings("SameReturnValue")
    @PostMapping("/testdto")
    public String signUp(LivraisonForm livraisonForm, Model model){

        model.addAttribute("list", livraisonForm);

        return "test";
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping("/testPdf")
    public String imprimer(Model model) {
        DocumentMetier dm = new DocumentMetier();
        dm.creerEtiquettePalette("RFFFCCCX",LocalDate.now(),"BIO");
        //dm.impressionFichier(ConstantesUtil.getProperty(ConstExt.INPUT_PATH)+"empty.pdf", 7);
        //String[] str = dm.creerEtiquettePalette("RFFFCCCX",LocalDate.now());
        //System.out.println(str[0]);
        //dm.conversionDocxToPdf("C:\\Programmes_BLG\\document\\etiquettes\\RELRBIO02020-09-04.docx","C:\\Programmes_BLG\\document\\etiquettes\\pdf\\" );
        //dm.impressionFichier("C:\\Programmes_BLG\\document\\etiquettes\\RELRBIO02020-09-01.docx",1);
        //dm.impressionFichier("C:\\Programmes_BLG\\document\\etiquettes\\pdf\\RELRBIO02020-09-01.pdf",1);
        return "test";
    }

}
