package com.blanchard.ovobio.tracoeuf.web.servlet;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


@Service(value="TestService")
public class TestService {

    @Autowired
    TestDao testDao;

    private final List<String> messages = new ArrayList<>();
    public List<String> executerTests(Model model) {
        TestModel testModel = new TestModel();
        testModel.setEmail("jmarc@mail.fr");
        testModel.setMotDePasse("lavieestbelle");
        testModel.setNomUtilisateur("jean-marc");
        testModel.setDateInscription(LocalDateTime.now());
        testDao.save(testModel);
        Iterable<TestModel> testList = testDao.findAll();
        for(TestModel test : testList){
            String email = test.getEmail();
            String mdp = test.getMotDePasse();
            String nom = test.getNomUtilisateur();

            messages.add(email + " | "+mdp+" | "+nom);
        }
        return messages;
    }
}
