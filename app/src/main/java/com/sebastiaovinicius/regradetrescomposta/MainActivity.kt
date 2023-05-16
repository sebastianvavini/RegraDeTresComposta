package com.sebastiaovinicius.regradetrescomposta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sebastiaovinicius.regradetrescomposta.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(v: View) {
            if(v.id==R.id.button_calculate){
                if(isValid()){
                    calcular()
                }
            }


    }

    private fun calcular(){
        var n1c1= binding.editTextNumero1Dias.text.toString().toDouble()
        var n1c2= binding.editTextNumero1Paginas.text.toString().toDouble()
        var n1c3= binding.editTextNumero1HorasPorDia.text.toString().toDouble()

        var n2c2=binding.editTextNumero2Paginas.text.toString().toDouble()
        var n2c3=binding.editTextNumero2HorasPorDia.text.toString().toDouble()

        var n2c1= (n1c1*n2c2*n1c3)/(n1c2*n2c3)

        binding.textViewResult.text=" Leva  ${n2c1} dias"
    }

    private fun isValid():Boolean{
        return  binding.editTextNumero1Dias.text.toString()!=""
                && binding.editTextNumero1Paginas.text.toString()!=""
                && binding.editTextNumero1HorasPorDia.text.toString()!=""
                && binding.editTextNumero2Paginas.text.toString()!=""
                && binding.editTextNumero2HorasPorDia.text.toString()!=""

    }
}