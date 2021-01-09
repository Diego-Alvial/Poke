package com.example.tarea7poke;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private ImageView btnIvPokeball;
    private EditText etIdMaestro;
    private EditText etContrasena;
    private CheckBox chbxRecordar;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.prefs = this.getSharedPreferences("user_preferences", Context.MODE_PRIVATE);
        btnIvPokeball = findViewById(R.id.btn_iv_pokeball);
        etIdMaestro = findViewById(R.id.et_id_maestro);
        etContrasena = findViewById(R.id.et_contrasena);
        chbxRecordar = findViewById(R.id.chkbx_recordar);

        //Al hacer click en la pokeball
        this.btnIvPokeball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = etIdMaestro.getText().toString();
                String pass = etContrasena.getText().toString();

                //Validar usuario y contraseña
                if(validarUsuario(user) && validarContrasena(pass)){

                    //Si el checkbox está marcado, guardar el usuario y contraseña
                    if (chbxRecordar.isChecked()){
                        saveOnSharedPreferences(user, pass);
                    }

                    //Enviar a la pokedex
                    Intent intent = new Intent(v.getContext(), PokedexActivity.class);
                    startActivity(intent);

                    //Si el usuario o la contraseña son erroneas
                }else {
                    Toast.makeText(v.getContext(), "Credenciales inválidas, favor reintente", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //Método para validar usuario
    private boolean validarUsuario(String user){

        String[] partes = new String[2];

        //Si el string del usuario es mayor a 4
        if(user.length()>4){

            //Se divide en dos el usuario, la segunda parte los últimos 4 caracteres y el primero el resto
            partes[0] = user.substring(0, user.length()-4);
            partes[1] = user.substring(user.length()-4);

            //Comprobar y retornar si la primera parte es una cadena de texto y de si
            //la segunda parte es una cadena de numeros
            return Pattern.matches("[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+", partes[0]) &&
                    Pattern.matches("\\d+", partes[1]);
        }else {
            return false;
        }
    }

    //Método para validar la contraseña
    private boolean validarContrasena(String pass) {

        //Comprobar que la contraseña cumpla con los requisitos de al menos una letra mayúscula,
        //que contenga al menos un .,-/* y que sea de largo igual o mayor a 8
        String regex = "(?=.*[A-Z])(?=.*[.,-/*]).{8,}";
        return Pattern.matches(regex, pass);
    }

    //Método para guardar las shared preferences de usuario y contraseña
    private void saveOnSharedPreferences(String user, String pass){
        SharedPreferences.Editor editor = this.prefs.edit();

        editor.putString("username", user);
        editor.putString("password", pass);

        editor.apply();
    }
}