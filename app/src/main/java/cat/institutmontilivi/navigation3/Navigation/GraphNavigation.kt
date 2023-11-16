package cat.institutmontilivi.navigation3.Navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cat.institutmontilivi.navigation3.Dades.Cotxe
import cat.institutmontilivi.navigation3.Dades.Guerrer
import cat.institutmontilivi.navigation3.ui.Pantalles.PantallaContingutCotxe
import cat.institutmontilivi.navigation3.ui.Pantalles.PantallaContingutGos
import cat.institutmontilivi.navigation3.ui.Pantalles.PantallaContingutGuerrer
import cat.institutmontilivi.navigation3.ui.Pantalles.PantallaLlistaDeCotxes
import cat.institutmontilivi.navigation3.ui.Pantalles.PantallaLlistaDeGossos
import cat.institutmontilivi.navigation3.ui.Pantalles.PantallaLlistaDeGuerrers
import cat.institutmontilivi.navigation3.ui.Pantalles.PantallaPrincipal

@Composable
fun GraphNAvigation()
{
    val controladorDeNAvegacio = rememberNavController()
    NavHost(navController = controladorDeNAvegacio,
        startDestination = Destinacio.Principal.rutaGenerica)
    {
        composable(
            route = Destinacio.Principal.rutaGenerica
        )
        {
            PantallaPrincipal(
                onCotxesClick = {titol:String -> controladorDeNAvegacio.navigate(Destinacio.LlistaDeCotxes.creaRutaEspecifica(titol))},
                onLlistaDeGuerrersClick = {titol:String -> controladorDeNAvegacio.navigate(Destinacio.LlistaDeGuerrers.creaRutaEspecifica(titol))},
                onLlistaDeGossosClick =  {titol:String -> controladorDeNAvegacio.navigate(Destinacio.LlistaDeGossos.creaRutaEspecifica(titol))}
            )
        }
        composable(
            route = Destinacio.LlistaDeCotxes.rutaGenerica,
            arguments = Destinacio.LlistaDeCotxes.navArgs
        )
        {
            val titol = it.arguments?.getString(ArgumentDeNavegacio.Cotxes.clau)
            requireNotNull(titol)
            PantallaLlistaDeCotxes(titol, onContingutClick = {id:Int -> controladorDeNAvegacio.navigate(Destinacio.ContingutCotxe.creaRutaEspecifica(id))})
        }
        composable(
            route = Destinacio.LlistaDeGuerrers.rutaGenerica,
            arguments = Destinacio.LlistaDeGuerrers.navArgs
        )
        {
            val titol = it.arguments?.getString(ArgumentDeNavegacio.Titol.clau)
            requireNotNull(titol)
            PantallaLlistaDeGuerrers(titol, onContingutClick = {id:Int -> controladorDeNAvegacio.navigate(Destinacio.ContingutGuerrer.creaRutaEspecifica(id))})
        }
        composable(
            route = Destinacio.LlistaDeGossos.rutaGenerica,
            arguments = Destinacio.LlistaDeGossos.navArgs
        )
        {
            val titol = it.arguments?.getString(ArgumentDeNavegacio.Gossos.clau)
            requireNotNull(titol)
            PantallaLlistaDeGossos(titol, onContingutClick = {id:Int -> controladorDeNAvegacio.navigate(Destinacio.ContingutGos.creaRutaEspecifica(id))})
        }
        composable(
            route = Destinacio.ContingutGos.rutaGenerica,
            arguments = Destinacio.ContingutGos.navArgs
        )
        {
            val gos = it.arguments?.getString(ArgumentDeNavegacio.GossosContent.clau)
            requireNotNull(gos)
            PantallaContingutGos(id = gos.toInt())
        }
        composable(
            route = Destinacio.ContingutCotxe.rutaGenerica,
            arguments = Destinacio.ContingutCotxe.navArgs
        )
        {
            val cotxe = it.arguments?.getString(ArgumentDeNavegacio.CotxeContent.clau)
            requireNotNull(cotxe)
            PantallaContingutCotxe(id = cotxe.toInt())
        }
        composable(
            route = Destinacio.ContingutGuerrer.rutaGenerica,
            arguments = Destinacio.ContingutGuerrer.navArgs
        )
        {
            val guerrer = it.arguments?.getString(ArgumentDeNavegacio.GuerrerContent.clau)
            requireNotNull(guerrer)
            PantallaContingutGuerrer(id = guerrer.toInt())
        }
    }
}




