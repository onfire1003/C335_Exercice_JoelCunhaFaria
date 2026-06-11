package com.example.welcomecardapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.welcomecardapp.ui.theme.WelcomeCardAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            WelcomeCardAppTheme {
                WelcomeCardApp()
            }
        }
    }
}

@Composable
fun WelcomeCardApp() {
    // la partie variable
    var currentScreen by remember { mutableStateOf("form") }

    var userName by remember { mutableStateOf("") }

    var selectedMood by remember { mutableStateOf("Heureux") }

    var showCard by remember { mutableStateOf(false) }

    val context = LocalContext.current

    when (currentScreen) {

        "form" -> {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                // espace a faire avant pour pas coller le tel
                Spacer(modifier = Modifier.height(4.dp))

                // titre
                Text(
                    text = "Welcome Card App",
                    style = MaterialTheme.typography.headlineMedium
                )


                // espace a faire  il faut responsive apres
                Spacer(modifier = Modifier.height(4.dp))

                // texte d'intro
                Text(
                    text = "Entrez votre prénom, choisissez votre humeur, puis générez une carte personnalisée."
                )

                // espace a faire  il faut responsive apres
                Spacer(modifier = Modifier.height(16.dp))

                // champ vide a remplir
                OutlinedTextField(
                    value = userName,
                    onValueChange = { userName = it },
                    // texte d'échange
                    label = { Text("Votre prénom") },
                    // prendre largeur max
                    modifier = Modifier.fillMaxWidth()
                )

                // espace a faire  il faut responsive apres
                Spacer(modifier = Modifier.height(16.dp))

                // humeur séléctionné
                Text(text = "Humeur :")

                // espace a faire  il faut responsive apres
                Spacer(modifier = Modifier.height(8.dp))

                // Organisé les cards
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // chaque humeur
                    FilterChip(
                        selected = selectedMood == "Heureux",
                        onClick = { selectedMood = "Heureux" },
                        label = { Text("Heureux") }
                    )

                    FilterChip(
                        selected = selectedMood == "Concentré",
                        onClick = { selectedMood = "Concentré" },
                        label = { Text("Concentré") }
                    )

                    FilterChip(
                        selected = selectedMood == "Fatigué",
                        onClick = { selectedMood = "Fatigué" },
                        label = { Text("Fatigué") }
                    )
                }

                // espace a faire  il faut responsive apres
                Spacer(modifier = Modifier.height(16.dp))

                // boutton pour créer la carte
                Button(
                    onClick = {

                        // gestion d'erreur si vide
                        if (userName.isBlank()) {

                            Toast.makeText(
                                context,
                                "Veuillez saisir votre prénom",
                                Toast.LENGTH_SHORT
                            ).show()

                        } else {

                            showCard = true
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Text("Créer la carte")
                }

                Spacer(modifier = Modifier.height(16.dp))

                if (showCard) {

                    WelcomeCard(
                        userName = userName,
                        selectedMood = selectedMood,
                        onOpenDetails = {
                            currentScreen = "details"
                        }
                    )
                }
            }
        }

        "details" -> {

            DetailsScreen(
                userName = userName,
                selectedMood = selectedMood,
                onBack = {
                    currentScreen = "form"
                }
            )
        }
    }
}

@Composable
fun WelcomeCard(
    userName: String,
    selectedMood: String,
    onOpenDetails: () -> Unit
) {

    val moodMessage = when (selectedMood) {

        "Heureux" ->
            "Continue à partager cette énergie positive."

        "Concentré" ->
            "Reste concentré et continue à progresser."

        "Fatigué" ->
            "Prends une courte pause puis reprends calmement."

        else -> "Bienvenue."
    }
// la carte restul
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(text = "Bonjour, $userName !")

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Humeur : $selectedMood")

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = moodMessage)

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onOpenDetails
            ) {

                Text("Ouvrir les détails")
            }
        }
    }
}

@Composable
fun DetailsScreen(
    userName: String,
    selectedMood: String,
    onBack: () -> Unit
) {

    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Text(
            text = "Détails du profil",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(text = "Prénom : $userName")

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "Humeur : $selectedMood")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onBack
        ) {

            Text("Retour")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {

    WelcomeCardAppTheme {
        WelcomeCardApp()
    }
}