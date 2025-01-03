unit telaprincipal;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, datamodule, FireDAC.Stan.Intf,
  FireDAC.Stan.Option, FireDAC.Stan.Param, FireDAC.Stan.Error, FireDAC.DatS,
  FireDAC.Phys.Intf, FireDAC.DApt.Intf, FireDAC.Stan.Async, FireDAC.DApt,
  Data.DB, FireDAC.Comp.DataSet, FireDAC.Comp.Client, Vcl.Grids, Vcl.DBGrids,
  Vcl.StdCtrls, Vcl.ExtCtrls, Vcl.ComCtrls;

type
  TForm1 = class(TForm)
    edNome: TEdit;
    lbData: TLabel;
    DateTimePicker1: TDateTimePicker;
    RadioGroup1: TRadioGroup;
    cbCategoria: TComboBox;
    Label1: TLabel;
    edDocumento: TEdit;
    Button1: TButton;
    procedure FormCreate(Sender: TObject);
    procedure RadioGroup1Click(Sender: TObject);
    procedure Button1Click(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form1: TForm1;

implementation

{$R *.dfm}

procedure TForm1.Button1Click(Sender: TObject);
begin
    DataModule2.FDQueryData.Close;
    DataModule2.FDQueryData.SQL.Text:= 'insert into cliente values '  +
                                        '(coalesce((select max(idcliente) from cliente), 0)+1, '  +
                                        ':nome, :data, :tipo, :doc, :categoria)';
    DataModule2.FDQueryData.ParamByName('nome').AsString:= edNome.Text;
    DataModule2.FDQueryData.ParamByName('data').AsDate := datetimepicker1.Date;

    case RadioGroup1.ItemIndex of
      0: DataModule2.FDQueryData.ParamByName('tipo').AsString := 'F';
      1: DataModule2.FDQueryData.ParamByName('tipo').AsString := 'J';
    end;
    DataModule2.FDQueryData.ParamByName('doc').AsString := edDocumento.Text;
    DataModule2.FDQueryData.ParamByName('cat').AsInteger :=
    StrToInt(copy(cbCategoria.Text, 1, pos ('-', cbCategoria.Text)-1));
    DataModule2.FDQueryData.ExecSQL;

end;

procedure TForm1.FormCreate(Sender: TObject);
begin
    DataModule2.FDQueryData.Close;
    DataModule2.FDQueryData.SQL.Text:= 'select * from categoria';
    DataModule2.FDQueryData.Open;

    while not DataModule2.FDQueryData.Eof do
    begin
      cbCategoria.Items.Add(DataModule2.FDQueryData.FieldByName('idcategoria').AsString + '-' +
                            DataModule2.FDQueryData.FieldByName('descricao').AsString);
      DataModule2.FDQueryData.Next;
    end;

end;

procedure TForm1.RadioGroup1Click(Sender: TObject);
begin
  if RadioGroup1.ItemIndex = 0 then
  begin
  edDocumento.MaxLength := 11;
  edDocumento.TextHint := 'CPF';
  end;

  if RadioGroup1.ItemIndex = 1 then
  begin
  edDocumento.MaxLength := 14;
  edDocumento.TextHint := 'CNPJ';
  end;

end;

end.
