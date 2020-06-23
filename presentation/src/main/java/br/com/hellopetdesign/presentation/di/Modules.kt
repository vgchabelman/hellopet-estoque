package br.com.hellopetdesign.presentation.di

import br.com.hellopetdesign.data.datasource.IProductDataSource
import br.com.hellopetdesign.data.datasource.LocalProductDataSource
import br.com.hellopetdesign.data.repository.ProductRepository
import br.com.hellopetdesign.data.room.Database
import br.com.hellopetdesign.domain.repository.IProductRepository
import br.com.hellopetdesign.domain.usecases.IProductInteractor
import br.com.hellopetdesign.domain.usecases.ProductInteractor
import br.com.hellopetdesign.presentation.product.detail.AddProductViewModel
import br.com.hellopetdesign.presentation.product.inventory.ProductInventoryViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module(override = true) {
    single { Database(androidContext()) }
}

val productModule = module {
    factory { LocalProductDataSource(get()) as IProductDataSource }
    factory { ProductRepository(get()) as IProductRepository }
    factory { ProductInteractor(get()) as IProductInteractor }

    viewModel {
        ProductInventoryViewModel(
            get()
        )
    }
    viewModel {
        AddProductViewModel(
            get()
        )
    }
}