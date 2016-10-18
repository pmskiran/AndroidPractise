package com.practice.androidpracitce;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import com.practice.animation.GraphFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*final BarAnimationWidget barAnimation = new BarAnimationWidget(MainActivity.this, BarAnimationWidget.HORIZONTAL);
        barAnimation.setLayoutParams(new FrameLayout.LayoutParams(500, 20));
        barAnimation.setVisibility(View.GONE);
        barAnimation.setBackground(getResources().getDrawable(R.drawable.roundcorner));
        ((RelativeLayout)findViewById(R.id.main)).addView(barAnimation);*/

        FrameLayout frame = new FrameLayout(this);
        frame.setId(R.id.main_container);
        setContentView(frame, new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment graphFragment = new GraphFragment();
        fragmentTransaction.add(R.id.main_container, graphFragment).commit();
        Log.i(getClass().getSimpleName(),"onCreate end.");
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

}
