unit telaPrincipal;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants,
  System.Classes, Vcl.Graphics, Vcl.Controls, Vcl.Forms,
  Vcl.Dialogs, Vcl.StdCtrls, telaCadastro, telaVotar,
  telaApuracao, UnitClasses, Vcl.Imaging.pngimage, Vcl.ExtCtrls;


type
    TformPrincipal = class(TForm)
    BtVotar: TButton;
    BtCadastro: TButton;
    BtApurar: TButton;
    Image2: TImage;
    procedure BtCadastroClick(Sender: TObject);
    procedure BtVotarClick(Sender: TObject);
    procedure BtApurarClick(Sender: TObject);
    procedure FormCreate(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
    Cadastrados: TCadastrados;
    Votacao: TVotacao;
    property prinCadastrados: TCadastrados read Cadastrados write Cadastrados;

  end;

var
  formPrincipal: TformPrincipal;

implementation

{$R *.dfm}

uses telaCadastroPartido, telaVotarFederal, telaVotarSenador,
  telaVotarGovernador, telaVotarPresidente, telaFim;

{Diz o candidato com mais votos e a porcentagem desses votos}
procedure TformPrincipal.BtApurarClick(Sender: TObject);
var
maiorEstadual, maiorFederal, maiorSenador,
maiorGovernador, maiorPresidente,
porcEstadual, porcFederal, porcSenador,
porcGovernador, porcPresidente, I: integer;

nomeEstadual, nomeFederal, nomeSenador,
nomeGovernador, nomePresidente: string;
begin
 maiorEstadual:= 0;
 maiorFederal:= 0;
 maiorSenador:= 0;
 maiorGovernador:= 0;
 maiorPresidente:= 0;

 porcEstadual:= 0;
 porcFederal:= 0;
 porcSenador:= 0;
 porcGovernador:= 0;
 porcPresidente:= 0;

 for I:= 0 to (length(formCadastro.Cadastrados.Estadual) - 1) do
  begin
    if formCadastro.Cadastrados.Estadual[I].Voto > maiorEstadual then
    begin
    maiorEstadual:= formCadastro.Cadastrados.Estadual[i].Voto;
    nomeEstadual:= formCadastro.Cadastrados.Estadual[i].Nome;
    end;

    if not formCadastro.Cadastrados.Estadual[I].Voto > maiorEstadual then
    begin
    maiorEstadual:= maiorEstadual;
    nomeEstadual:= nomeEstadual;
    end;

    porcEstadual:= maiorEstadual*100 div Votacao.TotalVotos;
  end;

 for I:= 0 to (length(formCadastro.Cadastrados.Federal) - 1) do
  begin
    if formCadastro.Cadastrados.Federal[I].Voto > maiorFederal then
    begin
    maiorFederal:= formCadastro.Cadastrados.Federal[i].Voto;
    nomeFederal:= formCadastro.Cadastrados.Federal[i].Nome;
    end;


    if not formCadastro.Cadastrados.Federal[I].Voto > maiorFederal then
    begin
    maiorFederal:= maiorFederal;
    nomeFederal:= nomeFederal;
    end;

    porcFEderal:= maiorFederal*100 div Votacao.TotalVotos;
  end;

 for I:= 0 to (length(formCadastro.Cadastrados.Senador) - 1) do
  begin
    if formCadastro.Cadastrados.Senador[I].Voto > maiorSenador then
    begin
    maiorSenador:= formCadastro.Cadastrados.Senador[i].Voto;
    nomeSenador:= formCadastro.Cadastrados.Senador[i].Nome;
    end;

    if not formCadastro.Cadastrados.Senador[I].Voto > maiorSenador then
    begin
    maiorSenador:= maiorSenador;
    nomeSenador:= nomeSenador;
    end;
    porcSenador:= maiorSenador*100 div Votacao.TotalVotos;
  end;

 for I:= 0 to (length(formCadastro.Cadastrados.Governador) - 1) do
  begin
    if formCadastro.Cadastrados.Governador[I].Voto > maiorGovernador then
    begin
    maiorGovernador:= formCadastro.Cadastrados.Governador[i].Voto;
    nomeGovernador:= formCadastro.Cadastrados.Governador[i].Nome;
    end;

    if not formCadastro.Cadastrados.Governador[I].Voto > maiorGovernador then
    begin
    maiorGovernador:= maiorGovernador;
    nomeGovernador:= nomeGovernador;
    end;

    porcGovernador:= maiorGovernador*100 div Votacao.TotalVotos;
  end;

 for I:= 0 to (length(formCadastro.Cadastrados.Presidente) - 1) do
  begin
    if formCadastro.Cadastrados.Presidente[I].Voto > maiorPresidente then
    begin
    maiorPresidente:= formCadastro.Cadastrados.Presidente[i].Voto;
    nomePresidente:= formCadastro.Cadastrados.Presidente[i].Nome;
    end;

    if not formCadastro.Cadastrados.Presidente[I].Voto > maiorPresidente then
    begin
    maiorPresidente:= maiorPresidente;
    nomePresidente:= nomePresidente;
    end;

    porcPresidente:= maiorPresidente*100 div Votacao.TotalVotos;
  end;

 ShowMessage ('Total Votos: '+ inttostr(votacao.TotalVotos) + #10 +
              'Vencedor Deputado Estadual: ' + nomeEstadual + ' com ' + IntToStr(porcEstadual) + '% dos votos' + #10 +
              'Vencedor Deputado Federal: ' + nomeFederal + ' com ' + IntToStr(porcFederal)  + '% dos votos' + #10 +
              'Vencedor Senador: ' + nomeSenador + ' com ' + IntToStr(porcSenador)  + '% dos votos' + #10 +
              'Vencedor Governador: ' + nomeGovernador + ' com ' + IntToStr(porcGovernador)  + '% dos votos' + #10 +
              'Vencedor Presidente: ' + nomePresidente + ' com ' + IntToStr(porcPresidente)  + '% dos votos' + #10)

end;

procedure TformPrincipal.BtCadastroClick(Sender: TObject);
begin

  try
    formCadastro.ShowModal;
  finally

  end;
end;

procedure TformPrincipal.BtVotarClick(Sender: TObject);
{Adiciona um voto a mais no total de votos}
begin
  votacao.TotalVotos:= votacao.TotalVotos + 1;
  formVotarEstadual:= TformVotarEstadual.Create(nil);
  try
    formVotarEstadual.ShowModal;
  finally
    FreeAndNil (formVotarEstadual)
  end;

    formVotarFederal:= TformVotarFederal.Create(nil);
  try
    formVotarFederal.ShowModal;
  finally
    FreeAndNil (formVotarFederal)
  end;

    formVotarSenador:= TformVotarSenador.Create(nil);
  try
    formVotarSenador.ShowModal;
  finally
    FreeAndNil (formVotarSenador)
  end;

    formVotarGovernador:= TformVotarGovernador.Create(nil);
  try
    formVotarGovernador.ShowModal;
  finally
    FreeAndNil (formVotarGovernador)
  end;

    formVotarPresidente:= TformVotarPresidente.Create(nil);
  try
    formVotarPresidente.ShowModal;
  finally
    FreeAndNil (formVotarPresidente)
  end;

      formFim:= TformFim.Create(nil);
  try
    formFim.ShowModal;
  finally
    FreeAndNil (formFim)
  end;

end;

procedure TformPrincipal.FormCreate(Sender: TObject);


begin
   formCadastro:= TformCadastro.Create(nil);
   Votacao:= TVotacao.Create;
   Votacao.TotalVotos:= 0;
end;

end.
