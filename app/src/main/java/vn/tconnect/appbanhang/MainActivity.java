package vn.tconnect.appbanhang;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    // khai báo các biến giao diện
    ViewPager2 viewPager2;
    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home,mouse,keyboard,laptop,monitor,news,headset,contact,logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ánh xạ id cho các biến giao diện
        drawerLayout =findViewById(R.id.drawer_layout);
        menu =findViewById(R.id.menu);
        home =findViewById(R.id.home);
        mouse = findViewById(R.id.mouse);
        keyboard = findViewById(R.id.keyboard);
        laptop=findViewById(R.id.laptop);
        monitor=findViewById(R.id.monitor);
        news=findViewById(R.id.news);
        headset=findViewById(R.id.headset);
        contact=findViewById(R.id.contact);
        logout=findViewById(R.id.logout);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrawer(drawerLayout);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recreate();
            }
        });
        mouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(MainActivity.this,MouseActivity.class);
            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Đăng xuất",Toast.LENGTH_SHORT).show();
            }
        });

        viewPager2= findViewById(R.id.saleViewPager);
        List<SlideItem> slideItems=new ArrayList<>();
        slideItems.add(new SlideItem(R.drawable.anh1));
        slideItems.add(new SlideItem(R.drawable.anh2));
        slideItems.add(new SlideItem(R.drawable.anh3));

        viewPager2.setAdapter(new Slide_Adapter(slideItems,viewPager2));

    }
    public static void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public static void closeDrawer(DrawerLayout drawerLayout){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public static void redirectActivity(Activity activity,Class secondActivity){
        Intent intent = new Intent(activity,secondActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }

}