package com.example.postrecycleviewapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Animal> animalList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = (RecyclerView) findViewById(R.id.main);
        animalList = new ArrayList<>();

        setAnimalInfo();
        setAdapter();
    }

    private void setAdapter() {
        recyclerAdapter adapter = new recyclerAdapter(animalList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(adapter);
    }

    private void setAnimalInfo() {
        animalList.add(new Animal("Beluga", "Arctic  Ocean", R.drawable.beluga));
        animalList.add(new Animal("Colugo", "Southeast Asia", R.drawable.colugo));
        animalList.add(new Animal("Eagle", "North America", R.drawable.eagle));
        animalList.add(new Animal("Fox", "Arctic to Desert", R.drawable.fox));
        animalList.add(new Animal("Hummingbird", "North America", R.drawable.hummingbird));
        animalList.add(new Animal("Koala", "Australia", R.drawable.koala));
        animalList.add(new Animal("Panther", "South/Southeast Asia", R.drawable.panther));
        animalList.add(new Animal("Polar Bear", "Arctic", R.drawable.polarbear));
        animalList.add(new Animal("Red Panda", "Southwest China", R.drawable.red_panda));
        animalList.add(new Animal("Tiger", "South/Southeast Asia", R.drawable.tiger));
    }
}