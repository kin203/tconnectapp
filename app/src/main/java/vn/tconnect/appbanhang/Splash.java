package vn.tconnect.appbanhang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class Splash extends AppCompatActivity {
    LauncherManager launcherManager;
//    private boolean backButtonPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        launcherManager =new LauncherManager(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(launcherManager.isFirstTime()){
                    launcherManager.setFirstLaunch(false);
                    startActivity(new Intent(getApplicationContext(),Slider.class));
                }else{
                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                }
                finish();

            }
        },2000);
    }
//    @Override
//    public void onBackPressed() {
//        if (backButtonPressedOnce) {
//            super.onBackPressed();
//            return;
//        }
//
//        this.backButtonPressedOnce = true;
//
//        // Hiển thị thông báo hoặc thông báo Toast thông báo người dùng cần phải bấm lần nữa để thoát.
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                backButtonPressedOnce = false;
//            }
//        }, 2000); // Thiết lập thời gian chờ để cho phép bấm lần nữa.
//    }
}