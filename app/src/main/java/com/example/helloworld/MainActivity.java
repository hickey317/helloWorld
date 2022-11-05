package com.example.helloworld;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        Button button1 = (Button) findViewById(R.id.Button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"rnm jianjun",Toast.LENGTH_SHORT).show();
                String data = "hello second page";
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                //Intent intent = new Intent("com.example.activitytest.ACTION_START");
                //intent.addCategory("com.example.activitytest.MY_CATEGORY");
                //Intent intent = new Intent(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse("http://www.baidu.com"));
                intent.putExtra("extra_data",data);
                startActivity(intent);
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("there is an imperative news");
                dialog.setMessage("king engine is started");
                dialog.setCancelable(false);
                dialog.setPositiveButton("give u", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.show();
            }
        });
        editText = (EditText) findViewById(R.id.edit_text);
        Button button2 = (Button) findViewById(R.id.firstPageButton2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = editText.getText().toString();
                Toast.makeText(MainActivity.this,input,Toast.LENGTH_SHORT).show();
                imageView.setImageResource(R.drawable.nini2);
                int progress = progressBar.getProgress();
                progress = progress + 10;
                progressBar.setProgress(progress);
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("do you like me ");
                progressDialog.setMessage("yes i do");
                progressDialog.setCancelable(true);
                progressDialog.show();

                /*
                if(progressBar.getVisibility()==View.GONE){
                    progressBar.setVisibility(View.VISIBLE);
                }else {
                    progressBar.setVisibility(View.GONE);
                }

                 */
            }
        });
        imageView = (ImageView) findViewById(R.id.image1);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    };
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"you click on add item",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:{
                Toast.makeText(this,"you click on remove item",Toast.LENGTH_SHORT).show();
                break;
            }
            default:
        }
        return true;
    }
}