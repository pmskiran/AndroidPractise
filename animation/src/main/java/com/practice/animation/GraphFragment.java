package com.practice.animation;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.practice.animation.BarAnimationWidget;

/**
 * Created by spartans on 16/9/16.
 */

public class GraphFragment extends Fragment{

    private final int[] ids = {R.id.bar_one, R.id.bar_two, R.id.bar_three, R.id.bar_four, R.id.bar_five,
            R.id.bar_six, R.id.bar_seven, R.id.bar_eight, R.id.bar_nine};
    private final int[] barLengths = {5,4,7,3,8,2,6,4,3};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final RelativeLayout relativeLayout = (RelativeLayout) inflater.inflate(R.layout.animation_main, null);
        addBarChar((RelativeLayout)relativeLayout.findViewById(R.id.container));

        ((Button) relativeLayout.findViewById(R.id.button01)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idsLength = ids.length;
                for(int i=0; i< idsLength; i++) {
                    ((RelativeLayout)relativeLayout.findViewById(R.id.main)).findViewById(ids[i]).setVisibility(View.VISIBLE);
                }
            }
        });

        return relativeLayout;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    private void addBarChar(RelativeLayout parent) {

        final BarAnimationWidget barAnimation = new BarAnimationWidget(this.getActivity().getBaseContext(), BarAnimationWidget.VERTICAL);
        barAnimation.setLayoutParams(new RelativeLayout.LayoutParams(50, barLengths[0]*100));
        barAnimation.setVisibility(View.GONE);
        barAnimation.setId(R.id.bar_one);
        barAnimation.setBackground(getResources().getDrawable(R.drawable.roundcorner));

        RelativeLayout.LayoutParams relativeLayoutParams = (RelativeLayout.LayoutParams)(barAnimation).getLayoutParams();
        relativeLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        relativeLayoutParams.leftMargin = 50;
        barAnimation.setLayoutParams(relativeLayoutParams);

        parent.addView(barAnimation);

        BarAnimationWidget barAnimation_next;
        int barCnt = ids.length;
        for(int i=1; i<barCnt; i++) {
            barAnimation_next = new BarAnimationWidget(this.getActivity().getBaseContext(), BarAnimationWidget.VERTICAL);
            barAnimation_next.setLayoutParams(new RelativeLayout.LayoutParams(50, barLengths[i]*100));
            barAnimation_next.setVisibility(View.GONE);
            barAnimation_next.setId(ids[i]);
            barAnimation_next.setBackground(getResources().getDrawable(R.drawable.roundcorner));

            RelativeLayout.LayoutParams relativeLayoutParams1 = (RelativeLayout.LayoutParams)(barAnimation_next).getLayoutParams();
            relativeLayoutParams1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            relativeLayoutParams1.addRule(RelativeLayout.RIGHT_OF, ids[i-1]);
            relativeLayoutParams1.leftMargin = 50;
            barAnimation_next.setLayoutParams(relativeLayoutParams1);

            parent.addView(barAnimation_next);
        }
    }
}
