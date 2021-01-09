package com.example.tarea7poke;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.tarea7poke.models.Pokemon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokedexActivity extends AppCompatActivity {

    private ListView lvPokemon;
    private Spinner spTipo;
    private Spinner spOrden;
    private Toolbar toolbar;

    static String ordenString;
    static String tipoString;

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);

        lvPokemon = findViewById(R.id.lv_pokemon);
        spTipo = findViewById(R.id.sp_tipo);
        spOrden = findViewById(R.id.sp_orden);

        //Obtener la toolbar
        this.toolbar = findViewById(R.id.toolbar_personalizada);
        setSupportActionBar(this.toolbar);
        //Verificar que la toolbar no sea null para colocarle el titulo
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(R.string.mis_pokemones);
        }

        this.prefs = getSharedPreferences("user_preferences", Context.MODE_PRIVATE);

        //Obtener los filtros y orden de las shared preferences
        ordenString = this.prefs.getString("orden", "Id");
        tipoString = this.prefs.getString("tipo", "Todos");

        cargarSpinnerOrden();
        cargarSpinnerTipos();

        //Al seleccionar un tipo de filtro
        this.spTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                tipoString = parent.getItemAtPosition(position).toString();
                List<Pokemon> pkList = Pokemon.pokemonList();

                //Filtra por tipo los pokemones
                switch (tipoString){
                    case "Normal":
                        filtrarPorNormal(parent, pkList);
                        break;
                    case "Agua":
                        filtrarPorAgua(parent, pkList);
                        break;
                    case "Fuego":
                        filtrarPorFuego(parent, pkList);
                        break;
                    case "Volador":
                        filtrarPorVolador(parent, pkList);
                        break;
                    case "Eléctrico":
                        filtrarPorElectrico(parent, pkList);
                        break;
                    default:
                        filtrarPorTodo(parent, pkList);
                }

                //Los ordena en caso de que se haya cambiado el orden
                switch (ordenString){
                    case "Nombre": ordenarPorNombre(parent, pkList);
                        break;
                    case "Tipo": ordenarPorTipo(parent, pkList);
                        break;
                    default: ordenarPorId(parent, pkList);
                }
                //Se guarda el filtro y orden
                saveOnSharedPreferences(ordenString, tipoString);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Al seleccionar un tipo de orden
        this.spOrden.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ordenString = parent.getItemAtPosition(position).toString();
                List<Pokemon> pkList = Pokemon.pokemonList();

                //Los ordena según la selección
                switch (ordenString){
                    case "Nombre":
                        ordenarPorNombre(parent, pkList);
                        break;
                    case "Tipo":
                        ordenarPorTipo(parent, pkList);
                        break;
                    default:
                        ordenarPorId(parent, pkList);
                }
                //Filtra por si había un filtro seleccionado
                switch (tipoString){
                    case "Normal": filtrarPorNormal(parent, pkList);
                        break;
                    case "Agua": filtrarPorAgua(parent, pkList);
                        break;
                    case "Fuego": filtrarPorFuego(parent, pkList);
                        break;
                    case "Volador": filtrarPorVolador(parent, pkList);
                        break;
                    case "Eléctrico": filtrarPorElectrico(parent, pkList);
                        break;
                    default: filtrarPorTodo(parent, pkList);
                }
                //Guarda el orden y filtro
                saveOnSharedPreferences(ordenString, tipoString);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        List<Pokemon> pkList = Pokemon.pokemonList();

        //Lista los pokemones
        MyAdapter adapter = new MyAdapter(this, pkList, R.layout.list_pokemon);
        this.lvPokemon.setAdapter(adapter);

        //Si se selecciona un elemento de la lista
        this.lvPokemon.setOnItemClickListener((parent, view, position, id) -> {

            //Redirecciona a InfoActivity
            Intent intent = new Intent(parent.getContext(), InfoActivity.class);
            intent.putExtra("id", String.valueOf(id));
            startActivity(intent);
        });

    }

    //Método que carga el spinner de filtro
    private void cargarSpinnerTipos(){
        List<String> tipos = new ArrayList<>();
        tipos.add("Todos");
        tipos.add("Normal");
        tipos.add("Agua");
        tipos.add("Fuego");
        tipos.add("Volador");
        tipos.add("Eléctrico");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, tipos);

        this.spTipo.setAdapter(adapter);

        switch (tipoString){
            case "Todos":
                break;
            case "Normal": spTipo.setSelection(1);
                break;
            case "Agua": spTipo.setSelection(2);
                break;
            case "Fuego": spTipo.setSelection(3);
                break;
            case "Volador": spTipo.setSelection(4);
                break;
            case "Eléctrico": spTipo.setSelection(5);
                break;
        }
    }

    //Método que carga el spinner de ordenamiento
    private void cargarSpinnerOrden(){
        List<String> orden = new ArrayList<>();
        orden.add("Id");
        orden.add("Nombre");
        orden.add("Tipo");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, orden);

        this.spOrden.setAdapter(adapter);

        switch (ordenString) {
            case "Id":
                break;
            case "Nombre":
                spOrden.setSelection(1);
                break;
            case "Tipo":
                spOrden.setSelection(2);
                break;
        }
    }

    //Método del filtro por defecto
    private void filtrarPorTodo(AdapterView<?> parent, List<Pokemon> pkList){

        MyAdapter adapter = new MyAdapter(parent.getContext(), pkList, R.layout.list_pokemon);
        this.lvPokemon.setAdapter(adapter);

    }

    //Método del filtro por tipo Normal
    private void filtrarPorNormal(AdapterView<?> parent, List<Pokemon> pkList){

        //Si el pokemon no es tipo normal lo elimina de la lista
        for(int i=0; i<pkList.size(); i++){
            if (!pkList.get(i).getTipo().equals("Normal")){
                Log.i("eliminado", pkList.get(i).getNombre() + " eliminado de la lista");
                pkList.remove(pkList.get(i));
                i--;
            }
        }

        MyAdapter adapter = new MyAdapter(parent.getContext(), pkList, R.layout.list_pokemon);
        this.lvPokemon.setAdapter(adapter);

    }

    //Método del filtro por tipo Agua
    private void filtrarPorAgua(AdapterView<?> parent, List<Pokemon> pkList){

        //Si el pokemon no es tipo agua lo elimina de la lista
        for(int i=0; i<pkList.size(); i++){
            if (!pkList.get(i).getTipo().equals("Agua")){
                Log.i("eliminado", pkList.get(i).getNombre() + " eliminado de la lista");
                pkList.remove(pkList.get(i));
                i--;
            }
        }

        MyAdapter adapter = new MyAdapter(parent.getContext(), pkList, R.layout.list_pokemon);
        this.lvPokemon.setAdapter(adapter);

    }

    //Método del filtro por tipo Fuego
    private void filtrarPorFuego(AdapterView<?> parent, List<Pokemon> pkList){

        //Si el pokemon no es tipo fuego lo elimina de la lista
        for(int i=0; i<pkList.size(); i++){
            if (!pkList.get(i).getTipo().equals("Fuego")){
                Log.i("eliminado", pkList.get(i).getNombre() + " eliminado de la lista");
                pkList.remove(pkList.get(i));
                i--;
            }
        }

        MyAdapter adapter = new MyAdapter(parent.getContext(), pkList, R.layout.list_pokemon);
        this.lvPokemon.setAdapter(adapter);

    }

    //Método del filtro por tipo volador
    private void filtrarPorVolador(AdapterView<?> parent, List<Pokemon> pkList){

        //Si el pokemon no es tipo volador lo elimina de la lista
        for(int i=0; i<pkList.size(); i++){
            if (!pkList.get(i).getTipo().equals("Volador")){
                Log.i("eliminado", pkList.get(i).getNombre() + " eliminado de la lista");
                pkList.remove(pkList.get(i));
                i--;
            }
        }

        MyAdapter adapter = new MyAdapter(parent.getContext(), pkList, R.layout.list_pokemon);
        this.lvPokemon.setAdapter(adapter);

    }

    //Método del filtro por tipo eléctrico
    private void filtrarPorElectrico(AdapterView<?> parent, List<Pokemon> pkList){

        //Si el pokemon no es tipo eléctrico lo elimina de la lista
        for(int i=0; i<pkList.size(); i++){
            if (!pkList.get(i).getTipo().equals("Eléctrico")){
                Log.i("eliminado", pkList.get(i).getNombre() + " eliminado de la lista");
                pkList.remove(pkList.get(i));
                i--;
            }
        }

        MyAdapter adapter = new MyAdapter(parent.getContext(), pkList, R.layout.list_pokemon);
        this.lvPokemon.setAdapter(adapter);

    }

    //Método de ordenamiento por defecto
    private void ordenarPorId(AdapterView<?> parent, List<Pokemon> pkList){

        MyAdapter adapter = new MyAdapter(parent.getContext(), pkList, R.layout.list_pokemon);
        this.lvPokemon.setAdapter(adapter);

    }

    //Método para ordenar por nombre
    private void ordenarPorNombre(AdapterView<?> parent, List<Pokemon> pkList){

        //Ordena a travéz del método sort
        Collections.sort(pkList, (pk1, pk2) -> pk1.getNombre().compareTo(pk2.getNombre()));
        //  Otra forma de escribirlo
        //    Collections.sort(pkList, new Comparator<Pokemon>() {
        //       public int compare(Pokemon pk1, Pokemon pk2) {
        //          return pk1.getNombre().compareTo(pk2.getNombre());
        //      }
        //    });

        MyAdapter adapter = new MyAdapter(parent.getContext(), pkList, R.layout.list_pokemon);
        this.lvPokemon.setAdapter(adapter);

    }

    //Método para ordenar por tipo
    private void ordenarPorTipo(AdapterView<?> parent, List<Pokemon> pkList){

        //Ordena a travéz del método sort
        Collections.sort(pkList, (pk1, pk2) -> pk1.getTipo().compareTo(pk2.getTipo()));

        MyAdapter adapter = new MyAdapter(parent.getContext(), pkList, R.layout.list_pokemon);
        this.lvPokemon.setAdapter(adapter);

    }

    //Método para guardar las shared preferences
    private void saveOnSharedPreferences(String orden, String tipo){
        SharedPreferences.Editor editor = this.prefs.edit();

        editor.putString("orden", orden);
        editor.putString("tipo", tipo);

        editor.apply();
    }

    //Agregar el boton Salir
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Activar el botón Salir
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //Borrar las shared preferences
        prefs.edit().clear().apply();

        //Vuelve a la pantalla de login
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);

        return super.onOptionsItemSelected(item);
    }
}