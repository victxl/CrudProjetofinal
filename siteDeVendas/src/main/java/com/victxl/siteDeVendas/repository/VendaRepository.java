package com.victxl.siteDeVendas.repository;

import com.victxl.siteDeVendas.models.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

    Venda findByidVenda(long idVenda);
    Venda deleteByidVenda(long idVenda);
}


