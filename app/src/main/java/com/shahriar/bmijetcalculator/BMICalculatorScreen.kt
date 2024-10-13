package com.shahriar.bmijetcalculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun BMICalculatorScreen(viewModel: BmiViewModel) {
    // Use a Column to arrange UI elements vertically
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Weight Input Field
        OutlinedTextField(
            value = viewModel.weight,
            onValueChange = { viewModel.weight = it },
            label = { Text("Enter weight (kg)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Height Input Field
        OutlinedTextField(
            value = viewModel.height,
            onValueChange = { viewModel.height = it },
            label = { Text("Enter height (m)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Button to Calculate BMI
        Button(
            onClick = { viewModel.calculateBMI() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Calculate BMI")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // BMI Result Text
        Text(
            text = "BMI: ${viewModel.bmiResult}",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        // BMI Category Text
        Text(
            text = "Category: ${viewModel.bmiCategory}",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
