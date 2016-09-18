package in.toroshu.resonit.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import in.toroshu.resonit.R;


public class Splash extends Activity {

    // Displays app logo and Toroshu's logo
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_first);
        try {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                setContentView(R.layout.activity_splash);
                            }
                        });

                        Thread.sleep(2000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    startActivity(new Intent(getApplicationContext(), Options.class));
                    finish();
                }
            }).start();

        } catch (Exception e) {
            //Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
    }


}
