package com.example.artspace2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.artspace2.ui.theme.ArtSpace2Theme
import com.example.artspace2.ui.theme.Typography

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            val sangrahaList = mutableListOf<ContributionForm>()
            val actorsList = mutableListOf<Actor>()
            val actorCategoryID = ActorCategoryID()

            updateKannadaActorsData(sangrahaList = sangrahaList, actorsList = actorsList, actorCategoryID = actorCategoryID)
            ArtSpace2Theme {
                WithTheme(sangrahaList = sangrahaList, actorsList = actorsList, actorCategoryID = actorCategoryID)
            }
        }
    }
}

@Composable
fun WithTheme(sangrahaList: MutableList<ContributionForm>, actorsList: MutableList<Actor>, actorCategoryID: ActorCategoryID) {
    MaterialTheme (
        colorScheme = darkColorScheme(
            primary = Color.Black,
            onPrimary = Color.White,
            secondary = Color.Yellow,
            onSecondary = Color.Red,
            background = Color.Black,
            onBackground = Color.White,
            surface = Color.Black,
            onSurface = Color.White
        ),
    ) {
        Scaffold(
            topBar = {TopAppBarDecoration(modifier = Modifier)},
            modifier = Modifier
                .fillMaxSize()
        ) { innerPadding ->
            ArtSpace2App(
                sangrahaList = sangrahaList,
                actorsList = actorsList,
                actorCategoryID = actorCategoryID,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarDecoration(
    modifier: Modifier = Modifier
) {
    Column{
        TopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.theTitle),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.ExtraBold
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.Yellow,
                titleContentColor = Color.Red,
            ),
            modifier = Modifier
        )  // TopAppBar
        Canvas(
            modifier = Modifier
                .fillMaxWidth(),
            contentDescription = null.toString(),
        ) {
            drawLine(
                color = Color.Red,
                start = Offset(0f, 0f),
                end = Offset(size.width, 0f),
                strokeWidth = 12f
            )  // Line
        }  // Canvas
    }  // Column
}  // TopBar

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    val sangrahaList = mutableListOf<ContributionForm>()
//    val actorsList = mutableListOf<Actor>()
//    val actorCategoryID = ActorCategoryID()
//
//    updateKannadaActorsData(sangrahaList = sangrahaList, actorsList = actorsList, actorCategoryID = actorCategoryID)
//    WithTheme(sangrahaList = sangrahaList, actorsList = actorsList, actorCategoryID = actorCategoryID)
//}

class MyStateVariables(
    private var currentActorInFullList: Int = 0,
    private var maxAlbums: Int = 0,
    private var currentAlbum: Int = 0,
    private var maxActorsInCurrentAlbum: Int = 0,
    private var currentActorInCurrentAlbum: Int = 0
) {
    fun setCurrentActorInFullList(value: Int) { currentActorInFullList = value }
    fun setMaxAlbums(value: Int) { maxAlbums = value }
    fun setCurrentAlbum(value: Int) { currentAlbum = value }
    fun setMaxActorsInCurrentAlbum(value: Int) { maxActorsInCurrentAlbum = value }
    fun setCurrentActorInCurrentAlbum(value: Int) { currentActorInCurrentAlbum = value }

    fun getCurrentActorInFullList(): Int { return currentActorInFullList }
    fun getMaxAlbums(): Int { return maxAlbums }
    fun getCurrentAlbum(): Int { return currentAlbum }
    fun getMaxActorsInCurrentAlbum(): Int { return maxActorsInCurrentAlbum }
    fun getCurrentActorInCurrentAlbum(): Int { return currentActorInCurrentAlbum }
}

@Composable
fun ArtSpace2App(
    sangrahaList: MutableList<ContributionForm>,
    actorsList: MutableList<Actor>,
    actorCategoryID: ActorCategoryID,
    modifier: Modifier = Modifier
) {
    var myStateVariables by remember {
        mutableStateOf(
            MyStateVariables(
                currentActorInFullList = 0,
                maxAlbums = sangrahaList.size,
                currentAlbum = 0,
                maxActorsInCurrentAlbum = 0,
                currentActorInCurrentAlbum = 0)
        )
    }

    var albumChange by remember { mutableStateOf(false) }
    var actorChange by remember { mutableStateOf(false) }

    myStateVariables.setMaxActorsInCurrentAlbum(actorCategoryID.theIDs.get(myStateVariables.getCurrentAlbum()).size)

    Surface(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(2.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Section1(
                actorChange = actorChange,
                actorsList = actorsList,
                myStateVariables = myStateVariables,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize()
                    .weight(40f)
            )
            Section2(
                actorChange = actorChange,
                actorsList = actorsList,
                myStateVariables = myStateVariables,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize()
                    .weight(35f)
            )
            Section3(
                albumChange = albumChange,
                sangrahaList = sangrahaList,
                myStateVariables = myStateVariables,
                currentAlbumInc = {
                    albumChange = !albumChange
                    myStateVariables.setCurrentAlbum(
                        when(myStateVariables.getCurrentAlbum()) {
                            myStateVariables.getMaxAlbums() - 1 -> 0
                            else -> myStateVariables.getCurrentAlbum() + 1
                        }
                    )
                    myStateVariables.setCurrentActorInCurrentAlbum(0)
                    myStateVariables.setCurrentActorInFullList(actorCategoryID.theIDs.get(myStateVariables.getCurrentAlbum()).get(myStateVariables.getCurrentActorInCurrentAlbum()))
                },
                currentAlbumDec = {
                    albumChange = !albumChange
                    myStateVariables.setCurrentAlbum(
                        when(myStateVariables.getCurrentAlbum()) {
                            0 -> myStateVariables.getMaxAlbums() - 1
                            else -> myStateVariables.getCurrentAlbum() - 1
                        }
                    )
                    myStateVariables.setCurrentActorInCurrentAlbum(0)
                    myStateVariables.setCurrentActorInFullList(actorCategoryID.theIDs.get(myStateVariables.getCurrentAlbum()).get(myStateVariables.getCurrentActorInCurrentAlbum()))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize()
                    .weight(5f)
            )
            Section4(
                currentActorInc = {
                    actorChange = !actorChange
                    myStateVariables.setCurrentActorInCurrentAlbum(
                        when(myStateVariables.getCurrentActorInCurrentAlbum()) {
                            myStateVariables.getMaxActorsInCurrentAlbum() - 1 -> 0
                            else -> myStateVariables.getCurrentActorInCurrentAlbum() + 1
                        }
                    )
                    myStateVariables.setCurrentActorInFullList(actorCategoryID.theIDs.get(myStateVariables.getCurrentAlbum()).get(myStateVariables.getCurrentActorInCurrentAlbum()))
                },
                currentActorDec = {
                    actorChange = !actorChange
                    myStateVariables.setCurrentActorInCurrentAlbum(
                        when(myStateVariables.getCurrentActorInCurrentAlbum()) {
                            0 -> myStateVariables.getMaxActorsInCurrentAlbum() - 1
                            else -> myStateVariables.getCurrentActorInCurrentAlbum() - 1
                        }
                    )
                    myStateVariables.setCurrentActorInFullList(actorCategoryID.theIDs.get(myStateVariables.getCurrentAlbum()).get(myStateVariables.getCurrentActorInCurrentAlbum()))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize()
                    .weight(7f)
            )
        }
    }  // Surface
}  // ArtSpace2App

@Composable
fun Section1(
    actorChange: Boolean,
    actorsList: MutableList<Actor>,
    myStateVariables: MyStateVariables,
    modifier: Modifier
) {
    Surface(
        modifier = modifier
            .padding(28.dp)
    ) {
        Image(
            painter = painterResource(
                id = actorsList.get(myStateVariables.getCurrentActorInFullList()).getImage()
            ),
            contentDescription = null.toString(),
            modifier = modifier
                .fillMaxHeight()
                .border(
                    width = 8.dp,
                    shape = RectangleShape,
                    brush = Brush.verticalGradient(
                        listOf(
                            Color.Yellow,
                            Color.Red,
                        )
                    )
                ),
            contentScale = ContentScale.FillHeight
        )
    }
}

@Composable
fun Section2(
    actorChange: Boolean,
    actorsList: MutableList<Actor>,
    myStateVariables: MyStateVariables,
    modifier: Modifier
) {
    Surface(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier
                .padding(2.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = actorsList.get(myStateVariables.getCurrentActorInFullList()).getNameKn(),
                style = Typography.headlineMedium,
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                SpecialLine(
                    modifier = Modifier
                        .weight(1f))
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(8f)
                ) {
                    val about = listOf(
                        listOf(stringResource(R.string.otherNames), actorsList.get(myStateVariables.getCurrentActorInFullList()).getOtherNames()),
                        listOf(stringResource(R.string.janana), actorsList.get(myStateVariables.getCurrentActorInFullList()).getBirth()),
                        listOf(stringResource(R.string.marana), actorsList.get(myStateVariables.getCurrentActorInFullList()).getDeath()),
//                        listOf(stringResource(R.string.kodugeRoopagalu), actorsList.get(myStateVariables.getCurrentActorInFullList()).getContributionForms()),
                        listOf(stringResource(R.string.kodugeRoopagalu), "ಬಾಕಿ ಇದೆ"), //TODO(Actual implementation pending)
                        listOf(stringResource(R.string.firstMovie), actorsList.get(myStateVariables.getCurrentActorInFullList()).getFirstKannadaMovie()),
                        listOf(stringResource(R.string.birudugalu), actorsList.get(myStateVariables.getCurrentActorInFullList()).getTitles()),
                    )
                    LazyColumn() {
                        items(about.size) { index ->
                            Row(
                                modifier = Modifier
                            ) {
                                Text(text = about[index][0], modifier = Modifier.weight(3f))
                                Text(
                                    text = about[index][1],
                                    modifier = Modifier.weight(7f)
                                )
                            }
                            if (index != about.size - 1) {
                                SimpleLine(modifier = Modifier)
                            }
                        }
                    }  // LazyColumn
                }  // Column
                SpecialLine(
                    modifier = Modifier
                        .weight(1f)
                )
            }  // Column
        }  // Column
    }
}

@Composable
fun SimpleLine(modifier: Modifier) {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp),
        contentDescription = null.toString(),
    )
    {
        drawLine(
            color = Color.Yellow,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
        )
    }
}

