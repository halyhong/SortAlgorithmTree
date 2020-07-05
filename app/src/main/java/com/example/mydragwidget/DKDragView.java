package com.example.mydragwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class DKDragView extends AppCompatTextView {
    private static final String TAG = "DragView";
    private int startX, startY, targetX, targetY, ORIENTATION;
    private long startTime;
    private Context context;
/*    private onDragViewClickListener onDragViewClickListener;
    private onDragViewLongClickListener onDragViewLongClickListener;*/
    private boolean move, hasAnimation;
    private int leftBoundary, topBoundary, rightBoundary, bottomBoundary;
    private int windowWidth, windowHeight;

    private int moveX;

    public DKDragView(Context context) {
        super(context);
    }

    public DKDragView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DKDragView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x=(int)event.getX();
        int y=(int)event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                moveX=x;
                break;
            case MotionEvent.ACTION_MOVE:
                //计算移动的距离
                int offsetX=x-moveX;
                int offsetY=y-moveX;
                //调用layout方法来重新放置它的位置
                offsetLeftAndRight(offsetX);
                offsetTopAndBottom(offsetY);
                break;
        }
        return true;
    }
}
