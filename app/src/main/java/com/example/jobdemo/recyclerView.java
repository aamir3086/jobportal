package com.example.jobdemo;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jobdemo.Model.ListItem;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class recyclerView extends AppCompatActivity {

    private static final String URL_DATA="https://jobdemo-1e182.firebaseio.com/";
    RecyclerView recyclerViewd;
    //private RecyclerView.Adapter adapter;
    private ArrayList <ListItem> list;
    DatabaseReference reference;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

         reference=FirebaseDatabase.getInstance().getReference().child("Job");


        recyclerViewd=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerViewd.setHasFixedSize(true);
        recyclerViewd.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<ListItem>();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    ListItem p=dataSnapshot.getValue(ListItem.class);
                    list.add(p);
                }

               adapter=new MyAdapter(recyclerView.this,list);
               recyclerViewd.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            Toast.makeText(recyclerView.this,"could not connect",Toast.LENGTH_SHORT).show();
            }
        });
/*        loadRecyclerViewData();

    }
        private void loadRecyclerViewData(){
            final ProgressDialog progressDialog=new ProgressDialog(this);
            progressDialog.setMessage("loading..");
            progressDialog.show();
            StringRequest stringRequest=new StringRequest(Request.Method.GET,
                    URL_DATA, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();
                    try {
                        JSONObject jsonObject=new JSONObject(response);
                        JSONArray array= jsonObject.getJSONArray("user");

                        for (int i=0; i<array.length();i++)
                        {
                            JSONObject o=array.getJSONObject(i);
                            ListItem item=new ListItem(
                                    o.getString("Name"),
                                    o.getString("Salary"),
                                    o.getString("Exp"),
                                    o.getString("Skills"),
                                    o.getString("Type"),
                                    o.getString("Job")

                            );
                            listItems.add(item);
                        }

                        adapter =new MyAdapter(listItems,getApplicationContext());
                        recyclerView.setAdapter(adapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            },

                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    });
            RequestQueue requestQueue= Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

            */
        }

}

