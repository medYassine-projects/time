package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseTest {
	@Autowired
	IEntrepriseService ie;

	@Test(timeout = 5000)
	public void ajouterEntrepriseTest() {
		Entreprise e = new Entreprise("test", "testtest");
		int idEntrprise = ie.ajouterEntreprise(e)  ;
		assertThat(idEntrprise).isGreaterThan(0);
		
	}

	@Test
	public void ajouterDepartementTest() {
		Departement d = new Departement("test");
		Assert.assertNotEquals(0, ie.ajouterDepartement(d));
		
	}

	@Test
	public void affecterDepartementAEntrepriseTest() {
		ie.affecterDepartementAEntreprise(6,10);
		
	}

	@Test
	public void getAllDepartementsNamesByEntreprise() {
		Assert.assertNotEquals(0 , ie.getAllDepartementsNamesByEntreprise(10).size());
	}

	@Test
	public void deleteEntrepriseById() {
		ie.deleteEntrepriseById(2);
	}

	@Test
	public void deleteDepartementById() {
		ie.deleteDepartementById(3);
	}

	

}