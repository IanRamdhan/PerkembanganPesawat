package com.fryanramzkhar.perkembanganpesawat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {
    private long ms = 0;
    private long splashTime = 3000;
    private boolean splashActive = true;
    private boolean paused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //TODO 2 membuat variable Thread
        Thread mythread = new Thread() {
            public void run() {
                //TODO 3 Melakukan perulangan sampai ms > 3000i
                try {
                    while (splashActive && ms < splashTime) {
                        if (!paused) {
                            ms = ms + 100;
                            sleep(100);
                        }
                    }
                } catch (Exception e) {
                } finally {
                    //TODO 4 setelah perulangan selesai maka akan berpindah halaman menggunkan intent
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        //Menjalankan Object mythread
        mythread.start();
    }
}
