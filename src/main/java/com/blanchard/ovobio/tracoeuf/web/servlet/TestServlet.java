package com.blanchard.ovobio.tracoeuf.web.servlet;

import com.blanchard.ovobio.tracoeuf.constantes.ConstExt;
import com.blanchard.ovobio.tracoeuf.docxWriter.DocxCreater;
import com.blanchard.ovobio.tracoeuf.dto.LivraisonForm;
import com.blanchard.ovobio.tracoeuf.printer.Printer;
import com.blanchard.ovobio.tracoeuf.template.TemplatePalette;
import com.blanchard.ovobio.tracoeuf.util.ConstantesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;
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

    @GetMapping("/testdto")
    public String testDto(Model model){

        return "test";
    }

    @PostMapping("/testdto")
    public String signUp(LivraisonForm livraisonForm, Model model){

        model.addAttribute("list", livraisonForm);

        return "test";
    }


    @GetMapping("/testPdf")
    public String imprimer(Model model){
        DocxCreater pc = new DocxCreater();
        pc.creerEtiquettePalette(new TemplatePalette("RFFFCCCX", LocalDate.now()));
        File file = new File(ConstantesUtil.getProperty(ConstExt.OUTPUT_PATH)+"essai1.docx");
        new Printer().imprimer(file,1);
        return "test";
    }

}
