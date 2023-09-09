package br.com.fakebookmvp.data.service

import br.com.fakebookmvp.domain.model.FakeBookDTO
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface FakeBookService {
    @GET("books")
    fun getBooks(): Observable<FakeBookDTO>
}