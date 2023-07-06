
    $(document).ready(function() {
    // Exibe ou oculta os campos de CNPJ e CPF com base no tipo de cliente selecionado
    $("#tipo").change(function() {
        var selectedValue = $(this).val();
        if (selectedValue === "J") {
            $("#cnpj-group").show();
            $("#cpf-group").hide();
        } else if (selectedValue === "F") {
            $("#cpf-group").show();
            $("#cnpj-group").hide();
        } else {
            $("#cpf-group").show();
            $("#cnpj-group").hide();
        }
    });
});


//cep

    const pesquisaCep = document.getElementById('cep');

    const limpaformulario = ()=> {


        document.getElementById('uf').value = '';
        document.getElementById('cidade').value = '';
        document.getElementById('bairro').value = '';
        document.getElementById('logradouro').value = '';

    };

    window.meuCallback = function(conteudo) {
        if (!('erro' in conteudo)) {
            document.getElementById('uf').value = conteudo.uf;
            document.getElementById('cidade').value = conteudo.localidade;
            document.getElementById('bairro').value = conteudo.bairro;
            document.getElementById('logradouro').value = conteudo.logradouro;
        } else {
            limpaformulario();
            alert('CEP não encontrado');
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
