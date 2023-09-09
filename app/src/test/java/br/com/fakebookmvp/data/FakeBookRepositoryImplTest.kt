package br.com.fakebookmvp.data

import br.com.fakebookmvp.data.service.FakeBookService
import br.com.fakebookmvp.domain.model.dummyFakeBook
import io.mockk.MockKAnnotations
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import io.reactivex.rxjava3.core.Observable
import org.junit.Before
import org.junit.Test

class FakeBookRepositoryImplTest {

    private lateinit var fakeBookRepository: FakeBookRepositoryImpl

    @RelaxedMockK
    private lateinit var service: FakeBookService

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        fakeBookRepository = FakeBookRepositoryImpl(service)
    }

    @Test
    fun `should return get book when it is called`() {

        //Arrange
        every {
            service.getBooks()
        } returns Observable.just(dummyFakeBook)

        //Act
        fakeBookRepository.getBooks()

        //Assert
        verify(exactly = 1) {
            service.getBooks()
        }
        confirmVerified(service)
    }
}