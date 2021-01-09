package com.example.tarea7poke.models;

import java.util.ArrayList;

public class Pokemon {
    private final int id;
    private final String nombre;
    private final String tipo;

    public Pokemon(int i, String tipo, String nombre){
        this.id = i;
        this.tipo = tipo;
        this.nombre = nombre;
    }

    public static ArrayList<Pokemon> pokemonList(){
        return new ArrayList<Pokemon>() {{
            add(new Pokemon(1, "Planta", "Bulbasaur"));
            add(new Pokemon(2, "Planta", "Ivysaur"));
            add(new Pokemon(3, "Planta", "Venasaur"));
            add(new Pokemon(4, "Fuego", "Charmander"));
            add(new Pokemon(5, "Fuego", "Charmeleon"));
            add(new Pokemon(6, "Fuego", "Charizard"));
            add(new Pokemon(7, "Agua", "Squirtle"));
            add(new Pokemon(8, "Agua", "Wartortle"));
            add(new Pokemon(9, "Agua", "Blastoise"));
            add(new Pokemon(10, "Bicho", "Caterpie"));
            add(new Pokemon(11, "Bicho", "Metapod"));
            add(new Pokemon(12, "Bicho", "Butterfree"));
            add(new Pokemon(13, "Bicho", "Weedle"));
            add(new Pokemon(14, "Bicho", "Kakuna"));
            add(new Pokemon(15, "Bicho", "Beedrill"));
            add(new Pokemon(16, "Volador", "Pidgey"));
            add(new Pokemon(17, "Volador", "Pidgeotto"));
            add(new Pokemon(18, "Volador", "Pidgeot"));
            add(new Pokemon(19, "Normal", "Rattata"));
            add(new Pokemon(20, "Normal", "Raticate"));
            add(new Pokemon(21, "Volador","Spearow"));
            add(new Pokemon(22 ,"Volador", "Fearow"));
            add(new Pokemon(23, "Veneno", "Ekans"));
            add(new Pokemon(24, "Veneno", "Arbok"));
            add(new Pokemon(25, "Eléctrico", "Pikachu"));
            add(new Pokemon(26, "Eléctrico", "Raichu"));
            add(new Pokemon(27, "Tierra", "Sandshrew"));
            add(new Pokemon(28, "Tierra", "Sandslash"));
            add(new Pokemon(29,"Veneno", "Nidoran"));
            add(new Pokemon(30, "Veneno", "Nidorina"));
        }};
    }

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getTipo(){
        return this.tipo;
    }
}
