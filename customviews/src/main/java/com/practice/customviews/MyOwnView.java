package com.practice.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;

/**
 * Created by spartans on 19/9/16.
 */

public class MyOwnView extends View {

    public void setmCircleRadius(int mCircleRadius) {
        this.mCircleRadius = mCircleRadius;
    }

    private int mCircleRadius;

    public MyOwnView(Context context) {
        super(context);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Log.i(getClass().getSimpleName(), "onSaveInstanceState() called.");
        final Parcelable superState = super.onSaveInstanceState();
        final MyOwnViweState savedState = new MyOwnViweState(superState);
        savedState.radius = mCircleRadius;
        return savedState;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.CYAN);
        paint.setAntiAlias(true);

        canvas.drawCircle(200, 200, mCircleRadius, paint);
    }

    static class MyOwnViweState extends BaseSavedState {

        int radius;

        public MyOwnViweState(Parcelable superState) {
            super(superState);
        }

        public MyOwnViweState(Parcel source) {
            super(source);
            radius = source.readInt();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(radius);
        }

        public static final Creator<MyOwnViweState> CREATOR = new Creator<MyOwnViweState>() {
            @Override
            public MyOwnViweState createFromParcel(Parcel parcel) {
                return new MyOwnViweState(parcel);
            }

            @Override
            public MyOwnViweState[] newArray(int i) {
                return new MyOwnViweState[0];
            }
        };
    }

}
