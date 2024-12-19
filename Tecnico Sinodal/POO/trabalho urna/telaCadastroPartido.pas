unit telaCadastroPartido;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls;

type
  TformCadastroPartido = class(TForm)
    EdNome: TEdit;
    EdSigla: TEdit;
    EdCodigo: TEdit;
    LbNome: TLabel;
    LbSigla: TLabel;
    LbCodigo: TLabel;
    BtFinalizar: TButton;
    BtListar: TButton;
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  formCadastroPartido: TformCadastroPartido;

implementation

{$R *.dfm}

end.
