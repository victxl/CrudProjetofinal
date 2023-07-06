package com.victxl.siteDeVendas.controllers;

import com.victxl.siteDeVendas.models.Cliente;
import com.victxl.siteDeVendas.models.Vendedor;
import com.victxl.siteDeVendas.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping(value = "/cadastroCliente", method = RequestMethod.GET)
    public String cadastroCliente(){
        return "cadastroCliente";
    }

    @RequestMapping (value = "/cadastroCliente",method = RequestMethod.POST)
    public  String cadastroCliente(Cliente cliente){
        cr.save(cliente);
        return "redirect:/";
    }


    @RequestMapping("/listarCliente")
    public ModelAndView listarCliente() {

        ModelAndView mv = new ModelAndView("listarCliente");

        Iterable<Cliente> clientes = cr.findAll();
        mv.addObject("cliente", clientes);

        return mv;
    }

    @RequestMapping(value="/alterarCliente/{codigoCliente}", method=RequestMethod.POST)
    public String alterarCliente(@Validated Cliente cliente, BindingResult result, RedirectAttributes attributes) {

        cr.save(cliente);

        return "redirect:/listarClientes";

    }

    @RequestMapping("/excluirCliente")
    public String excluirCliente(long idCliente) {

        Cliente cliente = cr.findByIdCliente(idCliente);
        cr.delete(cliente);

        return "redirect:/listarClientes";

    }




    @RequestMapping(value = "/cadastroVendedor",method = RequestMethod.GET)
    public  String cadastroVendedor(){
        return "cadastroVendedor";
    }

    @RequestMapping(value = "/cadastroVendedor",method = RequestMethod.POST)
    public  String cadastroVendedor(Vendedor vendedor) {


        vrr.save(vendedor);
        return "redirect:/";
    }
}

