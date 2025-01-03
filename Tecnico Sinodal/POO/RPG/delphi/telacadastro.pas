unit telacadastro;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls, datamodule, FireDAC.Stan.Intf,
  FireDAC.Stan.Option, FireDAC.Stan.Param, FireDAC.Stan.Error, FireDAC.DatS,
  FireDAC.Phys.Intf, FireDAC.DApt.Intf, FireDAC.Stan.Async, FireDAC.DApt,
  Data.DB, FireDAC.Comp.DataSet, FireDAC.Comp.Client;

type
  TfmCadastro = class(TForm)
    lbLogin: TLabel;
    edLogin: TEdit;
    edSenha: TEdit;
    lbSenha: TLabel;
    edConfirma: TEdit;
    lbConfirma: TLabel;
    btCriar: TButton;
    btChecar: TButton;
    procedure btChecarClick(Sender: TObject);
    procedure btCriarClick(Sender: TObject);
    procedure edSenhaChange(Sender: TObject);
    procedure edConfirmaChange(Sender: TObject);
    procedure FormCreate(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  fmCadastro: TfmCadastro;

implementation

{$R *.dfm}

procedure TfmCadastro.btChecarClick(Sender: TObject);
var
testeusuario: boolean;

begin
    testeusuario:= false;
    DataModule2.FDQueryData.Close;
    DataModule2.FDQueryData.SQL.Text:= 'select login from usuarios';
    DataModule2.FDQueryData.Open;

    while not DataModule2.FDQueryData.Eof do
    begin
      if edLogin.Text = DataModule2.FDQueryData.FieldByName('login').AsString then
      testeusuario:= true;
      DataModule2.FDQueryData.Next;
    end;
    if testeusuario = true then
    ShowMessage('Nome de usu�rio indispon�vel')
    else
    ShowMessage('Nome de usu�rio dispon�vel')
end;
procedure TfmCadastro.btCriarClick(Sender: TObject);
var
testelogin: boolean;

begin
    if edLogin.Text = '' then
    ShowMessage ('Digite um nome de usu�rio')
    else
    begin

      //Teste Condi��es
      testelogin:= false;
      DataModule2.FDQueryData.Close;
      DataModule2.FDQueryData.SQL.Text:= 'select login from usuarios';
      DataModule2.FDQueryData.Open;

      {if edSenha.Text <> edConfirma.Text then
        begin
          edSenha.Clear;
          edConfirma.Clear;
          ShowMessage('As senhas n�o combinam');
        end;}

      if edSenha.Text = edConfirma.Text then
        begin
          while not DataModule2.FDQueryData.Eof do
          begin
            if edLogin.Text = DataModule2.FDQueryData.FieldByName('login').AsString then
            testelogin:= true;
            DataModule2.FDQueryData.Next;
          end;


          if testelogin = true then
          ShowMessage('Nome de usu�rio indispon�vel')
          else
          begin
            //Criar Usu�rio
            DataModule2.FDQueryData.Close;
            DataModule2.FDQueryData.SQL.Text:= 'insert into usuarios values '  +
                                                '(coalesce((select max(codigousuario) from usuarios), 0)+1, '  +
                                                ':login, :senha)';
            DataModule2.FDQueryData.ParamByName('login').AsString:= edLogin.Text;
            DataModule2.FDQueryData.ParamByName('senha').AsString:= edSenha.Text;
            DataModule2.FDQueryData.ExecSQL;
            edLogin.Clear;
            edSenha.Clear;
            edConfirma.Clear;
            ShowMessage('Usu�rio criado com sucesso');
            Close;
          end;
        end;
    end;
end;
procedure TfmCadastro.edConfirmaChange(Sender: TObject);
begin
  if edSenha.Text <> edConfirma.Text then
    btCriar.Hide
    else
    btCriar.Show;
end;

procedure TfmCadastro.edSenhaChange(Sender: TObject);
begin
  if edSenha.Text <> edConfirma.Text then
  btCriar.Hide
  else
  btCriar.Show;

  if edSenha.Text = '' then
  btCriar.Hide;
end;

procedure TfmCadastro.FormCreate(Sender: TObject);
begin
  btCriar.Hide

end;

end.

