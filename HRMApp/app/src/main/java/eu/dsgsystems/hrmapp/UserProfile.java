package eu.dsgsystems.hrmapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        final Button b1 = findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selectAvatar();
            }
        });

        final Button b2 = findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                notImplemented();
            }
        });

        final Button b4 = findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                notImplemented();
            }
        });

        final Button b5 = findViewById(R.id.button5);
        b5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                notImplemented();
            }
        });

        final Button b6 = findViewById(R.id.button6);
        b6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                notImplemented();
            }
        });

        EditText et1 = findViewById(R.id.editText1);
        et1.setText("Manolios Brontakis");
        EditText et2 = findViewById(R.id.editText2);
        et2.setText("Brontakides - Xania");
        EditText et3 = findViewById(R.id.editText4);
        et3.setText("Krhtikoi");

    }

    private void notImplemented() {
        Context context = getApplicationContext();
        CharSequence text = "Η επιλογή δεν έχει υλοποιηθεί ακόμα.";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, String.valueOf(text), duration);
        toast.show();
    }

    private void selectAvatar() {
        Intent launchNewIntent = new Intent(this, SelectAvatar.class);
        startActivityForResult(launchNewIntent, 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.userprofile_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.Item1:
                finishAndRemoveTask();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
