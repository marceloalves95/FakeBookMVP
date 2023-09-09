package br.com.fakebookmvp.presentation.present

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fakebookmvp.domain.interactor.FakeBookInteractor
import br.com.fakebookmvp.domain.model.FakeBookDataDTO
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class FakeBookPresenter(
    private val interactor: FakeBookInteractor
) : FakeBookContract.Presenter, ViewModel() {

    private val _bookAll = MutableLiveData<List<FakeBookDataDTO>>()
    val bookAll: LiveData<List<FakeBookDataDTO>> get() = _bookAll

    override fun displayBooks(): LiveData<List<FakeBookDataDTO>> {
        return bookAll
    }

    @SuppressLint("CheckResult")
    override fun loadBooks() {
        interactor.getBookAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { books -> _bookAll.value = books.data },
                { error -> Log.d("RxJava", "${error.message}") }
            )
    }
}