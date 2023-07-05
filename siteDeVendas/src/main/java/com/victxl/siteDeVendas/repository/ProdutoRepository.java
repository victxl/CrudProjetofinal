package com.victxl.siteDeVendas.repository;

import com.victxl.siteDeVendas.models.Cliente;
import com.victxl.siteDeVendas.models.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {


    Produto findByidProduto(long idProduto);
    Produto deleteByidProduto(long idProduto);
}
