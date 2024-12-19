unit telaVotarSenador;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils,
  System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls,
  UnitClasses, Vcl.Imaging.pngimage, Vcl.ExtCtrls;

type
  TFormVotarSenador = class(TForm)
    lbSenador: TLabel;
    Bt1: TButton;
    Bt2: TButton;
    Bt3: TButton;
    Bt4: TButton;
    Bt5: TButton;
    Bt6: TButton;
    Bt7: TButton;
    Bt8: TButton;
    Bt9: TButton;
    Bt0: TButton;
    BtBranco: TButton;
    BtCorrigir: TButton;
    BtConfirma: TButton;
    Edit3: TEdit;
    EdCandidato: TEdit;
    EdPartido: TEdit;
    LbCandidato: TLabel;
    LbPartido: TLabel;
    EdSigla: TEdit;
    Image3: TImage;
    procedure Bt1Click(Sender: TObject);
    procedure Bt2Click(Sender: TObject);
    procedure Bt3Click(Sender: TObject);
    procedure Bt4Click(Sender: TObject);
    procedure Bt5Click(Sender: TObject);
    procedure Bt6Click(Sender: TObject);
    procedure Bt7Click(Sender: TObject);
    procedure Bt8Click(Sender: TObject);
    procedure Bt9Click(Sender: TObject);
    procedure Bt0Click(Sender: TObject);
    procedure BtConfirmaClick(Sender: TObject);
    procedure BtCorrigirClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  FormVotarSenador: TFormVotarSenador;

implementation

{$R *.dfm}

uses
telaPrincipal, telaCadastro;

procedure TFormVotarSenador.Bt0Click(Sender: TObject);
var
I: integer;
begin
    Edit3.Text:= (Edit3.Text)+ ('0');

  formCadastro.Cadastrados.localizarSenador(edit3.Text);

  if formCadastro.Cadastrados.localizarSenador(edit3.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Senador) -1) do
    begin
      if edit3.Text = formCadastro.Cadastrados.Senador[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Senador[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Senador[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Senador[i].Sigla;
    end;
  end;
end;

procedure TFormVotarSenador.Bt1Click(Sender: TObject);
var
I: integer;
begin
    Edit3.Text:= (Edit3.Text)+ ('1');

  formCadastro.Cadastrados.localizarSenador(edit3.Text);

  if formCadastro.Cadastrados.localizarSenador(edit3.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Senador) -1) do
    begin
      if edit3.Text = formCadastro.Cadastrados.Senador[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Senador[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Senador[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Senador[i].Sigla;
    end;
  end;
end;

procedure TFormVotarSenador.Bt2Click(Sender: TObject);
var
I: integer;
begin
    Edit3.Text:= (Edit3.Text)+ ('2');

  formCadastro.Cadastrados.localizarSenador(edit3.Text);

  if formCadastro.Cadastrados.localizarSenador(edit3.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Senador) -1) do
    begin
      if edit3.Text = formCadastro.Cadastrados.Senador[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Senador[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Senador[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Senador[i].Sigla;
    end;
  end;
end;

procedure TFormVotarSenador.Bt3Click(Sender: TObject);
var
I: integer;
begin
    Edit3.Text:= (Edit3.Text)+ ('3');

  formCadastro.Cadastrados.localizarSenador(edit3.Text);

  if formCadastro.Cadastrados.localizarSenador(edit3.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Senador) -1) do
    begin
      if edit3.Text = formCadastro.Cadastrados.Senador[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Senador[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Senador[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Senador[i].Sigla;
    end;
  end;
end;

procedure TFormVotarSenador.Bt4Click(Sender: TObject);
var
I: integer;
begin
    Edit3.Text:= (Edit3.Text)+ ('4');

  formCadastro.Cadastrados.localizarSenador(edit3.Text);

  if formCadastro.Cadastrados.localizarSenador(edit3.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Senador) -1) do
    begin
      if edit3.Text = formCadastro.Cadastrados.Senador[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Senador[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Senador[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Senador[i].Sigla;
    end;
  end;
end;


procedure TFormVotarSenador.Bt5Click(Sender: TObject);
var
I: integer;
begin
    Edit3.Text:= (Edit3.Text)+ ('5');

  formCadastro.Cadastrados.localizarSenador(edit3.Text);

  if formCadastro.Cadastrados.localizarSenador(edit3.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Senador) -1) do
    begin
      if edit3.Text = formCadastro.Cadastrados.Senador[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Senador[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Senador[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Senador[i].Sigla;
    end;
  end;
end;


procedure TFormVotarSenador.Bt6Click(Sender: TObject);
var
I: integer;
begin
    Edit3.Text:= (Edit3.Text)+ ('6');

  formCadastro.Cadastrados.localizarSenador(edit3.Text);

  if formCadastro.Cadastrados.localizarSenador(edit3.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Senador) -1) do
    begin
      if edit3.Text = formCadastro.Cadastrados.Senador[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Senador[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Senador[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Senador[i].Sigla;
    end;
  end;
end;


procedure TFormVotarSenador.Bt7Click(Sender: TObject);
var
I: integer;
begin
    Edit3.Text:= (Edit3.Text)+ ('7');

  formCadastro.Cadastrados.localizarSenador(edit3.Text);

  if formCadastro.Cadastrados.localizarSenador(edit3.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Senador) -1) do
    begin
      if edit3.Text = formCadastro.Cadastrados.Senador[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Senador[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Senador[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Senador[i].Sigla;
    end;
  end;
end;


procedure TFormVotarSenador.Bt8Click(Sender: TObject);
var
I: integer;
begin
    Edit3.Text:= (Edit3.Text)+ ('8');

  formCadastro.Cadastrados.localizarSenador(edit3.Text);

  if formCadastro.Cadastrados.localizarSenador(edit3.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Senador) -1) do
    begin
      if edit3.Text = formCadastro.Cadastrados.Senador[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Senador[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Senador[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Senador[i].Sigla;
    end;
  end;
end;


procedure TFormVotarSenador.Bt9Click(Sender: TObject);
var
I: integer;
begin
    Edit3.Text:= (Edit3.Text)+ ('9');

  formCadastro.Cadastrados.localizarSenador(edit3.Text);

  if formCadastro.Cadastrados.localizarSenador(edit3.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Senador) -1) do
    begin
      if edit3.Text = formCadastro.Cadastrados.Senador[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Senador[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Senador[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Senador[i].Sigla;
    end;
  end;
end;


procedure TFormVotarSenador.BtConfirmaClick(Sender: TObject);
var
  i: integer;
begin
  for I := 0 to length(formCadastro.Cadastrados.Senador) - 1 do
  begin
  if edit3.Text = formCadastro.Cadastrados.Senador[i].Codigo  then
  formCadastro.Cadastrados.Senador[i].Voto:= formCadastro.Cadastrados.Senador[i].Voto + 1
  end;
   close;
end;

procedure TFormVotarSenador.BtCorrigirClick(Sender: TObject);
begin
   Edit3.Clear;
   EdCandidato.Text:= 'VOTO NULO';
   EdPartido.Clear;
   EdSigla.Clear;
end;

end.
