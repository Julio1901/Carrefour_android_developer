package com.calculadora.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        //Eventos de click
        numero_zero.setOnClickListener{ addONeExpression("0", true)}
        numero_um.setOnClickListener{ addONeExpression("1", true)}
        numero_dois.setOnClickListener{ addONeExpression("2", true)}
        numero_tres.setOnClickListener{ addONeExpression("3", true)}
        numero_quatro.setOnClickListener{ addONeExpression("4", true)}
        numero_cinco.setOnClickListener{ addONeExpression("5", true)}
        numero_seis.setOnClickListener{ addONeExpression("6", true)}
        numero_sete.setOnClickListener{ addONeExpression("7", true)}
        numero_oito.setOnClickListener{ addONeExpression("8", true)}
        numero_nove.setOnClickListener{ addONeExpression("9", true)}
        ponto.setOnClickListener { addONeExpression(".", true) }


        //operadores
        adicao.setOnClickListener { addONeExpression("+", false) }
        subtracao.setOnClickListener { addONeExpression("-", false) }
        multiplicacao.setOnClickListener { addONeExpression("*", false) }
        divisao.setOnClickListener { addONeExpression("/", false) }

        limpar.setOnClickListener {
            expressao.text = ""
            view_resultado.text = ""
        }

        backspace.setOnClickListener {
            val string = expressao.text.toString()

            if(string.isNotBlank()){
                //verifica se string não está em branco, caso não esteja, verifica o tamanho
                    //da string e retira um elemento dela na posição zero
                expressao.text = string.substring(0, string.length -1)
            }
            view_resultado.text = ""
        }

        igual.setOnClickListener {

            try{
                val expressao = ExpressionBuilder(expressao.text.toString()).build()

                val resultado = expressao.evaluate()
                val longResult = resultado.toLong()

                if (resultado == longResult.toDouble())
                    view_resultado.text = longResult.toString()
                else
                    view_resultado.text = resultado.toString()

            }catch(e: Exception){

            }

        }

    }

    fun addONeExpression(some_string: String, clear_data: Boolean) {
        //Se o resultado não estiver vazio nós limpamos ele antes de adicionar uma nova expressão
        if(view_resultado.text.isNotEmpty()){
            expressao.text = ""
        }

        if(clear_data){
            view_resultado.text = ""
            //Está vindo do parâmetro da função
            expressao.append(some_string)
        }else{
            expressao.append(view_resultado.text)
            expressao.append(some_string)
            view_resultado.text = ""
        }


    }
}