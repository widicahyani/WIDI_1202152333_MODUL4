package com.ead.widi_1202152333_modul4;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class carigambar extends AppCompatActivity {
    private EditText cari;
    private Button fb;
    private ImageView image;
    private ProgressDialog PD;
    private String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carigambar);
        cari = (EditText) findViewById(R.id.linkinput);
        fb = (Button) findViewById(R.id.findbutton);
        image = (ImageView) findViewById(R.id.suspect);
        //Inisiating component
    }

    public void cariGambar(View view) {
        input = cari.getText().toString();
        //checking weather the edittext is filled
        if (input.isEmpty()) {
            Toast.makeText(this, "Please input the URL", Toast.LENGTH_LONG).show();
        } else {
            new Carisuspect().execute(input);
        }
    }


    private class Carisuspect extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            //to show the progress
            PD = new ProgressDialog(carigambar.this);
            PD.setTitle("Finding your picture");
            PD.setMessage("Please hold a second");
            PD.setIndeterminate(false);
            PD.show();
        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            //to find the picture in background
            String imageURL = urls[0];
            Bitmap bimage = null;
            try {

            } catch (Exception e) {

            }
            return bimage;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            image.setImageBitmap(bitmap);
            PD.dismiss();
        }
    }
}

