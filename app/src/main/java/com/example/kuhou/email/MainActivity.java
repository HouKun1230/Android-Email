package com.example.kuhou.email;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }

    private void sendEmail(){
        String[] TO = {"houkun1230@163.com"};
        //String[] CC = {"XXXX@XXXX.COM"};

        Intent intent_email = new Intent(Intent.ACTION_SEND);
        intent_email.setData(Uri.parse("mailto:"));
        intent_email.setType("text/plain");

        intent_email.putExtra(Intent.EXTRA_EMAIL, TO);
       // intent_email.putExtra(Intent.EXTRA_EMAIL,CC);
        intent_email.putExtra(Intent.EXTRA_SUBJECT,"subject");
        intent_email.putExtra(Intent.EXTRA_TEXT,"Your message");

        try{
            startActivity(Intent.createChooser(intent_email,"Send"));
            finish();
        }catch (android.content.ActivityNotFoundException e){
            Toast.makeText(MainActivity.this,"No Client Email installed",Toast.LENGTH_SHORT).show();
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
