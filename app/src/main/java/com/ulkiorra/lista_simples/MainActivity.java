package com.ulkiorra.lista_simples;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DigimonAdapter.OnItemClickListener {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new DigimonAdapter(this, initializeDigimonList(), this));
    }

    private List<Digimon> initializeDigimonList() {
        List<Digimon> digimons = new ArrayList<>();
        digimons.add(new Digimon("Angemon", R.drawable.angemon, "Descrição do Angemon"));
        digimons.add(new Digimon("Agumon", R.drawable.agumon, "Descrição do Agumon"));
        digimons.add(new Digimon("Angewomon", R.drawable.angewomon, "Descrição da Angewomon"));
        digimons.add(new Digimon("Patamon", R.drawable.patamon, "Descrição do Patamon"));
        digimons.add(new Digimon("Devimon", R.drawable.devimon, "Descrição do Devimon"));
        digimons.add(new Digimon("Tailmon", R.drawable.tailmon, "Descrição da Tailmon"));
        digimons.add(new Digimon("Seraphimon", R.drawable.seraphimon, "Descrição do Seraphimon"));
        return digimons;
    }

    @Override
    public void onItemClick(Digimon digimon) {
        Toast.makeText(this, digimon.getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("NAME", digimon.getName());
        intent.putExtra("IMAGE_ID", digimon.getImageResourceId());
        intent.putExtra("DESCRIPTION", digimon.getDescription());
        startActivity(intent);
    }
}
