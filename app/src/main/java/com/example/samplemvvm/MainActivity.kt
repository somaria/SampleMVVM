package com.example.samplemvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samplemvvm.ui.theme.SampleMVVMTheme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class CounterViewModel : ViewModel() {
    var count = mutableStateOf(0)
        private set

    fun increment() {
        count.value++
        println("incrementing count: ${count.value}")
    }

    fun decrement() {
        if (count.value > 0) {
            count.value--
        }
    }
}



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleMVVMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterScreen()
                }
            }
        }
    }
}
@Composable
fun CounterScreen() {
    // Create a reference to the ViewModel
    val viewModel: CounterViewModel = viewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Counter: ${viewModel.count.value}",
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                viewModel.increment()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "Increment")
        }
        Button(
            onClick = {
                viewModel.decrement()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "Decrement")
        }
    }
}





