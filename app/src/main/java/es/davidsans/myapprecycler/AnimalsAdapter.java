package es.davidsans.myapprecycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import es.davidsans.myapprecycler.models.Animals;

/**
 * Created by android on 15/03/2018.
 */

public class AnimalsAdapter extends RecyclerView.Adapter<AnimalsAdapter.ViewHolder>{

    private final ArrayList<Animals> items;

    public AnimalsAdapter(ArrayList<Animals> animalsList) {
        this.items = animalsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_animals,null);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.img.setImageResource(items.get(position).getImg());
        holder.txtnombre.setText(items.get(position).getNombre());
        holder.textPosition.setText(items.get(position).getUbicacion());
        holder.textBiologico.setText(items.get(position).getNombreBiologico());



    }

    @Override
    public int getItemCount() {
        return items!=null?items.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtnombre;
        TextView textBiologico;
        TextView textPosition;
        ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.item_layout_img);
            txtnombre = (TextView) itemView.findViewById(R.id.item_layout_name);
            textBiologico = (TextView) itemView.findViewById(R.id.item_text_nameBiologico);
            textPosition = (TextView) itemView.findViewById(R.id.item_layout_text_position);




        }
    }
}
