package br.gov.sp.etec.financiamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.gov.sp.etec.financiamento.model.Intent;


public interface FinanciamentoRepository extends JpaRepository<Intent, Long> {
	

}
