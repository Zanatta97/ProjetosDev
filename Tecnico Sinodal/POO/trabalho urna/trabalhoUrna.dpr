program trabalhoUrna;

uses
  Vcl.Forms,
  telaPrincipal in 'telaPrincipal.pas' {formPrincipal},
  telaVotar in 'telaVotar.pas' {formVotarEstadual},
  telaCadastro in 'telaCadastro.pas' {formCadastro},
  telaApuracao in 'telaApuracao.pas' {formApuracao},
  UnitClasses in 'UnitClasses.pas',
  telaVotarFederal in 'telaVotarFederal.pas' {FormVotarFederal},
  telaVotarPresidente in 'telaVotarPresidente.pas' {FormVotarPresidente},
  telaVotarGovernador in 'telaVotarGovernador.pas' {FormVotarGovernador},
  telaVotarSenador in 'telaVotarSenador.pas' {FormVotarSenador},
  telaFim in 'telaFim.pas' {FormFim};

{$R *.res}

begin
  Application.Initialize;
  Application.MainFormOnTaskbar := True;
  Application.CreateForm(TformPrincipal, formPrincipal);
  Application.CreateForm(TformVotarEstadual, formVotarEstadual);
  Application.CreateForm(TformCadastro, formCadastro);
  Application.CreateForm(TformApuracao, formApuracao);
  Application.CreateForm(TFormVotarFederal, FormVotarFederal);
  Application.CreateForm(TFormVotarPresidente, FormVotarPresidente);
  Application.CreateForm(TFormVotarGovernador, FormVotarGovernador);
  Application.CreateForm(TFormVotarSenador, FormVotarSenador);
  Application.CreateForm(TFormFim, FormFim);
  Application.Run;
end.
