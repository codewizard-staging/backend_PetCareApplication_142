package com.app.PetCareApplication.repository;

import com.app.PetCareApplication.model.Document;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class DocumentRepository extends SimpleJpaRepository<Document, String> {
    private final EntityManager em;
    public DocumentRepository(EntityManager em) {
        super(Document.class, em);
        this.em = em;
    }
    @Override
    public List<Document> findAll() {
        return em.createNativeQuery("Select * from \"petcareapplication_419\".\"Document\"", Document.class).getResultList();
    }
}