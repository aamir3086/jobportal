package com.example.jobdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jobdemo.Model.ListItem;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    public MyAdapter(recyclerView recyclerViewd, ArrayList<ListItem> list) {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return  new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ListItem listItem=listItems.get(i);
        viewHolder.textViewName.setText(listItem.getExp());
        viewHolder.textViewSal.setText(listItem.getName());
        viewHolder.textViewExp.setText(listItem.getName());
        viewHolder.textViewSkills.setText(listItem.getName());
        viewHolder.textViewType.setText(listItem.getName());
        viewHolder.textViewJob.setText(listItem.getName());


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewName;
        public  TextView textViewSal;
        public  TextView textViewExp;
        public  TextView textViewSkills;
        public  TextView textViewType;
        public  TextView textViewJob;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName=(TextView)itemView.findViewById(R.id.textViewName);
            textViewSal=(TextView)itemView.findViewById(R.id.textViewSal);
            textViewExp=(TextView)itemView.findViewById(R.id.textViewExp);
            textViewSkills=(TextView)itemView.findViewById(R.id.textViewSkills);
            textViewType=(TextView)itemView.findViewById(R.id.textViewType);
            textViewJob=(TextView)itemView.findViewById(R.id.textViewJob);

        }
    }
}
