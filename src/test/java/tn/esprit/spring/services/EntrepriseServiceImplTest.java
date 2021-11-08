package tn.esprit.spring.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Departement;

import java.text.ParseException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseServiceImplTest {
    @Autowired
    IEntrepriseService es;
   // private static final Logger l = LogManager.getLogger(EntrepriseServiceImplTest.class);

    @Test
    public void ajouterDepartement() throws ParseException {
        Departement d = new Departement("test");
        es.ajouterDepartement(d);
    }
}