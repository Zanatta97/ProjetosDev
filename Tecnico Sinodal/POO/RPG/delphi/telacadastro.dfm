object fmCadastro: TfmCadastro
  Left = 0
  Top = 0
  BorderStyle = bsDialog
  Caption = 'CRIAR USU'#193'RIO'
  ClientHeight = 503
  ClientWidth = 675
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  OldCreateOrder = False
  Position = poDesktopCenter
  OnCreate = FormCreate
  PixelsPerInch = 96
  TextHeight = 13
  object lbLogin: TLabel
    Left = 160
    Top = 93
    Width = 165
    Height = 13
    Caption = 'ESCOLHA UM NOME DE USU'#193'RIO:'
  end
  object lbSenha: TLabel
    Left = 160
    Top = 181
    Width = 99
    Height = 13
    Caption = 'DIGITE UMA SENHA:'
  end
  object lbConfirma: TLabel
    Left = 160
    Top = 237
    Width = 103
    Height = 13
    Caption = 'CONFIRME A SENHA:'
  end
  object edLogin: TEdit
    Left = 160
    Top = 112
    Width = 345
    Height = 21
    MaxLength = 24
    TabOrder = 0
  end
  object edSenha: TEdit
    Left = 160
    Top = 200
    Width = 345
    Height = 21
    MaxLength = 24
    PasswordChar = '*'
    TabOrder = 1
    OnChange = edSenhaChange
  end
  object edConfirma: TEdit
    Left = 160
    Top = 256
    Width = 345
    Height = 21
    MaxLength = 24
    PasswordChar = '*'
    TabOrder = 2
    OnChange = edConfirmaChange
  end
  object btCriar: TButton
    Left = 160
    Top = 296
    Width = 345
    Height = 89
    Caption = 'CRIAR USU'#193'RIO'
    TabOrder = 3
    OnClick = btCriarClick
  end
  object btChecar: TButton
    Left = 160
    Top = 139
    Width = 156
    Height = 25
    Caption = 'CHECAR DISPONIBILIDADE'
    TabOrder = 4
    OnClick = btChecarClick
  end
end