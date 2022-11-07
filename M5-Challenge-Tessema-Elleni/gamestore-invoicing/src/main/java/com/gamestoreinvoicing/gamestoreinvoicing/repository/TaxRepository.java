package com.gamestoreinvoicing.gamestoreinvoicing.repository;

import com.gamestoreinvoicing.gamestoreinvoicing.model.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRepository extends JpaRepository<Tax, String> {
}