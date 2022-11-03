package com.gameStoreInvoicing.gamestoreinvoicing.repository;

import com.gameStoreInvoicing.gamestoreinvoicing.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


    public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
        List<Invoice> findByName(String name);
}
