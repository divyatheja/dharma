package com.palthady.dharma.activity;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.palthady.dharma.R;

import org.json.JSONException;

import java.util.ArrayList;

import com.palthady.dharma.activity.entity.Admin;
import com.palthady.dharma.activity.entity.DBHelper;
import com.palthady.dharma.adapter.HomeViewPagerAdapter;

public class LoginActivity extends Activity {

  private DharmaServiceImpl dharmaService;
  private ActionBar actionBar;
  private ViewPager viewPager;
  private ActionBarDrawerToggle actionBarDrawerToggle;
  private DrawerLayout drawerLayout;
  public static final int ADD_NEW_CAT = 9991;
  private static Boolean isNotificationScheduled = false;
  private HomeViewPagerAdapter homeViewPagerAdapter;
  private DBHelper mydb;
  /**
   * ATTENTION: This was auto-generated to implement the App Indexing API.
   * See https://g.co/AppIndexing/AndroidStudio for more information.
   */
  private GoogleApiClient client;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mydb = new DBHelper(this);
    ArrayList array_list = mydb.getAllCotacts();

    setContentView(R.layout.login);
    actionBar = getActionBar();
    actionBar.hide();

    if (!(array_list.size() == 0)) {
        finish();
      Intent i = new Intent(getApplicationContext(), MainActivity.class);
      startActivity(i);
    }

    if (Build.VERSION.SDK_INT > 9) {
      StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
      StrictMode.setThreadPolicy(policy);
    }

    Button clickButton = (Button) findViewById(R.id.button);
    clickButton.setOnClickListener(new View.OnClickListener() {

      @TargetApi(Build.VERSION_CODES.LOLLIPOP_MR1)
      @Override
      public void onClick(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        Admin ad = new Admin();
        /*SubscriptionManager tm = (SubscriptionManager) getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE);
        String number = null;
        if((tm.getActiveSubscriptionInfoForSimSlotIndex(0).getNumber().toString()).equalsIgnoreCase(editText.getText().toString())){
          number = tm.getActiveSubscriptionInfoForSimSlotIndex(0).getNumber();
          System.out.println("sim at one");
        }
        else if((tm.getActiveSubscriptionInfoForSimSlotIndex(1).getNumber().toString()).equalsIgnoreCase(editText.getText().toString()) ){
          number = tm.getActiveSubscriptionInfoForSimSlotIndex(1).getNumber();
          System.out.println("sim at 2");
        }*/

        System.out.println("yyyyyyyyyyyyyyyyyyyy   "+editText.getText().toString());
       // System.out.println("xxxxxxxxxxxxxxxxxx    "+number   );
      /*  if (number ==null || !(editText.getText().toString()).equalsIgnoreCase(number)) {
          Toast.makeText(getApplication(), "SIM1 Number only allowed", Toast.LENGTH_LONG).show();
        } else {*/
          dharmaService = new DharmaServiceImpl();
          try {
            ad = dharmaService.getAuthenticated(String.valueOf(editText.getText()));

            System.out.println("1111111111111111111111");
          } catch (JSONException e) {

          }
          if (ad.getPhoneNumber() == null) {
            System.out.println("2222222222222222222");
            Toast.makeText(getApplication(), "Not autherized to use this app", Toast.LENGTH_LONG).show();
          } else {
            if (mydb.insertContact(ad.getPhoneNumber().toString())) {
              System.out.println("333333333333333333333333");
              Toast.makeText(getApplicationContext(), "done",
                      Toast.LENGTH_SHORT).show();
              finish();
              Intent i = new Intent(getApplicationContext(), MainActivity.class);
              startActivity(i);
            }
          }
        }
      //}
    });
    // ATTENTION: This was auto-generated to implement the App Indexing API.
    // See https://g.co/AppIndexing/AndroidStudio for more information.
  }



  @Override
  public void onStart() {
    super.onStart();

    // ATTENTION: This was auto-generated to implement the App Indexing API.
    // See https://g.co/AppIndexing/AndroidStudio for more information.
  /*  client.connect();
    Action viewAction = Action.newAction(
            Action.TYPE_VIEW, // TODO: choose an action type.
            "Login Page", // TODO: Define a title for the content shown.
            // TODO: If you have web page content that matches this app activity's content,
            // make sure this auto-generated web page URL is correct.
            // Otherwise, set the URL to null.
            Uri.parse("http://host/path"),
            // TODO: Make sure this auto-generated app URL is correct.
            Uri.parse("android-app://com.palthady.dharma.activity/http/host/path")
    );
    AppIndex.AppIndexApi.start(client, viewAction);
*/  }

  @Override
  public void onStop() {
    super.onStop();

    // ATTENTION: This was auto-generated to implement the App Indexing API.
    // See https://g.co/AppIndexing/AndroidStudio for more information.
/*    Action viewAction = Action.newAction(
            Action.TYPE_VIEW, // TODO: choose an action type.
            "Login Page", // TODO: Define a title for the content shown.
            // TODO: If you have web page content that matches this app activity's content,
            // make sure this auto-generated web page URL is correct.
            // Otherwise, set the URL to null.
            Uri.parse("http://host/path"),
            // TODO: Make sure this auto-generated app URL is correct.
            Uri.parse("android-app://com.palthady.dharma.activity/http/host/path")
    );
    AppIndex.AppIndexApi.end(client, viewAction);
    client.disconnect();*/
  }




  
}
