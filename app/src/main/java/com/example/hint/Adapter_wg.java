package com.example.hint;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_wg extends RecyclerView.Adapter<Adapter_wg.GridViewHolder> {
    private Context mcontext;
    private List<Book> bookList;
    private Drawable drawable;
    Adapter_wg(Context context,List<Book> books,Drawable drawable){
        this.mcontext = context;
        bookList = books;
        this.drawable = drawable;
    }
    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new GridViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.recyclerview_wg_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder viewHolder, final int i) {
        final Book book = bookList.get(i);
        viewHolder.textView1.setText(book.getName());
        viewHolder.textView2.setText(book.getFree());
        viewHolder.imageView.setImageResource(book.getNum());
        if(book.getFree().equals("Borrowed"))
        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                viewHolder.textView2.setBackground(drawable);
            }
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (book.getFree().equals("Borrowable")) {
                    Intent intent = new Intent(mcontext, Book_detals.class);
                    intent.putExtra("extra_data", book.getName());
                    intent.putExtra("extra_num",book.getNum());
                    intent.putExtra("type","borrow");
                    mcontext.startActivity(intent);
                }
                else {
                    Toast.makeText(mcontext,"This book has been borrowed",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }
    class GridViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView1,textView2;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ima_allbook);
            textView1  = itemView.findViewById(R.id.allbook_name);
            textView2 = itemView.findViewById(R.id.allbook_free);
        }
    }
}
