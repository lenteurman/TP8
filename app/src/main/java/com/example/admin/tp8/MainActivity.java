package com.example.admin.tp8;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String phone;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bouton = (Button) findViewById(R.id.button);
        bouton.setText(R.string.je_suis_pr_t);

        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText numero = (EditText) findViewById(R.id.editText);
                phone = numero.getText().toString();

                EditText message = (EditText) findViewById(R.id.editText2);
                text = message.getText().toString();

                /*
                String uri = "smsto:" + phone;
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse(uri));
                intent.putExtra("sms_body", text);
                startActivity(intent);
                */

                //get the default instance of SmsManager
                SmsManager smsManager = SmsManager.getDefault();
                //Send a text based SMS
                smsManager.sendTextMessage(phone, null, text, null, null);
            }
        });
    }
}
