package com.victxl.siteDeVendas.controllers;

import com.victxl.siteDeVendas.models.*;
import com.victxl.siteDeVendas.repository.*;

import ch.qos.logback.core.model.Model;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping("/")
    public String index() {
        return "index";
    }


// --------------------------------------Controller Cliente -------------------------------------------------


    @RequestMapping(value = "/cadastroCliente", method = RequestMethod.GET)

    public String cadastroCliente() {
        return "cadastroCliente";
    }

    @RequestMapping(value = "/cadastroCliente", method = RequestMethod.POST)
    public String cadastroCliente(@ModelAttribute("cliente") Cliente cliente,
                                  @ModelAttribute("endereco") Endereco endereco,
                                  Model model) {
        // Configurar a associação entre Cliente e Endereco
        cliente.setEndereco(endereco);


        // Salvar o Endereco primeiro, se necessário
        if (endereco.getIdEndereco() == null) {
            er.save(endereco);
        }

        // Salvar o Cliente
        cr.save(cliente);

        return "redirect:/cadastroCliente";
    }

    @RequestMapping("/listarCliente")
    public ModelAndView listarCliente() {
        ModelAndView mav = new ModelAndView("listarCliente");

        Iterable<Cliente> clientes = cr.findAll();
        mav.addObject("clientes", clientes);

        return mav;
    }

    @RequestMapping(value = "/alterarCliente/{idCliente}", method = RequestMethod.GET)
    public ModelAndView formAlterarCliente(@PathVariable("idCliente") long idCliente) {

        Cliente cliente = cr.findByIdCliente(idCliente);

        ModelAndView mav = new ModelAndView("alterarCliente");

        mav.addObject("cliente", cliente);

        return mav;

    }

    @RequestMapping(value = "/alterarCliente/{idCliente}", method = RequestMethod.POST)
    public String alterarCliente(@ModelAttribute("cliente") Cliente cliente,
                                 @ModelAttribute("endereco") Endereco endereco,
                                 BindingResult result,
                                 @PathVariable("idCliente") long idCliente) {
        if (result.hasErrors()) {
            // Lidar com erros de validação, se houver
            return "seu-formulario-de-atualizacao";
        }

        // Buscar o cliente existente
        Cliente clienteExistente = cr.findByIdCliente(idCliente);

        // Atualizar os campos do cliente existente com os novos valores do cliente recebido
        clienteExistente.setNome(cliente.getNome());
        clienteExistente.setEmail(cliente.getEmail());
        clienteExistente.setCpf(cliente.getCpf());
        clienteExistente.setTelefone(cliente.getTelefone());

        // Atualizar o endereço existente com os novos valores do endereço recebido
        Endereco enderecoExistente = clienteExistente.getEndereco();
        enderecoExistente.setCep(endereco.getCep());
        enderecoExistente.setCidade(endereco.getCidade());
        enderecoExistente.setEstado(endereco.getEstado());
        enderecoExistente.setBairro(endereco.getBairro());
        enderecoExistente.setComplemento(endereco.getComplemento());
        enderecoExistente.setNumero(endereco.getNumero());

        // Salvar as alterações
        er.save(enderecoExistente); // Salvar primeiro o endereço
        cr.save(clienteExistente);   // Salvar o cliente com o endereço atualizado

        // Redirecionar após a atualização
        return "redirect:/listarCliente";
    }


    @RequestMapping("/excluirCliente")
    public String excluirCliente(long idCliente) {

        Cliente cliente = cr.findByIdCliente(idCliente);
        Endereco endereco = cliente.getEndereco();
        cr.delete(cliente);
        er.delete(endereco);

        return "redirect:/listarCliente";

    }
// -------------------------------------- Fim Controller Cliente -------------------------------------------------

