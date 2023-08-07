function alternarMostrarSenha() {
    var senhaInput = document.getElementById("senha");

    if (senhaInput.type === "password") {
        senhaInput.type = "text";
        mostrarSenhaBtn.textContent = "Ocultar";
    } else {
        senhaInput.type = "password";
        mostrarSenhaBtn.textContent = "Mostrar";
    }
}


$(document).ready(function() {
    $('#produto').change(function() {
        var selectedProductId = $(this).val();

        // Fazer uma solicitação AJAX para buscar a quantidade em estoque do produto
        $.ajax({
            type: 'GET',
            url: '/getQuantidadeEmEstoque/' + selectedProductId, // Endpoint apropriado
            success: function(response) {
                $('#quantidadeEstoque').text(response); // Atualizar o elemento de exibição da quantidade em estoque
            }
        });
    });
});




//CEP
  const pesquisaCep = document.getElementById('cep');

  const limpaformulario = ()=> {
  
  
  document.getElementById('uf').value = '';
  document.getElementById('cidade').value = '';
  document.getElementById('bairro').value = '';
  document.getElementById('logradouro').value = '';
   
  };
  
  const meuCallback = (conteudo) => {
  
      if (!('erro'in conteudo)) {
  
              document.getElementById('uf').value = (conteudo.uf);
              document.getElementById('cidade').value = (conteudo.localidade);
              document.getElementById('bairro').value = (conteudo.bairro);
              document.getElementById('logradouro').value = (conteudo.logradouro);
  
      }
      else {
          limpaformulario();
          alert('CEP não encontrado')
  
      }
  
  
  
  
  };
  
  pesquisaCep.addEventListener('blur',()=>{
      let cep = pesquisaCep.value.replace(/\D/g,'');
      
      if (cep != "") {
                  // validada o codigo [0-9] pode digitar somente numero {8} quantidade de casa
          let validacep = /^[0-9]{8}$/;
          
          if (validacep.test(cep)) {
  
              
              let script = document.createElement('script');
  
  
              script.src = 'https://viacep.com.br/ws/'+ cep + '/json/?callback=meuCallback';
  
              document.body.appendChild(script);
              
          }
          else{
              limpaformulario();
              alert('CEP INVALIDO.')
          }
  
          
      }
      else{
          limpaformulario();
      }
  
  
  });

  


  

