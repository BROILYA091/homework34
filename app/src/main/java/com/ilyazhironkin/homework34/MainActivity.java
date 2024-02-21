package com.ilyazhironkin.homework34;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private EditText editTextA, editTextB, editTextC, editTextX1, editTextX2;
    private Button buttonSolve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        editTextC = findViewById(R.id.editTextC);
        editTextX1 = findViewById(R.id.editTextX1);
        editTextX2 = findViewById(R.id.editTextX2);

        buttonSolve = findViewById(R.id.buttonSolve);

        buttonSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = new Random().nextInt(10) + 1; // Генерация случайного коэффициента a от 1 до 10
                int b = new Random().nextInt(10) + 1; // Генерация случайного коэффициента b от 1 до 10
                int c = new Random().nextInt(10) + 1; // Генерация случайного коэффициента c от 1 до 10

                editTextA.setText(String.valueOf(a));
                editTextB.setText(String.valueOf(b));
                editTextC.setText(String.valueOf(c));

                double d = b * b - 4 * a * c;

                if (d < 0) {
                    Toast.makeText(MainActivity.this, "Уравнение не имеет вещественных корней", Toast.LENGTH_SHORT).show();
                    return;
                }


                double x1 = (-b + Math.sqrt(d)) / (2*a);
                double x2 = (-b - Math.sqrt(d)) / (2*a);

                if (x1 == Double.parseDouble(editTextX1.getText().toString()) && x2 == Double.parseDouble(editTextX2.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Правильный ответ!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Неправильный ответ!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}