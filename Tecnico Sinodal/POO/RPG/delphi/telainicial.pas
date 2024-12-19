unit telainicial;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls, telalogin,
  Vcl.Imaging.pngimage, Vcl.ExtCtrls, telaselecaopersonagem, unitclasses;

type
  TfmInicial = class(TForm)
    lbTitulo: TLabel;
    btLogin: TButton;
    btTutorial: TButton;
    btSobre: TButton;
    btSair: TButton;
    lbAno: TLabel;
    Image1: TImage;
    procedure btLoginClick(Sender: TObject);
    procedure btSairClick(Sender: TObject);
    procedure btTutorialClick(Sender: TObject);
    procedure btSobreClick(Sender: TObject);
    procedure FormCreate(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  fmInicial: TfmInicial;

implementation

{$R *.dfm}

procedure TfmInicial.btLoginClick(Sender: TObject);
begin
  fmLogin:= TfmLogin.Create(nil);
  try
    fmLogin.ShowModal;
  finally
     FreeAndNil(fmLogin)
  end;
end;

procedure TfmInicial.btSairClick(Sender: TObject);
begin
  fmInicial.Close;
end;

procedure TfmInicial.btSobreClick(Sender: TObject);
begin
  ShowMessage('Criadores:' + #10 +
              'Samuel Zanatta' + #10 +
              'Guilherme Schweig' + #10 +
              'Nicole Chapuis' + #10 + #10 +
              'Col�gio Sinodal Progresso' + #10 + #10 +
              'Montenegro, RS - Brasil 2019' + #10 + #10 +
              'Professor: Anderson Silva')
end;

procedure TfmInicial.btTutorialClick(Sender: TObject);
begin
  ShowMessage ('VAI NO GOOGLE')
end;

procedure TfmInicial.FormCreate(Sender: TObject);
begin
  fmPersonagem:= TfmPersonagem.Create(nil);
  try

  finally
    FreeAndNil(fmPersonagem)
  end;
end;

end.
