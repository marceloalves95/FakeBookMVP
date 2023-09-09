package br.com.fakebookmvp.app.di

import br.com.fakebookmvp.data.BASE_URL
import br.com.fakebookmvp.data.FakeBookRepositoryImpl
import br.com.fakebookmvp.data.service.FakeBookService
import br.com.fakebookmvp.domain.interactor.FakeBookInteractor
import br.com.fakebookmvp.domain.interactor.FakeBookInteractorImpl
import br.com.fakebookmvp.domain.repository.FakeBookRepository
import br.com.fakebookmvp.network.service.Service
import br.com.fakebookmvp.presentation.present.FakeBookPresenter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext
import org.koin.core.module.Module
import org.koin.dsl.module

object FakeBookModule {

    fun load() {
        GlobalContext.loadKoinModules(
            listOf(
                dataModule(),
                domainModule(),
                presentationModule()
            )
        )
    }

    private fun dataModule(): Module = module {
        factory<FakeBookService> {
            Service.createService(
                baseUrl = BASE_URL
            )
        }
        single<FakeBookRepository> {
            FakeBookRepositoryImpl(get())
        }
    }

    private fun domainModule(): Module = module {
        single<FakeBookInteractor> {
            FakeBookInteractorImpl(get())
        }
    }

    private fun presentationModule(): Module = module {
        viewModel { FakeBookPresenter(get()) }
    }
}