// --------------------------------------Controller Vendedor -------------------------------------------------

    @RequestMapping(value = "/cadastroVendedor", method = RequestMethod.GET)
    public String cadastroVendedor() {
        return "cadastroVendedor";
    }


    @RequestMapping(value = "/cadastroVendedor", method = RequestMethod.POST)
    public String cadastroVendedor(Vendedor vendedor) {
        vrr.save(vendedor);
        return "redirect:/";
    }

    @RequestMapping("/listarVendedor")
    public ModelAndView listarVendedor() {
        ModelAndView mav = new ModelAndView("listarVendedor");

        Iterable<Vendedor> vendedores = vrr.findAll();
        mav.addObject("vendedores", vendedores);

        return mav;
    }

    @RequestMapping(value = "/alterarVendedor/{idVendedor}", method = RequestMethod.GET)
    public ModelAndView formAlterarVendedor(@PathVariable("idVendedor") long idVendedor) {

        Vendedor vendedor = vrr.findByIdVendedor(idVendedor);

        ModelAndView mav = new ModelAndView("alterarVendedor");

        mav.addObject("vendedor", vendedor);

        return mav;
    }


    @RequestMapping(value = "/alterarVendedor/{idVendedor}", method = RequestMethod.POST)
    public String alterarVendedor(@Validated Vendedor vendedor, BindingResult result, RedirectAttributes attributes) {

        vrr.save(vendedor);

        return "redirect:/listarVendedor";
    }

    @RequestMapping("/excluirVendedor")
    public String excluirVendedor(long idVendedor) {

        Vendedor vendedor = vrr.findByIdVendedor(idVendedor);
        vrr.delete(vendedor);

        return "redirect:/listarVendedor";

    }


    // --------------------------------------Fim Controller Cliente -------------------------------------------------

    // --------------------------------------Controller Produto -------------------------------------------------


    @RequestMapping(value = "/cadastroProduto", method = RequestMethod.GET)
    public String cadastroProduto() {
        return "cadastroProduto";
    }

    @RequestMapping(value = "/cadastroProduto", method = RequestMethod.POST)
    public String cadastroProduto(Produto produto) {

        pr.save(produto);
        return "redirect:/cadastroProduto";
    }

    @RequestMapping("/listarProduto")
    public ModelAndView listarProduto() {
        ModelAndView mav = new ModelAndView("listarProduto");

        Iterable<Produto> produtos = pr.findAll();
        mav.addObject("produtos", produtos);

        return mav;
    }

    @RequestMapping(value = "/alterarProduto/{idProduto}", method = RequestMethod.GET)
    public ModelAndView formAlterarProduto(@PathVariable("idProduto") long idProduto) {

        Produto produto = pr.findByidProduto(idProduto);

        ModelAndView mav = new ModelAndView("alterarProduto");

        mav.addObject("produto", produto);

        return mav;
    }


    @RequestMapping(value = "/alterarProduto/{idProduto}", method = RequestMethod.POST)
    public String alterarProduto(@Validated Produto produto, BindingResult result, RedirectAttributes attributes) {

        pr.save(produto);

        return "redirect:/listarProduto";
    }

    @RequestMapping("/excluirProduto")
    public String excluirProduto(long idProduto) {

        Produto produto = pr.findByidProduto(idProduto);
        pr.delete(produto);

        return "redirect:/listarProduto";

    }


// -------------------------------------- FIM Controller Cliente -------------------------------------------------

    // --------------------------------------  Controller Venda -------------------------------------------------


    @RequestMapping(value = "/cadastroVenda", method = RequestMethod.GET)

    public ModelAndView cadastroVenda() {
        ModelAndView mav = new ModelAndView("cadastroVenda");

        Iterable<Venda> vendas = vr.findAll();
        mav.addObject("vendas", vendas);

        Iterable<Cliente> clientes = cr.findAll();
        mav.addObject("clientes", clientes);

        Iterable<Produto> produtos = pr.findAll();
        mav.addObject("produtos", produtos);



        return mav;
    }

    @RequestMapping(value = "/cadastroVenda", method = RequestMethod.POST)
    public String cadastroVenda(@ModelAttribute("venda") Venda venda,
                                @ModelAttribute("endereco") Endereco endereco,
                                @ModelAttribute("cliente") Cliente cliente,

                                Model model) {


//        if (venda.getCliente() != null) {
//            venda.setCliente(cr.findById(venda.getCliente().getIdCliente()).orElse(null));
//        }

        if (venda.getEndereco() != null) {
            venda.setEndereco(er.findById(venda.getEndereco().getIdEndereco()).orElse(null));
        }

        if (venda.getVendedor() != null) {
            venda.setVendedor(vrr.findById(venda.getVendedor().getIdVendedor()).orElse(null));
        }




        vr.save(venda);
        return "redirect:/";
    }

    @RequestMapping("/listarVenda")
    public ModelAndView listarVenda() {
        ModelAndView mav = new ModelAndView("listarVenda");

        Iterable<Venda> vendas = vr.findAll();
        mav.addObject("vendas", vendas);

        return mav;
    }

    @RequestMapping(value = "/alterarVenda/{idVenda}", method = RequestMethod.GET)
    public ModelAndView formAlterarVenda(@PathVariable("idVenda") long idVenda) {
        Venda venda = vr.findByidVenda(idVenda);

        ModelAndView mav = new ModelAndView("alterarVenda");
        mav.addObject("venda", venda);

        return mav;
    }

    @RequestMapping(value = "/alterarVenda/{idVenda}", method = RequestMethod.POST)
    public String alterarVenda(@Validated Venda venda, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            // Lidar com erros de validação, se houver
            return "seu-formulario-de-atualizacao";
        }

        // Configurar a associação entre Venda, Cliente, Endereco e Vendedor

       // venda.setCliente(cr.findById(venda.getCliente().getIdCliente()).orElse(null));
        venda.setEndereco(er.findById(venda.getEndereco().getIdEndereco()).orElse(null));
        venda.setVendedor(vrr.findById(venda.getVendedor().getIdVendedor()).orElse(null));

        vr.save(venda);

        return "redirect:/listarVenda";
    }

    @RequestMapping("/excluirVenda")
    public String excluirVenda(long idVenda) {
        Venda venda = vr.findByidVenda(idVenda);
        vr.delete(venda);

        return "redirect:/listarVenda";
    }


}


