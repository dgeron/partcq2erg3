package eu.dsgsystems.hrmapp;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher.ViewFactory;

/**
 * Created by Dimitris on 10/2/2018.
 */



public class SelectAvatar extends Activity {
    private ImageButton b1,b2,b3;
    private ImageSwitcher sw;
    //private TextSwitcher mSwitcher;
    private int image=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectavatar);

        sw = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        sw.setFactory(new ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                myView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                myView.setLayoutParams(new
                        ImageSwitcher.LayoutParams(LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT));
                return myView;
            }
        });

        /*
                mSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);
        mSwitcher.setFactory(new ViewFactory() {

            @Override
            public View makeView() {

                // Create a new TextView
                TextView t = new TextView(SelectAvatar.this);
                t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                t.setTextAppearance(SelectAvatar.this, android.R.style.TextAppearance_Large);
                return t;
            }
        });
         */

        b1 = (ImageButton) findViewById(R.id.imageButton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(image>1) {
                    image = image - 1;
                }
                String imageName= "image"+image;
                int resID = getResources().getIdentifier(imageName , "drawable", "eu.dsgsystems.hrmapp");
                sw.setImageResource(resID);
            }
        });

        b2 = (ImageButton) findViewById(R.id.imageButton2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(image<3) {
                    image = image + 1;
                }
                String imageName= "image"+image;
                int resID = getResources().getIdentifier(imageName , "drawable", "eu.dsgsystems.hrmapp");
                sw.setImageResource(resID);
            }
        });

        b3 = (ImageButton) findViewById(R.id.imageButton3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
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

        String imageName= "image"+image;
        int resID = getResources().getIdentifier(imageName , "drawable", "eu.dsgsystems.hrmapp");
        sw.setImageResource(resID);

    }

    private void notImplemented() {
        Context context = getApplicationContext();
        CharSequence text = "Η επιλογή δεν έχει υλοποιηθεί ακόμα.";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, String.valueOf(text), duration);
        toast.show();
    }

    private void save() {
        finishAndRemoveTask();
    }

  /*  private void setView(View view) {
        String imageName= "image"+image;
        int resID = getResources().getIdentifier(imageName , "drawable", "eu.dsgsystems.hrmapp");
        sw.setImageResource(resID);
       int mtext =getResources().getIdentifier(imageName , "values/string", "eu.dsgsystems.hrmapp");
        String mytext = getResources().getString(mtext);
        mSwitcher.setText(mytext);
    }*/

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
