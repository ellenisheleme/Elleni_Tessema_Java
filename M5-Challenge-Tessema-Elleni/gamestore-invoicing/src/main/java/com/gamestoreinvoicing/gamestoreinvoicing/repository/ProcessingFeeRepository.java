package com.gamestoreinvoicing.gamestoreinvoicing.repository;

import com.gamestoreinvoicing.gamestoreinvoicing.model.ProcessingFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessingFeeRepository extends JpaRepository<ProcessingFee, String> {
}
