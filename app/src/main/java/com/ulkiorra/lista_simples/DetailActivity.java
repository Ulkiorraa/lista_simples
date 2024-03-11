package com.ulkiorra.lista_simples;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView title = findViewById(R.id.tvTitle);
        ImageView image = findViewById(R.id.ivDigimon);
        TextView description = findViewById(R.id.tvDescription);
        Button back = findViewById(R.id.btnBack);

        Intent intent = getIntent();
        title.setText(intent.getStringExtra("NAME"));
        Glide.with(this).load(intent.getIntExtra("IMAGE_ID", 0)).into(image);
        description.setText(intent.getStringExtra("DESCRIPTION"));

        back.setOnClickListener(v -> finish());
    }
}