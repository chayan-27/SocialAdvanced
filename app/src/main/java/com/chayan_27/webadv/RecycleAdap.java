package com.chayan_27.webadv;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecycleAdap extends RecyclerView.Adapter<RecycleAdap.ContentHolder> {
    List<String> list;
    List<String> list1;
    List<String> urls;
    Context context;

    public RecycleAdap(List<String> list, List<String> list1, List<String> urls, Context context) {
        this.list = list;
        this.list1 = list1;
        this.urls = urls;
        this.context = context;
    }

    @NonNull
    @Override
    public ContentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.cards,parent,false);
        return new ContentHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final ContentHolder holder, final int position) {
        //holder.imageView.setImageResource(list.get(position));
        Picasso.get().load(list.get(position)).into(holder.imageView);
        holder.textView.setText(list1.get(position));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Drawable res=holder.imageView.getDrawable();
                    WebAct.drawable=res;
                    Intent intent=new Intent(context,WebAct.class);
                    intent.putExtra("url",urls.get(position));
                    intent.putExtra("title",list1.get(position));

                    context.startActivity(intent);




            }
        });


    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ContentHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        CardView cardView;

        public ContentHolder(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.image);
            textView=(TextView)itemView.findViewById(R.id.text);
            cardView=(CardView)itemView.findViewById(R.id.cards);
        }
    }
}
