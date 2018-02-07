package eu.dsgsystems.hrmapp;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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
        Context context = getApplicationContext();
        CharSequence text = "Η δυνατότητα δεν υλοποιήθηκε ακόμα";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, String.valueOf(text), duration);
        toast.show();
    }

    private void automationMenu() {

        openApp(this, "org.openhab.habdroid.ui.OpenHABMainActivity");
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
