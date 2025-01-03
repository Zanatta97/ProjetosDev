unit telaVotarFederal;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils,
  System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls,
  UnitClasses, Vcl.Imaging.pngimage, Vcl.ExtCtrls;

type
  TFormVotarFederal = class(TForm)
    lbDeputadoFederal: TLabel;
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
    Edit2: TEdit;
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
  FormVotarFederal: TFormVotarFederal;

implementation

uses
  telaPrincipal, telaCadastro;

{$R *.dfm}

procedure TFormVotarFederal.Bt0Click(Sender: TObject);
var
I: integer;
begin
  Edit2.Text:= (Edit2.Text)+ ('0');

  formCadastro.Cadastrados.localizarFederal(edit2.Text);

  if formCadastro.Cadastrados.localizarFederal(edit2.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Federal) -1) do
    begin
      if edit2.Text = formCadastro.Cadastrados.Federal[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Federal[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Federal[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Federal[i].Sigla;
    end;
  end;
end;

procedure TFormVotarFederal.Bt1Click(Sender: TObject);
var
I: integer;
begin
   Edit2.Text:= (Edit2.Text)+ ('1');

   formCadastro.Cadastrados.localizarFederal(edit2.Text);

  if formCadastro.Cadastrados.localizarFederal(edit2.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Federal) -1) do
    begin
      if edit2.Text = formCadastro.Cadastrados.Federal[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Federal[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Federal[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Federal[i].Sigla;
    end;
  end;
end;

procedure TFormVotarFederal.Bt2Click(Sender: TObject);
var
I: integer;
begin
  Edit2.Text:= (Edit2.Text)+ ('2');

  formCadastro.Cadastrados.localizarFederal(edit2.Text);

  if formCadastro.Cadastrados.localizarFederal(edit2.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Federal) -1) do
    begin
      if edit2.Text = formCadastro.Cadastrados.Federal[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Federal[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Federal[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Federal[i].Sigla;
    end;
  end;
end;

procedure TFormVotarFederal.Bt3Click(Sender: TObject);
var
I: integer;
begin
   Edit2.Text:= (Edit2.Text)+ ('3');

  formCadastro.Cadastrados.localizarFederal(edit2.Text);

  if formCadastro.Cadastrados.localizarFederal(edit2.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Federal) -1) do
    begin
      if edit2.Text = formCadastro.Cadastrados.Federal[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Federal[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Federal[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Federal[i].Sigla;
    end;
  end;
end;

procedure TFormVotarFederal.Bt4Click(Sender: TObject);
var
I: integer;
begin
   Edit2.Text:= (Edit2.Text)+ ('4');

  formCadastro.Cadastrados.localizarFederal(edit2.Text);

  if formCadastro.Cadastrados.localizarFederal(edit2.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Federal) -1) do
    begin
      if edit2.Text = formCadastro.Cadastrados.Federal[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Federal[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Federal[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Federal[i].Sigla;
    end;
  end;
end;

procedure TFormVotarFederal.Bt5Click(Sender: TObject);
var
I: integer;
begin
   Edit2.Text:= (Edit2.Text)+ ('5');

  formCadastro.Cadastrados.localizarFederal(edit2.Text);

  if formCadastro.Cadastrados.localizarFederal(edit2.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Federal) -1) do
    begin
      if edit2.Text = formCadastro.Cadastrados.Federal[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Federal[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Federal[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Federal[i].Sigla;
    end;
  end;
end;

procedure TFormVotarFederal.Bt6Click(Sender: TObject);
var
I: integer;
begin
  Edit2.Text:= (Edit2.Text)+ ('6');

  formCadastro.Cadastrados.localizarFederal(edit2.Text);

  if formCadastro.Cadastrados.localizarFederal(edit2.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Federal) -1) do
    begin
      if edit2.Text = formCadastro.Cadastrados.Federal[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Federal[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Federal[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Federal[i].Sigla;
    end;
  end;
end;

procedure TFormVotarFederal.Bt7Click(Sender: TObject);
var
I: integer;
begin
   Edit2.Text:= (Edit2.Text)+ ('7');

  formCadastro.Cadastrados.localizarFederal(edit2.Text);

  if formCadastro.Cadastrados.localizarFederal(edit2.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Federal) -1) do
    begin
      if edit2.Text = formCadastro.Cadastrados.Federal[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Federal[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Federal[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Federal[i].Sigla;
    end;
  end;
end;

procedure TFormVotarFederal.Bt8Click(Sender: TObject);
var
I: integer;
begin
   Edit2.Text:= (Edit2.Text)+ ('8');

  formCadastro.Cadastrados.localizarFederal(edit2.Text);

  if formCadastro.Cadastrados.localizarFederal(edit2.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Federal) -1) do
    begin
      if edit2.Text = formCadastro.Cadastrados.Federal[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Federal[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Federal[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Federal[i].Sigla;
    end;
  end;
end;

procedure TFormVotarFederal.Bt9Click(Sender: TObject);
var
I: integer;
begin
   Edit2.Text:= (Edit2.Text)+ ('9');

  formCadastro.Cadastrados.localizarFederal(edit2.Text);

  if formCadastro.Cadastrados.localizarFederal(edit2.Text) then
  begin
    for I := 0 to (length(formCadastro.Cadastrados.Federal) -1) do
    begin
      if edit2.Text = formCadastro.Cadastrados.Federal[I].Codigo then
      EdCandidato.Text:= formCadastro.Cadastrados.Federal[I].Nome;
      EdPartido.Text:= formCadastro.Cadastrados.Federal[I].Partido;
      EdSigla.Text:= formCadastro.Cadastrados.Federal[i].Sigla;
    end;
  end;
end;

procedure TFormVotarFederal.BtConfirmaClick(Sender: TObject);
var
  i: integer;
begin
  for I := 0 to length(formCadastro.Cadastrados.Federal) - 1 do
  begin
  if edit2.Text = formCadastro.Cadastrados.Federal[i].Codigo  then
  formCadastro.Cadastrados.Federal[i].Voto:= formCadastro.Cadastrados.Federal[i].Voto + 1
  end;
    close
end;

procedure TFormVotarFederal.BtCorrigirClick(Sender: TObject);
begin
   Edit2.Clear;
   EdCandidato.Text:= 'VOTO NULO';
   EdPartido.Clear;
   EdSigla.Clear;
end;

end.
