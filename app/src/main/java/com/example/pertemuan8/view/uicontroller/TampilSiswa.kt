package com.example.pertemuan8.view.uicontroller

import androidx.compose.runtime.Composable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.dimensionResource
import com.example.pertemuan8.model.Siswa
import com.example.pertemuan8.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilSiswa(
    statusUISiswa: Siswa,
    onBackButtonClicked: () -> Unit
) {

    val items = listOf(
        stringResource(R.string.nama) to statusUISiswa.nama,
        stringResource(R.string.gender) to statusUISiswa.gender,
        stringResource(R.string.alamat) to statusUISiswa.alamat
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.detail), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.purple_500)
                )
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier.padding(paddingValues),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier.padding(
                    start = dimensionResource(R.dimen.padding_medium),
                    end = dimensionResource(R.dimen.padding_medium)
                ),
                verticalArrangement = Arrangement.spacedBy(
                    dimensionResource(R.dimen.padding_small)
                )
            ) {
                items.forEach { (label, value) ->
                    Column {
                        Text(text = label.uppercase(), fontSize = 16.sp)
                        Text(text = value, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                    Divider(thickness = dimensionResource(R.dimen.thickness_divider))
                }
            }

            Spacer(
                modifier = Modifier.height(
                    dimensionResource(R.dimen.padding_medium)
                )
            )

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onBackButtonClicked
            ) {
                Text(stringResource(R.string.back))
            }
        }
    }
}


