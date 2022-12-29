import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

// main application function
@Composable
@Preview
fun App() {
    MaterialTheme {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {

            val stopwatch = remember { Stopwatch() }
            StopwatchDisplay(
                formattedTime = stopwatch::formattedTime.get(),
                onStartClick = stopwatch::start,
                onPauseClick = stopwatch::pause,
                onResetClick = stopwatch::reset
            )
        }
    }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Stopwatch",
        state = rememberWindowState(width = 480.dp, height = 480.dp),
        icon = painterResource("images/icon.png")
    ) {
        App()
    }
}
