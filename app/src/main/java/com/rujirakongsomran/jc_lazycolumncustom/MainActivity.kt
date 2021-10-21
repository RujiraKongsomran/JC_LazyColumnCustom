package com.rujirakongsomran.jc_lazycolumncustom

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rujirakongsomran.jc_lazycolumncustom.repository.PersonRepository
import com.rujirakongsomran.jc_lazycolumncustom.ui.theme.JC_LazyColumnCustomTheme

class MainActivity : ComponentActivity() {


    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JC_LazyColumnCustomTheme {
                val sections = listOf("A", "B", "C", "D", "E")
                LazyColumn(
                    contentPadding = PaddingValues(all = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    sections.forEach { section ->
                        stickyHeader {
                            Text(
                                text = "Section $section",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(MaterialTheme.colors.secondary)
                                    .padding(12.dp)
                            )
                        }
                        items(10) {
                            Text(
                                text = "Item $it from the section $section",
                                modifier = Modifier.padding(12.dp)
                            )
                        }
                    }
                }
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