unit telaprincipal;

interface

uses
  System.SysUtils, System.Types, System.UITypes, System.Classes, System.Variants,
  FMX.Types, FMX.Controls, FMX.Forms, FMX.Graphics, FMX.Dialogs, FMX.ListBox,
  FMX.Edit, FMX.Controls.Presentation, FMX.StdCtrls;

type
  TForm1 = class(TForm)
    comboboxclasse: TComboBox;
    guerreiro: TListBoxItem;
    barbaro: TListBoxItem;
    ladino: TListBoxItem;
    mago: TListBoxItem;
    ranger: TListBoxItem;
    comboboxraca: TComboBox;
    elfo: TListBoxItem;
    anao: TListBoxItem;
    halfling: TListBoxItem;
    humano: TListBoxItem;
    gnomo: TListBoxItem;
    lbClasse: TLabel;
    lbRaca: TLabel;
    edNome: TEdit;
    meioorc: TListBoxItem;
    lbdescricaoraca: TLabel;
    lbdescricaoclasse: TLabel;
    lbdescricaoclasse1: TLabel;
    lbdescricaoraca1: TLabel;
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form1: TForm1;

implementation

{$R *.fmx}

begin
end.
