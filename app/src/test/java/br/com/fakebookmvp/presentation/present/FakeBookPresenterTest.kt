package br.com.fakebookmvp.presentation.present

import androidx.lifecycle.Observer
import assertk.assertThat
import assertk.assertions.isEqualTo
import br.com.fakebookmvp.domain.interactor.FakeBookInteractor
import br.com.fakebookmvp.domain.model.FakeBookDataDTO
import br.com.fakebookmvp.domain.model.dummyFakeBook
import br.com.fakebookmvp.testing.RXBaseTest
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import io.reactivex.rxjava3.core.Observable
import org.junit.After
import org.junit.Before
import org.junit.Test

class FakeBookPresenterTest : RXBaseTest() {

    private lateinit var presenter: FakeBookPresenter

    @RelaxedMockK
    private lateinit var interactor: FakeBookInteractor

    @RelaxedMockK
    private lateinit var stateObserver: Observer<List<FakeBookDataDTO>>

    @Before
    fun setup() {
        presenter = FakeBookPresenter(interactor)
        presenter.bookAll.observeForever(stateObserver)
    }

    @After
    fun tearDown() {
        presenter.bookAll.removeObserver(stateObserver)
    }

    @Test
    fun `should show display books when it is called`() {
        //Arrange and Act
        val actual = presenter.displayBooks()
        val expected = presenter.bookAll
        //Assert
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `should load books when it is called`() {

        //Arrange
        every {
            interactor.getBookAll()
        } returns Observable.just(dummyFakeBook)

        //Act
        presenter.loadBooks()

        //Assert
        verify(exactly = 1) {
            interactor.getBookAll()
        }
        confirmVerified(interactor)
    }
}