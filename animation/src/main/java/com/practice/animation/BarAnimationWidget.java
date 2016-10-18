package com.practice.animation;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.IntDef;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.FrameLayout;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by spartans on 15/8/16.
 */
public class BarAnimationWidget extends FrameLayout {

    Context mContext;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({HORIZONTAL, VERTICAL})
    public @interface  AnimationDirection{}
    public static final int HORIZONTAL = 1;
    public static final int VERTICAL = 2;

    @AnimationDirection
    private int mAnimDirection;

    public BarAnimationWidget(Context context, @AnimationDirection int animDirection) {
        super(context);
        mContext = context;
        mAnimDirection = animDirection;
        setBackgroundColor(Color.GREEN);
    }

    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        Log.d(getClass().getSimpleName(), "onVisibilityChanged :: visibility :: "+visibility);

        Animation animation1 = null;
        if(mAnimDirection == HORIZONTAL) {
            animation1 = MyAnimations.getScaleAnim(mContext, 0, 1, 1, 1,Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f);
        } else if(mAnimDirection == VERTICAL) {
            animation1 = MyAnimations.getScaleAnim(mContext, 1, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 1f);
        }

        Animation animation2 = MyAnimations.getAlphaAnim(0f, 1f);

        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(animation1);
        animationSet.addAnimation(animation2);

        changedView.setAnimation(animationSet);
    }

}
