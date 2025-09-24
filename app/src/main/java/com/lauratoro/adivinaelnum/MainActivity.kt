package com.lauratoro.adivinaelnum

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    companion object {
        var number = Random.nextInt(1,100)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        /*

        contador para los intentos

        aqui va la logica si el numero es > el numero bla bla bla
        * val intent = findViewById<EditText>( R.idEditTextNumber).ToStrint().ToInt()
        *
        * if number > intent se crea el toast
        * elif number < intent se crea el toast
        * elif number == intent CONGRAAAAATS
        *
        *
        *  */
    }
}