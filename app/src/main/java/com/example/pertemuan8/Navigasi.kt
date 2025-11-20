package com.example.pertemuan8

enum class Navigasi {
    Formulir,
    Detail
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SiswaApp(
    // edit 1: parameter viewModel
    viewModel: SiswaViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    // edit 2: Tambahkan variabel uiState
    val uiState by viewModel.statusUI.collectAsState()
    NavHost(
        navController = navController,
        startDestination = Navigasi.Formulir.name,
        modifier = Modifier.padding(paddingValues = isiRuang)
    ) {
        composable(route = Navigasi.Formulir.name) {
            // edit 3 : Tambahkan variable konteks
            val konteks = LocalContext.current
            FormSiswa(
                // edit 4 : parameter pilihanJK dan onsubmitButtonClicked
                pilihanJK = JenisJK.map { id -> konteks.resources.getString(id) },
                onSubmitButtonClicked = {
                    viewModel.setSiswa(it)
                    navController.navigate(route = Navigasi.Detail.name)
                }
            )
        }
        composable(route = Navigasi.Detail.name) {
            TampilSiswa(
                // edit 5 : parameter statusUISiswa
                statusUISiswa = uiState.value,
                onBackButtonClicked = { cancelAndBackToFormulir(navController) }
            )
        }
    }
}

private fun cancelAndBackToFormulir(
    navHostController: NavHostController
) {
    navController.popBackStack(route = Navigasi.Formulir.name, inclusive = false)
}