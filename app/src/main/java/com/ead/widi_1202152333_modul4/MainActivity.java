package com.ead.widi_1202152333_modul4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);}

    public void list(View view) {
        Intent a = new Intent(this,listmahasiswa.class);
        startActivity(a);
    }

    public void cari(View view) {
        Intent b = new Intent(this,carigambar.class);
        startActivity(b);
    }
}
