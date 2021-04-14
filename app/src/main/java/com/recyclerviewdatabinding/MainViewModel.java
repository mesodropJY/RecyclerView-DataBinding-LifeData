package com.recyclerviewdatabinding;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public MutableLiveData<String> local1 = new MutableLiveData<>();
    public MutableLiveData<String> local2 = new MutableLiveData<>();
    public MutableLiveData<String> local3 = new MutableLiveData<>();
    public MutableLiveData<DataModel> array = new MutableLiveData<DataModel>();

    private deleteListener mListener;

    public void setDelete(deleteListener mDelete){
        mListener = mDelete;
    }

    public interface deleteListener{
        void delete();

        void clearAll();
    }

    public MainViewModel() {
        array.setValue(new DataModel("test", "test", "test"));
    }

    public void addFunc() {

        array.setValue(new DataModel(local1.getValue(), local2.getValue(), local3.getValue()));

        MainActivity.array.add(new DataModel(array.getValue().local1,array.getValue().local2,array.getValue().local3));

        MainActivity.adapter.notifyDataSetChanged();

        mListener.delete();

    }

    public void deleteFunc() {
        mListener.clearAll();
    }
}
