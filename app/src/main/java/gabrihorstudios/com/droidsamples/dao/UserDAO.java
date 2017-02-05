package gabrihorstudios.com.droidsamples.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import gabrihorstudios.com.droidsamples.model.User;

/**
 * Created by andersonferreira on 30/01/17.
 */

public class UserDAO extends BaseDAO {

    public UserDAO(Context context) {
        super(context);
    }

    public void insert(User user){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("name", user.getName());
        cv.put("mail", user.getMail());

        db.insert(super.TB_USER, null, cv);
        Log.i("Base", "usuário inserido com sucesso!");
    }

    public List<User> listar(){
        List<User> users = new ArrayList<User>();
        User user;
        String sql = "Select name, mail from " + super.TB_USER + ";";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()){
            user = new User();
            user.setName(cursor.getString(cursor.getColumnIndex("name")));
            user.setMail(cursor.getString(cursor.getColumnIndex("mail")));
            users.add(user);
        }
        return users;
    }

    public void remove(int id){
        SQLiteDatabase db = getWritableDatabase();
        String[] args = {String.valueOf(id)};
        db.delete(super.TB_USER, "id=?", args);
        Log.i("Base", "usuário removido com sucesso!");
    }
}
