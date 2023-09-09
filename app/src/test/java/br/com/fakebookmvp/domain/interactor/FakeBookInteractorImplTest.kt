package br.com.fakebookmvp.domain.interactor

import br.com.fakebookmvp.domain.model.dummyFakeBook
import br.com.fakebookmvp.domain.repository.FakeBookRepository
import br.com.fakebookmvp.testing.RXBaseTest
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import io.reactivex.rxjava3.core.Observable
import org.junit.Before
import org.junit.Test

class FakeBookInteractorImplTest : RXBaseTest() {

    private lateinit var interactor: FakeBookInteractorImpl

    @RelaxedMockK
    private lateinit var repository: FakeBookRepository

    @Before
    fun setup() {
        interactor = FakeBookInteractorImpl(repository)
    }

    @Test
    fun `should return list of books when it is called`() {

        //Arrange
        every {
            repository.getBooks()
        } returns Observable.just(dummyFakeBook)

        //Act
        interactor.getBookAll()

        //Assert
        verify(exactly = 1) {
            repository.getBooks()
        }

        confirmVerified(repository)
    }

}