package com.example.premal2.shopeasyily;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class OTP extends AppCompatActivity {
    public int y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        Button otp= (Button) findViewById(R.id.otp);
        final EditText et=(EditText) findViewById(R.id.otpent);
        Random rand=new Random();
        y=rand.nextInt(8999)+1000;
        otppass();
        otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                otppass();
            }
        });
        Button login= (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        String y3= et.getText().toString();
                        int z=Integer.valueOf(y3);
                        if(y==z)
                        {Intent o = new Intent(OTP.this, Home.class);
                        startActivity(o);}
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Invalid!",
                                    Toast.LENGTH_SHORT).show();
                        }
            }
        });
    }
    private void otppass()
    {

        NotificationCompat.Builder builder= (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.abc)
                .setContentTitle("ShopEasily")
                .setContentText("Your OTP is "+y);
        builder.setDefaults(Notification.DEFAULT_SOUND);
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }
}
