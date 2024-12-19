unit telaVotarPresidente;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils,
  System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls,
  UnitClasses, Vcl.Imaging.pngimage, Vcl.ExtCtrls;

type
  TFormVotarPresidente = class(TForm)
    lbPresidente: TLabel;
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
    Edit5: TEdit;
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
    procedure BtCorrigirClick(Sender: TObject);
    procedure BtConfirmaClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  FormVotarPresidente: TFormVotarPresidente;

implementation

{$R *.dfm}

uses
 telaPrincipal, telaCadastro;

procedure TFormVotarPresidente.Bt0Click(Sender: TObject);
var
I: integer;
begin
  Edit5.Text:= (Edit5.Text)+ ('0');

  formCadastro.Cadastrados.localizarPresidente(edit5.Text);

  if formCadastro.Cadastrados.localizarPresidente(edit5.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Presidente) -1) do
    begin
      if edit5.Text = formCadastro.Cadastrados.Presidente[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Presidente[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Presidente[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Presidente[i].Sigla;
    end;
  end;
end;

procedure TFormVotarPresidente.Bt1Click(Sender: TObject);
var
I: integer;
begin
  Edit5.Text:= (Edit5.Text)+ ('1');

  formCadastro.Cadastrados.localizarPresidente(edit5.Text);

  if formCadastro.Cadastrados.localizarPresidente(edit5.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Presidente) -1) do
    begin
      if edit5.Text = formCadastro.Cadastrados.Presidente[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Presidente[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Presidente[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Presidente[i].Sigla;
    end;
  end;
end;

procedure TFormVotarPresidente.Bt2Click(Sender: TObject);
var
I: integer;
begin
  Edit5.Text:= (Edit5.Text)+ ('2');

  formCadastro.Cadastrados.localizarPresidente(edit5.Text);

  if formCadastro.Cadastrados.localizarPresidente(edit5.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Presidente) -1) do
    begin
      if edit5.Text = formCadastro.Cadastrados.Presidente[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Presidente[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Presidente[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Presidente[i].Sigla;
    end;
  end;
end;

procedure TFormVotarPresidente.Bt3Click(Sender: TObject);
var
I: integer;
begin
  Edit5.Text:= (Edit5.Text)+ ('3');

  formCadastro.Cadastrados.localizarPresidente(edit5.Text);

  if formCadastro.Cadastrados.localizarPresidente(edit5.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Presidente) -1) do
    begin
      if edit5.Text = formCadastro.Cadastrados.Presidente[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Presidente[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Presidente[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Presidente[i].Sigla;
    end;
  end;
end;

procedure TFormVotarPresidente.Bt4Click(Sender: TObject);
var
I: integer;
begin
  Edit5.Text:= (Edit5.Text)+ ('4');

  formCadastro.Cadastrados.localizarPresidente(edit5.Text);

  if formCadastro.Cadastrados.localizarPresidente(edit5.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Presidente) -1) do
    begin
      if edit5.Text = formCadastro.Cadastrados.Presidente[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Presidente[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Presidente[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Presidente[i].Sigla;
    end;
  end;
end;

procedure TFormVotarPresidente.Bt5Click(Sender: TObject);
var
I: integer;
begin
  Edit5.Text:= (Edit5.Text)+ ('5');

  formCadastro.Cadastrados.localizarPresidente(edit5.Text);

  if formCadastro.Cadastrados.localizarPresidente(edit5.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Presidente) -1) do
    begin
      if edit5.Text = formCadastro.Cadastrados.Presidente[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Presidente[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Presidente[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Presidente[i].Sigla;
    end;
  end;
end;

procedure TFormVotarPresidente.Bt6Click(Sender: TObject);
var
I: integer;
begin
  Edit5.Text:= (Edit5.Text)+ ('6');

  formCadastro.Cadastrados.localizarPresidente(edit5.Text);

  if formCadastro.Cadastrados.localizarPresidente(edit5.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Presidente) -1) do
    begin
      if edit5.Text = formCadastro.Cadastrados.Presidente[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Presidente[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Presidente[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Presidente[i].Sigla;
    end;
  end;
end;

procedure TFormVotarPresidente.Bt7Click(Sender: TObject);
var
I: integer;
begin
  Edit5.Text:= (Edit5.Text)+ ('7');

  formCadastro.Cadastrados.localizarPresidente(edit5.Text);

  if formCadastro.Cadastrados.localizarPresidente(edit5.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Presidente) -1) do
    begin
      if edit5.Text = formCadastro.Cadastrados.Presidente[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Presidente[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Presidente[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Presidente[i].Sigla;
    end;
  end;
end;

procedure TFormVotarPresidente.Bt8Click(Sender: TObject);
var
I: integer;
begin
  Edit5.Text:= (Edit5.Text)+ ('8');

  formCadastro.Cadastrados.localizarPresidente(edit5.Text);

  if formCadastro.Cadastrados.localizarPresidente(edit5.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Presidente) -1) do
    begin
      if edit5.Text = formCadastro.Cadastrados.Presidente[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Presidente[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Presidente[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Presidente[i].Sigla;
    end;
  end;
end;

procedure TFormVotarPresidente.Bt9Click(Sender: TObject);
var
I: integer;
begin
  Edit5.Text:= (Edit5.Text)+ ('9');

  formCadastro.Cadastrados.localizarPresidente(edit5.Text);

  if formCadastro.Cadastrados.localizarPresidente(edit5.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Presidente) -1) do
    begin
      if edit5.Text = formCadastro.Cadastrados.Presidente[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Presidente[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Presidente[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Presidente[i].Sigla;
    end;
  end;
end;

procedure TFormVotarPresidente.BtConfirmaClick(Sender: TObject);
var
  i: integer;
begin
  for I := 0 to length(formCadastro.Cadastrados.Presidente) - 1 do
  begin
  if edit5.Text = formCadastro.Cadastrados.Presidente[i].Codigo  then
  formCadastro.Cadastrados.Presidente[i].Voto:= formCadastro.Cadastrados.Presidente[i].Voto + 1
  end;
  close;
end;

procedure TFormVotarPresidente.BtCorrigirClick(Sender: TObject);
begin
   Edit5.Clear;
   EdCandidato.Text:= 'VOTO NULO';
   EdPartido.Clear;
   EdSigla.Clear;
end;

end.
