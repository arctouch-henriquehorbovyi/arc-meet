package com.arctouch.arcmeet.meeting.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.arctouch.arcmeet.R
import com.arctouch.arcmeet.data.Attendee
import com.arctouch.arcmeet.data.mockedAttendees
import com.arctouch.arcmeet.ui.theme.ArcMeetTheme

/**
 * Composable function to render the screen with meeting participants and controls.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeetingScreen() {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.Black)
        ) {
            items(mockedAttendees) {
                AttendeeCard(attendee = it)
            }
        }
    }
}

@Composable
fun AttendeeCard(
    attendee: Attendee,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.DarkGray),
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(64.dp)
        ) {
            TopOptions()
            Avatar(attendee = attendee)
            BottomOptions(attendee = attendee)
        }
    }
}

@Composable
fun TopOptions(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Icon(
            modifier = modifier
                .clip(CircleShape)
                .background(color = Color.White),
            painter = painterResource(R.drawable.ic_opened_mic),
            contentDescription = null
        )
    }
}

@Composable
fun Avatar(modifier: Modifier = Modifier, attendee: Attendee) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        AsyncImage(
            modifier = Modifier
                .size(130.dp)
                .clip(CircleShape)
                .background(color = Color.Blue),
            model = ImageRequest.Builder(LocalContext.current)
                .data(attendee.imageUrl)
                .transformations(CircleCropTransformation())
                .placeholder(R.drawable.ic_launcher_foreground)
                .build(),
            contentDescription = null,
        )
    }
}

@Composable
fun BottomOptions(
    attendee: Attendee,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(attendee.name, color = Color.White)
        IconButton(onClick = { /* TODO */ }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                tint = Color.White,
                contentDescription = null,
            )
        }
    }
}

@Preview
@Composable
fun MeetingScreenPreview() {
    ArcMeetTheme {
        MeetingScreen()
    }
}