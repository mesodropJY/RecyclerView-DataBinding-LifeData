package com.recyclerviewdatabinding;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.recyclerviewdatabinding.databinding.CellMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private ArrayList<DataModel> mData;

    public MainAdapter(ArrayList<DataModel> data) {
        this.mData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CellMainBinding cellMainBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.cell_main, parent, false);

        ViewHolder viewHolder = new ViewHolder(cellMainBinding);

        Log.i("TAGGGG", "onCreateViewHolder");

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataModel data = mData.get(position);

        Log.i("TAGGGG", "onBindViewHolder");

        holder.cellMainBinding.textView5.setText(data.local1);
        holder.cellMainBinding.textView6.setText(data.local2);
        holder.cellMainBinding.textView7.setText(data.local3);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CellMainBinding cellMainBinding;

        public ViewHolder(@NonNull CellMainBinding cellMainBinding) {
            super(cellMainBinding.getRoot());
            this.cellMainBinding = cellMainBinding;
            this.cellMainBinding.setShowVar(MainActivity.viewModel);

            Log.i("TAGGGG", "ViewHolder");
        }

    }
}
