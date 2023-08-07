package com.victxl.siteDeVendas.repository;

import com.victxl.siteDeVendas.models.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, String> {

    Cliente findByIdCliente(long idCliente);
    Cliente deleteByIdCliente(long idCliente);
}
