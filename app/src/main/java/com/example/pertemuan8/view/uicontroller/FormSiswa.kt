package com.example.pertemuan8.view.uicontroller

import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormSiswa(
    pilihanJK : List<String>,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    modifier: Modifier = Modifier
){
    var txtNama by rememberSaveable { mutableStateOf("") }
    var txtAlamat by remember { mutableStateOf("")}
    var txtGender by remember { mutableStateOf("")}
    val listData: MutableList<String> =mutableListOf(txtNama, txtGender, txtAlamat)


    Scaffold(modifier = Modifier,
        {TopAppBar(title = { Text(Text(StringResource(id = "Form Pendaftaran"), color = Color.White,
            colors = TopAppBarDefaults.mediumTopAppBarColors(colorResource(id = R.color.purple)
            )


}
