unit telaselecaopersonagem;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls, unitclasses, datamodule;

type
  TfmPersonagem = class(TForm)
    lbPersonagem1: TLabel;
    btPersonagem1: TButton;
    lbPersonagem3: TLabel;
    Button1: TButton;
    lbPersonagem2: TLabel;
    Button2: TButton;
    lbLogin: TLabel;
    procedure FormCreate(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
    UserAtual: TuserAtual;
  end;

var
  fmPersonagem: TfmPersonagem;

implementation

{$R *.dfm}

procedure TfmPersonagem.FormCreate(Sender: TObject);
begin
    UserAtual:= TuserAtual.Create;
    lbLogin.Caption:= UserAtual.Nome;
    lbPersonagem1.Caption:= 'Nome Personagem ' + #10 +
                      'Nivel:' + #10 +
                      'Classe' + #10 +
                      'Ra�a' + #10 +
                      'Arma Atual' + #10 +
                      'Armadura' ;
end;

end.