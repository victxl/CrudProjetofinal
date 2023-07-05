package com.victxl.siteDeVendas.repository;

import com.victxl.siteDeVendas.models.Cliente;
import com.victxl.siteDeVendas.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    Endereco findByidEndereco(long idEndereco);
    Endereco deleteByidEndereco(long idEndereco);
}


