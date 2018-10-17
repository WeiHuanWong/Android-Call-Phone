package com.oliver.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_CALL_PHONE=0x01;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt=findViewById(R.id.bt1);
        bt.setOnClickListener(view ->{
            Uri uri= Uri.parse("tel:123");
            Intent intent=new Intent(Intent.ACTION_CALL,uri);
            if(checkSelfPermission(Manifest.permission.CALL_PHONE)==PackageManager.PERMISSION_GRANTED){
                startActivity(intent);
            }else {
                requestPermissions(new String[]{Manifest.permission.CALL_PHONE},REQUEST_CODE_CALL_PHONE);
            }

        }

        );

    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[]permissions,@NonNull int[] grantResults){
            if (requestCode==REQUEST_CODE_CALL_PHONE) {
                if (grantResults.length > 0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                }
            }
    }
}

