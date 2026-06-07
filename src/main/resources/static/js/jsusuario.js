//Ativando o elemento do Select
document.addEventListener('DOMContentLoaded', function () {
    var elems = document.querySelectorAll('select');
    var instances = M.FormSelect.init(elems); 
});

//Enviando a Requisição para Salvar no banco
$("#frmUsuario").submit(function(event) {
    event.preventDefault();

    let usuario = {
        nome: $("#nome").val(),
        cpf: $("#cpf").val(),
        email: $("#email").val(),
        senha: $("#senha").val(),
        tipoUsuario: $("#tipoUsuario").val()
    };

    console.log(usuario);
    console.log(JSON.stringify(usuario));

    $.ajax({
        url: "usuarios",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(usuario),
        success: function(resposta){
            alert("Usuário cadastrado com sucesso!");

            $("#frmUsuario")[0].reset();

            $("#frmUsuario label").removeClass("active");

            $("select").formSelect();
        },
        error: function(){
            alert("Erro ao cadastrar usuário.");
        }
    });
});

