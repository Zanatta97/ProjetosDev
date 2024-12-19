unit UnitClasses;

interface

uses Dialogs;

type
 TVotacao = class
    private

    public
       fTotalVotos: integer;
       fVotosNulos: integer;
       fVotosBrancos: integer;
      procedure setTotalVotos (const Value: integer);
      procedure setVotosNulos (const Value: integer);
      procedure setVotosBrancos (const Value: integer);

    published
       property TotalVotos: integer read fTotalVotos write setTotalVotos;
  end;

  TCandidato = class
    private

    public
      fNome: string;
      fCodigo: string;
      fPartido: string;
      fSigla: string;
      fCargo: string;
      fVoto: integer;
      constructor create;
      procedure setNome (const Value: string);
      procedure setCodigo (const Value: string);
      procedure setPartido (const Value: string);
      procedure setCargo (const Value: string);
      procedure setSigla (const Value: string);
      procedure setVoto (const Value: integer);

    published
      property Nome: string read fNome write setNome;
      property Codigo: string read fCodigo write setCodigo;
      property Partido: string read fPartido write setPartido;
      property Cargo: string read fCargo write setCargo;
      property Sigla: string read fSigla write setSigla;
      property Voto: integer read fVoto write setVoto;

  end;

  TCadastrados = class
    private

    public
       Presidente: Array of TCandidato;
       Governador: Array of TCandidato;
       Senador: Array of TCandidato;
       Federal: Array of TCandidato;
       Estadual: Array of TCandidato;
       constructor create;
       procedure incluirPresidente (pNome: string);
       procedure incluirGovernador (pNome: string);
       procedure incluirSenador (pNome: string);
       procedure incluirFederal (pNome: string);
       procedure incluirEstadual (pNome: string);

       procedure definirCodigoEstadual (pCodigo: string);
       procedure definirPartidoEstadual (pPartido: string);
       procedure definirSiglaEstadual (pSigla: string);
       procedure definirCargoEstadual (pCargo: string);
       function localizarEstadual (pCodigo: string): boolean;

       procedure definirCodigoFederal (pCodigo: string);
       procedure definirPartidoFederal (pPartido: string);
       procedure definirSiglaFederal (pSigla: string);
       procedure definirCargoFederal (pCargo: string);
       function localizarFederal (pCodigo: string): boolean;

       procedure definirCodigoSenador (pCodigo: string);
       procedure definirPartidoSenador (pPartido: string);
       procedure definirSiglaSenador (pSigla: string);
       procedure definirCargoSenador (pCargo: string);
       function localizarSenador (pCodigo: string): boolean;

       procedure definirCodigoGovernador (pCodigo: string);
       procedure definirPartidoGovernador (pPartido: string);
       procedure definirSiglaGovernador (pSigla: string);
       procedure definirCargoGovernador (pCargo: string);
       function localizarGovernador (pCodigo: string): boolean;

       procedure definirCodigoPresidente (pCodigo: string);
       procedure definirPartidoPresidente (pPartido: string);
       procedure definirSiglaPresidente (pSigla: string);
       procedure definirCargoPresidente (pCargo: string);
       function localizarPresidente (pCodigo: string): boolean;

       procedure listarCandidatos;

    published

  end;

implementation

{ TCandidato }

constructor TCandidato.create;
begin
    Voto:= 0
end;

procedure TCandidato.setNome(const Value: string);
begin
   fNome:= Value;
end;

procedure TCandidato.setCodigo(const Value: string);
begin
   fCodigo:= Value
end;

procedure TCandidato.setPartido(const Value: string);
begin
   fPartido:= Value
end;

procedure TCandidato.setCargo(const Value: string);
begin
   fCargo:= Value
end;

procedure TCandidato.setSigla(const Value: string);
begin
    fSigla:= Value
end;

procedure TCandidato.setVoto(const Value: Integer);
begin
  fVoto:= Value
end;

{ TVotacao }

procedure TVotacao.setTotalVotos(const Value: Integer);
begin
    fTotalVotos:= Value
end;

{ TCadastrados }

constructor TCadastrados.create;
begin
  setlength (Estadual, 0);
  setlength (Federal, 0);
  setlength (Senador, 0);
  setlength (Governador, 0);
  setlength (Presidente, 0);
end;

{Incluir} //Adiciona os candidatos no vetor correto

procedure TCadastrados.incluirEstadual(pNome: string);
var
  posAtual: integer;
