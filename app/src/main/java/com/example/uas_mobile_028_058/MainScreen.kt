package com.example.uas_mobile_028_058

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uas_mobile_028_058.ui.theme.UAS_Mobile_028_058Theme

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Event Management System")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /*TODO: panggil API di sini nanti*/ }) {
            Text(text = "Load Events")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    UAS_Mobile_028_058Theme {
        MainScreen()
    }
}