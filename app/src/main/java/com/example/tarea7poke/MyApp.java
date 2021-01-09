package com.example.tarea7poke;

import android.app.Application;
import android.os.SystemClock;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //Tiempo de duración del splash
        SystemClock.sleep(3000);
    }
}
