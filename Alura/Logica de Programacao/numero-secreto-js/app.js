alert("Hello There, boas vindas ao jogo do número secreto.");

let numeroMaximo = 30;

let numeroSecreto = parseInt(Math.random() * numeroMaximo);

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

function rececbeNumeroUsuario(mensagem){
    
    switch (mensagem){
        case 1 : {
            return prompt("Tente advinhar o número secreto! Deve ser entre 1 e " + numeroMaximo.toString());
        }
        
        case 2 : {
            return prompt("O Número secreto é maior que o número selecionado! Tente novamente!");
        }

        case 3 : {
            return prompt("O Número secreto é menor que o número selecionado! Tente novamente!");
        }

        case 4 :{
            return prompt("O texto digitado não é um número! Favor digitar um número!");
        }
        
    }
     
}

function validaNumero(numero) {

    if (isNaN(numero)){
        return validaNumero(rececbeNumeroUsuario(4));
    } else {
        return numero;
    }

};