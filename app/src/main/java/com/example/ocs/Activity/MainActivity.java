package com.example.ocs.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.ocs.Adapter.CategoryAdapter;
import com.example.ocs.Adapter.DItemsAdapter;
import com.example.ocs.Domain.CategoryDomain;
import com.example.ocs.Domain.FoodDomain;
import com.example.ocs.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button logout;
    FirebaseAuth auth;
    TextView category;

    private RecyclerView.Adapter adapter , adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewDailyItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout = findViewById(R.id.logoutbtn);
        category = findViewById(R.id.categoryViews);
        auth =FirebaseAuth.getInstance();


        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity.class);
                startActivity(intent);
            }
        });

        recyclerViewCategory();
        recyclerViewDaily();

        logout.setOnClickListener(view ->{
            auth.signOut();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        });



    }

    private void recyclerViewDaily() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerViewDailyItems = findViewById(R.id.recyclerView);
        recyclerViewDailyItems.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> FoodList = new ArrayList<>();
        FoodList.add(new FoodDomain("piza", "piza", 10.00, "****", 10, 20));
        FoodList.add(new FoodDomain("piza", "piza", 10.00, "****", 10, 20));
        FoodList.add(new FoodDomain("piza", "piza", 10.00, "****", 10, 20));
        FoodList.add(new FoodDomain("piza", "piza", 10.00, "****", 10, 20));
        FoodList.add(new FoodDomain("piza", "piza", 10.00, "****", 10, 20));
        FoodList.add(new FoodDomain("piza", "piza", 10.00, "****", 10, 20));

        adapter2 = new DItemsAdapter(FoodList);
        recyclerViewDailyItems.setAdapter(adapter2);
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView2);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categorylist = new ArrayList<>();
        categorylist.add(new CategoryDomain("Pizza", "cat_1"));
        categorylist.add(new CategoryDomain("Pizza", "cat_2"));
        categorylist.add(new CategoryDomain("Pizza", "cat_3"));
        categorylist.add(new CategoryDomain("Pizza", "cat_4"));

        adapter = new CategoryAdapter(categorylist);
        recyclerViewCategoryList.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = auth.getCurrentUser();
        if(user == null){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }
}