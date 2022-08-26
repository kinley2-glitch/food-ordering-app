package com.example.ocs.Activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ocs.Adapter.CategoryAdapter;
import com.example.ocs.Domain.CategoryDomain;
import com.example.ocs.R;

import java.util.ArrayList;


public class DrinksFragment extends Fragment {

    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drinks, container, false);

    }


}