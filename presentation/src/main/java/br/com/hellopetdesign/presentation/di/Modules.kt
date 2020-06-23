package br.com.hellopetdesign.presentation.di

import br.com.hellopetdesign.data.datasource.*
import br.com.hellopetdesign.data.repository.MaterialRepository
import br.com.hellopetdesign.data.repository.ProductRepository
import br.com.hellopetdesign.data.room.Database
import br.com.hellopetdesign.domain.repository.IMaterialRepository
import br.com.hellopetdesign.domain.repository.IProductRepository
import br.com.hellopetdesign.domain.usecases.IMaterialInteractor
import br.com.hellopetdesign.domain.usecases.IProductInteractor
import br.com.hellopetdesign.domain.usecases.MaterialInteractor
import br.com.hellopetdesign.domain.usecases.ProductInteractor
import br.com.hellopetdesign.presentation.material.MaterialInventoryViewModel
import br.com.hellopetdesign.presentation.product.detail.AddProductViewModel
import br.com.hellopetdesign.presentation.product.inventory.ProductInventoryViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module(override = true) {
    single { Database(androidContext()) }
}

val productModule = module {
    factory { LocalProductDataSource(get()) }
    factory { RemoteProductDataSource() }
    factory {
        ProductRepository(
            get(LocalProductDataSource::class),
            get(RemoteProductDataSource::class)
        ) as IProductRepository
    }
    factory { ProductInteractor(get()) as IProductInteractor }

    viewModel { ProductInventoryViewModel(get()) }
    viewModel { AddProductViewModel(get()) }
}

val materialModule = module {
    factory { LocalMaterialDataSource(get()) }
    factory { RemoteMaterialDataSource() }
    factory {
        MaterialRepository(
            get(LocalMaterialDataSource::class),
            get(RemoteMaterialDataSource::class)
        ) as IMaterialRepository
    }
    factory { MaterialInteractor(get()) as IMaterialInteractor }

    viewModel { MaterialInventoryViewModel(get()) }
}