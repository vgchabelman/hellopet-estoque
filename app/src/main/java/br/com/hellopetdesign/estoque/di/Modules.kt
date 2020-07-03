package br.com.hellopetdesign.estoque.di

import br.com.hellopetdesign.data.datasource.LocalMaterialDataSource
import br.com.hellopetdesign.data.datasource.LocalProductDataSource
import br.com.hellopetdesign.data.repository.MaterialRepository
import br.com.hellopetdesign.data.repository.OrderRepository
import br.com.hellopetdesign.data.repository.ProductRepository
import br.com.hellopetdesign.data.room.RoomDb
import br.com.hellopetdesign.domain.repository.IMaterialRepository
import br.com.hellopetdesign.domain.repository.IOrderRepository
import br.com.hellopetdesign.domain.repository.IProductRepository
import br.com.hellopetdesign.domain.usecases.*
import br.com.hellopetdesign.presentation.material.MaterialInventoryViewModel
import br.com.hellopetdesign.presentation.order.OrderViewModel
import br.com.hellopetdesign.presentation.product.detail.AddProductViewModel
import br.com.hellopetdesign.presentation.product.inventory.ProductInventoryViewModel
import br.com.hellopetdesign.remote.FirebaseRemote
import br.com.hellopetdesign.remote.MaterialDataSource
import br.com.hellopetdesign.remote.OrderDataSource
import br.com.hellopetdesign.remote.ProductDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module(override = true) {
    single { RoomDb(androidContext()) }
    single { FirebaseRemote() }
}

val productModule = module {
    factory { LocalProductDataSource(get()) }
    factory { ProductDataSource(get()) }
    factory {
        ProductRepository(
            get(LocalProductDataSource::class),
            get(ProductDataSource::class)
        ) as IProductRepository
    }
    factory { ProductInteractor(get()) as IProductInteractor }

    viewModel { ProductInventoryViewModel(get()) }
    viewModel { AddProductViewModel(get()) }
}

val materialModule = module {
    factory { LocalMaterialDataSource(get()) }
    factory { MaterialDataSource(get()) }
    factory {
        MaterialRepository(
            get(LocalMaterialDataSource::class),
            get(MaterialDataSource::class)
        ) as IMaterialRepository
    }
    factory { MaterialInteractor(get()) as IMaterialInteractor }

    viewModel { MaterialInventoryViewModel(get()) }
}

val orderModule = module {
    factory { OrderDataSource(get()) }
    factory {
        OrderRepository(get(OrderDataSource::class)) as IOrderRepository
    }
    factory { OrderInteractor(get()) as IOrderInteractor }

    viewModel { OrderViewModel(get()) }
}