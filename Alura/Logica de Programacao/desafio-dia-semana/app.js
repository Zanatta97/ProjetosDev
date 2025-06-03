var diaSemana = prompt('Bom dia, boa tarde ou boa noite, qual é o dia da semana atual?')

if (diaSemana.toUpperCase() == 'SEGUNDA' || diaSemana.toUpperCase() == 'TERÇA' ||
    diaSemana.toUpperCase() == 'TERCA' || diaSemana.toUpperCase() == 'QUARTA' ||
    diaSemana.toUpperCase() == 'QUINTA' || diaSemana.toUpperCase() == 'SEXTA') {
    alert('Boa Semana!');
} else {
    alert('Bom Final de Semana!');
}