package in.toroshu.resonit.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import in.toroshu.resonit.R;
import in.toroshu.resonit.engine.Rings;
import in.toroshu.resonit.utils.Constants;


public class PlayGround extends Activity {

    SharedPreferences preferences;


    int back;

    // people ivs
    ImageView janta[];

    int leftRing[];
    int rightRing[];

    //reqd iv configs
    int reqJantaConfig[];
    int level;

    boolean won;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pentagon);
        try {

            //Ad part
            AdView mAdView = (AdView) findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);

            back = 0;
            preferences = getSharedPreferences(Constants.GAME_PROGRESS, MODE_PRIVATE);
            won = false;

            reqJantaConfig = new int[]{R.drawable.blank, R.drawable.doctor, R.drawable.pirate,
                    R.drawable.student, R.drawable.police, R.drawable.worker
            };

            janta = new ImageView[]{
                    (ImageView) findViewById(R.id.e0),
                    (ImageView) findViewById(R.id.e1),
                    (ImageView) findViewById(R.id.e2),
                    (ImageView) findViewById(R.id.e3),
                    (ImageView) findViewById(R.id.e4),
                    (ImageView) findViewById(R.id.e5)
            };

            level = getIntent().getIntExtra(Constants.LEVEL, 0);

            //initialising rings according to the level
            leftRing = new int[4];
            rightRing = new int[4];
            Rings r = new Rings(leftRing, rightRing);
            int allRings[][] = r.getRings(level);
            leftRing = allRings[0];
            rightRing = allRings[1];

            //showing help option if the user is playing 1st 2 levels
            if (level < 2) {
                findViewById(R.id.quickhelpimg).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Intent help = new Intent(getApplicationContext(), Info.class);
                            help.putExtra("token", 0);
                            startActivity(help);
                        } catch (Exception e) {
                            //Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                new ShowcaseView.Builder(this)
                        .setTarget(new ViewTarget(findViewById(R.id.quickhelpimg)))
                        .setContentTitle("Put everything at its right \nplace to win")
                        .setContentText("Click here to learn how to play.")
                        .hideOnTouchOutside()
                        .build();


            } else {
                findViewById(R.id.quickhelpimg).setVisibility(View.GONE);
            }
            //build the rings
            updateUI();
        } catch (Exception e) {
            //toast(e.toString());
        }

    }


    public void leftUp(View v) {
        // update left ring
        int length = leftRing.length;
        int[] leftRingCopy = new int[4];

        System.arraycopy(leftRing, 0, leftRingCopy, 0, 4);

        for (int i = 1; i < length; i++)
            leftRing[i] = leftRingCopy[i - 1];

        leftRing[0] = leftRingCopy[length - 1];
        rightRing[0] = leftRing[0];
        rightRing[3] = leftRing[1];

        updateUI();

    }

    public void leftDown(View v) {
        // update left ring
        int length = leftRing.length;
        int[] leftRingCopy = new int[4];

        System.arraycopy(leftRing, 0, leftRingCopy, 0, 4);

        for (int i = 0; i < length - 1; i++)
            leftRing[i] = leftRingCopy[i + 1];

        leftRing[length - 1] = leftRingCopy[0];
        rightRing[0] = leftRing[0];
        rightRing[3] = leftRing[1];

        updateUI();
    }

    public void rightDown(View v) {

        int length = rightRing.length;
        int[] rightRingCopy = new int[length];

        System.arraycopy(rightRing, 0, rightRingCopy, 0, length);

        for (int i = 1; i < length; i++)
            rightRing[i] = rightRingCopy[i - 1];

        rightRing[0] = rightRingCopy[length - 1];
        leftRing[0] = rightRing[0];
        leftRing[1] = rightRing[3];

        updateUI();
    }

    public void rightUp(View v) {
        // update left ring
        int length = rightRing.length;
        int[] rightRingCopy = new int[length];

        System.arraycopy(rightRing, 0, rightRingCopy, 0, length);

        for (int i = 0; i < length - 1; i++)
            rightRing[i] = rightRingCopy[i + 1];

        rightRing[length - 1] = rightRingCopy[0];
        leftRing[0] = rightRing[0];
        leftRing[1] = rightRing[3];

        updateUI();
    }

    public void updateUI() {

        janta[0].setImageResource(leftRing[1]);
        janta[1].setImageResource(leftRing[0]);
        janta[2].setImageResource(rightRing[1]);
        janta[3].setImageResource(rightRing[2]);
        janta[4].setImageResource(leftRing[2]);
        janta[5].setImageResource(leftRing[3]);

        checkIfWon();
    }

    private void toast(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }


    // checks if the user has won the game or not
    void checkIfWon() {
        int counter = 0;

        for (int i = 0; i < reqJantaConfig.length; i++) {

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP && janta[i].getDrawable().getConstantState()
                    .equals(getResources().getDrawable(reqJantaConfig[i]).getConstantState())) {
                //toast("Eq - i: " + i);
                counter += 1;
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && janta[i].getDrawable().getConstantState()
                    .equals(janta[i].getContext().getDrawable(reqJantaConfig[i]).getConstantState())) {
                //toast("Eq - i: " + i);
                counter += 1;
            }
        }
        //toast("counter: " + counter);

        if (counter == reqJantaConfig.length) {
            // toast("counterw: " + counter);

            if (preferences.getInt(Constants.CLEARED_UPTO, 2) <= level) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt(Constants.CLEARED_UPTO, level);
                editor.apply();
            }

            won = true;
            Toast.makeText(getApplicationContext(), "You Won!", Toast.LENGTH_SHORT).show();
            MediaPlayer.create(getApplicationContext(), R.raw.cleared).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(500);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                setContentView(R.layout.activity_won);
                                Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/dadhand.ttf");
                                TextView textView = (TextView) findViewById(R.id.wontv);
                                textView.setTypeface(typeface);

                                findViewById(R.id.continuebt).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        Intent continueIntent = new Intent(getApplicationContext(), ChooseLevel.class);
                                        if (level < 11)
                                            continueIntent.putExtra("token", 0);
                                        else if (level >= 11 && level <= 20)
                                            continueIntent.putExtra("token", 1);
                                        else
                                            continueIntent.putExtra("token", 2);

                                        startActivity(continueIntent);
                                        finish();
                                    }
                                });
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();


        }
        won = false;
    }

    public void q(View v) {
        Intent help = new Intent(getApplicationContext(), Info.class);
        help.putExtra("token", 0);
        startActivity(help);
    }

    @Override
    public void onBackPressed() {
        back++;
        if (back == 2)
            super.onBackPressed();
        else
            Toast.makeText(getApplicationContext(), "Press back again to exit the level", Toast.LENGTH_SHORT).show();
    }
}
