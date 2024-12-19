package com.methasystems.pedidosandroidmethasystems.dataSource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.methasystems.pedidosandroidmethasystems.dataModel.ClienteDataModel;
import com.methasystems.pedidosandroidmethasystems.dataModel.EmpresaDataModel;
import com.methasystems.pedidosandroidmethasystems.dataModel.GrupoLoginDataModel;
import com.methasystems.pedidosandroidmethasystems.dataModel.ModalidadePagamentoDataModel;
import com.methasystems.pedidosandroidmethasystems.dataModel.ProdutoDataModel;
import com.methasystems.pedidosandroidmethasystems.dataModel.ProdutoVendaDataModel;
import com.methasystems.pedidosandroidmethasystems.dataModel.RemessaDataModel;
import com.methasystems.pedidosandroidmethasystems.dataModel.UsuarioDataModel;
import com.methasystems.pedidosandroidmethasystems.dataModel.VencimentoDataModel;
import com.methasystems.pedidosandroidmethasystems.dataModel.VendaDataModel;
import com.methasystems.pedidosandroidmethasystems.model.Cliente;
import com.methasystems.pedidosandroidmethasystems.model.Empresa;
import com.methasystems.pedidosandroidmethasystems.model.GrupoLogin;
import com.methasystems.pedidosandroidmethasystems.model.ModalidadePagamento;
import com.methasystems.pedidosandroidmethasystems.model.Produto;
import com.methasystems.pedidosandroidmethasystems.model.ProdutoVenda;
import com.methasystems.pedidosandroidmethasystems.model.Remessa;
import com.methasystems.pedidosandroidmethasystems.model.Usuario;
import com.methasystems.pedidosandroidmethasystems.model.Vencimento;
import com.methasystems.pedidosandroidmethasystems.model.Venda;

