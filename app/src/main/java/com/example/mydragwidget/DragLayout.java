package com.example.mydragwidget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.TreeMap;

public class DragLayout extends RelativeLayout {
    private final static String TAG = "DragLayout";

    private int moveX;

    private LinearLayout wrapper;
    private DKDragView dragView;
    private Context mContext;

    private int mViewWidth;
    private int mViewHeight;
    private int mImageWidth;
    private int mImageHeight;

    public DragLayout(Context context) {
        super(context);

        initData(context);
        initView(context);
    }

    public DragLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        initData(context);
        initView(context);
    }

    public DragLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initData(context);
        initView(context);

    }

    public DragLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        initData(context);
    }

    private void initData(Context context) {
        mContext = context;
    }

    private void initView(Context context) {
        setBackgroundColor(context.getResources().getColor(android.R.color.black));
        wrapper = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.layout_drag, this, false);
        wrapper.setBackgroundColor(context.getResources().getColor(android.R.color.white));

/*        dragView = new DKDragView(context);
        wrapper.addView(dragView);*/

        wrapper.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();

                if (MotionEvent.ACTION_MOVE == action) {
                    return true;
                } else if (MotionEvent.ACTION_DOWN == action) {
                    return false;
                } else if (MotionEvent.ACTION_UP == action) {
                    return false;
                }

                return false;
            }
        });

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        wrapper.setLayoutParams(layoutParams);

        this.addView(wrapper);
    }

    public void textHelloClicked(View v) {
        Toast.makeText(mContext, "textHelloClicked", Toast.LENGTH_SHORT).show();
    }

    public void imgClicked(View v) {
        Toast.makeText(mContext, "imgClicked", Toast.LENGTH_SHORT).show();
    }

    public void worldClicked(View v) {
        Toast.makeText(mContext, "worldClicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();

        if (MotionEvent.ACTION_MOVE == action) {
/*
            if (lastEvent == MotionEvent.ACTION_DOWN) {
                return true;
            }
*/
            lastEvent = MotionEvent.ACTION_MOVE;
        } else if (MotionEvent.ACTION_DOWN == action) {
            lastEvent = MotionEvent.ACTION_DOWN;
        } else if (MotionEvent.ACTION_UP == action) {
            lastEvent = MotionEvent.ACTION_UP;
        } else if (MotionEvent.ACTION_CANCEL == action) {
            lastEvent = MotionEvent.ACTION_CANCEL;
        }

        return super.onInterceptTouchEvent(ev);
    }

    private int sx;
    private int sy;
    private int lastEvent;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
/*        int x=(int)event.getX();
        int y=(int)event.getY();*/



        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
//                moveX=x;

                sx = (int) event.getRawX();
                sy = (int) event.getRawY();

                Log.d(TAG, "onTouchEvent, ACTION_DOWN ");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "onTouchEvent, ACTION_MOVE ");
                int x = (int) event.getRawX();
                int y = (int) event.getRawY();

                //计算移动的距离
/*                int offsetX=x-moveX;
                int offsetY=y-moveX;*/
                //调用layout方法来重新放置它的位置
/*                offsetLeftAndRight(offsetX);
                offsetTopAndBottom(offsetY);*/

                // 获取手指移动的距离
                int dx = x - sx;
                int dy = y - sy;
                // 得到imageView最开始的各顶点的坐标
                int l = getLeft();
                int r = getRight();
                int t = getTop();
                int b = getBottom();
                // 更改imageView在窗体的位置
//                if (dx > 1 || dy > 1) {
                    layout(l + dx, t + dy, r + dx, b + dy);
//                }

                // 获取移动后的位置
                sx = (int) event.getRawX();
                sy = (int) event.getRawY();

                break;

            case MotionEvent.ACTION_UP:
                break;


            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return true;
    }

    private int wMode;
    private int hMode;
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        mViewWidth=getMeasuredWidth();
        mViewHeight=getMeasuredHeight();

        wMode = MeasureSpec.getMode(widthMeasureSpec);
        hMode = MeasureSpec.getMode(heightMeasureSpec);

        Log.d(TAG, "onMeasure, wMode " + wMode + ", hMode = " + hMode + ", mViewWidth = " + mViewWidth + ", mViewHeight = " + mViewHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }
}
