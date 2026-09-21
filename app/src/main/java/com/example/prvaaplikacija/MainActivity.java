package com.example.prvaaplikacija;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            Toast.makeText(
                    MainActivity.this,
                    "My first Android Studio application!",
                    Toast.LENGTH_SHORT
            ).show();
        });
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(v -> {
            Snackbar snackbar = Snackbar.make(v, "Just another option for button.", Snackbar.LENGTH_LONG);

            View view = snackbar.getView();
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
            params.gravity = Gravity.CENTER;
            view.setLayoutParams(params);

            snackbar.show();
        });
    }
}