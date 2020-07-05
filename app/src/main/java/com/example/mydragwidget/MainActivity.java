package com.example.mydragwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import android.widget.Toast;

import com.example.mydragwidget.sort.Algorithm;
import com.example.mydragwidget.sort.CommonSort;
import com.example.mydragwidget.sort.finder.AVLBTree2;
import com.example.mydragwidget.sort.finder.BTree;
import com.example.mydragwidget.sort.finder.RBTree;
import com.example.mydragwidget.sort.finder.TreeNode;
import com.example.mydragwidget.statictest.ActivityThread;
import com.example.mydragwidget.statictest.RefStaticMethod;
import com.example.mydragwidget.statictest.childParameterizedType;
import com.example.mydragwidget.statictest.testParameterizedType;
import com.example.mydragwidget.statictest.testclass;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity implements testabc{
        // 这里不会去初始化
        private static testclass method;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void textHelloClicked(View v) {
        Toast.makeText(this, "textHelloClicked", Toast.LENGTH_SHORT).show();
    }

    public void imgClicked(View v) {
        Toast.makeText(this, "imgClicked", Toast.LENGTH_SHORT).show();
    }

    public void worldClicked(View v) {
        Toast.makeText(this, "worldClicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Log.d("lizhihong", "" + abc.class.getTypeName() + ", " + abc.class.toGenericString()
                    + ", " + abc.class.isInterface());
            Log.d("lizhihong", "" + MainActivity.class.getTypeName() + ", " + MainActivity.class.toGenericString()
                    + ", " + MainActivity.class.getInterfaces().length);
        }
        testSort();

//        Activity

        int FLAG_IN_USE = 4 >> 1;
        int FLAG_ASYNCHRONOUS = 1 << 1;

        Log.d("lizhihong", "FLAG_IN_USE = " + FLAG_IN_USE);
        Log.d("lizhihong", "FLAG_ASYNCHRONOUS = " + FLAG_ASYNCHRONOUS);
        int flags = 0;
        flags |= FLAG_IN_USE;

        Log.d("lizhihong", "flags = " + flags);


//        ActivityManager
//        Activity

        testclass tc = new testclass();
        Log.d("lizhihong", "tc.i = " + tc.i);
//        Log.d("lizhihong", "ActivityThread.currentActivityThread = " + m);
//        Log.d("lizhihong", "ActivityThread.currentActivityThread.call = " + o);

        Object o = testclass.currentActivityThread.call();
//        RefStaticMethod m = testclass.currentActivityThread;
        Log.d("lizhihong", "ActivityThread.currentActivityThread.call = " + o);
        Log.d("lizhihong", "==============================");

        /**
         * 这里是报异常 InstantiationException
         */
        try {
            Log.d("lizhihong", "abc.class.newInstance() = " + abc.class.newInstance());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        Log.d("lizhihong", "abc.class.newInstance() = " + new abc() {

        });

        // 获取父类泛型参数及个数
        testParameterizedType pt = new childParameterizedType<Integer>();
        Type type = pt.getClass().getGenericSuperclass();
        ParameterizedType p=(ParameterizedType)type;
        Log.d("lizhihong", "" + p.getActualTypeArguments().length);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            Log.d("lizhihong", "&&&&&&" + p.getActualTypeArguments()[0].getTypeName());
//        }
    }

    public <T> T test3(T a) {
        return a;
    }

    // 不报错， "?" 是类型通配符，无需声明，但不是泛型方法
    public void test(Class<?> a) {

    }

    // 报错，因为这个不是一个 泛型方法，而且 ”T“ 没有被声明
/*
    public void test1(Class<T> a) {

    }
*/

    public interface abc {

    }

    private void testSort() {
        try {
            addition_isCorrect();
            CommonSort.main();
            Algorithm.main();

            TreeNode.main();

            BTree.main(null);

            AVLBTree2.main();

            RBTree.main();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addition_isCorrect() throws Exception {
//        assertEquals(4, 2 + 2);
//        fun(3);
//        System.out.println(fact(5));
        hanoi(5,1,2,3);
    }

    /**
     * 测试递归的思想
     */
    public void fun(int n){  //3
        System.out.println(n);
        if(n<0){
            return;
        }else{
            fun(n-1);
            System.out.println(n);
        }
    }
    /**
     * 1*2*3*4*5....     n!
     * 5!  = 5*4!      4! =  4*3!
     */
    public int fact(int n){
        if(n<=1){
            return 1;
        }else{
            return n*fact(n-1);
        }
    }
    /**
     * fibonacciSequence数列   8=7+6   7=6+5  6=5+4
     * 1   1  2  3  5  8   13  21  34  55  89  144......
     * 返回第n项
     */
    public int fibonacciSequence(int n){
        if(n==1 || n==2){
            return 1;
        }else{
            return fibonacciSequence(n-1)+fibonacciSequence(n-2);
        }
    }

    /**
     * @param n      盘子的个数
     * @param start   开始的柱子
     * @param middle   中介柱子
     * @param end      结果柱子
     */
    public static void hanoi(int n,int start,int middle,int end){
        if(n<=1){
            System.out.println(start+"----->"+end);
        }else{
            hanoi(n-1,start,end,middle);
            System.out.println(start+"----->"+end);
            hanoi(n-1,middle,start,end);
        }
    }
}
