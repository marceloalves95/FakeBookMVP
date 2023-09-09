package br.com.fakebookmvp.domain.interactor

import br.com.fakebookmvp.domain.model.FakeBook
import io.reactivex.rxjava3.core.Observable

interface FakeBookInteractor {
    fun getBookAll(): Observable<FakeBook>
}