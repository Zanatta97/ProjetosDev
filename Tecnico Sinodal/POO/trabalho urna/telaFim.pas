unit telaFim;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls, Vcl.Imaging.pngimage,
  Vcl.ExtCtrls;

type
  TFormFim = class(TForm)
    LbFim: TLabel;
    BtVoltar: TButton;
    Image3: TImage;
    procedure BtVoltarClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  FormFim: TFormFim;

implementation

{$R *.dfm}

procedure TFormFim.BtVoltarClick(Sender: TObject);
begin
  close;
end;

end.
