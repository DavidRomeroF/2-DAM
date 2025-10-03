package com.example.ciclodevidaapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CicloVidaActivity extends AppCompatActivity {
    String TAG = "LogPropio";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            Log.i(TAG, "onCreate: Se ha creado");
            return insets;
        });
    }

    public void irSegunda(View view) {
        Intent intent = new Intent(CicloVidaActivity.this, SegundaActividad.class);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause: Se ha pausado");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStop: Se ha parado");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy: Se ha destruido");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart: Se ha empezado");
    }
}

