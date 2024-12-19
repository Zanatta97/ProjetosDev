unit telaCadastro;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils,
  System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls,
  UnitClasses, Vcl.Imaging.jpeg, Vcl.ExtCtrls, Vcl.Imaging.pngimage;

type
    TformCadastro = class(TForm)
    lbNome: TEdit;
    Label1: TLabel;
    EdNumero: TEdit;
    lbCodigo: TLabel;
    EdPartido: TEdit;
    lbPartido: TLabel;
    lbCargo: TLabel;
    lbComboBox: TComboBox;
    BtFinalizar: TButton;
    BtListar: TButton;
    LbSigla: TLabel;
    EdSigla: TEdit;
    Image3: TImage;
    procedure FormCreate(Sender: TObject);
    procedure BtFinalizarClick(Sender: TObject);
    procedure BtListarClick(Sender: TObject);

  private
    { Private declarations }
  public
    { Public declarations }
    Cadastrados: TCadastrados;
  end;

var
  formCadastro: TformCadastro;

implementation

uses
telaVotar, telaVotarFederal, telaVotarSenador,
telaVotarGovernador, telaVotarPresidente, telaPrincipal;

{$R *.dfm}


procedure TformCadastro.BtFinalizarClick(Sender: TObject);
begin
  if lbComboBox.Text = 'Cargo' then
  ShowMessage ('Por Favor selecione um cargo')
  else
  begin
  if lbComboBox.Text = 'Deputado Estadual' then
  begin
    if length(edNumero.Text) <> 5 then
    ShowMessage ('N�mero Invalido' + #10 + 'O N�mero deve conter 5 d�gitos')
    else
    begin
    Cadastrados.incluirEstadual(lbNome.Text); //Adiciona um candidato no vetor correspondente
    Cadastrados.definirCodigoEstadual(edNumero.Text);
    Cadastrados.definirPartidoEstadual(edPartido.Text);
    Cadastrados.definirSiglaEstadual(edSigla.Text);
    Cadastrados.definirCargoEstadual(lbComboBox.Text);

    lbNome.Clear;
    edNumero.Clear;
    edPartido.Clear;
    edSigla.Clear;
    lbComboBox.Text:= 'Cargo'
    end;
  end;

  if lbComboBox.Text = 'Deputado Federal' then
  begin
  if length(edNumero.Text) <> 4 then
    ShowMessage ('N�mero Invalido' + #10 + 'O N�mero deve conter 4 d�gitos')
    else
    begin
    Cadastrados.incluirFederal(lbNome.Text);
    Cadastrados.definirCodigoFederal(edNumero.Text);
    Cadastrados.definirPartidoFederal(edPartido.Text);
    Cadastrados.definirSiglaFederal(edSigla.Text);
    Cadastrados.definirCargoFederal(lbComboBox.Text);

    lbNome.Clear;
    edNumero.Clear;
    edPartido.Clear;
    edSigla.Clear;
    lbComboBox.Text:= 'Cargo'
    end;
  end;

  if lbComboBox.Text = 'Senador' then
  begin
    if length(edNumero.Text) <> 3 then
    ShowMessage ('N�mero Invalido' + #10 + 'O N�mero deve conter 3 d�gitos')
    else
    begin
    Cadastrados.incluirSenador(lbNome.Text);
    Cadastrados.definirCodigoSenador(edNumero.Text);
    Cadastrados.definirPartidoSenador(edPartido.Text);
    Cadastrados.definirSiglaSenador(edSigla.Text);
    Cadastrados.definirCargoSenador(lbComboBox.Text);

    lbNome.Clear;
    edNumero.Clear;
    edPartido.Clear;
    edSigla.Clear;
    lbComboBox.Text:= 'Cargo'
    end;
  end;

  if lbComboBox.Text = 'Governador' then
  begin
    if length(edNumero.Text) <> 2 then
    ShowMessage ('N�mero Invalido' + #10 + 'O N�mero deve conter 2 d�gitos')
    else
    begin
    Cadastrados.incluirGovernador(lbNome.Text);
    Cadastrados.definirCodigoGovernador(edNumero.Text);
    Cadastrados.definirPartidoGovernador(edPartido.Text);
    Cadastrados.definirSiglaGovernador(edSigla.Text);
    Cadastrados.definirCargoGovernador(lbComboBox.Text);

    lbNome.Clear;
    edNumero.Clear;
    edPartido.Clear;
    edSigla.Clear;
    lbComboBox.Text:= 'Cargo'
    end;
  end;

  if lbComboBox.Text = 'Presidente' then
  begin
    if length(edNumero.Text) <> 2 then
    ShowMessage ('N�mero Invalido' + #10 + 'O N�mero deve conter 2 d�gitos')
    else
    begin
    Cadastrados.incluirPresidente(lbNome.Text);
    Cadastrados.definirCodigoPresidente(edNumero.Text);
    Cadastrados.definirPartidoPresidente(edPartido.Text);
    Cadastrados.definirSiglaPresidente(edSigla.Text);
    Cadastrados.definirCargoPresidente(lbComboBox.Text);

    lbNome.Clear;
    edNumero.Clear;
    edPartido.Clear;
    edSigla.Clear;
    lbComboBox.Text:= 'Cargo'
    end;
  end;

  end;
end;

procedure TformCadastro.BtListarClick(Sender: TObject);
begin
  Cadastrados.listarCandidatos;
end;

procedure TformCadastro.FormCreate(Sender: TObject);

begin
   Cadastrados := TCadastrados.Create;
end;

end.
