package com.lauratoro.adivinaelnum

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    //Aqui dentro van variables
    companion object {
        val number = Random.nextInt(1,100)
        var contador = 0

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


        findViewById<Button>(R.id.adivina).setOnClickListener {

            // se obtiene texto del EditText
            val guessText = findViewById<EditText>( R.id.guessText).text.toString()
            val guess = guessText.toIntOrNull() //esta linea identifica que guess es un INT
            val contadorUpdate = findViewById<TextView>(R.id.contadorIntentos)

            if (guess != null){
                    contador += 1
                    contadorUpdate.text = contador.toString()

                    val guess = guessText.toInt()
                    Log.d("MI_TAG_DEBUG", "Número secreto: $number")
                    Log.d("MI_TAG_DEBUG", "Número ingresado: $guess")

                    // ayuda pistas usuario
                    if (number > guess){
                        Toast.makeText(this,"El número secreto es mayor", Toast.LENGTH_SHORT).show()
                    } else if (number < guess){
                        Toast.makeText(this,"EL número secreto es menor", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this,"¡Acertaste!", Toast.LENGTH_SHORT).show()

                    }
            } else {
                Toast.makeText(this, "Solo números", Toast.LENGTH_SHORT).show()
            }

        }
    }
}

/* FALTA
*  Si se adivina el numero dar mensaje de puntaje segun intentos
*
* */


