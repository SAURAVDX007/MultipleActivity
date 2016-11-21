package com.example.saura.hsport.multipleactivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private static String webURL ="https://twitter.com/";

    private  String email = "sauravkumar001@outlook.com";
    private CoordinatorLayout coordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] addresses = {email};
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL,addresses);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Support request");
                intent.putExtra(Intent.EXTRA_TEXT,"Please provide your concern");
                if (intent.resolveActivity(getPackageManager())!=null){
                    startActivity(intent);
                }

            }

        });
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);


        ImageView imageView = (ImageView) findViewById(R.id.image2);
        try {
            InputStream stream = getAssets().open("jacket101.png");
            Drawable drawable = Drawable.createFromStream(stream,null);
            imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                Snackbar.make(coordinatorLayout, "You clicked for Settings", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                return true;
            case R.id.action_about:
//                Snackbar.make(coordinatorLayout, "About the company", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(this, About_Activity.class);
                startActivity(intent);
                return true;
            case R.id.logout:
                Snackbar.make(coordinatorLayout, "You clicked for Logout", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                return true;
            case R.id.cart:
                Snackbar.make(coordinatorLayout, "You clicked for Carts", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                return true;
            case R.id.WebTwitter:
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(webURL));
                //Resolving the activity, very very important when we do implicit intent
                if (webIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(webIntent);
                }
                return true;
//            case R.id.writeToUs:
//                String[] address = {email};
//                Intent intent1 = new Intent(Intent.ACTION_SENDTO);
//                intent1.setData(Uri.parse("mailTo:"));
//                intent1.putExtra(Intent.EXTRA_EMAIL, address);
//                intent1.putExtra(Intent.EXTRA_SUBJECT, "Service Request");
//                intent1.putExtra(Intent.EXTRA_TEXT, "Please provide a detailed query");
//                if (intent1.resolveActivity(getPackageManager()) != null) {
//                    startActivity(intent1);
//                }
//                return true;

        }
        return super.onOptionsItemSelected(item);
    }
//    }Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
//            "mailto","abc@gmail.com", null));
//    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
//    emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");
//    startActivity(Intent.createChooser(emailIntent, "Send email..."));
}
