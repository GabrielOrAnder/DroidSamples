package gabrihorstudios.com.droidsamples.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by andersonferreira on 30/01/17.
 */

public class BaseDAO extends SQLiteOpenHelper{

    private static String BASE = "DroidSamples";
    private static int DB_VERSION = 1;
    public static String TB_USER = "User";

    public BaseDAO(Context context) {
        super(context, BASE, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table " + TB_USER + " (id integer primary key, name text not null, mail text);";
        db.execSQL(sql);
        Log.i("Base", "Tabela de usuários criada com sucesso!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
