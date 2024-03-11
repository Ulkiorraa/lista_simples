package com.ulkiorra.lista_simples;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class DigimonAdapter extends RecyclerView.Adapter<DigimonAdapter.DigimonViewHolder> {

    private Context context;
    private List<Digimon> digimonList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Digimon digimon);
    }

    public DigimonAdapter(Context context, List<Digimon> digimonList, OnItemClickListener listener) {
        this.context = context;
        this.digimonList = digimonList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DigimonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_digimon, parent, false);
        return new DigimonViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DigimonViewHolder holder, int position) {
        Digimon digimon = digimonList.get(position);
        holder.bind(digimon, listener);
    }

    @Override
    public int getItemCount() {
        return digimonList.size();
    }

    class DigimonViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        DigimonViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }

        void bind(final Digimon digimon, final OnItemClickListener listener) {
            textView.setText(digimon.getName());
            Glide.with(itemView.getContext()).load(digimon.getImageResourceId()).into(imageView);
            itemView.setOnClickListener(v -> listener.onItemClick(digimon));
        }
    }
}