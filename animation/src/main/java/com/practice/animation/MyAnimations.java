package com.practice.animation;

import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by spartans on 4/8/16.
 */
public class MyAnimations {

    Context mcontext;

    public static Animation getScaleAnim(Context context, float fromX, float toX, float fromY, float toY, int relativeToX, float pivotX, int relativeToY, float pivotY) {
        android.view.animation.ScaleAnimation scaleAnimation = new android.view.animation.ScaleAnimation(fromX, toX, fromY, toY, relativeToX, pivotX, relativeToY, pivotY);
        scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleAnimation.setDuration(300);
        return scaleAnimation;
    }

    public static boolean getTransformationAnim() {
        Transformation transformation = new Transformation();

        return true;
    }

    public static Animation getAlphaAnim(float fromAlpha, float toAlpha) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(fromAlpha, toAlpha);
        alphaAnimation.setDuration(300);
        return alphaAnimation;
    }
}
