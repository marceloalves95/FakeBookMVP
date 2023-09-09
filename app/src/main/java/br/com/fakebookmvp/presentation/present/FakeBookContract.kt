package br.com.fakebookmvp.presentation.present

import androidx.lifecycle.LiveData
import br.com.fakebookmvp.domain.model.FakeBookDataDTO

interface FakeBookContract {
    interface Presenter {
        fun displayBooks(): LiveData<List<FakeBookDataDTO>>
        fun loadBooks()
    }
}