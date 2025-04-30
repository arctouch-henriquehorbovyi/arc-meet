package com.arctouch.arcmeet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.arctouch.arcmeet.meeting.ui.MeetingScreen
import com.arctouch.arcmeet.ui.theme.ArcMeetTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArcMeetTheme {
                MeetingScreen()
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun MeetingScreenPreviewPreview() {
    ArcMeetTheme {
        MeetingScreen()
    }
}