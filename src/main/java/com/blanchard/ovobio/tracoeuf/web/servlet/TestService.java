package com.blanchard.ovobio.tracoeuf.web.servlet;

import io.swagger.annotations.Scope;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service(value="TestService")
public class TestService {

    @Autowired
    TestDao testDao;

    private List<String> messages = new ArrayList<>();
    public List<String> executerTests(Model model) {
        TestModel testModel = new TestModel();
        testModel.setEmail("jmarc@mail.fr");
        testModel.setMotDePasse("lavieestbelle");
        testModel.setNomUtilisateur("jean-marc");
        testModel.setDateInscription(LocalDateTime.now());
        testDao.save(testModel);
        Iterable<TestModel> testList = testDao.findAll();
        for(Iterator i = testList.iterator();i.hasNext();){
            TestModel test = (TestModel) i.next();
            String email = test.getEmail();
            String mdp = test.getMotDePasse();
            String nom = test.getNomUtilisateur();

            messages.add(email + " | "+mdp+" | "+nom);
        }
        return messages;
    }
}
