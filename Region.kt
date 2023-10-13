package com.example.petproject

data class Region (
    val id: Int,
    val numRegion: String,
    val nameOfRegion: String
) {
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            "$numRegion $nameOfRegion",
            "$nameOfRegion $numRegion",
            "${nameOfRegion.first()} ${numRegion.first()}",
        )

        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}