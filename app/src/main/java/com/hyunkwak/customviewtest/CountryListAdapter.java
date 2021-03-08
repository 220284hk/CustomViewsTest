package com.hyunkwak.customviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.CountryViewHolder> {
    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;

    public CountryListAdapter(Context context, LinkedList<String> mWordList) {
        this.mWordList = mWordList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent,
                                                int viewType) {
        View mItemView = mInflater.inflate(R.layout.word_list_item,
                parent, false);
        return new CountryViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryListAdapter.CountryViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }



    class CountryViewHolder extends RecyclerView.ViewHolder {
        public final TextView wordItemView;
        final CountryListAdapter mAdapter;

        public CountryViewHolder(@NonNull View itemView, CountryListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
        }


    }
}
