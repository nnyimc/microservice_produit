package fr.nnyimc.microservice_produit;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.plugin.core.PluginRegistry;

import com.fasterxml.classmate.TypeResolver;

import fr.nnyimc.microservice_produit.dao.ProduitRepository;
import fr.nnyimc.microservice_produit.entities.Produit;
import springfox.documentation.schema.TypeNameExtractor;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.DescriptionResolver;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Import({SpringDataRestConfiguration.class})
public class MicroserviceProduitApplication implements ApplicationRunner{
	private ProduitRepository produitRepository;
	
	public MicroserviceProduitApplication(ProduitRepository produitRepository) {
		this.produitRepository = produitRepository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProduitApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Produit p1 = (Produit) Class.forName("fr.nnyimc.microservice_produit.entities.Produit").newInstance();
		p1.setDesignation("Borealis");
		p1.setPrix(352.29f);
		produitRepository.save(p1);
		
		Produit p2 = (Produit) Class.forName("fr.nnyimc.microservice_produit.entities.Produit").newInstance();
		p2.setDesignation("Australasia");
		p2.setPrix(682.29f);
		produitRepository.save(p2);
		
		Produit p3 = (Produit) Class.forName("fr.nnyimc.microservice_produit.entities.Produit").newInstance();
		p3.setDesignation("La Favière");
		p3.setPrix(402.29f);
		produitRepository.save(p3);
	}

}