begin
    setLength (Estadual, length(Estadual) + 1);
    posAtual:= length(Estadual) - 1;

    Estadual[posAtual]:= TCandidato.Create;
    Estadual[posAtual].nome:= pNome;
    Estadual[posAtual].Voto:= 0;
end;

procedure TCadastrados.incluirFederal(pNome: string);
var
  posAtual: integer;
begin
    setLength (Federal, length(Federal) + 1);
    posAtual:= length(Federal) - 1;

    Federal[posAtual]:= TCandidato.Create;
    Federal[posAtual].nome:= pNome;
    Federal[posAtual].Voto:= 0;
end;

procedure TCadastrados.incluirGovernador(pNome: string);
var
  posAtual: integer;
begin
    setLength (Governador, length(Governador) + 1);
    posAtual:= length(Governador) - 1;

    Governador[posAtual]:= TCandidato.Create;
    Governador[posAtual].nome:= pNome;
    Governador[posAtual].Voto:= 0;
end;

procedure TCadastrados.incluirPresidente(pNome: string);
var
  posAtual: integer;
begin
    setLength (Presidente, length(Presidente) + 1);
    posAtual:= length(Presidente) - 1;

    Presidente[posAtual]:= TCandidato.Create;
    Presidente[posAtual].nome:= pNome;
    Presidente[posAtual].Voto:= 0;
end;

procedure TCadastrados.incluirSenador(pNome: string);
var
  posAtual: integer;
begin
    setLength (Senador, length(Senador) + 1);
    posAtual:= length(Senador) - 1;

    Senador[posAtual]:= TCandidato.Create;
    Senador[posAtual].nome:= pNome;
    Senador[posAtual].Voto:= 0;
end;

{Estadual}  //Define as propriedades do candidato

procedure Tcadastrados.definirCodigoEstadual(pCodigo: string);
begin
   Estadual[length(Estadual) -1].Codigo:= pCodigo;
end;

procedure TCadastrados.definirPartidoEstadual(pPartido: string);
begin
   Estadual[length(Estadual) -1].Partido:= pPartido;
end;

procedure TCadastrados.definirSiglaEstadual(pSigla: string);
begin
   Estadual[length(Estadual) -1].Sigla:= pSigla;
end;

procedure TCadastrados.definirCargoEstadual(pCargo: string);
begin
   Estadual[length(Estadual) -1].Cargo:= pCargo;
end;

function Tcadastrados.localizarEstadual(pCodigo: string): boolean;
var
  I: integer;
begin
   result:= false;
   for I := 0 to (length(Estadual)-1) do
   begin
     if pCodigo = Estadual[I].Codigo then
     result:= true;
   end;
end;

{Federal}  //Define as propriedades do candidato

procedure Tcadastrados.definirCodigoFederal(pCodigo: string);
begin
   Federal[length(Federal) -1].Codigo:= pCodigo;
end;

procedure TCadastrados.definirPartidoFederal(pPartido: string);
begin
   Federal[length(Federal) -1].Partido:= pPartido;
end;

procedure TCadastrados.definirSiglaFederal(pSigla: string);
begin
   Federal[length(Federal) -1].Sigla:= pSigla;
end;

procedure TCadastrados.definirCargoFederal(pCargo: string);
begin
   Federal[length(Federal) -1].Cargo:= pCargo;
end;

function Tcadastrados.localizarFederal(pCodigo: string): boolean;
var
  I: integer;
begin
   result:= false;
   for I := 0 to (length(Federal)-1) do
   begin
     if pCodigo = Federal[I].Codigo then
     result:= true;
   end;
end;

{Senador}  //Define as propriedades do candidato

procedure Tcadastrados.definirCodigoSenador(pCodigo: string);
begin
   Senador[length(Senador) -1].Codigo:= pCodigo;
end;

procedure TCadastrados.definirPartidoSenador(pPartido: string);
begin
   Senador[length(Senador) -1].Partido:= pPartido;
end;

procedure TCadastrados.definirSiglaSenador(pSigla: string);
begin
   Senador[length(Senador) -1].Sigla:= pSigla;
end;

procedure TCadastrados.definirCargoSenador(pCargo: string);
begin
   Senador[length(Senador) -1].Cargo:= pCargo;
end;

function Tcadastrados.localizarSenador(pCodigo: string): boolean;
var
  I: integer;
