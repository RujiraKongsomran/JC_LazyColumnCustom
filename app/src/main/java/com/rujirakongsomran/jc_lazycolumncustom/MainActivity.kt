package com.rujirakongsomran.jc_lazycolumncustom

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

        LazyColumn(
            contentPadding = PaddingValues(all = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(items = getAllData) { index, person ->
                Log.d("MainActivity", index.toString())
                CustomProfile(person = person)
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