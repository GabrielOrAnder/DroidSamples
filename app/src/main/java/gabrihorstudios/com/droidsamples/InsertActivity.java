package gabrihorstudios.com.droidsamples;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import gabrihorstudios.com.droidsamples.model.User;

public class InsertActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText mailEditText;
    private ListView namesListView;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        nameEditText = (EditText) findViewById(R.id.name_edit_text);
        mailEditText = (EditText) findViewById(R.id.mail_edit_text);
        namesListView = (ListView) findViewById(R.id.names_list_view);
    }

    @Override
    protected void onResume() {
        listNames();
    }

    public void save(View view){
        insertName();
    }

    public void insertName(){
        if(!isNameEmpty()){
           new AlertDialog.Builder(this)
                   .setTitle(R.string.alert_insert_name)
                   .setMessage(R.string.question_insert_name)
                   .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener(){
                       public void onClick(DialogInterface dialog, int which){
                           Toast.makeText(InsertActivity.this, R.string.name_successfully_saved, Toast.LENGTH_SHORT).show();
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

    public void listNames(){

    }
}
