package br.com.fakebookmvp.domain.interactor

import br.com.fakebookmvp.domain.model.FakeBook
import br.com.fakebookmvp.domain.repository.FakeBookRepository
import io.reactivex.rxjava3.core.Observable

class FakeBookInteractorImpl(
    private val repository: FakeBookRepository
) : FakeBookInteractor {
    override fun getBookAll(): Observable<FakeBook> {
        return repository.getBooks()
    }
}