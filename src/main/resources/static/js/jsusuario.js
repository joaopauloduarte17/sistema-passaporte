//Ativando o elemento do Select
document.addEventListener('DOMContentLoaded', function () {
    var elems = document.querySelectorAll('select');
    var instances = M.FormSelect.init(elems); 
});

//Enviando a Requisição para Salvar no banco
const URL_USUARIO = "/sistema-passaporte/usuarios";

$(document).ready(function() {
    $("#frmUsuario").submit(function(event) {
        event.preventDefault();
        salvarUsuario();
    });
});

function salvarUsuario() {

    const usuario = {
        nome: $("#nome").val(),
        cpf: $("#cpf").val(),
        senha: $("#senha").val(),
        tipoUsuario: $("#tipoUsuario").val()
    };

    enviarDados(URL_USUARIO, usuario, function() {

        exibirMensagem("Usuário cadastrado com sucesso!");

        limparFormularioUsuario();
    });
}

function limparFormularioUsuario() {

    $("#frmUsuario")[0].reset();

    if(typeof M !== "undefined") {
        M.updateTextFields();

        $('select').formSelect();
    }
}

