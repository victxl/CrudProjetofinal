package com.victxl.siteDeVendas.controllers;

import com.victxl.siteDeVendas.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SiteDeVendasController {

    @Autowired
    private ClienteRepository cr;
    @Autowired
    private EnderecoRepository er;
    @Autowired
    private ProdutoRepository pr;
    @Autowired
    private VendedorRepository vrr;
    @Autowired
    private VendaRepository vr;


    @RequestMapping ("/")
    public String index() {
        return "index";
    }


}
