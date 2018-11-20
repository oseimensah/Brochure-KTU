package com.ktu.bismark.project.brochurektu;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import static android.graphics.Color.TRANSPARENT;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Toolbar mtoolbar;
    Button nextButton;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Dialog myDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        mtoolbar=findViewById(R.id.myToolbar);
        setSupportActionBar(mtoolbar);

        myDialog = new Dialog(this);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, mtoolbar,
                R.string.open_drawer, R.string.close_drawer);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

    }

    public void showPopup(View v){
        Button btnFollow;;
        myDialog.setContentView(R.layout.custompopup);
        btnFollow = findViewById(R.id.btnFollow);

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.green(TRANSPARENT)));
        myDialog.show();

    }

    public void closePopup(View view){
        myDialog.dismiss();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        switch (id){
            case R.id.check_one:
                Toast.makeText(this, "Inbox Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.check_two:
                Toast.makeText(this, "Starred Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.check_three:
                Toast.makeText(this, "Sent Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.check_four:
                Toast.makeText(this, "Draft Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.message_app:
                Toast.makeText(this, "Email Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.debate_app:
                Toast.makeText(this, "Trash Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.update_app:
                Toast.makeText(this, "Spam Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.relation_app:
                Toast.makeText(this, "Profile Selected", Toast.LENGTH_SHORT).show();
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {

            super.onBackPressed();
        }
    }

    //    private static long back_pressed;
//
//    @Override
//    public void onBackPressed() {
//
//        if (back_pressed >= 2) {
//            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
//            alertBuilder.setCancelable(false);
//            alertBuilder.setTitle("QUIT");
//            alertBuilder.setMessage("Do you really want to Quit");
//            alertBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    Toast.makeText(getApplicationContext(), "Thank you for using our app", Toast.LENGTH_LONG).show();
//                    finish();
//                }
//            });
//            alertBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    Toast.makeText(getApplicationContext(), "Thank you. Continue using our app", Toast.LENGTH_SHORT).show();
//                }
//            });
//            alertBuilder.create().show();
////            super.onBackPressed();
//        } else {
//            Toast.makeText(getBaseContext(), "Press once again to exit!", Toast.LENGTH_SHORT).show();
//            back_pressed = System.currentTimeMillis();
//        }
//    }

}
