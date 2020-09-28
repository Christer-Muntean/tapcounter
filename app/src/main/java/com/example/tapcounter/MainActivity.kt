package com.example.tapcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var counter = 0
    var currentSelectedButton = "ONE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_one_button.setOnClickListener {
            addNumber("ONE", 1)
        }

        add_five_button.setOnClickListener {
            addNumber("FIVE", 5)
        }

        add_ten_button.setOnClickListener {
            addNumber("TEN", 10)
        }

        subtract_button.setOnClickListener {

            if (counter > 0) {
                if (currentSelectedButton == "ONE") {
                    counter -= 1
                } else if (currentSelectedButton == "FIVE") {
                    counter -= 5
                } else if (currentSelectedButton == "TEN") {
                    counter -= 10
                }
            }

            if(counter < 0){
                counter = 0
            }

            counter_textView.text = counter.toString()
        }
    }

    private fun addNumber(selectedButton: String, incrementDecrementValue: Int){
        currentSelectedButton = selectedButton
        subtract_button.text = "-$incrementDecrementValue"
        counter += incrementDecrementValue
        counter_textView.text = counter.toString()
    }
}