package com.example.ballondorapp

import android.graphics.Paint.Align
import android.os.Bundle
import android.text.BoringLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ballondorapp.data.Player
import com.example.ballondorapp.data.players
import com.example.compose.BallonDorAppTheme
import kotlin.math.exp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BallonDorAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    BallonDorApp()
                }
            }
        }
    }
}

@Composable
fun BallonDorApp(){
    Scaffold(
        topBar = {
            BallonDorAppBar()
        }
    ){
        it ->
        LazyColumn(contentPadding = it){
            items(players){
                ListItem(player = it,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)))
            }
        }
    }
}



@Composable
fun ListItem(
    player: Player,
    modifier: Modifier = Modifier
){
    var expanded by remember { mutableStateOf(false) }
    Card(modifier = modifier){
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))
        ) {
            PlayerIcon(player.imageResourceId)
            PlayerInformation(player.name, player.nationality)
            Spacer(modifier = Modifier.weight(1f)) // to do space and align element
            PlayerItemButton(
                expanded = expanded,
                onClick = {}
            )
        }
    }
}

@Composable
private fun PlayerItemButton(
    expanded: Boolean,
    onClick: () -> Unit, // unit like void in java
    modifier: Modifier = Modifier
){
    IconButton(
        onClick = onClick,
        modifier = modifier
    ){
        Icon(
            imageVector = Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun PlayerIcon(
    @DrawableRes playerIcon: Int,
    modifier: Modifier = Modifier
){
   Image(
       modifier = modifier
           .size(dimensionResource(R.dimen.image_size))
           .padding(dimensionResource(R.dimen.padding_small))
           .clip(MaterialTheme.shapes.small),
       contentScale = ContentScale.Crop,
       painter = painterResource(playerIcon),
       contentDescription = null
   )

}

@Composable
fun PlayerInformation(
    @StringRes playerName: Int,
    playerNationality: String,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier){
        Text(
            text = stringResource(playerName),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = stringResource(R.string.nationality ,playerNationality),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BallonDorAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.logo_size))
                        .padding(dimensionResource(id = R.dimen.padding_small)),
                    painter = painterResource(R.drawable.ballon_dor_logo),
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun BallonDorPreview() {
    BallonDorAppTheme(darkTheme = false) {
        Surface(modifier = Modifier.fillMaxSize()) {
            BallonDorApp()
        }
    }
}

//@Preview(showBackground = true,
//    showSystemUi = true)
@Composable
fun BallonDorDarkThemPreview() {
    BallonDorAppTheme(darkTheme = true) {
        Surface(modifier = Modifier.fillMaxSize()) {
            BallonDorApp()
        }
    }
}

