unit telalogin;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls, Vcl.Imaging.pngimage, telaselecaopersonagem,
  Vcl.ExtCtrls, datamodule, telacadastro, unitclasses;

type
  TfmLogin = class(TForm)
    edLogin: TEdit;
    edSenha: TEdit;
    btEntrar: TButton;
    btVoltar: TButton;
    Image1: TImage;
    btCriar: TButton;
    procedure btVoltarClick(Sender: TObject);
    procedure btEntrarClick(Sender: TObject);
    procedure btCriarClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  fmLogin: TfmLogin;

implementation

{$R *.dfm}

procedure TfmLogin.btCriarClick(Sender: TObject);
begin

  fmCadastro:= TfmCadastro.Create(nil);
  try
    fmCadastro.ShowModal;
  finally
     FreeAndNil(fmCadastro)
  end;


end;

procedure TfmLogin.btEntrarClick(Sender: TObject);

  begin
    DataModule2.FDQueryData.Close;
    DataModule2.FDQueryData.SQL.Text:= 'select * from usuarios ' +
                                              'where login= :login and ' +
                                              'senha= :senha';
    DataModule2.FDQueryData.ParamByName('login').AsString:= edLogin.Text;
    DataModule2.FDQueryData.ParamByName('senha').AsString:= edSenha.Text;
    DataModule2.FDQueryData.Open;


    if DataModule2.FDQueryData.IsEmpty then
    ShowMessage ('Usu�rio ou senha incorretos');

    if not DataModule2.FDQueryData.IsEmpty then
    begin
      fmPersonagem.UserAtual.Nome:= edLogin.Text;
      Close;
      fmPersonagem.Show;
    end;
  end;

procedure TfmLogin.btVoltarClick(Sender: TObject);
begin
  Close
end;

end.
