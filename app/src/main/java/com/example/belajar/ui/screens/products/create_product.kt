package com.example.belajar.ui.screens.products

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize

@Composable
fun CreateProduct(){
    var nama_product by remember { mutableStateOf("") }
    var stock by remember { mutableStateOf("") }
    var harga by remember { mutableStateOf("") }
    var expired_date by remember { mutableStateOf("") }

    var expandedDropdown1 by remember { mutableStateOf(false) }
    val itemsDropdown1 = listOf("Madrasah Aliyah (MA)", "Madrasah Tsanawiyah (MTs")
    var selectedOptionDropdown1 by remember { mutableStateOf(itemsDropdown1[0]) }

    // State for Dropdown 2 (Searchable)
    var expandedDropdown2 by remember { mutableStateOf(false) }
    val itemsDropdown2 = listOf("Laeli", "Dewi", "Azizah", "Dian", "Dona")
    var searchQueryDropdown2 by remember { mutableStateOf("") }
    var filteredItemsDropdown2 by remember { mutableStateOf(itemsDropdown2) }
    var selectedOptionDropdown2 by remember { mutableStateOf("") }

    var expandedDropdown3 by remember { mutableStateOf(false) }
    val itemsDropdown3 = listOf("X", "XI", "XII")
    var selectedOptionDropdown3 by remember { mutableStateOf(itemsDropdown3[0]) }


    Column (
        modifier = Modifier.fillMaxSize().verticalScroll(
            rememberScrollState()
        ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Registrasi", fontWeight = FontWeight.Bold, fontSize = 25.sp)
        Spacer(modifier = Modifier.padding(10.dp))
        OutlinedTextField(
            shape = RoundedCornerShape(10.dp),
            value = nama_product,
            onValueChange = {nama_product = it},
            label = { Text("Nama Orang Tua", fontWeight = FontWeight.Bold) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Person Icon"
                )
            },
            placeholder = { Text("Masukkan Nama Orang Tua") }
        )
        Spacer(modifier = Modifier.padding(10.dp))
        OutlinedTextField(
            shape = RoundedCornerShape(10.dp),
            value = stock,
            onValueChange = {stock = it},
            label = { Text("Nomor WhatsApp", fontWeight = FontWeight.Bold) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = "Call Icon"
                )
            },
            placeholder = { Text("Masukkan Stock Product") }
        )
        Spacer(modifier = Modifier.padding(10.dp))
        OutlinedTextField(
            shape = RoundedCornerShape(10.dp),
            value = harga,
            onValueChange = {harga = it},
            label = { Text("Email", fontWeight = FontWeight.Bold) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email Icon"
                )
            },
            placeholder = { Text("Masukkan Harga Product") }
        )
        Spacer(modifier = Modifier.padding(10.dp))
        OutlinedTextField(
            shape = RoundedCornerShape(10.dp),
            value = expired_date,
            onValueChange = {expired_date = it},
            label = { Text("Password", fontWeight = FontWeight.Bold) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Lock Icon"
                )
            },
            placeholder = { Text("Masukkan Expired Date Product") }
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text("Data Santri", fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
        Column(
            modifier = Modifier.width(300.dp).padding(5.dp)
        ) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                OutlinedTextField(
                    shape = RoundedCornerShape(10.dp),
                    value = selectedOptionDropdown1,
                    onValueChange = {}, // No manual editing allowed
                    readOnly = true, // Prevent manual input
                    label = { Text("Tingkat Sekolah") },
                    trailingIcon = {
                        Icon(
                            imageVector = if (expandedDropdown1) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                            contentDescription = "Dropdown Icon",
                            Modifier.clickable { expandedDropdown1 = !expandedDropdown1 }
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { expandedDropdown1 = !expandedDropdown1 } // Open dropdown on click
                )
                DropdownMenu(
                    expanded = expandedDropdown1,
                    onDismissRequest = { expandedDropdown1 = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    itemsDropdown1.forEach { item ->
                        DropdownMenuItem(
                            onClick = {
                                selectedOptionDropdown1 = item
                                expandedDropdown1 = false
                            },
                            text = { Text(text = item) }
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                OutlinedTextField(
                    shape = RoundedCornerShape(10.dp),
                    value = selectedOptionDropdown3,
                    onValueChange = {}, // No manual editing allowed
                    readOnly = true, // Prevent manual input
                    label = { Text("Tingkat Kelas") },
                    trailingIcon = {
                        Icon(
                            imageVector = if (expandedDropdown3) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                            contentDescription = "Dropdown Icon",
                            Modifier.clickable { expandedDropdown3 = !expandedDropdown3 }
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { expandedDropdown3 = !expandedDropdown3 } // Open dropdown on click
                )
                DropdownMenu(
                    expanded = expandedDropdown3,
                    onDismissRequest = { expandedDropdown3 = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    itemsDropdown3.forEach { item ->
                        DropdownMenuItem(
                            onClick = {
                                selectedOptionDropdown3 = item
                                expandedDropdown3 = false
                            },
                            text = { Text(text = item) }
                        )
                    }
                }
            }
        }
//            Text("Nama Santri", fontWeight = FontWeight.Bold)
            Column (
                modifier = Modifier.width(300.dp).padding(5.dp)
            ){
                OutlinedTextField(
                    shape = RoundedCornerShape(10.dp),
                    value = searchQueryDropdown2,
//                    label = { Text("Tingkat Kelas") },
//                    trailingIcon = {
//                        Icon(
//                            imageVector = if (expandedDropdown3) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
//                            contentDescription = "Dropdown Icon",
//                            Modifier.clickable { expandedDropdown3 = !expandedDropdown3 }
//                        )
//                    },
                    onValueChange = {
                        searchQueryDropdown2 = it
                        filteredItemsDropdown2 = itemsDropdown2.filter { item ->
                            item.contains(it, ignoreCase = true)
                        }
                    },
                    label = { Text("Nama Santri") },
                    trailingIcon = {
                        Icon(
                            imageVector = if (expandedDropdown2) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                            contentDescription = "Dropdown Icon",
                            Modifier.clickable { expandedDropdown2 = !expandedDropdown2 }
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .onFocusChanged { focusState ->
                            expandedDropdown2 = focusState.isFocused
                        }
                )

                DropdownMenu(
                    expanded = expandedDropdown2,
                    onDismissRequest = { expandedDropdown2 = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    if (filteredItemsDropdown2.isEmpty()) {
                        DropdownMenuItem(
                            onClick = { },
                            text = { Text("No results found") }
                        )
                    } else {
                        filteredItemsDropdown2.forEach { item ->
                            DropdownMenuItem(
                                onClick = {
                                    selectedOptionDropdown2 = item
                                    expandedDropdown2 = false
                                    searchQueryDropdown2 = ""
                                },
                                text = { Text(text = item) }
                            )
                        }
                    }
                }
            }

        Spacer(modifier = Modifier.padding(10.dp))
        Row(
            modifier = Modifier.width(300.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            FilledTonalButton(
                modifier = Modifier.fillMaxSize(),
                shape = RoundedCornerShape(12.dp),onClick ={}) {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = "submit icon",
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.padding(3.dp))
                Text("SUBMIT")
            }
        }
    }
}

fun OutlinedTextField() {
    TODO("Not yet implemented")
}

@Preview(showBackground = true)
@Composable
fun CreateProductReview(){
    CreateProduct()
}