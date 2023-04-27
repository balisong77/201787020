package com.example.hint;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

import androidx.annotation.NonNull;

public class SpinnerAdapter extends ArrayAdapter {

    public SpinnerAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    @Override
    public int getCount() {
        //返回数据的统计数量，大于0项则减去1项，从而不显示最后一项
        int i = super.getCount();
        return i>0?i-1:i;
    }
}
