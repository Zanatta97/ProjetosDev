alert("Hello There, boas vindas ao jogo do número secreto.");

let numeroMaximo = 100;

let numeroSecreto = parseInt((Math.random() * numeroMaximo) + 1);

console.log(`Número Secreto: ${numeroSecreto}`);

let tentativas = 0;

let numeroUsuario = validaNumero(rececbeNumeroUsuario(1));


let acertou = false;

while (acertou == false) {
    if (numeroUsuario < numeroSecreto){
        numeroUsuario = validaNumero(rececbeNumeroUsuario(2));
    } else if (numeroUsuario > numeroSecreto){
        numeroUsuario = validaNumero(rececbeNumeroUsuario(3));
    } else if (numeroUsuario == numeroSecreto){
        acertou = true;
        break;
    }
};

document.getElementById("titulo").textContent = `Você acertou!`;

let texto = tentativas > 1 ? "tentativas" : "tentativa";

document.getElementById("textoAcertou").textContent = `Você descobriu o número secreto ${numeroSecreto} em ${tentativas} ${texto}!`;

/*if (tentativas > 1) {
    document.getElementById("textoAcertou").textContent = `Você descobriu o número secreto em ${tentativas} tentativas!`;
} else {
    document.getElementById("textoAcertou").textContent = `Você descobriu o número secreto em ${tentativas} tentativa!`;
}*/

//Recebe o número do usuário com a mensagem escolhida
function rececbeNumeroUsuario(mensagem){
    
    switch (mensagem){
        case 1 : {
            tentativas ++;
            return prompt(`Tente advinhar o número secreto! Deve ser entre 1 e ${numeroMaximo.toString()}!`); //Crase para definir uma string permite inserir variáveis utilizando ${}
        }
        
        case 2 : {
            tentativas ++;
            return prompt(`O Número secreto é maior que ${numeroUsuario}! Tente novamente!`);
        }

        case 3 : {
            tentativas ++;
            return prompt(`O Número secreto é menor que ${numeroUsuario}! Tente novamente!`);
        }

        case 4 :{
            return prompt("O texto digitado não é um número! Favor digitar um número!");
        }
        
    }
     
}

//valida se é o usuário digitou um número mesmo
function validaNumero(numero) {

    if (isNaN(numero)){
        return validaNumero(rececbeNumeroUsuario(4));
    } else {
        return numero;
    }

};