@Composable
fun SpecialLine(
    modifier: Modifier = Modifier
) {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp)
            .height(8.dp),
        contentDescription = null.toString(),
    ) {
        val strokeWidth = 8f
        val halfOfStrokeWidth = strokeWidth / 2
        var nextY = 0f
        drawLine(
            color = Color.Yellow,
            start = Offset(0f, halfOfStrokeWidth),
            end = Offset(size.width, halfOfStrokeWidth),
            strokeWidth = strokeWidth
        )
        nextY += strokeWidth
        drawLine(
            color = Color.Red,
            start = Offset(0f, nextY + halfOfStrokeWidth),
            end = Offset(size.width, nextY + halfOfStrokeWidth),
            strokeWidth = strokeWidth
        )
    }
}

@Composable
fun Section3(
    albumChange: Boolean,
    sangrahaList: MutableList<ContributionForm>,
    myStateVariables: MyStateVariables,
    currentAlbumInc: () -> Unit,    // TODO: Will be used for swipe feature
    currentAlbumDec: () -> Unit,    // TODO: Will be used for swipe feature
    modifier: Modifier
) {
    Surface(
        modifier = modifier
            .border(width = 2.dp, color = Color.Red)
            .padding(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = stringResource(R.string.sangrahaKn), style = Typography.headlineSmall)
            Text(text = sangrahaList.get(myStateVariables.getCurrentAlbum()).getNameKn(), style = Typography.headlineSmall)
        }
    }
}

@Composable
fun Section4(
    currentActorInc: () -> Unit,
    currentActorDec: () -> Unit,
    modifier: Modifier
){
    Surface(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            btnsNextOrPrevious(
                text = R.string.prevKn,
                onClickOp = currentActorDec,
                modifier = Modifier
                    .weight(3f)
            )
            Spacer(modifier = Modifier.weight(4f))
            btnsNextOrPrevious(
                text = R.string.nextKn,
                onClickOp = currentActorInc,
                modifier = Modifier
                    .weight(3f)
            )
        }
    }
}

@Composable
fun btnsNextOrPrevious(
    @StringRes text: Int,
    onClickOp: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClickOp,
        modifier = modifier
            .padding(2.dp)
            .background(brush = Brush.verticalGradient(listOf(Color.Yellow, Color.Red))),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Yellow,
            contentColor = Color.Red
        )
    ) {
        Text(text = stringResource(id = text))
    }
}
