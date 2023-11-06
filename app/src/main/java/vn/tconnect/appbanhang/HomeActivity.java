package vn.tconnect.appbanhang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewPager2= findViewById(R.id.saleViewPager);
        List<SlideItem> slideItems=new ArrayList<>();
        slideItems.add(new SlideItem(R.drawable.anh1));
        slideItems.add(new SlideItem(R.drawable.anh2));
        slideItems.add(new SlideItem(R.drawable.anh3));

        viewPager2.setAdapter(new Slide_Adapter(slideItems,viewPager2));
    }
}