begin
   result:= false;
   for I := 0 to (length(Senador)-1) do
   begin
     if pCodigo = Senador[I].Codigo then
     result:= true;
   end;
end;

{Governador}  //Define as propriedades do candidato

procedure Tcadastrados.definirCodigoGovernador(pCodigo: string);
begin
   Governador[length(Governador) -1].Codigo:= pCodigo;
end;

procedure TCadastrados.definirPartidoGovernador(pPartido: string);
begin
   Governador[length(Governador) -1].Partido:= pPartido;
end;

procedure TCadastrados.definirSiglaGovernador(pSigla: string);
begin
   Governador[length(Governador) -1].Sigla:= pSigla;
end;

procedure TCadastrados.definirCargoGovernador(pCargo: string);
begin
   Governador[length(Governador) -1].Cargo:= pCargo;
end;

function Tcadastrados.localizarGovernador(pCodigo: string): boolean;
var
  I: integer;
begin
   result:= false;
   for I := 0 to (length(Governador)-1) do
   begin
     if pCodigo = Governador[I].Codigo then
     result:= true;
   end;
end;

{Presidente}  //Define as propriedades do candidato

procedure Tcadastrados.definirCodigoPresidente(pCodigo: string);
begin
   Presidente[length(Presidente) -1].Codigo:= pCodigo;
end;

procedure TCadastrados.definirPartidoPresidente(pPartido: string);
begin
   Presidente[length(Presidente) -1].Partido:= pPartido;
end;

procedure TCadastrados.definirSiglaPresidente(pSigla: string);
begin
   Presidente[length(Presidente) -1].Sigla:= pSigla;
end;

procedure TCadastrados.definirCargoPresidente(pCargo: string);
begin
   Presidente[length(Presidente) -1].Cargo:= pCargo;
end;

function Tcadastrados.localizarPresidente(pCodigo: string): boolean;
var
  I: integer;
begin
   result:= false;
   for I := 0 to (length(Presidente)-1) do
   begin
     if pCodigo = Presidente[I].Codigo then
     result:= true;
   end;
end;

procedure TCadastrados.listarCandidatos;
var
  I: integer;
begin
  for I:= 0 to length(Estadual) - 1 do
  begin
    ShowMessage ('Nome: ' + Estadual[I].Nome
    + #10 + 'Código: ' + Estadual[i].Codigo
     + #10 + 'Partido: ' + Estadual[i].Partido
     + #10 + 'Sigla: ' + Estadual[i].Sigla
      + #10 + 'Cargo: ' + Estadual[i].Cargo)
  end;

  for I:= 0 to length(Federal) - 1 do
  begin
    ShowMessage ('Nome: ' + Federal[I].Nome
    + #10 + 'Código: ' + Federal[i].Codigo
     + #10 + 'Partido: ' + Federal[i].Partido
     + #10 + 'Sigla: ' + Federal[i].Sigla
      + #10 + 'Cargo: ' + Federal[i].Cargo)
  end;

  for I:= 0 to length(Senador) - 1 do
  begin
    ShowMessage ('Nome: ' + Senador[I].Nome
    + #10 + 'Código: ' + Senador[i].Codigo
     + #10 + 'Partido: ' + Senador[i].Partido
     + #10 + 'Sigla: ' + Senador[i].Sigla
      + #10 + 'Cargo: ' + Senador[i].Cargo)
  end;

  for I:= 0 to length(Governador) - 1 do
  begin
    ShowMessage ('Nome: ' + Governador[I].Nome
    + #10 + 'Código: ' + Governador[i].Codigo
     + #10 + 'Partido: ' + Governador[i].Partido
     + #10 + 'Sigla: ' + Governador[i].Sigla
      + #10 + 'Cargo: ' + Governador[i].Cargo)
  end;

  for I:= 0 to length(Presidente) - 1 do
  begin
    ShowMessage ('Nome: ' + Presidente[I].Nome
    + #10 + 'Código: ' + Presidente[i].Codigo
     + #10 + 'Partido: ' + Presidente[i].Partido
     + #10 + 'Sigla: ' + Presidente[i].Sigla
      + #10 + 'Cargo: ' + Presidente[i].Cargo)
  end;
end;

procedure TVotacao.setVotosBrancos(const Value: integer);
begin
  fVotosBrancos:= Value;
end;

procedure TVotacao.setVotosNulos(const Value: integer);
begin
  fVotosNulos:= Value;
end;

end.
