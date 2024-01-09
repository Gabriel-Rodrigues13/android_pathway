package com.example.dessertclicker.ui

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource.dessertList
import com.example.dessertclicker.data.DessertUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class DessertViewModel: ViewModel() {

    private val _dessertUiState = MutableStateFlow(DessertUiState())
    val dessertUiState: StateFlow<DessertUiState> = _dessertUiState.asStateFlow()



    fun onDessertClicked(){
        _dessertUiState.update {cupcakeUiState ->
            val dessertsSold = cupcakeUiState.dessertSold + 1
            val nextDesertIndex = determineDessertToShow(dessertsSold)
            cupcakeUiState.copy(
                currentDessertIndex = nextDesertIndex,
                dessertSold = dessertsSold,
                totalRevenue = cupcakeUiState.totalRevenue + cupcakeUiState.currentDessertPrice,
                currentDessertImageId = dessertList[nextDesertIndex].imageId,
                currentDessertPrice = dessertList[nextDesertIndex].price
            )
        }
    }

    private fun determineDessertToShow(dessertsSold: Int): Int{
        var dessertIndex = 0
        for (index in dessertList.indices){
            if(dessertsSold >= dessertList[index].startProductionAmount){
                dessertIndex = index
            }else{
                break
            }
        }
        return dessertIndex
    }

}