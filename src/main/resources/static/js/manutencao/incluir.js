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
            input.name = `flag${i + 1}`;
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

