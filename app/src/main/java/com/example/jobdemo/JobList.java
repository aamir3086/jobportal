package com.example.jobdemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class JobList extends AppCompatActivity {
    Button apply;
    Button map;
    String java=
            "<body>\n" +
            "<h2> Senior Java Developer @ 3i Infotech Limited</h2><br> <ul><li>Specialisation : IT-Software,Oracle/Sybase/SQL/DB2, Java Technologies</li>\n" +
            "    <li>Location : Mumbai </li>\n" +

            "    <li>Key Skills : Core Java Spring framework Angular JS Rest APIs Micro Service\n" +
            "    <li>Job Description: " +" "+"Candidate must have 4+ years of Java experience with the following\n" +
                    " Core Java\n"+"Spring framework\n"+"Angular JS\n"+"Rest APIs<br>\n" +
            "Micro Service experience is desirable. </li>\n" +

            "</body>\n" +
            "</html>";
    String asp=
            "<body>\n" +
                    "<h2>    Microsoft .Net Developer @ Avista Information Systems LLP\n</h2><br> <ul><li>Specialisation : IT-Software , Oracle/Sybase/SQL/DB2, .Net Technologies</li>\n" +
                    "    <li>Location : Dadar </li>\n" +

                    "    <li>Key Skills : ASP .NET, C# and Java Script, SQL Database \n" +

                    "    <li>Job Description: " +" "+"Work on large U.S based web and mobile projects using ASP .NET, C# and Java Script \n" +
                    " Develop code based on company standards\n" +
                    "Work with SQL Server databases </li>\n" +

                    "</body>\n" +
                    "</html>";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_list);

        TextView textView=(TextView)findViewById(R.id.java);
        textView.setText(Html.fromHtml(java));

        apply=(Button)findViewById(R.id.apply);
        map=(Button)findViewById(R.id.map);
        //applyasp=(Button)findViewById(R.id.applyasp);


    apply.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            apply.setText("Appiled");
            apply.setEnabled(false);
            Toast.makeText(JobList.this,"Job Applied Sucessfully",Toast.LENGTH_SHORT).show();
        }
    });
    map.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent mapdemo=new Intent(JobList.this,google_map.class);
            startActivity(mapdemo);

        }
    });



   /* applyasp.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            applyasp.setText("Appiled");
            applyasp.setEnabled(false);
            Toast.makeText(JobList.this,"Job Applied Sucessfully",Toast.LENGTH_SHORT).show();
        }
    });*/
    }
}
