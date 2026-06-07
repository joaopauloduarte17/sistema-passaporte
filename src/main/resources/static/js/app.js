    $(document).ready(function(){
        if(typeof M !== "undefined"){
            M.Modal.init(document.querySelectorAll('.modal'));
            M.FormSelect.init(document.querySelectorAll('select'));
            M.updateTextFields();
        }
    });

    console.log("Método:", metodo);
    console.log("URL:", urlFinal);

    function enviarDados(url, dados, callbackSucesso, metodo = "POST") {
        $.ajax({
            type: metodo,
            url: url,
            data: JSON.stringify(dados),
            contentType: "application/json",
            success: function(resposta) {
                if (callbackSucesso) callbackSucesso(resposta);
            },
            error: function(xhr) {
                console.error(xhr);
                exibirMensagem(xhr.responseText || "Erro ao processar requisição.");
            }
        });
    }

    function exibirMensagem(msg) {
        if(typeof M !== "undefined") {
            M.toast({
                html: msg,
                classes: "rounded blue darken-3",
                displayLength: 4000
            });
        } else {
            alert(msg);
        }
    }