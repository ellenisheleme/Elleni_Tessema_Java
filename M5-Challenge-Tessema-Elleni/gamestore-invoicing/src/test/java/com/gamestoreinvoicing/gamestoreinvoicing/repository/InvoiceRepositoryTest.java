package com.gamestoreinvoicing.gamestoreinvoicing.repository;

import com.gamestoreinvoicing.gamestoreinvoicing.model.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceRepositoryTest {

    //Based on class activity done with Dan
    @Autowired
    InvoiceRepository invoiceRepository;

    private Invoice invoice;

    @Before
    public void setUp() throws Exception {

        invoice = new Invoice();
        invoice.setName("Customer 1");
        invoice.setStreet("100 Main Street");
        invoice.setCity("Clovis");
        invoice.setState("CA");
        invoice.setZipcode("93612");
        invoice.setItemType("Game");
        invoice.setItemId(269);
        invoice.setQuantity(12);
        invoice.setUnitPrice(new BigDecimal("12.99"));
        invoice.setSubtotal(new BigDecimal("155.88"));
        invoice.setTax(new BigDecimal("9.35"));
        invoice.setProcessingFee(new BigDecimal("16.98"));
        invoice.setTotal(new BigDecimal("182.21"));

    }

    @Test
    public void ShouldSaveInvoiceToTheDataBaseAndTheInvoice() {

        invoice = invoiceRepository.save(invoice);

        Invoice newInvoice = invoiceRepository.findById(invoice.getId()).get();

        //invoice I put should be same as invoice I get
        assertEquals(newInvoice, invoice);

        //delete invoice
        invoiceRepository.deleteById(invoice.getId());

        //check the invoice is deleted

        Optional<Invoice> deletedInvoice = invoiceRepository.findById(invoice.getId());

        //confirm it's gone
        assertEquals(false, deletedInvoice.isPresent());

    }


}