package eu.dsgsystems.hrmapp;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static String OPENHAB_URL = "https://demo.openhab.org:8443/basicui/app";
    public static String FACEBOOK_URL = "https://www.facebook.com/profile.php?id=100004300365767";
    public static String FACEBOOK_PAGE_ID = "100004300365767";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();
        CharSequence text = "Καλώς ήρθατε στην ενεργειακή εφαρμογή-παιχνίδι HRM.\n" +
                " \n" +
                "Για περισσότερες πληροφορίες για τις απαιτήσεις της εφαρμογής, οδηγίες χρήσεις και ένα βίντεο με επεξήγηση των λειτουργιών της σοβαρής αλλά και της διασκεδαστικής πλευράς της εφαρμογής επιλέξτε το tutorial στο μένου πάνω δεξιά.";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, String.valueOf(text), duration);
        toast.show();

        final Button b2 = findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                notImplemented();
            }
        });

        final Button b3 = findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                notImplemented();
            }
        });

    }


    private void notImplemented() {
        Context context = getApplicationContext();
        CharSequence text = "Η επιλογή δεν έχει υλοποιηθεί ακόμα.";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, String.valueOf(text), duration);
        toast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.hrm_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.Item1:
                userProfile();
                return true;
            case R.id.Item2:
                automationMenu();
                return true;
            case R.id.Item3:
                facebook();
                return true;
            case R.id.Item4:
                communityNet();
                return true;
            case R.id.Item5:
                statistics();
                return true;
            case R.id.Item6:
                finishAndRemoveTask();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void communityNet() {
        Context context = getApplicationContext();
        CharSequence text = "Η δυνατότητα δεν υλοποιήθηκε ακόμα";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, String.valueOf(text), duration);
        toast.show();
    }

    private void facebook() {
        Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
        String facebookUrl = getFacebookPageURL(this);
        facebookIntent.setData(Uri.parse(facebookUrl));
        startActivity(facebookIntent);
    }

    //method to get the right URL to use in the intent
    public String getFacebookPageURL(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
            } else { //older versions of fb app
                return "fb://page/" + FACEBOOK_PAGE_ID;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return FACEBOOK_URL; //normal web url
        }
    }

    private void automationMenu() {
    Intent openHABIntent = new Intent(Intent.ACTION_VIEW);
    String openHABUrl = getOpenHABUrl(this);
    openHABIntent.setData(Uri.parse(openHABUrl));
    startActivity(openHABIntent);
    }

    private String getOpenHABUrl(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent i = packageManager.getLaunchIntentForPackage("org.openhab.habdroid.ui.OpenHABMainActivity");
        if (i == null)
        {
            CharSequence text = "Η δυνατότητα δεν υλοποιήθηκε ακόμα";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, String.valueOf(text), duration);
            toast.show();
        }
        return OPENHAB_URL;

    }

    private void userProfile() {
        Intent launchNewIntent = new Intent(MainActivity.this, UserProfile.class);
        startActivityForResult(launchNewIntent, 0);
    }

    private void statistics() {
        Intent launchNewIntent = new Intent(MainActivity.this, Statistics.class);
        startActivityForResult(launchNewIntent, 0);
       // openApp(this, "com.google.android.apps.maps");
    }


    /** Open another app.
     * @param context current Context, like Activity, App, or Service
     * @param packageName the full package name of the app to open
     * @return true if likely successful, false if unsuccessful
     */
    public static boolean openApp(Context context, String packageName) {
        PackageManager manager = context.getPackageManager();
        try {
            Intent i = manager.getLaunchIntentForPackage(packageName);
            if (i == null) {
                return false;
                //throw new ActivityNotFoundException();
            }
            i.addCategory(Intent.CATEGORY_LAUNCHER);
            context.startActivity(i);
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }

}
