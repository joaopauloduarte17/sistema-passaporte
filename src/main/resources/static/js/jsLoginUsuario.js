    $("#frmLogin").submit(function(event){
        event.preventDefault();

        let login = {
            cpf: $("#cpf").val(),
            senha: $("#senha").val()
        };

        $.ajax({
            url: "/sistema-passaporte/usuarios/login",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(login),

            success: function(usuario){
                sessionStorage.setItem("usuarioLogadoId", usuario.id);
                sessionStorage.setItem("nomeUsuario", usuario.nome);

                window.location.href = "perfilPassaporte.html";
            },

            error: function(xhr){
                alert(xhr.responseText);
            }


        });

    });