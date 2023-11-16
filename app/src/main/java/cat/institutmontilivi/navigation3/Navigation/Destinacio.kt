package cat.institutmontilivi.navigation3.Navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import cat.institutmontilivi.navigation3.Dades.Guerrer

private val Any.Guerrer: NavType<*>
    get() {return Guerrer}

sealed class Destinacio(
    val rutaBase: String,
    val argumentsDeNavegacio: List<ArgumentDeNavegacio> = emptyList()
)
{
    val rutaGenerica = run{
        val claus = argumentsDeNavegacio.map { "{${it.clau}}" }
        listOf(rutaBase)
            .plus(claus)
            .joinToString("/")
    }
    val navArgs = argumentsDeNavegacio.map { it.toNavArgument() }

    object Principal: Destinacio(rutaBase = "Principal")

    object LlistaDeGuerrers: Destinacio(rutaBase = "LlistaDeGuerrers",
        listOf(ArgumentDeNavegacio.Titol)){
        fun creaRutaEspecifica(titol: String) = "$rutaBase/$titol"
    }
    object LlistaDeCotxes: Destinacio(rutaBase = "LlistaDeCotxes",
        listOf(ArgumentDeNavegacio.Cotxes)){
        fun creaRutaEspecifica(titolCotxes: String) = "$rutaBase/$titolCotxes"
    }
    object LlistaDeGossos: Destinacio(rutaBase = "LlistaDeGossos",
        listOf(ArgumentDeNavegacio.Gossos)){
        fun creaRutaEspecifica(titolGossos: String) = "$rutaBase/$titolGossos"
    }
    object ContingutGos: Destinacio(rutaBase = "ContingutGos",
        listOf(ArgumentDeNavegacio.GossosContent))
    {
        fun creaRutaEspecifica(Gos: Int) = "$rutaBase/${Gos.toString()}"
    }
    object ContingutCotxe: Destinacio(rutaBase = "ContingutCotxe",
        listOf(ArgumentDeNavegacio.CotxeContent))
    {
        fun creaRutaEspecifica(Cotxe: Int) = "$rutaBase/${Cotxe.toString()}"
    }
    object ContingutGuerrer: Destinacio(rutaBase = "ContingutGuerrer",
        listOf(ArgumentDeNavegacio.GuerrerContent))
    {
        fun creaRutaEspecifica(Guerrer: Int) = "$rutaBase/${Guerrer.toString()}"
    }
}

enum class ArgumentDeNavegacio (
    val clau: String,
    val tipus: NavType<*>
)
{
    Titol("Titol", NavType.StringType),
    Cotxes("Cotxes", NavType.StringType),
    Gossos("Gossos", NavType.StringType),
    GossosContent("GossosContent", NavType.StringType),
    CotxeContent("CotxeContent", NavType.StringType),
    GuerrerContent("GuerrerContent", NavType.StringType);

    fun toNavArgument () : NamedNavArgument{
        return navArgument(clau){tipus}
    }
}
