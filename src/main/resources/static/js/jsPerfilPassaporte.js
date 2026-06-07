const URL_PERFIL = "/sistema-passaporte/perfil-passaporte";

$(document).ready(function () {
    console.log("JS do Perfil Passaporte carregou");

    M.Datepicker.init(document.querySelectorAll('.datepicker'), {
        format: 'yyyy-mm-dd'
    });

    listarPerfisDoUsuario();

    $("#frmPerfilPassaporte").submit(function(event) {
        event.preventDefault();
        salvarPerfil();
    });
});

function salvarPerfil() {
    console.log($("#id").val());
    const usuarioId = sessionStorage.getItem("usuarioLogadoId");
    const id = $("#id").val();

    const perfil = {
        nome: $("#nome").val(),
        descricao: $("#descricao").val(),
        versao: $("#versao").val(),
        dataPublicado: $("#dataPublicado").val(),
        ativo: $("#ativo").is(":checked"),
        usuarioId: parseInt(usuarioId)
    };

    const metodo = id ? "PUT" : "POST";
    const urlFinal = id ? `${URL_PERFIL}/${id}` : URL_PERFIL;

    console.log("Método:", metodo);
    console.log("URL:", urlFinal);

    enviarDados(urlFinal, perfil, function() {
        exibirMensagem("Perfil salvo com sucesso!");
        limparFormularioPerfil();
        listarPerfisDoUsuario();
    }, metodo);
}

function listarPerfisDoUsuario() {
    const usuarioId = sessionStorage.getItem("usuarioLogadoId");

    if (!usuarioId) {
        exibirMensagem("Usuário não está logado.");
        return;
    }

    $.get(`${URL_PERFIL}/usuario/${usuarioId}`, function(lista) {
        $("#listaPerfis").html(gerarTabelaPerfis(lista));
    }).fail(function() {
        exibirMensagem("Erro ao carregar perfis.");
    });
}

function prepararEdicao(id) {
    $.get(`${URL_PERFIL}/${id}`, function(perfil) {
        $("#id").val(perfil.id);
        $("#nome").val(perfil.nome);
        $("#descricao").val(perfil.descricao);
        $("#versao").val(perfil.versao);
        $("#dataPublicado").val(perfil.publicado);
        $("#ativo").prop("checked", perfil.ativo);

        M.updateTextFields();

        window.scrollTo({ top: 0, behavior: "smooth" });
    });
}

function gerarTabelaPerfis(lista) {
    if (!lista || lista.length === 0) {
        return "<p>Nenhum perfil cadastrado por este usuário.</p>";
    }

    let html = `
        <table class="highlight responsive-table">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Descrição</th>
                    <th>Versão</th>
                    <th>Data</th>
                    <th>Ativo</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
    `;

    lista.forEach(perfil => {
        html += `
            <tr>
                <td>${perfil.nome}</td>
                <td>${perfil.descricao}</td>
                <td>${perfil.versao}</td>
                <td>${perfil.publicado || ""}</td>
                <td>${perfil.ativo ? "Sim" : "Não"}</td>
                <td>
                  <a class="btn-flat" onclick="prepararEdicao(${perfil.id})">
                          <i class="material-icons blue-text">edit</i>
                  </a>
                </td>
            </tr>
        `;
    });

    html += `
            </tbody>
        </table>
    `;

    return html;
}

function limparFormularioPerfil() {
    $("#frmPerfilPassaporte")[0].reset();

    if (typeof M !== "undefined") {
        M.updateTextFields();
    }
}


