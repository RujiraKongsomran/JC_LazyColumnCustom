package com.rujirakongsomran.jc_lazycolumncustom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rujirakongsomran.jc_lazycolumncustom.repository.PersonRepository
import com.rujirakongsomran.jc_lazycolumncustom.ui.theme.JC_LazyColumnCustomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JC_LazyColumnCustomTheme {
                MyApp()
            }
        }
    }

    @Composable
    fun MyApp() {
        Surface(color = MaterialTheme.colors.background) {
            DisplayData()
        }
    }

    @Composable
    fun DisplayData() {
        val personRepository = PersonRepository()
        val getAllData = personRepository.getAllData()

        LazyColumn() {
            items(items = getAllData) { person ->
                CustomItem(person = person)
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewScreen() {
        JC_LazyColumnCustomTheme {
            MyApp()
        }
    }
}