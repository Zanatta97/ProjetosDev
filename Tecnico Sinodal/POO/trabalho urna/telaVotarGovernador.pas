unit telaVotarGovernador;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils,
  System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls,
  UnitClasses, Vcl.Imaging.pngimage, Vcl.ExtCtrls;

type
  TFormVotarGovernador = class(TForm)
    lbGovernador: TLabel;
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
    Edit4: TEdit;
    EdCandidato: TEdit;
    EdPartido: TEdit;
    LbCandidato: TLabel;
    LbPartido: TLabel;
    EdSigla: TEdit;
    Image3: TImage;
    Image1: TImage;
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
    procedure BtCorrigirClick(Sender: TObject);
    procedure BtConfirmaClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  FormVotarGovernador: TFormVotarGovernador;

implementation

{$R *.dfm}

uses
  telaPrincipal, telaCadastro;
procedure TFormVotarGovernador.Bt0Click(Sender: TObject);
var
I: integer;
begin
   Edit4.Text:= (Edit4.Text)+ ('0');

  formCadastro.Cadastrados.localizarGovernador(edit4.Text);

  if formCadastro.Cadastrados.localizarGovernador(edit4.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Governador) -1) do
    begin
      if edit4.Text = formCadastro.Cadastrados.Governador[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Governador[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Governador[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Governador[i].Sigla;
    end;
  end;
end;

procedure TFormVotarGovernador.Bt1Click(Sender: TObject);
var
I: integer;
begin
   Edit4.Text:= (Edit4.Text)+ ('1');

  formCadastro.Cadastrados.localizarGovernador(edit4.Text);

  if formCadastro.Cadastrados.localizarGovernador(edit4.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Governador) -1) do
    begin
      if edit4.Text = formCadastro.Cadastrados.Governador[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Governador[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Governador[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Governador[i].Sigla;
    end;
  end;
end;

procedure TFormVotarGovernador.Bt2Click(Sender: TObject);
var
I: integer;
begin
   Edit4.Text:= (Edit4.Text)+ ('2');

  formCadastro.Cadastrados.localizarGovernador(edit4.Text);

  if formCadastro.Cadastrados.localizarGovernador(edit4.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Governador) -1) do
    begin
      if edit4.Text = formCadastro.Cadastrados.Governador[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Governador[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Governador[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Governador[i].Sigla;
    end;
  end;
end;

procedure TFormVotarGovernador.Bt3Click(Sender: TObject);
var
I: integer;
begin
   Edit4.Text:= (Edit4.Text)+ ('3');

  formCadastro.Cadastrados.localizarGovernador(edit4.Text);

  if formCadastro.Cadastrados.localizarGovernador(edit4.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Governador) -1) do
    begin
      if edit4.Text = formCadastro.Cadastrados.Governador[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Governador[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Governador[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Governador[i].Sigla;
    end;
  end;
end;

procedure TFormVotarGovernador.Bt4Click(Sender: TObject);
var
I: integer;
begin
   Edit4.Text:= (Edit4.Text)+ ('4');

  formCadastro.Cadastrados.localizarGovernador(edit4.Text);

  if formCadastro.Cadastrados.localizarGovernador(edit4.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Governador) -1) do
    begin
      if edit4.Text = formCadastro.Cadastrados.Governador[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Governador[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Governador[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Governador[i].Sigla;
    end;
  end;
end;

procedure TFormVotarGovernador.Bt5Click(Sender: TObject);
var
I: integer;
begin
   Edit4.Text:= (Edit4.Text)+ ('5');

  formCadastro.Cadastrados.localizarGovernador(edit4.Text);

  if formCadastro.Cadastrados.localizarGovernador(edit4.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Governador) -1) do
    begin
      if edit4.Text = formCadastro.Cadastrados.Governador[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Governador[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Governador[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Governador[i].Sigla;
    end;
  end;
end;

procedure TFormVotarGovernador.Bt6Click(Sender: TObject);
var
I: integer;
begin
   Edit4.Text:= (Edit4.Text)+ ('6');

  formCadastro.Cadastrados.localizarGovernador(edit4.Text);

  if formCadastro.Cadastrados.localizarGovernador(edit4.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Governador) -1) do
    begin
      if edit4.Text = formCadastro.Cadastrados.Governador[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Governador[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Governador[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Governador[i].Sigla;
    end;
  end;
end;

procedure TFormVotarGovernador.Bt7Click(Sender: TObject);
var
I: integer;
begin
   Edit4.Text:= (Edit4.Text)+ ('7');

  formCadastro.Cadastrados.localizarGovernador(edit4.Text);

  if formCadastro.Cadastrados.localizarGovernador(edit4.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Governador) -1) do
    begin
      if edit4.Text = formCadastro.Cadastrados.Governador[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Governador[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Governador[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Governador[i].Sigla;
    end;
  end;
end;

procedure TFormVotarGovernador.Bt8Click(Sender: TObject);
var
I: integer;
begin
   Edit4.Text:= (Edit4.Text)+ ('8');

  formCadastro.Cadastrados.localizarGovernador(edit4.Text);

  if formCadastro.Cadastrados.localizarGovernador(edit4.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Governador) -1) do
    begin
      if edit4.Text = formCadastro.Cadastrados.Governador[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Governador[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Governador[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Governador[i].Sigla;
    end;
  end;
end;

procedure TFormVotarGovernador.Bt9Click(Sender: TObject);
var
I: integer;
begin
   Edit4.Text:= (Edit4.Text)+ ('9');

  formCadastro.Cadastrados.localizarGovernador(edit4.Text);

  if formCadastro.Cadastrados.localizarGovernador(edit4.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Governador) -1) do
    begin
      if edit4.Text = formCadastro.Cadastrados.Governador[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Governador[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Governador[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Governador[i].Sigla;
    end;
  end;
end;

procedure TFormVotarGovernador.BtConfirmaClick(Sender: TObject);
var
  i: integer;
begin
  for I := 0 to length(formCadastro.Cadastrados.Governador) - 1 do
  begin
  if edit4.Text = formCadastro.Cadastrados.Governador[i].Codigo  then
  formCadastro.Cadastrados.Governador[i].Voto:= formCadastro.Cadastrados.Governador[i].Voto + 1
  end;

  close;
end;

procedure TFormVotarGovernador.BtCorrigirClick(Sender: TObject);
begin
     Edit4.Clear;
     EdCandidato.Text:= 'VOTO NULO';
     EdPartido.Clear;
     EdSigla.Clear;
end;

end.
