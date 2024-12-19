package com.example.mediaescolarmvc.dataSource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.mediaescolarmvc.dataModel.MediaEscolarDataModel;
import com.example.mediaescolarmvc.model.MediaEscolar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class DataSource extends SQLiteOpenHelper {

    private static final String DB_NAME = "media_escolar.sqlite";
    private static final int DB_VERSION = 1;

    Cursor cursor; //Recebe o ID e pega a coluna e o conteudo dela

    SQLiteDatabase db;

    public DataSource(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(MediaEscolarDataModel.criarTabela());
        } catch (Exception e) {
            Log.e("Media", "DB ----> ERRO: " + e.getMessage());
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

    public boolean alterar(String tabela, ContentValues dados) {

        boolean sucesso = true;

        int id = dados.getAsInteger("id");

        sucesso = db.update(tabela, dados, "id=?", new String[]{Integer.toString(id)}) > 0;

        return sucesso;
    }

    public List<MediaEscolar> getAllMediaEscolar() {
        MediaEscolar obj;

        List<MediaEscolar> lista = new ArrayList<>();

        String sql = "SELECT * FROM " + MediaEscolarDataModel.getTABELA() + " ORDER BY materia";

        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {

                obj = new MediaEscolar();

                obj.setId(cursor.getInt(cursor.getColumnIndex(MediaEscolarDataModel.getId())));
                obj.setMateria(cursor.getString(cursor.getColumnIndex(MediaEscolarDataModel.getMateria())));
                obj.setBimestre(cursor.getString(cursor.getColumnIndex(MediaEscolarDataModel.getBimestre())));
                obj.setSituacao(cursor.getString(cursor.getColumnIndex(MediaEscolarDataModel.getSituacao())));
                obj.setNotaTrabalho(cursor.getDouble(cursor.getColumnIndex(MediaEscolarDataModel.getNotaTrabalho())));
                obj.setNotaProva(cursor.getDouble(cursor.getColumnIndex(MediaEscolarDataModel.getNotaProva())));
                obj.setMediaFinal(cursor.getDouble(cursor.getColumnIndex(MediaEscolarDataModel.getMediaFinal())));

                lista.add(obj);

            } while (cursor.moveToNext());
        }

        cursor.close(); // SEMPRE fechar o cursor

        return lista;

    }

    public ArrayList<MediaEscolar> getAllResultadoFinal() {
        MediaEscolar obj;

        ArrayList<MediaEscolar> lista = new ArrayList<>();

        String sql = "SELECT * FROM " + MediaEscolarDataModel.getTABELA() + " ORDER BY materia";

        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {

                obj = new MediaEscolar();

                obj.setId(cursor.getInt(cursor.getColumnIndex(MediaEscolarDataModel.getId())));
                obj.setIdPK(cursor.getInt(cursor.getColumnIndex(MediaEscolarDataModel.getIdPK())));
                obj.setMateria(cursor.getString(cursor.getColumnIndex(MediaEscolarDataModel.getMateria())));
                obj.setBimestre(cursor.getString(cursor.getColumnIndex(MediaEscolarDataModel.getBimestre())));
                obj.setSituacao(cursor.getString(cursor.getColumnIndex(MediaEscolarDataModel.getSituacao())));
                obj.setNotaTrabalho(cursor.getDouble(cursor.getColumnIndex(MediaEscolarDataModel.getNotaTrabalho())));
                obj.setNotaProva(cursor.getDouble(cursor.getColumnIndex(MediaEscolarDataModel.getNotaProva())));
                obj.setMediaFinal(cursor.getDouble(cursor.getColumnIndex(MediaEscolarDataModel.getMediaFinal())));

                lista.add(obj);

            } while (cursor.moveToNext());
        }

        cursor.close(); // SEMPRE fechar o cursor

        return lista;

    }

    public MediaEscolar buscarObjetoPeloID(String tabela, MediaEscolar obj){

        MediaEscolar mediaEscolar = new MediaEscolar();

        String consultaSQL = "SELECT * FROM " + tabela + " WHERE id= '" + obj.getId() + "'";

        cursor = db.rawQuery(consultaSQL, null);

        if (cursor.moveToFirst()){

            obj = new MediaEscolar();

            obj.setId(cursor.getInt(cursor.getColumnIndex(MediaEscolarDataModel.getId())));
            obj.setIdPK(cursor.getInt(cursor.getColumnIndex(MediaEscolarDataModel.getIdPK())));
            obj.setMateria(cursor.getString(cursor.getColumnIndex(MediaEscolarDataModel.getMateria())));
            obj.setBimestre(cursor.getString(cursor.getColumnIndex(MediaEscolarDataModel.getBimestre())));
            obj.setSituacao(cursor.getString(cursor.getColumnIndex(MediaEscolarDataModel.getSituacao())));
            obj.setNotaTrabalho(cursor.getDouble(cursor.getColumnIndex(MediaEscolarDataModel.getNotaTrabalho())));
            obj.setNotaProva(cursor.getDouble(cursor.getColumnIndex(MediaEscolarDataModel.getNotaProva())));
            obj.setMediaFinal(cursor.getDouble(cursor.getColumnIndex(MediaEscolarDataModel.getMediaFinal())));
        }
        return obj;
    }

    public void backupBancoDeDados(){
        File sd; //Caminho de Destino - Download no SD
        File data; //Caminho de Origem - data/data/pacote/db_name

        File arquivoBancoDeDados; //Nome do arquivo do banco de dados
        File arquivoBackupBanco; //Nome do arquivo do backup

        FileChannel origem; //Leitura do arquivo original
        FileChannel destino; //Gravação do arquivo de destino com o Backup

        try{
            sd = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

            data = Environment.getDataDirectory();

            if (sd.canWrite()){
                String nomeDoBancoDeDados =
                        "//data//com.example.mediaescolarmvc//databases/" + DB_NAME;

                String nomeDoBackup =
                        "bkp_" + DB_NAME;

                arquivoBancoDeDados = new File(data, nomeDoBancoDeDados);
                arquivoBackupBanco = new File(sd, nomeDoBackup);

                if (arquivoBancoDeDados.exists()){

                    origem = new FileInputStream(arquivoBancoDeDados).getChannel();

                    destino = new FileOutputStream(arquivoBackupBanco).getChannel();

                    destino.transferFrom(origem, 0, origem.size());

                    origem.close();
                    destino.close();
                }
            }
        } catch (Exception e){
            Log.e("DB", "ERRO ao realizar o backup: " + e.getMessage());
        }
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
}
