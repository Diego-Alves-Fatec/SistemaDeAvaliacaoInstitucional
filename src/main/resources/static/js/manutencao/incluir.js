function toggleOptions() {
    const questionType = document.getElementById('tipo-questao').value;
    const additionalOptions = document.getElementById('opcoes-adicionais');

    if (questionType === '2') {
        additionalOptions.style.display = 'block';
        generateOptions();
    } else {
        additionalOptions.style.display = 'none';
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
        optionsContainer.appendChild(input);
    }
}
