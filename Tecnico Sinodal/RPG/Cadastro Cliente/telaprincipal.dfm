object Form1: TForm1
  Left = 0
  Top = 0
  Caption = 'Tela Principal'
  ClientHeight = 389
  ClientWidth = 630
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  OldCreateOrder = False
  OnCreate = FormCreate
  PixelsPerInch = 96
  TextHeight = 13
  object lbData: TLabel
    Left = 8
    Top = 45
    Width = 100
    Height = 13
    Caption = 'Data de Nascimento:'
  end
  object Label1: TLabel
    Left = 8
    Top = 205
    Width = 51
    Height = 13
    Caption = 'Categoria:'
  end
  object edNome: TEdit
    Left = 8
    Top = 15
    Width = 489
    Height = 21
    MaxLength = 75
    TabOrder = 0
    TextHint = 'Nome'
  end
  object DateTimePicker1: TDateTimePicker
    Left = 8
    Top = 64
    Width = 186
    Height = 21
    Date = 43591.847027453700000000
    Time = 43591.847027453700000000
    TabOrder = 1
  end
  object RadioGroup1: TRadioGroup
    Left = 8
    Top = 104
    Width = 489
    Height = 49
    Caption = 'Tipo de Pessoa:'
    Columns = 2
    Items.Strings = (
      'F'#237'sica'
      'Juridica')
    TabOrder = 2
    OnClick = RadioGroup1Click
  end
  object cbCategoria: TComboBox
    Left = 8
    Top = 224
    Width = 177
    Height = 21
    TabOrder = 3
  end
  object edDocumento: TEdit
    Left = 8
    Top = 168
    Width = 186
    Height = 21
    NumbersOnly = True
    TabOrder = 4
    TextHint = 'Documento'
  end
  object Button1: TButton
    Left = 424
    Top = 336
    Width = 198
    Height = 45
    Caption = 'Button1'
    TabOrder = 5
    OnClick = Button1Click
  end
end