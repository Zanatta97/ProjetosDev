unit unitclasses;

interface

uses Dialogs;

type

  Tarma = class
    private
      fCodigo: integer;
      fNome: string;
      fDescricao: string;
      fTamanho: integer;
      fTipo: string;
      procedure setCodigo (const Value: integer);
      procedure setNome (const Value: string);
      procedure setDescricao (const Value: string);
      procedure setTamanho (const Value: integer);
      procedure setTipo (const Value: string);
    public

    published
      property Codigo: integer read fCodigo write setCodigo;
      property Nome: string read fNome write setNome;
      property Descricao: string read fDescricao write setDescricao;
      property Tamanho: integer read fTamanho write setTamanho;
      property Tipo: string read fTipo write setTipo;

  end;

    Tarmadura = class
    private
      fCodigo: integer;
      fNome: string;
      fDescricao: string;
      fTamanho: integer;
      fTipo: string;
      procedure setCodigo (const Value: integer);
      procedure setNome (const Value: string);
      procedure setDescricao (const Value: string);
      procedure setTamanho (const Value: integer);
      procedure setTipo (const Value: string);
    public

    published
      property Codigo: integer read fCodigo write setCodigo;
      property Nome: string read fNome write setNome;
      property Descricao: string read fDescricao write setDescricao;
      property Tamanho: integer read fTamanho write setTamanho;
      property Tipo: string read fTipo write setTipo;

  end;

  Tpersonagem = class
    private
      fCodigo: integer;
      fNome: string;
      fNivel: integer;
      fXP: integer;
      fRaca: string;
      fClasse: string;
      fPVMax: integer;
      fPVAtual: integer;
      fForca: integer;
      fDestreza: integer;
      fConstituicao: integer;
      fInteligencia: integer;
      fSabedoria: integer;
      fCarisma: integer;
      fArma: integer;
      fArmadura: integer;
      fInventario: integer;
      procedure setCodigo (const Value: integer);
      procedure setNome (const Value: string);
      procedure setNivel (const Value: integer);
      procedure setRaca (const Value: string);
      procedure setClasse (const Value: string);
      procedure setPVMax (const Value: integer);
      procedure setPVAtual (const Value: integer);
      procedure setForca (const Value: integer);
      procedure setDestreza (const Value: integer);
      procedure setConstituicao (const Value: integer);
      procedure setInteligencia (const Value: integer);
      procedure setSabedoria (const Value: integer);
      procedure setCarisma (const Value: integer);
      procedure setArma (const Value: integer);
      procedure setArmadura (const Value: integer);
      procedure setInventario (const Value: integer);

    public

    published
    property Codigo: integer read fCodigo write setCodigo;
    property Nome: string read fNome write setNome;
    property Nivel: integer read fNivel write setNivel;
    property Raca: string read fRaca write setRaca;
    property Classe: string read fClasse write setClasse;
    property PVMax: integer read fPVMax write setPVMax;
    property PVAtual: integer read fPVAtual write setPVAtual;
    property Forca: integer read fForca write setForca;
    property Destreza: integer read fDestreza write setDestreza;
    property Constituicao: integer read fConstituicao write setConstituicao;
    property Inteligencia: integer read fInteligencia write setInteligencia;
    property Sabedoria: integer read fSabedoria write setSabedoria;
    property Carisma: integer read fCarisma write setCarisma;
    property Arma: integer read fArma write setArma;
    property Armadura: integer read fArmadura write setArmadura;
    property inventario: integer read fInventario write setInventario;
  end;

  TuserAtual = class
    private

    public
      fNome: string;
      fPersonagem1: Tpersonagem;
      fPersonagem2: Tpersonagem;
      fPersonagem3: Tpersonagem;
      procedure setNome(const Value: string);
      procedure setPersonagem1(const Value: Tpersonagem);
      procedure setPersonagem2(const Value: Tpersonagem);
      procedure setPersonagem3(const Value: Tpersonagem);

    published
      property Nome: string read fNome write setNome;
      property Personagem1: Tpersonagem read fPersonagem1 write setPersonagem1;
      property Personagem2: Tpersonagem read fPersonagem2 write setPersonagem2;
      property Personagem3: Tpersonagem read fPersonagem3 write setPersonagem3;

  end;


implementation

{ Tarma }

procedure Tarma.setCodigo(const Value: integer);
begin
  fCodigo:= Value
end;

procedure Tarma.setDescricao(const Value: string);
begin
  fDescricao:= Value
end;

procedure Tarma.setNome(const Value: string);
begin
  fNome:= Value
end;

procedure Tarma.setTamanho(const Value: integer);
begin
  fTamanho:= Value
end;

procedure Tarma.setTipo(const Value: string);
begin
   fTipo:= Value
end;

{ Tarmadura }

procedure Tarmadura.setCodigo(const Value: integer);
begin
  fCodigo:= Value
end;

procedure Tarmadura.setDescricao(const Value: string);
begin
  fDescricao:= Value
end;

procedure Tarmadura.setNome(const Value: string);
begin
  fNome:= Value
end;

procedure Tarmadura.setTamanho(const Value: integer);
begin
  fTamanho:= Value
end;

procedure Tarmadura.setTipo(const Value: string);
begin
  fTipo:= Value
end;

{ Tpersonagem }

procedure Tpersonagem.setArma(const Value: integer);
begin
  fArma:= Value
end;

procedure Tpersonagem.setArmadura(const Value: integer);
begin
  fArmadura:= Value
end;

procedure Tpersonagem.setCarisma(const Value: integer);
begin
  fCarisma:= Value
end;

procedure Tpersonagem.setClasse(const Value: string);
begin
  fClasse:= Value
end;

procedure Tpersonagem.setCodigo(const Value: integer);
begin
  fCodigo:= Value
end;

procedure Tpersonagem.setConstituicao(const Value: integer);
begin
  fConstituicao:= Value
end;

procedure Tpersonagem.setDestreza(const Value: integer);
begin
  fDestreza:= Value
end;

procedure Tpersonagem.setForca(const Value: integer);
begin
  fForca:= Value
end;

procedure Tpersonagem.setInteligencia(const Value: integer);
begin
  fInteligencia:= Value
end;

procedure Tpersonagem.setInventario(const Value: integer);
begin
   fInventario:= Value
end;

procedure Tpersonagem.setNivel(const Value: integer);
begin
   fNivel:= Value
end;

procedure Tpersonagem.setNome(const Value: string);
begin
   fNome:= Value
end;

procedure Tpersonagem.setPVAtual(const Value: integer);
begin
   fPVAtual:= Value
end;

procedure Tpersonagem.setPVMax(const Value: integer);
begin
   fPVMax:= Value
end;

procedure Tpersonagem.setRaca(const Value: string);
begin
   fRaca:= Value
end;

procedure Tpersonagem.setSabedoria(const Value: integer);
begin
  fSabedoria:= Value
end;


{ TuserAtual }

procedure TuserAtual.setNome(const Value: string);
begin
   fNome:= Value
end;

procedure TuserAtual.setPersonagem1(const Value: Tpersonagem);
begin
  fPersonagem1:= Value
end;

procedure TuserAtual.setPersonagem2(const Value: Tpersonagem);
begin
  fPersonagem2:= Value
end;

procedure TuserAtual.setPersonagem3(const Value: Tpersonagem);
begin
  fPersonagem3:= Value
end;

end.
