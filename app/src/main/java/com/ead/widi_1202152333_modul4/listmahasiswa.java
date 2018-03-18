package com.ead.widi_1202152333_modul4;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class listmahasiswa extends AppCompatActivity {
        private ListView LV;
        private ProgressBar PB;
        private String [] SN= {
                "Widi","Setia", "Cahyani","Binti","Tugiman",
                "Setiaman"};
        //Entry the list

        private AddItemToListView AddItemToListView;
        private Button StartAsyncTask;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_listmahasiswa);
            //Defining Atribut
            PB = (ProgressBar) findViewById(R.id.progressBar);
            LV = (ListView) findViewById(R.id.List);
            StartAsyncTask = (Button) findViewById(R.id.dotask);
            //Enter listview in empty value
            LV.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,new ArrayList<String>()));

            //inisiating every used component with array
            StartAsyncTask.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AddItemToListView = new AddItemToListView();
                    AddItemToListView.execute();
                    //run asynctask
                }
            });
        }
        public class AddItemToListView extends AsyncTask<Void, String, Void> {

            private ArrayAdapter<String> mAdapter;
            private int counter=1;
            ProgressDialog Progress = new ProgressDialog(listmahasiswa.this);
            //initiation every used component

            @Override
            protected void onPreExecute() {
                mAdapter = (ArrayAdapter<String>) LV.getAdapter();

                //process dialogue to be appeared
                Progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                Progress.setTitle("Finding The Data");
                Progress.setMessage("Please Wait");
                Progress.setCancelable(false);
                Progress.setProgress(0);
                Progress.show();
            }

            @Override
            protected Void doInBackground(Void... voids) {
                //Run sleep
                for (String item : SN){
                    publishProgress(item);
                    try {
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    if(isCancelled()){
                        AddItemToListView.cancel(true);
                    }
                }
                return null;
            }
            @Override
            protected void onProgressUpdate(String... values) {
                //run progress bar based on uploaded data
                mAdapter.add(values[0]);
                Integer current_status = (int) ((counter/(float)SN.length)*100);
                PB.setProgress(current_status);
                Progress.setProgress(current_status);
                Progress.setMessage(String.valueOf(current_status+"%"));
                counter++;
            }


            @Override
            protected void onPostExecute(Void aVoid) {
                //vanishing progress bar and dialog
                PB.setVisibility(View.GONE);
                Progress.dismiss();
                LV.setAdapter(new ArrayAdapter<String>(listmahasiswa.this,android.R.layout.simple_list_item_1,SN));

            }
        }
    }


