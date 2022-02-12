package com.example.newcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var operator: String? = null
    var firstNum: Int? = null
    var typeNum: Int? = null

    private lateinit var tvView: TextView

    private lateinit var btnZero: Button
    private lateinit var btnOne: Button
    private lateinit var btnTwo: Button
    private lateinit var btnThree: Button
    private lateinit var btnFour: Button
    private lateinit var btnFive: Button
    private lateinit var btnSix: Button
    private lateinit var btnSeven: Button
    private lateinit var btnEight: Button
    private lateinit var btnNine: Button

    private lateinit var btnMultiply: Button
    private lateinit var btnAddition: Button
    private lateinit var btnSubtract: Button
    private lateinit var btnDivide: Button
    private lateinit var btnEqual: Button
    private lateinit var btnClear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnZero = findViewById(R.id.btnZero)
        btnOne = findViewById(R.id.btnOne)
        btnTwo = findViewById(R.id.btnTwo)
        btnThree = findViewById(R.id.btnThree)
        btnFour = findViewById(R.id.btnFour)
        btnFive = findViewById(R.id.btnFive)
        btnSix = findViewById(R.id.btnSix)
        btnSeven = findViewById(R.id.btnSeven)
        btnEight = findViewById(R.id.btnEight)
        btnNine = findViewById(R.id.btnNine)

        tvView = findViewById(R.id.tvView)

        btnAddition = findViewById(R.id.btnAddition)
        btnSubtract = findViewById(R.id.btnSubtract)
        btnDivide = findViewById(R.id.btnDivide)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnEqual = findViewById(R.id.btnEqual)
        btnClear = findViewById(R.id.btnClear)

        btnClicked()

        btnEqual.setOnClickListener { equal() }
        btnClear.setOnClickListener {
            operator = null
            tvView.text = ""
            firstNum = null
            typeNum = null
        }

        btnAddition.setOnClickListener {
            typeNum=0
            signs()}

        btnMultiply.setOnClickListener {
            typeNum = 1
            signs() }

        btnSubtract.setOnClickListener {
            signs()
            typeNum = 2}
        btnDivide.setOnClickListener {
            typeNum = 3
            signs()}


    }

    private fun equal() {
        var equalNum: Int? = null
        var secondNum: Int? = null
        if(operator == null)
            return
        if (tvView.text.isNotEmpty())
            secondNum = tvView.text.toString().toInt()
        when(operator) {
            "Addition" -> equalNum = firstNum!! + secondNum!!
            "Subtraction" -> equalNum = firstNum!! - secondNum!!
            "Multiplication" -> equalNum = firstNum!! * secondNum!!
            "Division" -> equalNum = firstNum!! / secondNum!!
        }
        operator = null
        tvView.text = "$equalNum"
    }

    private fun signs() {
        if (tvView.text.isEmpty())
            return
        when (typeNum) {
            0 -> operator = "Addition"
            1 ->operator = "Multiplication"
            2 -> operator = "Subtraction"
            3 -> operator = "Division"
    }
        firstNum = tvView.text.toString().toInt()
        tvView.text = ""
    }

    private fun btnClicked(){
        btnZero.setOnClickListener { tvView.append("0") }
        btnOne.setOnClickListener { tvView.append("1") }
        btnTwo.setOnClickListener { tvView.append("2") }
        btnThree.setOnClickListener { tvView.append("3") }
        btnFour.setOnClickListener { tvView.append("4") }
        btnFive.setOnClickListener { tvView.append("5") }
        btnSix.setOnClickListener { tvView.append("6") }
        btnSeven.setOnClickListener { tvView.append("7") }
        btnEight.setOnClickListener { tvView.append("8") }
        btnNine.setOnClickListener { tvView.append("9") }
    }
}