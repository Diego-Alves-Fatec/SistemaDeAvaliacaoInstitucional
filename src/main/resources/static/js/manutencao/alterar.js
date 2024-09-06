function toggleOpcoes() {
    const tipoQuestao = document.getElementById('tipoQuestao').value;
    const opcoesAdicionais = document.getElementById('opcoes-adicionais');

    if (tipoQuestao === '2') {
        opcoesAdicionais.style.display = 'block';
        document.getElementById("num-opcoes").style.display = 'block';
        document.getElementById("tipoDeBotao").style.display = 'block';
        gerarOpcoes();
    } else {
        opcoesAdicionais.style.display = 'none';
        document.getElementById("num-opcoes").style.display = 'none';
        document.getElementById("tipoDeBotao").style.display = 'none';
        document.getElementById('opcoes-container').innerHTML = '';
    }
}

function gerarOpcoes() {

    let numOpcoes = document.getElementById('num-opcoes').value

    if ((numOpcoes < 2 || numOpcoes > 10) && (numOpcoes !== '' && numOpcoes != null)) {
        dispararAlerta();
    } else {
        const numOpcoes = Math.max(2, Math.min(10, parseInt(document.getElementById('num-opcoes').value) || 0));
        const opcoesContainer = document.getElementById('opcoes-container');

        opcoesContainer.innerHTML = '';

        for (let i = 0; i < numOpcoes; i++) {
            const input = document.createElement('input');
            input.type = 'text';
            input.className = 'opcao-input';
            input.placeholder = `Opção ${i + 1}`;
            input.name = `resposta${i + 1}`;
            opcoesContainer.appendChild(input);
        }
    }

}

function dispararAlerta() {
    var alert = document.getElementById('alertaCustomizado');

    var alertText = 'O valor deve ser no mínimo 2 e no máximo 10 opções';
    alert.innerText = alertText;
    alert.classList.remove('hidden');
    alert.classList.add('visible');


    setTimeout(function () {
        alert.classList.remove('visible');
        alert.classList.add('hidden');
    }, 5000);
}

function carregarQuestao() {

    const numeroQuestao = document.getElementById("numeroQuestao").value;
    const tipoAvaliacao = document.getElementById("tipoAvaliacao").value;

    if (numeroQuestao != null && numeroQuestao !== '' && tipoAvaliacao !== null && tipoAvaliacao !== '') {
        const dados = {numeroQuestao, tipoAvaliacao};

        fetch('/manutencao/carregar', {
            method: 'POST', headers: {
                'Content-Type': 'application/json',
            }, body: JSON.stringify(dados),
        })
            .then(response => response.json())
            .then(data => {
                carregaDados(data);
            })
            .catch((error) => {
                disparaErroAjax();
            });
    }
}

function carregaDados(data) {
    document.getElementById("categoriaQuestao").classList.remove('hidden');
    document.getElementById("tipoQuestao").classList.remove('hidden');
    document.getElementById("dsQuestao").classList.remove('hidden');
    document.getElementById("numeroQuestao").disabled = true;
    document.getElementById("tipoAvaliacao").disabled = true;

    document.getElementById("dsQuestao").innerHTML = data['questao-dsQuestao'];
    let questao = ["categoriaQuestao","tipoQuestao","tipoAvaliacao"];

    selecionarOpcao(questao[0],data);
    selecionarOpcao(questao[1],data);
    selecionarOpcao(questao[2],data);
    toggleOpcoes();

}

function selecionarOpcao(questao,data) {

    let selectElement = document.getElementById(questao);
    let valorSelecionado = data["questao-" + questao];

    for (var i = 0; i < selectElement.options.length; i++) {
        var option = selectElement.options[i];
        if (option.value === valorSelecionado) {
            option.selected = true;
            break;
        }
    }
}

function disparaErroAjax() {
    document.getElementById("numeroQuestao").classList.add('hidden');
    document.getElementById("tipoAvaliacao").classList.add('hidden');
    document.getElementById("erro").classList.remove('hidden');
    let form = document.getElementById("formulario");
    form.action = '/manutencao/exibirAlterar'
    form.method = 'GET';
    document.getElementById("botao-form").innerHTML = 'Voltar'
}

