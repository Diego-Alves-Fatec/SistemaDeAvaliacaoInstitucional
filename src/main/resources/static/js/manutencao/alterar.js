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
    let numOpcoes = parseInt(document.getElementById('num-opcoes').value);

    if ((numOpcoes < 2 || numOpcoes > 10) && (numOpcoes !== '' && numOpcoes != null)) {
        dispararAlerta();
    } else {
        const opcoesContainer = document.getElementById('opcoes-container');
        const inputsExistentes = opcoesContainer.querySelectorAll('.opcao-input').length;

        if (numOpcoes > inputsExistentes) {
            for (let i = inputsExistentes; i < numOpcoes; i++) {
                let input = document.createElement('input');
                input.type = 'text';
                input.className = 'opcao-input';
                input.placeholder = `Opção ${i + 1}`;
                input.name = `resposta${i + inputsExistentes}`;
                opcoesContainer.appendChild(input);
            }
        }

        else if (numOpcoes < inputsExistentes) {
            for (let i = inputsExistentes; i > numOpcoes; i--) {
                const lastInput = opcoesContainer.querySelector('.opcao-input:last-of-type');
                if (lastInput) {
                    lastInput.remove();
                }
            }
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

        document.getElementById("formulario").submit();
    }
}




