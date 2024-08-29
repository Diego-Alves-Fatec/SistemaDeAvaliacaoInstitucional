function toggleOptions() {
    const questionType = document.getElementById('tipoQuestao').value;
    const additionalOptions = document.getElementById('opcoes-adicionais');

    if (questionType === '2') {
        additionalOptions.style.display = 'block';
        document.getElementById("num-opcoes").style.display = 'block';
        generateOptions();
    } else {
        additionalOptions.style.display = 'none';
        document.getElementById("num-opcoes").style.display = 'none';
        document.getElementById('opcoes-container').innerHTML = '';
    }
}

function generateOptions() {
    const numOptions = Math.max(4, Math.min(10, parseInt(document.getElementById('num-opcoes').value) || 0));
    const optionsContainer = document.getElementById('opcoes-container');

    optionsContainer.innerHTML = '';

    for (let i = 0; i < numOptions; i++) {
        const input = document.createElement('input');
        input.type = 'text';
        input.className = 'opcao-input';
        input.placeholder = `Opção ${i + 1}`;
        input.name = `flag${i + 1}`;
        optionsContainer.appendChild(input);
    }
}



// function prepareCheckboxes() {
//     // Seleciona todos os checkboxes marcados com o nome 'tipoPerfil'
//     const checkboxes = document.querySelectorAll('input[name="tipoPerfilCheckbox"]:checked');
//
//     // Cria um array com os valores dos checkboxes selecionados
//     const selectedValues = Array.from(checkboxes).map(checkbox => checkbox.value);
//
//     // Transforma o array de valores em uma string, separada por vírgulas
//     const selectedValuesString = selectedValues.join(',');
//
//     // Define a string no campo oculto que será enviado no formulário
//     document.getElementById('tipoPerfil').value = selectedValuesString;
// }


