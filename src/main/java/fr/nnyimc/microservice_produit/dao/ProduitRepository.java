package fr.nnyimc.microservice_produit.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.nnyimc.microservice_produit.entities.Produit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Produit Entity")
@RepositoryRestResource(collectionResourceRel = "assur3000", path = "assur3000")
public interface ProduitRepository extends PagingAndSortingRepository<Produit, Long> {
	
	@ApiOperation("Récupérer les produits à partir de leur désignation")
	Page<Produit> findByDesignation(@Param("designation") String designation, Pageable pageable);
	
	@ApiOperation("Récupérer les produits à partir de leur prix")
	Page<Produit> findByPrixLessThanEqual(@Param("prix") float prix, Pageable pageable);
}
