package com.example.hint;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.LinearViewholder> {
    private Context mcontext;
    private List<Book> bookList;
    public Adapter(Context context, List<Book> books){
        this.mcontext=context;
        bookList = books;
    }
    @NonNull
    @Override
    public Adapter.LinearViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new LinearViewholder(LayoutInflater.from(mcontext).inflate(R.layout.recyclerview_sql_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final Adapter.LinearViewholder viewHolder, final int i) {
        final Book book = bookList.get(i);
        viewHolder.name.setText(book.getName());
        viewHolder.author.setText(book.getAuthor());
        viewHolder.ima.setImageResource(book.getNum());
        viewHolder.date.setText("到期时间："+book.getTime());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mcontext,Book_detals.class);
                intent.putExtra("extra_data",book.getName());
                intent.putExtra("extra_num",book.getNum());
                intent.putExtra("type","还");
                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }
    class LinearViewholder extends RecyclerView.ViewHolder{

        private TextView author,date,name;
        private ImageView ima;
        public LinearViewholder(@NonNull View itemView) {
            super(itemView);
            ima = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            author= itemView.findViewById(R.id.author);
            date = itemView.findViewById(R.id.mybook_time);
        }
    }
}
