package com.example.petproject


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*


@OptIn(FlowPreview::class)
class MainViewModel: ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _regions = MutableStateFlow(allRegions)
    val regions = searchText
        .debounce(100L)
        .onEach { _isSearching.update { true } }
        .combine(_regions) { text, regions ->
            if(text.isBlank()) {
                regions
            } else {
                regions.filter {
                    it.doesMatchSearchQuery(text)
                }
            }
        }
        .onEach { _isSearching.update { false } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(50),
            _regions.value
        )

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }
}

private val allRegions = listOf(
    Region(
        id =78,
        numRegion = "Saint-P",
        nameOfRegion = "78"
    ),
    Region(
        id =71,
        numRegion = "Lomik",
        nameOfRegion = "71"
    ),
    Region(
        id =22,
        numRegion = "EKB",
        nameOfRegion = "22"
    ),
    Region(
        id =22,
        numRegion = "ВВ",
        nameOfRegion = "22"
    ),
    Region(
        id =22,
        numRegion = "ТТТТ",
        nameOfRegion = "22"
    ),

)