object DataModule2: TDataModule2
  OldCreateOrder = False
  Height = 504
  Width = 639
  object FDConnection1: TFDConnection
    Params.Strings = (
      'Database=rpg'
      'User_Name=postgres'
      'Password=123456'
      'DriverID=pG')
    Connected = True
    LoginPrompt = False
    Left = 408
    Top = 304
  end
  object FDPhysPgDriverLink1: TFDPhysPgDriverLink
    VendorLib = 'C:\Users\Cliente\Desktop\'#8192#8194#8194#8194'\RPG\delphi\libpq.dll'
    Left = 440
    Top = 184
  end
  object FDQueryData: TFDQuery
    Connection = FDConnection1
    Left = 248
    Top = 200
  end
end
