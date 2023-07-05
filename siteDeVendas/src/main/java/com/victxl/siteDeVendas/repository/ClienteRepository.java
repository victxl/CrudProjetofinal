package com.victxl.siteDeVendas.repository;

import com.victxl.siteDeVendas.models.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, String> {

    Cliente findByidCliente(long idCliente);
    Cliente deleteByidCliente(long idCliente);
}
