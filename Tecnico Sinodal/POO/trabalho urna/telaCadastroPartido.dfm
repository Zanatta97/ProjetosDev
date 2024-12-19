object formCadastroPartido: TformCadastroPartido
  Left = 0
  Top = 0
  Caption = 'formCadastroPartido'
  ClientHeight = 233
  ClientWidth = 472
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  OldCreateOrder = False
  PixelsPerInch = 96
  TextHeight = 13
  object LbNome: TLabel
    Left = 32
    Top = 37
    Width = 79
    Height = 13
    Caption = 'Nome do Partido'
  end
  object LbSigla: TLabel
    Left = 328
    Top = 37
    Width = 22
    Height = 13
    Caption = 'Sigla'
  end
  object LbCodigo: TLabel
    Left = 32
    Top = 149
    Width = 33
    Height = 13
    Caption = 'Codigo'
  end
  object EdNome: TEdit
    Left = 32
    Top = 56
    Width = 241
    Height = 21
    TabOrder = 0
  end
  object EdSigla: TEdit
    Left = 328
    Top = 56
    Width = 121
    Height = 21
    TabOrder = 1
  end
  object EdCodigo: TEdit
    Left = 32
    Top = 168
    Width = 121
    Height = 21
    TabOrder = 2
  end
  object BtFinalizar: TButton
    Left = 216
    Top = 168
    Width = 233
    Height = 49
    Caption = 'Finalizar Cadastro'
    TabOrder = 3
  end
  object BtListar: TButton
    Left = 328
    Top = 137
    Width = 121
    Height = 25
    Caption = 'Listar Cadastrados'
    TabOrder = 4
  end
end
