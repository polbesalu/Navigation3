package cat.institutmontilivi.navigation3.ui.Pantalles

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kotlin.random.Random


@Composable
fun PantallaPrincipal(onCotxesClick: (String) -> Unit, onLlistaDeGuerrersClick: (String) -> Unit, onLlistaDeGossosClick: (String) -> Unit) {
    Column (
        modifier = Modifier
            .fillMaxSize()
    ){
        Box(Modifier.fillMaxWidth().weight(1F))
        {
            Button(modifier = Modifier.align(Alignment.Center),
                onClick = {
                    onCotxesClick("Llista de cotxes")
                }){
                Text(text = "Llista de Cotxes", fontSize = 35.sp)
            }
        }
        Box(Modifier.fillMaxWidth().weight(1F))
        {
            Button(modifier = Modifier.align(Alignment.Center),
                onClick = {
                    onLlistaDeGuerrersClick("Llista de Guerrers")
                }){
                Text(text = "Llista de guerrers", fontSize = 35.sp)
            }
        }
        Box(Modifier.fillMaxWidth().weight(1F))
        {
            Button(modifier = Modifier.align(Alignment.Center),
                onClick = {
                    onLlistaDeGossosClick("Llista de Gossos")
                }){
                Text(text = "Llista de Gossos", fontSize = 35.sp)
            }
        }
    }
}