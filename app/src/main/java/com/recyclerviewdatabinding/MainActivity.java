package com.recyclerviewdatabinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.recyclerviewdatabinding.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    public static MainViewModel viewModel;
    public  static MainAdapter adapter;
    public static ArrayList<DataModel> array = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        adapter = new MainAdapter(array);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(adapter);

        viewModel.setDelete(new MainViewModel.deleteListener() {
            @Override
            public void delete() {
                binding.editTextTextPersonName.setText("");
                binding.editTextTextPersonName2.setText("");
                binding.editTextTextPersonName3.setText("");
            }

            @Override
            public void clearAll() {
                binding.editTextTextPersonName.setText("");
                binding.editTextTextPersonName2.setText("");
                binding.editTextTextPersonName3.setText("");
                array.clear();
                adapter.notifyDataSetChanged();
            }
        });

        binding.setLifecycleOwner(this);
        binding.setMainVar(viewModel);
    }
}