package com.example.tarea7poke;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tarea7poke.models.Pokemon;

import java.util.List;

public class InfoActivity extends AppCompatActivity {

    private ImageView ivPoke00;
    private ImageView ivPoke01;
    private ImageView ivPoke02;
    private ImageView ivPoke03;
    private TextView tvIdPokemon;
    private TextView tvNombrePokemon;
    private TextView tvTipoPokemon;
    private Button btnAnterior;
    private Button btnSiguiente;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ivPoke00 = findViewById(R.id.iv_Poke_00);
        ivPoke01 = findViewById(R.id.iv_Poke_01);
        ivPoke02 = findViewById(R.id.iv_Poke_02);
        ivPoke03 = findViewById(R.id.iv_Poke_03);
        tvIdPokemon = findViewById(R.id.tv_Id_Pokemon);
        tvNombrePokemon = findViewById(R.id.tv_Nombre_Pokemon);
        tvTipoPokemon = findViewById(R.id.tv_Tipo_Pokemon);
        btnAnterior = findViewById(R.id.btn_Anterior);
        btnSiguiente = findViewById(R.id.btn_Siguiente);

        //Obtengo el id del pokemon de la lista
        Intent intent = getIntent();
        int id = Integer.parseInt(intent.getStringExtra("id"));

        //Se crea la lista de pokemon y dependiendo del id se cambia el texto
        List<Pokemon> pokemonList = Pokemon.pokemonList();
        tvIdPokemon.setText(String.valueOf(id));
        tvNombrePokemon.setText(pokemonList.get(id-1).getNombre());
        tvTipoPokemon.setText(pokemonList.get(id-1).getTipo());

