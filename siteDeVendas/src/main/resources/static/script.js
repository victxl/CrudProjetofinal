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
            $("#cpf-group").hide();
            $("#cnpj-group").hide();
        }
    });
});
