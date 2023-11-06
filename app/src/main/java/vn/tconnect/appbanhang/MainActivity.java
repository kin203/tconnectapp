package vn.tconnect.appbanhang;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    // khai báo các biến giao diện
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ánh xạ id cho các biến giao diện
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_nav,R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish(); // Tùy chọn: Đóng Activity gốc nếu bạn không muốn quay lại nó
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_mouse:
                intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_keyboard:
                intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_monitor:
                intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_headset:
                intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_laptop:
                intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_top_product:
                intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_news:
                intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_contact:
                intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_logout:
                Toast.makeText(this, "Đăng Xuất !", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}