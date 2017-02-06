package gabrihorstudios.com.droidsamples;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import gabrihorstudios.com.droidsamples.customAdapter.ListUsersAdapter;
import gabrihorstudios.com.droidsamples.dao.UserDAO;
import gabrihorstudios.com.droidsamples.model.User;

public class InsertActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText mailEditText;
    private ListView usersListView;
    private User user;
    private UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        nameEditText = (EditText) findViewById(R.id.name_edit_text);
        mailEditText = (EditText) findViewById(R.id.mail_edit_text);
        usersListView = (ListView) findViewById(R.id.users_list_view);
        listUsers();
    }

    @Override
    protected void onRestart() {
        listUsers();
    }

    public void save(View view){
        insertUser();
    }

    public void insertUser(){
        if(!isNameEmpty()){
            userDAO = new UserDAO(this);
           new AlertDialog.Builder(this)
                   .setTitle(R.string.alert_insert_name)
                   .setMessage(R.string.question_insert_user)
                   .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener(){
                       public void onClick(DialogInterface dialog, int which){
                           user = new User();
                           user.setName(nameEditText.getText().toString());
                           user.setMail(mailEditText.getText().toString());
                           userDAO.insert(user);
                           Toast.makeText(InsertActivity.this, R.string.user_successfully_saved, Toast.LENGTH_SHORT).show();
                           userDAO.close();
                       }
                   })
                   .setNegativeButton(R.string.no, new DialogInterface.OnClickListener(){
                       public void onClick(DialogInterface dialog, int which){
                           nameEditText.requestFocus();
                       }
                   })
                   .setIcon(android.R.drawable.ic_dialog_alert)
                   .show();
        }
    }

    private boolean isNameEmpty(){
        if(nameEditText.getText().toString().equals("")){
            return true;
        }else{
            return false;
        }
    }

    public void listUsers(){
        List<User> users;
        userDAO = new UserDAO(this);
        users = userDAO.listar();
        userDAO.close();

        ArrayAdapter<User> adapter = new ListUsersAdapter(this, users);
        usersListView = (ListView) findViewById(R.id.users_list_view);
        usersListView.setAdapter(adapter);
    }
}
