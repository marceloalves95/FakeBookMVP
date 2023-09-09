package br.com.fakebookmvp.data

import br.com.fakebookmvp.data.service.FakeBookService
import br.com.fakebookmvp.domain.model.FakeBook
import br.com.fakebookmvp.domain.repository.FakeBookRepository
import io.reactivex.rxjava3.core.Observable

class FakeBookRepositoryImpl(
    private val service: FakeBookService
) : FakeBookRepository {
    override fun getBooks(): Observable<FakeBook> {
        return service.getBooks()
    }
}