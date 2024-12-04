package com.example.mimancala

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import com.example.mimancala.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var mibindingbindingim: ActivityMainBinding
    var array: MutableMap<String, MutableList<Int>> = mutableMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        inicializarComponentes()
    }

    fun inicializarComponentes() {
        mibindingbindingim = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mibindingbindingim.root)
        //array = emptyMap();
        for (i in 1..5) {
            array["hueco$i"] = mutableListOf()
        }

        /*var i = 0
        while (i < array.size - 1) {
            var rand = Random.nextInt(2, 4)
            var j = 0;
            while (j <= rand) {
                array["hueco" + i]!!.add(j)
                j++
            }
            i++
        }*/
        for ((key, value) in array) {
            if (key != "hueco5") {
                val rand = (2..4).random() // Número aleatorio entre 2 y 4
                for (i in 0..(rand - 1)) {
                    value.add(i) // Agregar elementos a la lista
                }
            }
        }
        mostrarCambios()

        mibindingbindingim.hueco1.setOnClickListener {
            var count = array["hueco1"]!!.size
            if (count == 0) {
            } else {
                for (key in array.keys) {
                    if (key == "hueco1") {
                        array[key]!!.clear()
                    } else {
                        if (count != 0) {
                            array[key]!!.add(1)
                            count - 1
                        }
                    }
                }
                mostrarCambios()
            }
        }
    }

    fun mostrarCambios() {
        mibindingbindingim.hueco1.text = array["hueco1"]!!.size.toString()
        mibindingbindingim.hueco2.text = array["hueco2"]!!.size.toString()
        mibindingbindingim.hueco3.text = array["hueco3"]!!.size.toString()
        mibindingbindingim.hueco4.text = array["hueco4"]!!.size.toString()
        mibindingbindingim.hueco5.text = array["hueco5"]!!.size.toString()
    }
}