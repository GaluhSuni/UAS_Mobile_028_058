package com.example.uas_mobile_028_058.ui.theme.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.uas_mobile_028_058.models.Event
import com.example.uas_mobile_028_058.viewmodel.EventViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventListScreen(
    viewModel: EventViewModel = EventViewModel(),
    onCreateClick: () -> Unit
) {
    val events by viewModel.events.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Event List") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onCreateClick) {
                Text("+")
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            items(events) { event ->
                EventItem(event = event, onClick = {})
            }
        }
    }
}


@Composable
fun EventItem(event: Event, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(
                event.title,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(Modifier.height(4.dp))

            Text(
                "${event.date} • ${event.time}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                event.location,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(Modifier.height(6.dp))

            AssistChip(
                onClick = { },
                label = { Text(event.status) }
            )
        }
    }
}

//fun EventListScreen(
//    viewModel: EventViewModel = EventViewModel(),
//    onEventClick: (Int) -> Unit = {}
//) {
//    val events by viewModel.events.collectAsState()
//
//    Scaffold(
//        topBar = {
//            CenterAlignedTopAppBar(
//                title = { Text("Event List") }
//            )
//        },
//        floatingActionButton = {
//            FloatingActionButton(onClick = { viewModel.navigateToCreate() }) {
//                Text("+", style = MaterialTheme.typography.titleLarge)
//            }
//        }
//    ) { padding ->
//        LazyColumn(
//            modifier = Modifier
//                .padding(padding)
//                .padding(16.dp)
//        ) {
//            items(events) { event ->
//                EventItem(event = event, onClick = { onEventClick(event.id!!) })
//            }
//        }
//    }
//}