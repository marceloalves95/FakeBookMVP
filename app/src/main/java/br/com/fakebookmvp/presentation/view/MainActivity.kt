package br.com.fakebookmvp.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.fakebookmvp.databinding.ActivityMainBinding
import br.com.fakebookmvp.extensions.view.observe
import br.com.fakebookmvp.extensions.view.viewBinding
import br.com.fakebookmvp.presentation.present.FakeBookPresenter
import br.com.fakebookmvp.presentation.view.adapter.FakeBookAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val viewModel: FakeBookPresenter by viewModel()
    private var fakeBookAdapter = FakeBookAdapter(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.loadBooks()
        initializeUI()
    }

    private fun initializeUI() {
        observe(viewModel.bookAll) {
            fakeBookAdapter = FakeBookAdapter(it)
            binding.rvFakeBook.adapter = fakeBookAdapter
        }
    }
}