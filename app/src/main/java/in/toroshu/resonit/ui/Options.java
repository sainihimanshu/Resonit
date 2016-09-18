package in.toroshu.resonit.ui;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import in.toroshu.resonit.R;

public class Options extends Activity {
    public final String TOKEN = "token";
    Intent infoIntent;
    Intent playIntent;


    int back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        back = 0;


        infoIntent = new Intent(getApplicationContext(), Info.class);
        playIntent = new Intent(getApplicationContext(), ChooseLevel.class);


    }

    // displays difficulty levels
    public void play(View v) {
        playSound();
        back = 0;
        setContentView(R.layout.activity_after_play_clicked);
    }

    public void easy(View v) {
        playSound();
        playIntent.putExtra(TOKEN, 0);
        startActivity(playIntent);
    }

    public void normal(View v) {
        playSound();
        playIntent.putExtra(TOKEN, 1);
        startActivity(playIntent);
    }

    public void difficult(View v) {
        playSound();
        playIntent.putExtra(TOKEN, 2);
        startActivity(playIntent);
    }


    public void help(View v) {
        playSound();
        infoIntent.putExtra(TOKEN, 0);
        startActivity(infoIntent);
    }

    public void explore(View v) {
        playSound();
        infoIntent.putExtra(TOKEN, 1);
        startActivity(infoIntent);
    }

    public void about(View v) {
        playSound();
        infoIntent.putExtra(TOKEN, 2);
        startActivity(infoIntent);
    }

    @Override
    public void onBackPressed() {
        back++;
        if (back == 2)
            super.onBackPressed();
        else
            Toast.makeText(getApplicationContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
    }

    public void playSound() {
        MediaPlayer.create(getApplicationContext(), R.raw.won).start();
    }
}
