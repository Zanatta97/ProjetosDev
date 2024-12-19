program RPG;

uses
  Vcl.Forms,
  telainicial in 'telainicial.pas' {fmInicial},
  datamodule in 'datamodule.pas' {DataModule2: TDataModule},
  telalogin in 'telalogin.pas' {fmLogin},
  telaselecaopersonagem in 'telaselecaopersonagem.pas' {fmPersonagem},
  telacadastro in 'telacadastro.pas' {fmCadastro},
  unitclasses in 'unitclasses.pas';

{$R *.res}

begin
  Application.Initialize;
  Application.MainFormOnTaskbar := True;
  Application.CreateForm(TfmInicial, fmInicial);
  Application.CreateForm(TDataModule2, DataModule2);
  Application.CreateForm(TfmLogin, fmLogin);
  Application.CreateForm(TfmPersonagem, fmPersonagem);
  Application.CreateForm(TfmCadastro, fmCadastro);
  Application.Run;
end.
