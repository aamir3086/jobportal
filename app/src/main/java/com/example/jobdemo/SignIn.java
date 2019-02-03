package com.example.jobdemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jobdemo.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignIn extends AppCompatActivity {
    EditText editPhone,editPass;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editPhone=(MaterialEditText)findViewById(R.id.editPhone);
        editPass=(MaterialEditText)findViewById(R.id.editPassword);
        btnSignIn=(Button)findViewById(R.id.btnSignIn);

        final FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference table_user=database.getReference("user");
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog=new ProgressDialog(SignIn.this);
                mDialog.setMessage("Please Wait....");
                mDialog.show();
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(editPhone.getText().toString()).exists())
                        {
                        mDialog.dismiss();
                        User user=dataSnapshot.child(editPhone.getText().toString()).getValue(User.class);
                        if (user.getPassword().equals(editPass.getText().toString()))
                        {
                            mDialog.dismiss();
                            Intent Joblist=new Intent(SignIn.this,JobList.class);
                            startActivity(Joblist);
                        }
                        else
                        {
                            mDialog.dismiss();
                            Toast.makeText(SignIn.this,"Enter Correct User & Password",Toast.LENGTH_SHORT).show();
                        }}
                        else {
                        Toast.makeText(SignIn.this,"User Doesn't Exist",Toast.LENGTH_SHORT).show();
                        }
                        }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
