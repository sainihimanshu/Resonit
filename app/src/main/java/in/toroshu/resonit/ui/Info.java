package in.toroshu.resonit.ui;

import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import in.toroshu.resonit.R;
import in.toroshu.resonit.utils.Constants;

public class Info extends Activity {
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int infoIntentToken = getIntent().getIntExtra(Constants.TOKEN, 1);

        i = 1;
        switch (infoIntentToken + 1) {
            case 1:
                setContentView(R.layout.activity_help);
                final ImageView tutorialImageView = (ImageView) findViewById(R.id.tutorial_imgs);
                Toast.makeText(getApplicationContext(), "Tap on the screen to continue", Toast.LENGTH_LONG).show();

                tutorialImageView.setOnClickListener(new View.OnClickListener() {


                    @Override
                    public void onClick(View v) {
                        i++;
                        Drawable dw;
                        switch (i) {
                            case 2:
                                dw = getResources().getDrawable(R.drawable.how2);
                                break;
                            case 3:
                                dw = getResources().getDrawable(R.drawable.how3);
                                break;
                            default:
                                dw = getResources().getDrawable(R.drawable.how1);
                                finish();
                                break;
                        }
                        tutorialImageView.setImageDrawable(dw);
                    }
                });
                break;
            case 2:
                setContentView(R.layout.activity_explore);
                break;
            case 3:
                setContentView(R.layout.activity_about);
                TextView creditsTextView = (TextView) findViewById(R.id.credit_tv);
                TextView credits = (TextView) findViewById(R.id.credits);
                credits.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/dadhand.ttf"));

                creditsTextView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/dadhand.ttf"));
                break;
            default:
                setContentView(R.layout.activity_info);
                break;
        }

    }


}
