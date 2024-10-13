package com.shahriar.bmijetcalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class BmiViewModel {
    // LiveData for weight and height inputs
    var weight by mutableStateOf("")
    var height by mutableStateOf("")

    // LiveData for the calculated BMI and its category
    var bmiResult by mutableStateOf(0f)
    var bmiCategory by mutableStateOf("")

    // Function to calculate BMI
    fun calculateBMI() {
        val weightValue = weight.toFloatOrNull() ?: 0f
        val heightValue = height.toFloatOrNull() ?: 0f

        if (weightValue > 0 && heightValue > 0) {
            bmiResult = BMICalculator.calculateBMI(weightValue, heightValue)
            bmiCategory = BMICalculator.getBMICategory(bmiResult)
        } else {
            bmiResult = 0f
            bmiCategory = "Invalid input"
        }
    }
}