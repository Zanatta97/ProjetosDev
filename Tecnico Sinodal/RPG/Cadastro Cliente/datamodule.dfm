object DataModule2: TDataModule2
  OldCreateOrder = False
  Height = 373
  Width = 545
  object FDConnection1: TFDConnection
    Params.Strings = (
      'Database=cadcliente'
      'User_Name=postgres'
      'Password=123456'
      'DriverID=PG')
    LoginPrompt = False
    Left = 232
    Top = 144
  end
  object FDPhysPgDriverLink1: TFDPhysPgDriverLink
    VendorLib = 'Z:\Samuel Zanatta\Programa'#231#227'o 3\Cadastro Cliente\libpq.dll'
    Left = 344
    Top = 160
  end
  object FDQueryData: TFDQuery
    Connection = FDConnection1
    Left = 152
    Top = 160
  end
end
