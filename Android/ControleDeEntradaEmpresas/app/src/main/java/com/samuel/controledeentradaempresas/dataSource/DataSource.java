package com.samuel.controledeentradaempresas.dataSource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.samuel.controledeentradaempresas.dataModel.ClienteDataModel;
import com.samuel.controledeentradaempresas.dataModel.EmpresaDataModel;
import com.samuel.controledeentradaempresas.dataModel.ReservaDataModel;
import com.samuel.controledeentradaempresas.model.Cliente;
import com.samuel.controledeentradaempresas.model.Empresa;
import com.samuel.controledeentradaempresas.model.Reserva;
import com.samuel.controledeentradaempresas.util.UtilAplicativo;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DataSource extends SQLiteOpenHelper {

    private static final String DB_NAME = "controle_entradas.sqlite";
    private static final int DB_VERSION = 1;

    Cursor cursor;

    SQLiteDatabase db;

    public DataSource(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db =getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        try {
            db.execSQL(EmpresaDataModel.criarTabela());
        } catch (Exception e) {
            Log.e("Banco de Dados", "DB ----> ERRO na Criação da Tabela Empresas: " + e.getMessage());
        }

        try {
            db.execSQL(ClienteDataModel.criarTabela());
        } catch (Exception e) {
            Log.e("Banco de Dados", "DB ----> ERRO na Criação da Tabela Clientes: " + e.getMessage());
        }

        try {
            db.execSQL(ReservaDataModel.criarTabela());
        } catch (Exception e) {
            Log.e("Banco de Dados", "DB ----> ERRO na Criação da Tabela Reservas: " + e.getMessage());
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

    public boolean deletar(String tabela, int id) {

        boolean sucesso = true;

        sucesso = db.delete(tabela, "id=?", new String[]{Integer.toString(id)}) > 0;

        return sucesso;
    }

    public boolean deletarReserva(String tabela, int id) {

        boolean sucesso = true;

        sucesso = db.delete(tabela, "id_reserva=?", new String[]{Integer.toString(id)}) > 0;

        return sucesso;
    }


    public boolean alterarReserva(String tabela, ContentValues dados) {

        boolean sucesso = true;

        int id = dados.getAsInteger("id_reserva");

        sucesso = db.update(tabela, dados, "id_reserva=?", new String[]{Integer.toString(id)}) > 0;

        return sucesso;
    }

    public boolean alterarEmpresa(String tabela, ContentValues dados) {

        boolean sucesso = true;

        int id = dados.getAsInteger("id_empresa");

        sucesso = db.update(tabela, dados, "id_empresa=?", new String[]{Integer.toString(id)}) > 0;

        return sucesso;
    }

    public boolean alterarCliente(String tabela, ContentValues dados) {

        boolean sucesso = true;

        int id = dados.getAsInteger("id_cliente");

        sucesso = db.update(tabela, dados, "id_cliente=?", new String[]{Integer.toString(id)}) > 0;

        return sucesso;
    }

    public Empresa getEmpresa(String email) {

        Empresa obj;

        String sql = "SELECT * FROM " + EmpresaDataModel.getTABELA() + " WHERE " + EmpresaDataModel.getEmail() + " = '" + email + "'";

        cursor = db.rawQuery(sql, null);

        if (cursor.getCount() > 0){

            cursor.moveToFirst();
            obj = new Empresa();

            obj.setId(cursor.getInt(cursor.getColumnIndex(EmpresaDataModel.getId())));
            obj.setIdPk(cursor.getInt(cursor.getColumnIndex(EmpresaDataModel.getIdPk())));
            obj.setNome(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getNome())));
            obj.setCnpj(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getCnpj())));
            obj.setEndereco(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getEndereco())));
            obj.setNumero(cursor.getInt(cursor.getColumnIndex(EmpresaDataModel.getNumero())));
            obj.setComplemento(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getComplemento())));
            obj.setBairro(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getBairro())));
            obj.setCidade(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getCidade())));
            obj.setUf(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getUf())));
            obj.setCep(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getCep())));
            obj.setDescricao(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getDescricao())));


            //Checa se os Valores de Time foram nulos para a tabela e coloca 00:00:00 se sim
            //Abertura Segunda
            if (cursor.getString(cursor.getColumnIndexOrThrow(EmpresaDataModel.getHoraAberturaSegunda())).equals("null")){
                obj.setHoraAberturaSegunda(Time.valueOf("00:00:00"));
            } else {
                obj.setHoraAberturaSegunda(Time.valueOf(cursor.getString((cursor.getColumnIndex(EmpresaDataModel.getHoraAberturaSegunda())))));
            }

            //Fechamento Segunda
            if (cursor.getString(cursor.getColumnIndexOrThrow(EmpresaDataModel.getHoraFechamentoSegunda())).equals("null")){
                obj.setHoraFechamentoSegunda(Time.valueOf("00:00:00"));
            } else {
                obj.setHoraFechamentoSegunda(Time.valueOf(cursor.getString((cursor.getColumnIndex(EmpresaDataModel.getHoraFechamentoSegunda())))));
            }

            //Abertura Terça
            if (cursor.getString(cursor.getColumnIndexOrThrow(EmpresaDataModel.getHoraAberturaTerca())).equals("null")){
                obj.setHoraAberturaTerca(Time.valueOf("00:00:00"));
            } else {
                obj.setHoraAberturaTerca(Time.valueOf(cursor.getString((cursor.getColumnIndex(EmpresaDataModel.getHoraAberturaTerca())))));
            }


            //Fechamento Terça
            if (cursor.getString(cursor.getColumnIndexOrThrow(EmpresaDataModel.getHoraFechamentoTerca())).equals("null")){
                obj.setHoraFechamentoTerca(Time.valueOf("00:00:00"));
            } else {
                obj.setHoraFechamentoTerca(Time.valueOf(cursor.getString((cursor.getColumnIndex(EmpresaDataModel.getHoraFechamentoTerca())))));
            }

            //Abertura Quarta
            if (cursor.getString(cursor.getColumnIndexOrThrow(EmpresaDataModel.getHoraAberturaQuarta())).equals("null")){
                obj.setHoraAberturaQuarta(Time.valueOf("00:00:00"));
            } else {
                obj.setHoraAberturaQuarta(Time.valueOf(cursor.getString((cursor.getColumnIndex(EmpresaDataModel.getHoraAberturaQuarta())))));
            }

            //Fechamento Quarta
            if (cursor.getString(cursor.getColumnIndexOrThrow(EmpresaDataModel.getHoraFechamentoQuarta())).equals("null")){
                obj.setHoraFechamentoQuarta(Time.valueOf("00:00:00"));
            } else {
                obj.setHoraFechamentoQuarta(Time.valueOf(cursor.getString((cursor.getColumnIndex(EmpresaDataModel.getHoraFechamentoQuarta())))));
            }

            //Abertura Quinta
            if (cursor.getString(cursor.getColumnIndexOrThrow(EmpresaDataModel.getHoraAberturaQuinta())).equals("null")){
                obj.setHoraAberturaQuinta(Time.valueOf("00:00:00"));
            } else {
                obj.setHoraAberturaQuinta(Time.valueOf(cursor.getString((cursor.getColumnIndex(EmpresaDataModel.getHoraAberturaQuinta())))));
            }

            //Fechamento Quinta
            if (cursor.getString(cursor.getColumnIndexOrThrow(EmpresaDataModel.getHoraFechamentoQuinta())).equals("null")){
                obj.setHoraFechamentoQuinta(Time.valueOf("00:00:00"));
            } else {
                obj.setHoraFechamentoQuinta(Time.valueOf(cursor.getString((cursor.getColumnIndex(EmpresaDataModel.getHoraFechamentoQuinta())))));
            }

            //Abertura Sexta
            if (cursor.getString(cursor.getColumnIndexOrThrow(EmpresaDataModel.getHoraAberturaSexta())).equals("null")){
                obj.setHoraAberturaSexta(Time.valueOf("00:00:00"));
            } else {
                obj.setHoraAberturaSexta(Time.valueOf(cursor.getString((cursor.getColumnIndex(EmpresaDataModel.getHoraAberturaSexta())))));
            }

            //Fechamento Sexta
            if (cursor.getString(cursor.getColumnIndexOrThrow(EmpresaDataModel.getHoraFechamentoSexta())).equals("null")){
                obj.setHoraFechamentoSexta(Time.valueOf("00:00:00"));
            } else {
                obj.setHoraFechamentoSexta(Time.valueOf(cursor.getString((cursor.getColumnIndex(EmpresaDataModel.getHoraFechamentoSexta())))));
            }

            //Abertura Sabado
            if (cursor.getString(cursor.getColumnIndexOrThrow(EmpresaDataModel.getHoraAberturaSabado())).equals("null")){
                obj.setHoraAberturaSabado(Time.valueOf("00:00:00"));
            } else {
                obj.setHoraAberturaSabado(Time.valueOf(cursor.getString((cursor.getColumnIndex(EmpresaDataModel.getHoraAberturaSabado())))));
            }

            //Fechamento Sabado
            if (cursor.getString(cursor.getColumnIndexOrThrow(EmpresaDataModel.getHoraFechamentoSabado())).equals("null")){
                obj.setHoraFechamentoSabado(Time.valueOf("00:00:00"));
            } else {
                obj.setHoraFechamentoSabado(Time.valueOf(cursor.getString((cursor.getColumnIndex(EmpresaDataModel.getHoraFechamentoSabado())))));
            }

            //Abertura Domingo
            if (cursor.getString(cursor.getColumnIndexOrThrow(EmpresaDataModel.getHoraAberturaDomingo())).equals("null")){
                obj.setHoraAberturaDomingo(Time.valueOf("00:00:00"));
            } else {
                obj.setHoraAberturaDomingo(Time.valueOf(cursor.getString((cursor.getColumnIndex(EmpresaDataModel.getHoraAberturaDomingo())))));
            }

            //Fechamento Domingo
            if (cursor.getString(cursor.getColumnIndexOrThrow(EmpresaDataModel.getHoraFechamentoDomingo())).equals("null")){
                obj.setHoraFechamentoDomingo(Time.valueOf("00:00:00"));
            } else {
                obj.setHoraFechamentoDomingo(Time.valueOf(cursor.getString((cursor.getColumnIndex(EmpresaDataModel.getHoraFechamentoDomingo())))));
            }

            obj.setTokenFirebase(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getTokenFirebase())));
            obj.setEmail(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getEmail())));
            obj.setSenha(cursor.getString(cursor.getColumnIndex(EmpresaDataModel.getSenha())));

        } else {
            cursor.close();
            return null;
        }

        /*if (cursor.moveToFirst()) {

            do {

                obj = new Empresa();

                obj.setId(cursor.getInt(cursor.getColumnIndex(EmpresaDataModel.getId())));

            } while (cursor.moveToNext());
        }*/

        cursor.close(); // SEMPRE fechar o cursor

        return obj;
    }

    public Cliente getCliente(String email) {

        Cliente obj;

        String sql = "SELECT * FROM " + ClienteDataModel.getTABELA() + " WHERE " + ClienteDataModel.getEmail() + " = '" + email + "'";

        cursor = db.rawQuery(sql, null);

        if (cursor.getCount() > 0){

            cursor.moveToFirst();
            obj = new Cliente();

            obj.setId(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.getId())));
            obj.setIdPk(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.getIdPk())));
            obj.setNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.getNome())));
            obj.setEmail(cursor.getString(cursor.getColumnIndex(ClienteDataModel.getEmail())));
            obj.setSenha(cursor.getString(cursor.getColumnIndex(ClienteDataModel.getSenha())));
            obj.setTelefone(cursor.getString(cursor.getColumnIndex(ClienteDataModel.getTelefone())));
            obj.setStatus(cursor.getString(cursor.getColumnIndex(ClienteDataModel.getStatus())));
            obj.setTokenFirebase(cursor.getString(cursor.getColumnIndex(ClienteDataModel.getTokenFirebase())));

        } else {
            cursor.close();
            return null;
        }

        cursor.close(); // SEMPRE fechar o cursor

        return obj;
    }

    public ArrayList<Reserva> getAllReservas() {
        Reserva obj;

        ArrayList<Reserva> lista = new ArrayList<>();

        String sql = "SELECT * FROM " + ReservaDataModel.getTABELA() +
                " ORDER BY " + ReservaDataModel.getHoraReserva();

        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {

                obj = new Reserva();

                obj.setId(cursor.getInt(cursor.getColumnIndex(ReservaDataModel.getId())));
                obj.setIdPk(cursor.getInt(cursor.getColumnIndex(ReservaDataModel.getIdPk())));
                obj.setIdCliente(cursor.getInt(cursor.getColumnIndex(ReservaDataModel.getIdCliente())));
                obj.setNomeClliente(cursor.getString(cursor.getColumnIndex(ReservaDataModel.getNomeCliente())));
                obj.setIdEmpresa(cursor.getInt(cursor.getColumnIndex(ReservaDataModel.getIdEmpresa())));
                obj.setQtdPessoas(cursor.getInt(cursor.getColumnIndex(ReservaDataModel.getQtdPessoas())));
                obj.setHoraReserva(Timestamp.valueOf(cursor.getString(cursor.getColumnIndex(ReservaDataModel.getHoraReserva()))));
                obj.setStatus(cursor.getString(cursor.getColumnIndex(ReservaDataModel.getStatus())));
                obj.setTelefoneCliente(cursor.getString(cursor.getColumnIndex(ReservaDataModel.getTelefoneCliente())));

                lista.add(obj);

            } while (cursor.moveToNext());
        }

        cursor.close(); // SEMPRE fechar o cursor

        return lista;

    }

    public long getCountReservas(){

        String date = new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis());

        long count = DatabaseUtils.longForQuery(db,"SELECT COUNT(*) FROM " + ReservaDataModel.getTABELA() +
                " WHERE date(" + ReservaDataModel.getHoraReserva() + ") = '" + date + "'", null);
        //where date(timestamp) = '1999-12-15'
        return count;
    };

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
}