        //Dependiendo del id se cambian las imágenes
        switch (id){
            case 1: ivPoke00.setImageResource(R.drawable.bulbasaur01);
                ivPoke01.setImageResource(R.drawable.bulbasaur03);
                ivPoke02.setImageResource(R.drawable.bulbasaur02);
                ivPoke03.setImageResource(R.drawable.bulbasaur01);
                break;
            case 2: ivPoke00.setImageResource(R.drawable.ivysaur01);
                ivPoke01.setImageResource(R.drawable.ivysaur03);
                ivPoke02.setImageResource(R.drawable.ivysaur02);
                ivPoke03.setImageResource(R.drawable.ivysaur01);
                break;
            case 3: ivPoke00.setImageResource(R.drawable.venasaur01);
                ivPoke01.setImageResource(R.drawable.venasaur03);
                ivPoke02.setImageResource(R.drawable.venasaur02);
                ivPoke03.setImageResource(R.drawable.venasaur01);
                break;
            case 4: ivPoke00.setImageResource(R.drawable.charmander01);
                ivPoke01.setImageResource(R.drawable.charmander02);
                ivPoke02.setImageResource(R.drawable.charmander03);
                ivPoke03.setImageResource(R.drawable.charmander01);
                break;
            case 5: ivPoke00.setImageResource(R.drawable.charmeleon01);
                ivPoke01.setImageResource(R.drawable.charmeleon03);
                ivPoke02.setImageResource(R.drawable.charmeleon02);
                ivPoke03.setImageResource(R.drawable.charmeleon01);
                break;
            case 6: ivPoke00.setImageResource(R.drawable.charizard01);
                ivPoke01.setImageResource(R.drawable.charizard03);
                ivPoke02.setImageResource(R.drawable.charizard02);
                ivPoke03.setImageResource(R.drawable.charizard01);
                break;
            case 7: ivPoke00.setImageResource(R.drawable.squirtle01);
                ivPoke01.setImageResource(R.drawable.squirtle03);
                ivPoke02.setImageResource(R.drawable.squirtle02);
                ivPoke03.setImageResource(R.drawable.squirtle01);
                break;
            case 8: ivPoke00.setImageResource(R.drawable.wartortle01);
                ivPoke01.setImageResource(R.drawable.wartortle03);
                ivPoke02.setImageResource(R.drawable.wartortle02);
                ivPoke03.setImageResource(R.drawable.wartortle01);
                break;
            case 9: ivPoke00.setImageResource(R.drawable.blastoise01);
                ivPoke01.setImageResource(R.drawable.blastoise03);
                ivPoke02.setImageResource(R.drawable.blastoise02);
                ivPoke03.setImageResource(R.drawable.blastoise01);
                break;
            case 10: ivPoke00.setImageResource(R.drawable.caterpie01);
                ivPoke01.setImageResource(R.drawable.caterpie03);
                ivPoke02.setImageResource(R.drawable.caterpie02);
                ivPoke03.setImageResource(R.drawable.caterpie01);
                break;
            case 11: ivPoke00.setImageResource(R.drawable.metapod01);
                ivPoke01.setImageResource(R.drawable.metapod3);
                ivPoke02.setImageResource(R.drawable.metapod02);
                ivPoke03.setImageResource(R.drawable.metapod01);
                break;
            case 12: ivPoke00.setImageResource(R.drawable.butterfree01);
                ivPoke01.setImageResource(R.drawable.butterfree03);
                ivPoke02.setImageResource(R.drawable.butterfree02);
                ivPoke03.setImageResource(R.drawable.butterfree01);
                break;
            case 13: ivPoke00.setImageResource(R.drawable.weedle01);
                ivPoke01.setImageResource(R.drawable.weedle03);
                ivPoke02.setImageResource(R.drawable.weedle02);
                ivPoke03.setImageResource(R.drawable.weedle01);
                break;
            case 14: ivPoke00.setImageResource(R.drawable.kakuna01);
                ivPoke01.setImageResource(R.drawable.kakuna03);
                ivPoke02.setImageResource(R.drawable.kakuna02);
                ivPoke03.setImageResource(R.drawable.kakuna01);
                break;
            case 15: ivPoke00.setImageResource(R.drawable.beedrill01);
                ivPoke01.setImageResource(R.drawable.beedrill03);
                ivPoke02.setImageResource(R.drawable.beedrill02);
                ivPoke03.setImageResource(R.drawable.beedrill01);
                break;
            case 16: ivPoke00.setImageResource(R.drawable.pidgey01);
                ivPoke01.setImageResource(R.drawable.pidgey03);
                ivPoke02.setImageResource(R.drawable.pidgey02);
                ivPoke03.setImageResource(R.drawable.pidgey01);
                break;
            case 17: ivPoke00.setImageResource(R.drawable.pidgeotto01);
                ivPoke01.setImageResource(R.drawable.pidgeotto03);
                ivPoke02.setImageResource(R.drawable.pidgeotto02);
                ivPoke03.setImageResource(R.drawable.pidgeotto01);
                break;
            case 18: ivPoke00.setImageResource(R.drawable.pidgeot01);
                ivPoke01.setImageResource(R.drawable.pidgeot03);
                ivPoke02.setImageResource(R.drawable.pidgeot02);
                ivPoke03.setImageResource(R.drawable.pidgeot01);
                break;
            case 19: ivPoke00.setImageResource(R.drawable.rattata01);
                ivPoke01.setImageResource(R.drawable.rattata03);
                ivPoke02.setImageResource(R.drawable.rattata02);
                ivPoke03.setImageResource(R.drawable.rattata01);
                break;
            case 20: ivPoke00.setImageResource(R.drawable.raticate01);
                ivPoke01.setImageResource(R.drawable.raticate03);
                ivPoke02.setImageResource(R.drawable.raticate02);
                ivPoke03.setImageResource(R.drawable.raticate01);
                break;
            case 21: ivPoke00.setImageResource(R.drawable.spearow01);
                ivPoke01.setImageResource(R.drawable.spearrow03);
                ivPoke02.setImageResource(R.drawable.spearrow02);
                ivPoke03.setImageResource(R.drawable.spearow01);
                break;
            case 22: ivPoke00.setImageResource(R.drawable.fearow01);
                ivPoke01.setImageResource(R.drawable.fearrow03);
                ivPoke02.setImageResource(R.drawable.fearrow02);
                ivPoke03.setImageResource(R.drawable.fearow01);
                break;
            case 23: ivPoke00.setImageResource(R.drawable.ekans01);
                ivPoke01.setImageResource(R.drawable.ekans03);
                ivPoke02.setImageResource(R.drawable.ekans02);
                ivPoke03.setImageResource(R.drawable.ekans01);
                break;
            case 24: ivPoke00.setImageResource(R.drawable.arbok01);
                ivPoke01.setImageResource(R.drawable.arbok03);
                ivPoke02.setImageResource(R.drawable.arbok02);
                ivPoke03.setImageResource(R.drawable.arbok01);
                break;
            case 25: ivPoke00.setImageResource(R.drawable.pikachu01);
                ivPoke01.setImageResource(R.drawable.pikachu03);
                ivPoke02.setImageResource(R.drawable.pikachu02);
                ivPoke03.setImageResource(R.drawable.pikachu01);
                break;
            case 26: ivPoke00.setImageResource(R.drawable.raichu01);
                ivPoke01.setImageResource(R.drawable.raichu03);
                ivPoke02.setImageResource(R.drawable.raichu02);
                ivPoke03.setImageResource(R.drawable.raichu01);
                break;
            case 27: ivPoke00.setImageResource(R.drawable.sandshrew01);
                ivPoke01.setImageResource(R.drawable.sandshrew03);
                ivPoke02.setImageResource(R.drawable.sandshrew02);
                ivPoke03.setImageResource(R.drawable.sandshrew01);
                break;
            case 28: ivPoke00.setImageResource(R.drawable.sandslash01);
                ivPoke01.setImageResource(R.drawable.sandslash03);
                ivPoke02.setImageResource(R.drawable.sandslash02);
                ivPoke03.setImageResource(R.drawable.sandslash01);
                break;
            case 29: ivPoke00.setImageResource(R.drawable.nidoranf01);
                ivPoke01.setImageResource(R.drawable.nidoranf03);
                ivPoke02.setImageResource(R.drawable.nidoranf02);
                ivPoke03.setImageResource(R.drawable.nidoranf01);
                break;
            case 30: ivPoke00.setImageResource(R.drawable.nidorina01);
                ivPoke01.setImageResource(R.drawable.nidorina03);
                ivPoke02.setImageResource(R.drawable.nidorina02);
                ivPoke03.setImageResource(R.drawable.nidorina01);
                break;
        }

        //El botón anterior lleva al pokemon con un id anterior si la id no es 1
        this.btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id>1){
                    Intent intent = new Intent(v.getContext(), InfoActivity.class);
                    intent.putExtra("id", String.valueOf(id-1));
                    startActivity(intent);
                }
            }
        });

        //El botón siguiente lleva al pokemon con un id más si la id no es 30
        this.btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id<30){
                    Intent intent = new Intent(v.getContext(), InfoActivity.class);
                    intent.putExtra("id", String.valueOf(id+1));
                    startActivity(intent);
                }
            }
        });


        //Obtener la toolbar
        this.toolbar = findViewById(R.id.toolbar_personalizada);
        setSupportActionBar(this.toolbar);
        //Verificar que la toolbar no sea null para colocarle el titulo
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(pokemonList.get(id-1).getNombre());
        }
        //Obtener el boton para volver
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Activar el boton para volver
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),PokedexActivity.class));
            }
        });
    }
}