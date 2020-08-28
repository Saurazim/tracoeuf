package com.blanchard.ovobio.tracoeuf.controller;

import com.blanchard.ovobio.tracoeuf.dao.ProductDao;
import com.blanchard.ovobio.tracoeuf.model.Product;
import com.blanchard.ovobio.tracoeuf.exceptions.ProduitIntrouvableException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * TODO controller test
 * sert de référence
 */
@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;

    /**
     * récupère la liste des produits
     *
     * @return produits filtrés*/
    @RequestMapping(value="/Produits", method= RequestMethod.GET)
    public MappingJacksonValue listeProduits(){
         Iterable<Product> produits = productDao.findAll();

        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("prixAchat");

        FilterProvider listeFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);

        MappingJacksonValue produitsFiltres = new MappingJacksonValue(produits);

        produitsFiltres.setFilters(listeFiltres);

        return produitsFiltres;
    }

    /**
     * produit par id
     * @param id id du produit
     * @return un produit
     */
    @GetMapping(value="/Produits/{id}")
    public Product afficherUnProduit(@PathVariable int id) {
        Product produit = productDao.findById(id);
        if (produit==null)
            throw new ProduitIntrouvableException("le produit n°"+id+" est INTROUVABLE.");

        return produit;
    }

//    @GetMapping("test/{prixLimite}")
//    public List<Product> testRequetes(@PathVariable int prixLimite){
//        return productDao.findByPrixGreaterThan(prixLimite);
//    }

//    @GetMapping("test/{recherche}")
//    public List<Product> testRequete(@PathVariable String recherche){
//        return productDao.findByNomLike("%"+recherche+"%");
//    }

    /**
     * ajout d'un produit
     * @param product le produit défini
     * @return
     */
    @PostMapping(value = "/Produits")
    public ResponseEntity<Void> ajouterProduits(@Valid @RequestBody Product product){
        Product productAdded = productDao.save(product);

        if (productAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/Produits/{id}")
    public void supprimerProduit(@PathVariable int id){
        productDao.deleteById(id);
    }

    @PutMapping("/Produits")
    public void updateProduit(@RequestBody Product product) {
        productDao.save(product);
    }

    @PostMapping("/retour")
    public Map<String,Object> retour(Map<String, Object> payload){
        return payload;
    }
//    @GetMapping("/test/{prixLimite}")
//    public List<Product> chercherProduitPlusCher(@PathVariable int prixLimite) {
//        List<Product> productList = productDao.chercherProduitPlusCher(prixLimite);
//        return productList;
//    }
}
