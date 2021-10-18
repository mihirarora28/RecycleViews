package com.example.recycleviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var list = arrayOf(
        city("In", "India", "New Delhi", R.drawable.india),
        city("Ag", "Afganistan", "Dhaka", R.drawable.afganistan),
        city("Pak", "Pakistan", "Lahore", R.drawable.pakistan),
        city("Po", "Portugal", "LaaLLa", R.drawable.portugal)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var r1 = findViewById<RecyclerView>(R.id.ry1);

        r1.layoutManager = LinearLayoutManager(this);

        var cc = CityAdapter{
            Toast.makeText(this@MainActivity, "${it.Country}" , Toast.LENGTH_SHORT ).show();
        };

        r1.adapter = cc;

        r1.setHasFixedSize(true);

        val btn1 = findViewById<Button>(R.id.btn1);
        btn1.setOnClickListener {
            cc.list = list;
            r1.adapter = cc;
        }
    }
}