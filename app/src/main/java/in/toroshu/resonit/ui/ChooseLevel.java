package in.toroshu.resonit.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.lukedeighton.wheelview.WheelView;
import com.lukedeighton.wheelview.adapter.WheelAdapter;

import in.toroshu.resonit.R;
import in.toroshu.resonit.utils.Constants;

public class ChooseLevel extends Activity {

    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_level);

        preferences = getSharedPreferences(Constants.GAME_PROGRESS, MODE_PRIVATE);
        final int clearedUpto = preferences.getInt(Constants.CLEARED_UPTO, 1);

        final int difficulty = getIntent().getIntExtra(Constants.TOKEN, 0);
        final int offSet;
        if (difficulty == 0)
            offSet = 0;
        else if (difficulty == 1)
            offSet = 10;
        else
            offSet = 20;

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/dadhand.ttf");
        TextView textView = (TextView) findViewById(R.id.levelselecttv);
        textView.setTypeface(typeface);

        WheelView wheelView = (WheelView) findViewById(R.id.wheelview);

        final Drawable originalDrawableArray[] = new Drawable[]
                {
                        getResources().getDrawable(R.drawable.l1),
                        getResources().getDrawable(R.drawable.l2),
                        getResources().getDrawable(R.drawable.l3),
                        getResources().getDrawable(R.drawable.l4),
                        getResources().getDrawable(R.drawable.l5),
                        getResources().getDrawable(R.drawable.l6),
                        getResources().getDrawable(R.drawable.l7),
                        getResources().getDrawable(R.drawable.l8),
                        getResources().getDrawable(R.drawable.l9),
                        getResources().getDrawable(R.drawable.l10)

                };

        final Drawable drawableArray[] = new Drawable[10];
        for (int i = 0; i < 10; i++) {
            if (clearedUpto + 1 < i + offSet) {
                drawableArray[i] = getResources().getDrawable(R.drawable.lock);
            } else
                drawableArray[i] = originalDrawableArray[i];
        }


        wheelView.setAdapter(new WheelAdapter() {
            @Override
            public Drawable getDrawable(int i) {
                return drawableArray[i];
            }

            @Override
            public int getCount() {
                return drawableArray.length;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }
        });


        wheelView.setOnWheelItemClickListener(new WheelView.OnWheelItemClickListener() {
            @Override
            public void onWheelItemClick(WheelView parent, int position, boolean isSelected) {
                //Toast.makeText(getApplicationContext(), "Position: " + position, Toast.LENGTH_SHORT).show();
                if (clearedUpto + 1 >= position + offSet) {
                    Intent intent = new Intent(getApplicationContext(), PlayGround.class);
                    if (difficulty == 0)
                        intent.putExtra(Constants.LEVEL, position);
                    else if (difficulty == 1)
                        intent.putExtra(Constants.LEVEL, position + 10);
                    else
                        intent.putExtra(Constants.LEVEL, position + 20);

                    MediaPlayer.create(getApplicationContext(), R.raw.won).start();

                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Unlock previous levels first!", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

}
