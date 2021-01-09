package com.example.tarea7poke;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tarea7poke.models.Pokemon;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private final Context context;
    private final List<Pokemon> pokemons;
    private final int layout;

    public MyAdapter(Context context, List<Pokemon> pokemons, int layout){
        this.context = context;
        this.pokemons = pokemons;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return this.pokemons.size();
    }

    @Override
    public Object getItem(int position) {
        return this.pokemons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.pokemons.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Inflar nuestro layout a ocupar en el adapter
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        convertView = layoutInflater.inflate(this.layout, null);

        //Se obtienen los valores de nombre, id y tipo del pokemon dependiendo de la posición
        String nombrePoke = this.pokemons.get(position).getNombre();
        String idPokemon = String.valueOf(this.pokemons.get(position).getId());
        String tipoPoke = this.pokemons.get(position).getTipo();

        //Se asigna el nombre, id y tipo del pokemon actual a la vista
        TextView tvNombrePk = convertView.findViewById(R.id.tv_nombre_pk);
        tvNombrePk.setText(nombrePoke);
        TextView tvIdPk = convertView.findViewById(R.id.tv_id_pk);
        tvIdPk.setText(idPokemon);
        TextView tvTipoPk = convertView.findViewById(R.id.tv_tipo_pk);
        tvTipoPk.setText(tipoPoke);

        //Se asigna la imagen del pokemon actual a la vista
        ImageView ivPokemon = convertView.findViewById(R.id.iv_pokemon);
        switch (this.pokemons.get(position).getId()){
            case 1: ivPokemon.setImageResource(R.drawable.bulbasaur01);
                break;
            case 2: ivPokemon.setImageResource(R.drawable.ivysaur01);
                break;
            case 3: ivPokemon.setImageResource(R.drawable.venasaur01);
                break;
            case 4: ivPokemon.setImageResource(R.drawable.charmander01);
                break;
            case 5: ivPokemon.setImageResource(R.drawable.charmeleon01);
                break;
            case 6: ivPokemon.setImageResource(R.drawable.charizard01);
                break;
            case 7: ivPokemon.setImageResource(R.drawable.squirtle01);
                break;
            case 8: ivPokemon.setImageResource(R.drawable.wartortle01);
                break;
            case 9: ivPokemon.setImageResource(R.drawable.blastoise01);
                break;
            case 10: ivPokemon.setImageResource(R.drawable.caterpie01);
                break;
            case 11: ivPokemon.setImageResource(R.drawable.metapod01);
                break;
            case 12: ivPokemon.setImageResource(R.drawable.butterfree01);
                break;
            case 13: ivPokemon.setImageResource(R.drawable.weedle01);
                break;
            case 14: ivPokemon.setImageResource(R.drawable.kakuna01);
                break;
            case 15: ivPokemon.setImageResource(R.drawable.beedrill01);
                break;
            case 16: ivPokemon.setImageResource(R.drawable.pidgey01);
                break;
            case 17: ivPokemon.setImageResource(R.drawable.pidgeotto01);
                break;
            case 18: ivPokemon.setImageResource(R.drawable.pidgeot01);
                break;
            case 19: ivPokemon.setImageResource(R.drawable.rattata01);
                break;
            case 20: ivPokemon.setImageResource(R.drawable.raticate01);
                break;
            case 21: ivPokemon.setImageResource(R.drawable.spearow01);
                break;
            case 22: ivPokemon.setImageResource(R.drawable.fearow01);
                break;
            case 23: ivPokemon.setImageResource(R.drawable.ekans01);
                break;
            case 24: ivPokemon.setImageResource(R.drawable.arbok01);
                break;
            case 25: ivPokemon.setImageResource(R.drawable.pikachu01);
                break;
            case 26: ivPokemon.setImageResource(R.drawable.raichu01);
                break;
            case 27: ivPokemon.setImageResource(R.drawable.sandshrew01);
                break;
            case 28: ivPokemon.setImageResource(R.drawable.sandslash01);
                break;
            case 29: ivPokemon.setImageResource(R.drawable.nidoranf01);
                break;
            case 30: ivPokemon.setImageResource(R.drawable.nidorina01);
                break;
        }

        return convertView;
    }
}
