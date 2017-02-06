package gabrihorstudios.com.droidsamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class Main extends AppCompatActivity{

    public ListView listMainMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        listMainMenu = (ListView) findViewById(R.id.list_view_main_menu);

    }

    /*
    Sample activity responsible to show  the basic insert into SQLite database.
     */
    public void callInsertActivity(View view) {
        Intent intent = new Intent(Main.this, InsertActivity.class);
        startActivity(intent);
    }
}
