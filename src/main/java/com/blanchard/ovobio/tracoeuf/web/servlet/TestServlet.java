package com.blanchard.ovobio.tracoeuf.web.servlet;

import com.blanchard.ovobio.tracoeuf.PdfWriter.PdfCreater;
import com.blanchard.ovobio.tracoeuf.dto.LivraisonForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;
import java.util.List;

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
    public String imprimer(Model model) throws Exception{
        PdfCreater pc = new PdfCreater();
        pc.createPdf(NOM);
        return "test";
    }

}
