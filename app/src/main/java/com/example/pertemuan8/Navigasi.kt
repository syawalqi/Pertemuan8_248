package com.example.pertemuan8

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.platform.LocalContext
import com.example.pertemuan8.view.uicontroller.FormSiswa
import com.example.pertemuan8.view.uicontroller.TampilSiswa
import com.example.pertemuan8.viewmodel.SiswaViewModel
import com.example.pertemuan8.model.DataJK

enum class Navigasi {
    Formulir,
    Detail
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SiswaApp(
    viewModel: SiswaViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val uiState by viewModel.statusUI.collectAsState()

    NavHost(
        navController = navController,
        startDestination = Navigasi.Formulir.name
    ) {

        composable(Navigasi.Formulir.name) {

            val konteks = LocalContext.current

            FormSiswa(
                pilihanJK = DataJK.JenisJK.map { id ->
                    konteks.resources.getString(id)
                },
                onSubmitButtonClicked = {
                    viewModel.setSiswa(it)
                    navController.navigate(Navigasi.Detail.name)
                }
            )
        }

        composable(Navigasi.Detail.name) {
            TampilSiswa(
                statusUISiswa = uiState,
                onBackButtonClicked = { cancelAndBackToFormulir(navController) }
            )
        }
    }
}

private fun cancelAndBackToFormulir(
    navHostController: NavHostController
) {
    navHostController.popBackStack(
        Navigasi.Formulir.name,
        false
    )
}
