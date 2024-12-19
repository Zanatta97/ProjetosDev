program cadcliente;

uses
  Vcl.Forms,
  telaprincipal in 'telaprincipal.pas' {Form1},
  datamodule in 'datamodule.pas' {DataModule2: TDataModule};

{$R *.res}

begin
  Application.Initialize;
  Application.MainFormOnTaskbar := True;
  Application.CreateForm(TDataModule2, DataModule2);
  Application.CreateForm(TForm1, Form1);
  Application.Run;
end.
