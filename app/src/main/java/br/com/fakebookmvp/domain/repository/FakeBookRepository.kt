package br.com.fakebookmvp.domain.repository

import br.com.fakebookmvp.domain.model.FakeBook
import io.reactivex.rxjava3.core.Observable

interface FakeBookRepository {
    fun getBooks(): Observable<FakeBook>
}