import java.security.PublicKey;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class DataSource  extends SQLiteOpenHelper {

    private static final String DB_NAME = "pedidos.sqlite";
    private static final int DB_VERSION =  1;

    Cursor cursor;
    SQLiteDatabase db;

    public DataSource(@Nullable Context context){
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        try{
            db.execSQL(ClienteDataModel.criarTabela());
        } catch (Exception e) {
            Log.e("Banco de Dados", "DB -----> Erro na criação da Tabela TB_CLIENTES: " + e.getMessage());
        }

        try{
            db.execSQL(EmpresaDataModel.criarTabela());
        } catch (Exception e) {
            Log.e("Banco de Dados", "DB -----> Erro na criação da Tabela TB_EMPRESAS: " + e.getMessage());
        }

        try{
            db.execSQL(GrupoLoginDataModel.criarTabela());
        } catch (Exception e) {
            Log.e("Banco de Dados", "DB -----> Erro na criação da Tabela TB_LOGIN_GROUP: " + e.getMessage());
        }

        try{
            db.execSQL(ModalidadePagamentoDataModel.criarTabela());
        } catch (Exception e) {
            Log.e("Banco de Dados", "DB -----> Erro na criação da Tabela TB_MOD_PAGAMENTO: " + e.getMessage());
        }

        try{
            db.execSQL(ProdutoDataModel.criarTabela());
        } catch (Exception e) {
            Log.e("Banco de Dados", "DB -----> Erro na criação da Tabela TB_PRODUTO: " + e.getMessage());
        }

        try{
            db.execSQL(ProdutoVendaDataModel.criarTabela());
        } catch (Exception e) {
            Log.e("Banco de Dados", "DB -----> Erro na criação da Tabela TB_PROD_VENDAS: " + e.getMessage());
        }

        try{
            db.execSQL(RemessaDataModel.criarTabela());
        } catch (Exception e) {
            Log.e("Banco de Dados", "DB -----> Erro na criação da Tabela TB_REMESSAS: " + e.getMessage());
        }

        try{
            db.execSQL(UsuarioDataModel.criarTabela());
        } catch (Exception e) {
            Log.e("Banco de Dados", "DB -----> Erro na criação da Tabela TB_LOGIN_USER: " + e.getMessage());
        }

        try{
            db.execSQL(VencimentoDataModel.criarTabela());
        } catch (Exception e) {
            Log.e("Banco de Dados", "DB -----> Erro na criação da Tabela TB_VENCIMENTO: " + e.getMessage());
        }

        try{
            db.execSQL(VendaDataModel.criarTabela());
        } catch (Exception e) {
            Log.e("Banco de Dados", "DB -----> Erro na criação da Tabela TB_VENDA: " + e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insert(String tabela, ContentValues dados) {

        boolean sucesso = true;
        try {
            sucesso = db.insert(tabela, null, dados) > 0;
        } catch (Exception e) {
            sucesso = false;
        }
        return sucesso;

    }

    public boolean deletar(String tabela, int codigo){

        boolean sucesso = true;
        sucesso = db.delete(tabela, "codigo=?", new String[]{Integer.toString(codigo)}) > 0;
        return sucesso;

    }

    public boolean alterar(String tabela, ContentValues dados){

        boolean sucesso = true;
        int codigo = dados.getAsInteger("codigo");
        sucesso = db.update(tabela, dados, "codigo=?", new String[]{Integer.toString(codigo)}) > 0;
        return sucesso;

    }

    public void deletarTabela(String tabela){
        try{
            db.execSQL("DROP TABLE IF EXISTS " + tabela);
        }catch (Exception e){

        }
    }

    public void criarTabela (String queryCriarTabela){
        try {
            db.execSQL(queryCriarTabela);
        }catch (SQLiteCantOpenDatabaseException e){

        }
    }

    public Cliente getCliente(int codigo){

        Cliente obj;

        String sql = "SELECT * FROM " + ClienteDataModel.getTABELA() +
                " WHERE " + ClienteDataModel.getCodGefims() + " = " + codigo;

        cursor = db.rawQuery(sql, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            obj = new Cliente();

            obj.setCodigo(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.getCodigo())));
            obj.setCodigoPk(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.getCodigoPk())));
            obj.setCodGefims(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.getCodGefims())));
            obj.setNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.getNome())));
            obj.setCnpj(cursor.getString(cursor.getColumnIndex(ClienteDataModel.getCnpj())));
            obj.setInscricaoEstadual(cursor.getString(cursor.getColumnIndex(ClienteDataModel.getInscricaoEstadual())));
            obj.setCpf(cursor.getString(cursor.getColumnIndex(ClienteDataModel.getCpf())));
            obj.setLoginEmpresa(cursor.getString(cursor.getColumnIndex(ClienteDataModel.getLoginEmpresa())));
            obj.setGrupoEmpresa(cursor.getString(cursor.getColumnIndex(ClienteDataModel.getGrupoEmpresa())));

        } else {
            cursor.close();
            return null;
        }
        cursor.close();
        return obj;
    }

    public ArrayList<Cliente> getAllCliente(){

        Cliente obj;
        ArrayList<Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM " + ClienteDataModel.getTABELA() +
                " ORDER BY " + ClienteDataModel.getCodigo();

        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {

                obj = new Cliente();

                obj.setCodigo(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.getCodigo())));
                obj.setCodigoPk(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.getCodigoPk())));
                obj.setCodGefims(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.getCodGefims())));
                obj.setNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.getNome())));
                obj.setCnpj(cursor.getString(cursor.getColumnIndex(ClienteDataModel.getCnpj())));
                obj.setInscricaoEstadual(cursor.getString(cursor.getColumnIndex(ClienteDataModel.getInscricaoEstadual())));
                obj.setCpf(cursor.getString(cursor.getColumnIndex(ClienteDataModel.getCpf())));
                obj.setLoginEmpresa(cursor.getString(cursor.getColumnIndex(ClienteDataModel.getLoginEmpresa())));
                obj.setGrupoEmpresa(cursor.getString(cursor.getColumnIndex(ClienteDataModel.getGrupoEmpresa())));

                lista.add(obj);

            } while (cursor.moveToNext());
        }

        cursor.close(); // SEMPRE fechar o cursor

        return lista;

    }

    public Empresa getEmpresa(int codigo){

        Empresa obj;

        String sql = "SELECT * FROM " + EmpresaDataModel.getTABELA() +
                " WHERE " + EmpresaDataModel.getCodigo() + " = " + codigo;

        cursor = db.rawQuery(sql, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            obj = new Empresa();

            obj.setCodigo(cursor.getInt(cursor.getColumnIndex(EmpresaDataModel.getCodigo())));
            obj.setCodigoPk(cursor.getInt(cursor.getColumnIndex(EmpresaDataModel.getCodigoPk())));
            obj.setNome(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getNome())));
            obj.setFantasia(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getFantasia())));
            obj.setEndereco(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getEndereco())));
            obj.setNumero(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getNumero())));
            obj.setComplemento(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getComplemento())));
            obj.setBairro(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getBairro())));
            obj.setCep(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getCep())));
            obj.setCidade(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getCidade())));
            obj.setUf(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getUf())));
            obj.setCnpj(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getCnpj())));
            obj.setInscricaoEstadual(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getInscricaoEstadual())));
            obj.setCpf(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getCpf())));
            obj.setEmail(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getEmail())));
            obj.setTelefone(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getTelefone())));
            obj.setCelular(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getCelular())));
            obj.setUrlFtp(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getUrlFtp())));
            obj.setPortaFtp(cursor.getInt(cursor.getColumnIndex(EmpresaDataModel.getPortaFtp())));
            obj.setUsuarioFtp(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getUsuarioFtp())));
            obj.setSenhaFtp(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getSenhaFtp())));
            obj.setPastaRemssaFtp(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getPastaRemssaFtp())));
            obj.setPastaPedidosFtp(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getPastaPedidosFtp())));

        } else {
            cursor.close();
            return null;
        }
        cursor.close();
        return obj;
    }

    public ArrayList<Empresa> getAllEmpresa(int codigo){

        Empresa obj;
        ArrayList<Empresa> lista = new ArrayList<>();

        String sql = "SELECT * FROM " + EmpresaDataModel.getTABELA() +
                " ORDER BY " + EmpresaDataModel.getCodigo();

        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {

                obj = new Empresa();

                obj.setCodigo(cursor.getInt(cursor.getColumnIndex(EmpresaDataModel.getCodigo())));
                obj.setCodigoPk(cursor.getInt(cursor.getColumnIndex(EmpresaDataModel.getCodigoPk())));
                obj.setNome(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getNome())));
                obj.setFantasia(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getFantasia())));
                obj.setEndereco(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getEndereco())));
                obj.setNumero(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getNumero())));
                obj.setComplemento(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getComplemento())));
                obj.setBairro(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getBairro())));
                obj.setCep(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getCep())));
                obj.setCidade(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getCidade())));
                obj.setUf(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getUf())));
                obj.setCnpj(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getCnpj())));
                obj.setInscricaoEstadual(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getInscricaoEstadual())));
                obj.setCpf(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getCpf())));
                obj.setEmail(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getEmail())));
                obj.setTelefone(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getTelefone())));
                obj.setCelular(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getCelular())));
                obj.setUrlFtp(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getUrlFtp())));
                obj.setPortaFtp(cursor.getInt(cursor.getColumnIndex(EmpresaDataModel.getPortaFtp())));
                obj.setUsuarioFtp(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getUsuarioFtp())));
                obj.setSenhaFtp(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getSenhaFtp())));
                obj.setPastaRemssaFtp(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getPastaRemssaFtp())));
                obj.setPastaPedidosFtp(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getPastaPedidosFtp())));

                lista.add(obj);

            } while (cursor.moveToNext());
        }

        cursor.close(); // SEMPRE fechar o cursor

        return lista;

    }

    public GrupoLogin getGrupoLogin(int codigo){

        GrupoLogin obj;

        String sql = "SELECT * FROM " + GrupoLoginDataModel.getTABELA() +
                " WHERE " + GrupoLoginDataModel.getCodigo() + " = " + codigo;

        cursor = db.rawQuery(sql, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            obj = new GrupoLogin();

            obj.setCodigo(cursor.getInt(cursor.getColumnIndex(GrupoLoginDataModel.getCodigo())));
            obj.setCodigoPk(cursor.getInt(cursor.getColumnIndex(GrupoLoginDataModel.getCodigoPk())));
            obj.setNome(cursor.getString(cursor.getColumnIndex(GrupoLoginDataModel.getNome())));
            obj.setAdmin(cursor.getInt(cursor.getColumnIndex(GrupoLoginDataModel.getIsAdmin())) > 0);

        } else {
            cursor.close();
            return null;
        }
        cursor.close();
        return obj;
    }

    public ArrayList<GrupoLogin> getAllGrupoLogin(int codigo){

        GrupoLogin obj;
        ArrayList<GrupoLogin> lista = new ArrayList<>();

        String sql = "SELECT * FROM " + GrupoLoginDataModel.getTABELA() +
                " ORDER BY " + GrupoLoginDataModel.getCodigo();

        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {

                obj = new GrupoLogin();

                obj.setCodigo(cursor.getInt(cursor.getColumnIndex(GrupoLoginDataModel.getCodigo())));
                obj.setCodigoPk(cursor.getInt(cursor.getColumnIndex(GrupoLoginDataModel.getCodigoPk())));
                obj.setNome(cursor.getString(cursor.getColumnIndex(GrupoLoginDataModel.getNome())));
                obj.setAdmin(cursor.getInt(cursor.getColumnIndex(GrupoLoginDataModel.getIsAdmin())) > 0);

                lista.add(obj);

            } while (cursor.moveToNext());
        }

        cursor.close(); // SEMPRE fechar o cursor

        return lista;

    }

    public ModalidadePagamento getModalidadePagamento(int codigo){

        ModalidadePagamento obj;

        String sql = "SELECT * FROM " + ModalidadePagamentoDataModel.getTABELA() +
                " WHERE " + ModalidadePagamentoDataModel.getCodigo() + " = " + codigo;

        cursor = db.rawQuery(sql, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            obj = new ModalidadePagamento();

            obj.setCodigo(cursor.getInt(cursor.getColumnIndex(ModalidadePagamentoDataModel.getCodigo())));
            obj.setCodigoPk(cursor.getInt(cursor.getColumnIndex(ModalidadePagamentoDataModel.getCodigoPk())));
            obj.setNome(cursor.getString(cursor.getColumnIndex(ModalidadePagamentoDataModel.getNome())));

        } else {
            cursor.close();
            return null;
        }
        cursor.close();
        return obj;
    }

    public ArrayList<ModalidadePagamento> getAllModalidadePagamento(){

        ModalidadePagamento obj;
        ArrayList<ModalidadePagamento> lista = new ArrayList<>();

        String sql = "SELECT * FROM " + ModalidadePagamentoDataModel.getTABELA() +
                " ORDER BY " + ModalidadePagamentoDataModel.getCodigo();

        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {

                obj = new ModalidadePagamento();

                obj.setCodigo(cursor.getInt(cursor.getColumnIndex(ModalidadePagamentoDataModel.getCodigo())));
                obj.setCodigoPk(cursor.getInt(cursor.getColumnIndex(ModalidadePagamentoDataModel.getCodigoPk())));
                obj.setNome(cursor.getString(cursor.getColumnIndex(ModalidadePagamentoDataModel.getNome())));

                lista.add(obj);

            } while (cursor.moveToNext());
        }

        cursor.close(); // SEMPRE fechar o cursor

        return lista;

    }

    public Produto getProduto(int codigo){

        Produto obj;

        String sql = "SELECT * FROM " + ProdutoDataModel.getTABELA() +
                " WHERE " + ProdutoDataModel.getCodigo() + " = " + codigo;

        cursor = db.rawQuery(sql, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            obj = new Produto();

            obj.setCodigo(cursor.getInt(cursor.getColumnIndex(ProdutoDataModel.getCodigo())));
            obj.setCodigoPk(cursor.getInt(cursor.getColumnIndex(ProdutoDataModel.getCodigoPk())));
            obj.setNome(cursor.getString(cursor.getColumnIndex(ProdutoDataModel.getNome())));
            obj.setValor(cursor.getFloat(cursor.getColumnIndex(ProdutoDataModel.getValor())));
            obj.setEstoque(cursor.getFloat(cursor.getColumnIndex(ProdutoDataModel.getEstoque())));
            obj.setUnidade(cursor.getString(cursor.getColumnIndex(ProdutoDataModel.getUnidade())));
            obj.setReferencia(cursor.getString(cursor.getColumnIndex(ProdutoDataModel.getReferencia())));
            obj.setCodEmpresa(cursor.getInt(cursor.getColumnIndex(ProdutoDataModel.getCodEmpresa())));
            obj.setLoginEmpresa(cursor.getString(cursor.getColumnIndex(ProdutoDataModel.getLoginEmpresa())));
            obj.setCodGefims(cursor.getInt(cursor.getColumnIndex(ProdutoDataModel.getCodGefims())));
            obj.setGrupoEmpresa(cursor.getString(cursor.getColumnIndex(ProdutoDataModel.getGrupoEmpresa())));

        } else {
            cursor.close();
            return null;
        }
        cursor.close();
        return obj;
    }

    public ArrayList<Produto> getAllProduto(){

        Produto obj;
        ArrayList<Produto> lista = new ArrayList<>();

        String sql = "SELECT * FROM " + ProdutoDataModel.getTABELA() +
                " ORDER BY " + ProdutoDataModel.getCodigo();

        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {

                obj = new Produto();

                obj.setCodigo(cursor.getInt(cursor.getColumnIndex(ProdutoDataModel.getCodigo())));
                obj.setCodigoPk(cursor.getInt(cursor.getColumnIndex(ProdutoDataModel.getCodigoPk())));
                obj.setNome(cursor.getString(cursor.getColumnIndex(ProdutoDataModel.getNome())));
                obj.setValor(cursor.getFloat(cursor.getColumnIndex(ProdutoDataModel.getValor())));
                obj.setEstoque(cursor.getFloat(cursor.getColumnIndex(ProdutoDataModel.getEstoque())));
                obj.setUnidade(cursor.getString(cursor.getColumnIndex(ProdutoDataModel.getUnidade())));
                obj.setReferencia(cursor.getString(cursor.getColumnIndex(ProdutoDataModel.getReferencia())));
                obj.setCodEmpresa(cursor.getInt(cursor.getColumnIndex(ProdutoDataModel.getCodEmpresa())));
                obj.setLoginEmpresa(cursor.getString(cursor.getColumnIndex(ProdutoDataModel.getLoginEmpresa())));
                obj.setCodGefims(cursor.getInt(cursor.getColumnIndex(ProdutoDataModel.getCodGefims())));
                obj.setGrupoEmpresa(cursor.getString(cursor.getColumnIndex(ProdutoDataModel.getGrupoEmpresa())));

                lista.add(obj);

            } while (cursor.moveToNext());
        }

        cursor.close(); // SEMPRE fechar o cursor

        return lista;

    }

    public ProdutoVenda getProdutoVenda(int codigo){

        ProdutoVenda obj;

        String sql = "SELECT * FROM " + ProdutoVendaDataModel.getTABELA() +
                " WHERE " + ProdutoVendaDataModel.getCodigo() + " = " + codigo;

        cursor = db.rawQuery(sql, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            obj = new ProdutoVenda();

            obj.setCodigo(cursor.getInt(cursor.getColumnIndex(ProdutoVendaDataModel.getCodigo())));
            obj.setCodigoPk(cursor.getInt(cursor.getColumnIndex(ProdutoVendaDataModel.getCodigoPk())));
            obj.setCliente(cursor.getInt(cursor.getColumnIndex(ProdutoVendaDataModel.getCliente())));

            //Função para pegar uma data do SQLite através de um cursor
            String stringData = cursor.getString(cursor.getColumnIndex(ProdutoVendaDataModel.getData()));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date data = new Date();
            try {
                data = dateFormat.parse(stringData);
            } catch (ParseException e) {
                Log.e("Erro de Conversão", "DB -----> Erro na conversão de data em TB_PROD_VENDAS: " + e.getMessage());
                e.printStackTrace();
            }
            obj.setData(data);

            obj.setCodigoProduto(cursor.getInt(cursor.getColumnIndex(ProdutoVendaDataModel.getCodigoProduto())));
            obj.setNomeProduto(cursor.getString(cursor.getColumnIndex(ProdutoVendaDataModel.getNomeProduto())));
            obj.setQuantidade(cursor.getFloat(cursor.getColumnIndex(ProdutoVendaDataModel.getQuantidade())));
            obj.setValorUnitario(cursor.getFloat(cursor.getColumnIndex(ProdutoVendaDataModel.getValorUnitario())));
            obj.setValorTotal(cursor.getFloat(cursor.getColumnIndex(ProdutoVendaDataModel.getValorTotal())));
            obj.setUnidade(cursor.getString(cursor.getColumnIndex(ProdutoVendaDataModel.getUnidade())));
            obj.setItem(cursor.getInt(cursor.getColumnIndex(ProdutoVendaDataModel.getItem())));
            obj.setNumPedido(cursor.getString(cursor.getColumnIndex(ProdutoVendaDataModel.getNumPedido())));
            obj.setLoginEmpresa(cursor.getString(cursor.getColumnIndex(ProdutoVendaDataModel.getLoginEmpresa())));
            obj.setReferencia(cursor.getString(cursor.getColumnIndex(ProdutoVendaDataModel.getReferencia())));
            obj.setCodigoVenda(cursor.getInt(cursor.getColumnIndex(ProdutoVendaDataModel.getCodigoVenda())));
            obj.setGrupoEmpresa(cursor.getString(cursor.getColumnIndex(ProdutoVendaDataModel.getGrupoEmpresa())));

        } else {
            cursor.close();
            return null;
        }
        cursor.close();
        return obj;
    }

    public ArrayList<ProdutoVenda> getAllProdutoVenda(int codigo){

        ProdutoVenda obj;
        ArrayList<ProdutoVenda> lista = new ArrayList<>();

        String sql = "SELECT * FROM " + ProdutoVendaDataModel.getTABELA() +
                " WHERE " + ProdutoVendaDataModel.getCodigoVenda() + " = " + codigo +
                " ORDER BY " + ProdutoVendaDataModel.getCodigo();

        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {

                obj = new ProdutoVenda();

                obj.setCodigo(cursor.getInt(cursor.getColumnIndex(ProdutoVendaDataModel.getCodigo())));
                obj.setCodigoPk(cursor.getInt(cursor.getColumnIndex(ProdutoVendaDataModel.getCodigoPk())));
                obj.setCliente(cursor.getInt(cursor.getColumnIndex(ProdutoVendaDataModel.getCliente())));

                //Função para pegar uma data do SQLite através de um cursor
                String stringData = cursor.getString(cursor.getColumnIndex(ProdutoVendaDataModel.getData()));
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date data = new Date();
                try {
                    data = dateFormat.parse(stringData);
                } catch (ParseException e) {
                    Log.e("Erro de Conversão", "DB -----> Erro na conversão de data em TB_PROD_VENDAS: " + e.getMessage());
                    e.printStackTrace();
                }
                obj.setData(data);

                obj.setCodigoProduto(cursor.getInt(cursor.getColumnIndex(ProdutoVendaDataModel.getCodigoProduto())));
                obj.setNomeProduto(cursor.getString(cursor.getColumnIndex(ProdutoVendaDataModel.getNomeProduto())));
                obj.setQuantidade(cursor.getFloat(cursor.getColumnIndex(ProdutoVendaDataModel.getQuantidade())));
                obj.setValorUnitario(cursor.getFloat(cursor.getColumnIndex(ProdutoVendaDataModel.getValorUnitario())));
                obj.setValorTotal(cursor.getFloat(cursor.getColumnIndex(ProdutoVendaDataModel.getValorTotal())));
                obj.setUnidade(cursor.getString(cursor.getColumnIndex(ProdutoVendaDataModel.getUnidade())));
                obj.setItem(cursor.getInt(cursor.getColumnIndex(ProdutoVendaDataModel.getItem())));
                obj.setNumPedido(cursor.getString(cursor.getColumnIndex(ProdutoVendaDataModel.getNumPedido())));
                obj.setLoginEmpresa(cursor.getString(cursor.getColumnIndex(ProdutoVendaDataModel.getLoginEmpresa())));
                obj.setReferencia(cursor.getString(cursor.getColumnIndex(ProdutoVendaDataModel.getReferencia())));
                obj.setCodigoVenda(cursor.getInt(cursor.getColumnIndex(ProdutoVendaDataModel.getCodigoVenda())));
                obj.setGrupoEmpresa(cursor.getString(cursor.getColumnIndex(ProdutoVendaDataModel.getGrupoEmpresa())));

                lista.add(obj);

            } while (cursor.moveToNext());
        }

        cursor.close(); // SEMPRE fechar o cursor

        return lista;

    }

    public Remessa getRemessa(int codigo){

        Remessa obj;

        String sql = "SELECT * FROM " + RemessaDataModel.getTABELA() +
                " WHERE " + RemessaDataModel.getCodigo() + " = " + codigo;

        cursor = db.rawQuery(sql, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            obj = new Remessa();

            obj.setCodigo(cursor.getInt(cursor.getColumnIndex(RemessaDataModel.getCodigo())));
            obj.setCodigoPk(cursor.getInt(cursor.getColumnIndex(RemessaDataModel.getCodigoPk())));
            obj.setCnpj(cursor.getString(cursor.getColumnIndex(RemessaDataModel.getCnpj())));
            obj.setNroRemessa(cursor.getInt(cursor.getColumnIndex(RemessaDataModel.getNroRemessa())));

            //Função para pegar uma data do SQLite através de um cursor
            String stringData = cursor.getString(cursor.getColumnIndex(RemessaDataModel.getDataRemessa()));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date data = new Date();
            try {
                data = dateFormat.parse(stringData);
            } catch (ParseException e) {
                Log.e("Erro de Conversão", "DB -----> Erro na conversão de data em TB_REMESSAS: " + e.getMessage());
                e.printStackTrace();
            }
            obj.setDataRemessa(data);

            obj.setLoginEmpresa(cursor.getString(cursor.getColumnIndex(RemessaDataModel.getLoginEmpresa())));
            obj.setGrupoEmpresa(cursor.getString(cursor.getColumnIndex(RemessaDataModel.getGrupoEmpresa())));

        } else {
            cursor.close();
            return null;
        }
        cursor.close();
        return obj;
    }

    public ArrayList<Remessa> getAllRemessa(int codigo){

        Remessa obj;
        ArrayList<Remessa> lista = new ArrayList<>();

        String sql = "SELECT * FROM " + RemessaDataModel.getTABELA() +
                " ORDER BY " + RemessaDataModel.getCodigo();

        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {

                obj = new Remessa();

                obj.setCodigo(cursor.getInt(cursor.getColumnIndex(RemessaDataModel.getCodigo())));
                obj.setCodigoPk(cursor.getInt(cursor.getColumnIndex(RemessaDataModel.getCodigoPk())));
                obj.setCnpj(cursor.getString(cursor.getColumnIndex(RemessaDataModel.getCnpj())));
                obj.setNroRemessa(cursor.getInt(cursor.getColumnIndex(RemessaDataModel.getNroRemessa())));

                //Função para pegar uma data do SQLite através de um cursor
                String stringData = cursor.getString(cursor.getColumnIndex(RemessaDataModel.getDataRemessa()));
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date data = new Date();
                try {
                    data = dateFormat.parse(stringData);
                } catch (ParseException e) {
                    Log.e("Erro de Conversão", "DB -----> Erro na conversão de data em TB_REMESSAS: " + e.getMessage());
                    e.printStackTrace();
                }
                obj.setDataRemessa(data);

                obj.setLoginEmpresa(cursor.getString(cursor.getColumnIndex(RemessaDataModel.getLoginEmpresa())));
                obj.setGrupoEmpresa(cursor.getString(cursor.getColumnIndex(RemessaDataModel.getGrupoEmpresa())));

                lista.add(obj);

            } while (cursor.moveToNext());
        }

        cursor.close(); // SEMPRE fechar o cursor

        return lista;

    }

    public Usuario getUsuario(int codigo){

        Usuario obj;

        String sql = "SELECT * FROM " + UsuarioDataModel.getTABELA() +
                " WHERE " + UsuarioDataModel.getCodigo() + " = " + codigo;

        cursor = db.rawQuery(sql, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            obj = new Usuario();

            obj.setCodigo(cursor.getInt(cursor.getColumnIndex(UsuarioDataModel.getCodigo())));
            obj.setCodigoPk(cursor.getInt(cursor.getColumnIndex(UsuarioDataModel.getCodigoPk())));
            obj.setLogin(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.getLogin())));
            obj.setSenha(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.getSenha())));
            obj.setNomeGrupo(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.getNomeGrupo())));
            obj.setGrupo(cursor.getInt(cursor.getColumnIndex(UsuarioDataModel.getGrupo())));
            obj.setObs(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.getObs())));

        } else {
            cursor.close();
            return null;
        }
        cursor.close();
        return obj;
    }

    public ArrayList<Usuario> getAllUsuario(int codigo){

        Usuario obj;
        ArrayList<Usuario> lista = new ArrayList<>();

        String sql = "SELECT * FROM " + UsuarioDataModel.getTABELA() +
                " ORDER BY " + UsuarioDataModel.getCodigo();

        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {

                obj = new Usuario();

                obj.setCodigo(cursor.getInt(cursor.getColumnIndex(UsuarioDataModel.getCodigo())));
                obj.setCodigoPk(cursor.getInt(cursor.getColumnIndex(UsuarioDataModel.getCodigoPk())));
                obj.setLogin(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.getLogin())));
                obj.setSenha(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.getSenha())));
                obj.setNomeGrupo(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.getNomeGrupo())));
                obj.setGrupo(cursor.getInt(cursor.getColumnIndex(UsuarioDataModel.getGrupo())));
                obj.setObs(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.getObs())));

                lista.add(obj);

            } while (cursor.moveToNext());
        }

        cursor.close(); // SEMPRE fechar o cursor

        return lista;

    }

    public Vencimento getVencimento(int codigo){

        Vencimento obj;

        String sql = "SELECT * FROM " + VencimentoDataModel.getTABELA() +
                " WHERE " + VencimentoDataModel.getCodigo() + " = " + codigo;

        cursor = db.rawQuery(sql, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            obj = new Vencimento();

            obj.setCodigo(cursor.getInt(cursor.getColumnIndex(VencimentoDataModel.getCodigo())));
            obj.setCodigoPk(cursor.getInt(cursor.getColumnIndex(VencimentoDataModel.getCodigoPk())));
            obj.setCodigoVenda(cursor.getInt(cursor.getColumnIndex(VencimentoDataModel.getCodigoVenda())));
            obj.setNumVenda(cursor.getString(cursor.getColumnIndex(VencimentoDataModel.getNumVenda())));
            obj.setValorParcela(cursor.getFloat(cursor.getColumnIndex(VencimentoDataModel.getValorParcela())));
            obj.setLoginEmpresa(cursor.getString(cursor.getColumnIndex(VencimentoDataModel.getLoginEmpresa())));

            //Função para pegar uma data do SQLite através de um cursor
            String stringData = cursor.getString(cursor.getColumnIndex(VencimentoDataModel.getDataVencimento()));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date data = new Date();
            try {
                data = dateFormat.parse(stringData);
            } catch (ParseException e) {
                Log.e("Erro de Conversão", "DB -----> Erro na conversão de data em TB_VENCIMENTOS: " + e.getMessage());
                e.printStackTrace();
            }
            obj.setDataVencimento(data);

            obj.setGrupoEmpresa(cursor.getString(cursor.getColumnIndex(VencimentoDataModel.getGrupoEmpresa())));

        } else {
            cursor.close();
            return null;
        }
        cursor.close();
        return obj;
    }

    public ArrayList<Vencimento> getAllVencimento(int codigo){

        Vencimento obj;
        ArrayList<Vencimento> lista = new ArrayList<>();

        String sql = "SELECT * FROM " + VencimentoDataModel.getTABELA() +
                " WHERE " + VencimentoDataModel.getCodigoVenda() + " = " + codigo +
                " ORDER BY " + VencimentoDataModel.getCodigo();

        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {

                obj = new Vencimento();

                obj.setCodigo(cursor.getInt(cursor.getColumnIndex(VencimentoDataModel.getCodigo())));
                obj.setCodigoPk(cursor.getInt(cursor.getColumnIndex(VencimentoDataModel.getCodigoPk())));
                obj.setCodigoVenda(cursor.getInt(cursor.getColumnIndex(VencimentoDataModel.getCodigoVenda())));
                obj.setNumVenda(cursor.getString(cursor.getColumnIndex(VencimentoDataModel.getNumVenda())));
                obj.setValorParcela(cursor.getFloat(cursor.getColumnIndex(VencimentoDataModel.getValorParcela())));
                obj.setLoginEmpresa(cursor.getString(cursor.getColumnIndex(VencimentoDataModel.getLoginEmpresa())));

                //Função para pegar uma data do SQLite através de um cursor
                String stringData = cursor.getString(cursor.getColumnIndex(VencimentoDataModel.getDataVencimento()));
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date data = new Date();
                try {
                    data = dateFormat.parse(stringData);
                } catch (ParseException e) {
                    Log.e("Erro de Conversão", "DB -----> Erro na conversão de data em TB_VENCIMENTOS: " + e.getMessage());
                    e.printStackTrace();
                }
                obj.setDataVencimento(data);

                obj.setGrupoEmpresa(cursor.getString(cursor.getColumnIndex(VencimentoDataModel.getGrupoEmpresa())));

                lista.add(obj);

            } while (cursor.moveToNext());
        }

        cursor.close(); // SEMPRE fechar o cursor

        return lista;

    }

    public Venda getVenda(int codigo){

        Venda obj;

        String sql = "SELECT * FROM " + VendaDataModel.getTABELA() +
                " WHERE " + VendaDataModel.getCodigo() + " = " + codigo;

        cursor = db.rawQuery(sql, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            obj = new Venda();

            obj.setCodigo(cursor.getInt(cursor.getColumnIndex(VendaDataModel.getCodigo())));
            obj.setCodigoPk(cursor.getInt(cursor.getColumnIndex(VendaDataModel.getCodigoPk())));

            //Função para pegar uma data do SQLite através de um cursor
            String stringData = cursor.getString(cursor.getColumnIndex(VendaDataModel.getData()));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date data = new Date();
            try {
                data = dateFormat.parse(stringData);
            } catch (ParseException e) {
                Log.e("Erro de Conversão", "DB -----> Erro na conversão de data em TB_VENDAS: " + e.getMessage());
                e.printStackTrace();
            }
            obj.setData(data);

            obj.setCliente(cursor.getInt(cursor.getColumnIndex(VendaDataModel.getCliente())));
            obj.setTotal(cursor.getFloat(cursor.getColumnIndex(VendaDataModel.getTotal())));
            obj.setModalidadePagamento(cursor.getInt(cursor.getColumnIndex(VendaDataModel.getModalidadePagamento())));
            obj.setNumParcelas(cursor.getInt(cursor.getColumnIndex(VendaDataModel.getNumParcelas())));
            obj.setLoginEmpresa(cursor.getString(cursor.getColumnIndex(VendaDataModel.getLoginEmpresa())));
            obj.setNumPedido(cursor.getString(cursor.getColumnIndex(VendaDataModel.getNumPedido())));
            obj.setGrupoEmpresa(cursor.getString(cursor.getColumnIndex(VendaDataModel.getGrupoEmpresa())));
            obj.setTransmitida(cursor.getInt(cursor.getColumnIndex(VendaDataModel.getTransmitida())) > 0);

        } else {
            cursor.close();
            return null;
        }
        cursor.close();
        return obj;
    }

    public ArrayList<Venda> getAllVenda(){

        Venda obj;
        ArrayList<Venda> lista = new ArrayList<>();

        String sql = "SELECT * FROM " + VendaDataModel.getTABELA() +
                " ORDER BY " + VendaDataModel.getData() + " DESC";

        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {

                obj = new Venda();

                obj.setCodigo(cursor.getInt(cursor.getColumnIndex(VendaDataModel.getCodigo())));
                obj.setCodigoPk(cursor.getInt(cursor.getColumnIndex(VendaDataModel.getCodigoPk())));

                //Função para pegar uma data do SQLite através de um cursor
                String stringData = cursor.getString(cursor.getColumnIndex(VendaDataModel.getData()));
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date data = new Date();
                try {
                    data = dateFormat.parse(stringData);
                } catch (ParseException e) {
                    Log.e("Erro de Conversão", "DB -----> Erro na conversão de data em TB_VENDAS: " + e.getMessage());
                    e.printStackTrace();
                }
                obj.setData(data);

                obj.setCliente(cursor.getInt(cursor.getColumnIndex(VendaDataModel.getCliente())));
                obj.setTotal(cursor.getFloat(cursor.getColumnIndex(VendaDataModel.getTotal())));
                obj.setModalidadePagamento(cursor.getInt(cursor.getColumnIndex(VendaDataModel.getModalidadePagamento())));
                obj.setNumParcelas(cursor.getInt(cursor.getColumnIndex(VendaDataModel.getNumParcelas())));
                obj.setLoginEmpresa(cursor.getString(cursor.getColumnIndex(VendaDataModel.getLoginEmpresa())));
                obj.setNumPedido(cursor.getString(cursor.getColumnIndex(VendaDataModel.getNumPedido())));
                obj.setGrupoEmpresa(cursor.getString(cursor.getColumnIndex(VendaDataModel.getGrupoEmpresa())));
                obj.setTransmitida(cursor.getInt(cursor.getColumnIndex(VendaDataModel.getTransmitida())) > 0);

                lista.add(obj);

            } while (cursor.moveToNext());
        }

        cursor.close(); // SEMPRE fechar o cursor

        return lista;

    }
}
