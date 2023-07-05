package com.victxl.siteDeVendas.repository;

import com.victxl.siteDeVendas.models.Vendedor;
import org.springframework.data.repository.CrudRepository;

public interface VendedorRepository extends CrudRepository<Vendedor, Long> {

    Vendedor findByIdVendedor(long idVendedor);
    Vendedor deleteByIdVendedor(long idVendedor);
}
