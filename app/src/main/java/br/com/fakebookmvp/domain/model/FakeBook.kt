package br.com.fakebookmvp.domain.model

typealias FakeBookDTO = FakeBook
typealias FakeBookDataDTO = FakeBookData

data class FakeBook(
    val status: String,
    val code: Int,
    val total: Int,
    val data: List<FakeBookData>
)

data class FakeBookData(
    val id: Int,
    val title: String,
    val author: String,
    val genre: String,
    val description: String,
    val isbn: String,
    val image: String,
    val published: String,
    val publisher: String
)