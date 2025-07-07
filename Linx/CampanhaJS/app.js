document.getElementById("numeroForm").addEventListener("submit", function (e) {
  e.preventDefault(); // Evita o recarregamento da página

  // Obtém o valor máximo digitado pelo usuário
  const numeroMaximo = parseInt(document.getElementById("numeroMaximo").value);

  // Verifica se o número é válido
  if (isNaN(numeroMaximo) || numeroMaximo < 2) {
    alert("Por favor, digite um número válido");
    return;
  }

  // Gera dois números aleatórios diferentes entre 1 e o número máximo
  const numero1 = Math.floor(Math.random() * numeroMaximo) + 1;
  let numero2;

  // Garante que os números sejam diferentes
  do {
    numero2 = Math.floor(Math.random() * numeroMaximo) + 1;
  } while (numero2 === numero1);

  // Exibe o resultado
  if (numero1 < numero2) {
    document.getElementById(
      "numerosGerados"
    ).textContent = `Casos a serem analisados: ${numero1} e ${numero2}`;
  } else {
    document.getElementById(
      "numerosGerados"
    ).textContent = `Casos a serem analisados: ${numero2} e ${numero1}`;
  }

  document.getElementById("resultado").style.display = "block";
});
