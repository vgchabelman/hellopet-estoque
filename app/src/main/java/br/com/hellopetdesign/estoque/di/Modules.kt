package br.com.hellopetdesign.estoque.di

import br.com.hellopetdesign.data.repository.MaterialRepository
import br.com.hellopetdesign.data.repository.OrderRepository
import br.com.hellopetdesign.data.repository.ProductRepository
import br.com.hellopetdesign.domain.repository.IMaterialRepository
import br.com.hellopetdesign.domain.repository.IOrderRepository
import br.com.hellopetdesign.domain.repository.IProductRepository
import br.com.hellopetdesign.domain.usecases.*
import br.com.hellopetdesign.local.MaterialDataSource as LocalMaterialDataSource
import br.com.hellopetdesign.local.ProductDataSource as LocalProductDataSource
import br.com.hellopetdesign.local.RoomDb
import br.com.hellopetdesign.presentation.material.MaterialInventoryViewModel
import br.com.hellopetdesign.presentation.order.OrderViewModel
import br.com.hellopetdesign.presentation.product.detail.AddProductViewModel
import br.com.hellopetdesign.presentation.product.inventory.ProductInventoryViewModel
import br.com.hellopetdesign.remote.FirebaseRemote
import br.com.hellopetdesign.remote.MaterialDataSource as RemoteMaterialDataSource
import br.com.hellopetdesign.remote.OrderDataSource as RemoteOrderDataSource
import br.com.hellopetdesign.remote.ProductDataSource as RemoteProductDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module(override = true) {
    single { RoomDb(androidContext()) }
    single { FirebaseRemote() }
}

val productModule = module {
    factory { LocalProductDataSource(get()) }
    factory { RemoteProductDataSource(get()) }
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
    factory { RemoteMaterialDataSource(get()) }
    factory {
        MaterialRepository(
            get(LocalMaterialDataSource::class),
            get(RemoteMaterialDataSource::class)
        ) as IMaterialRepository
    }
    factory { MaterialInteractor(get()) as IMaterialInteractor }

    viewModel { MaterialInventoryViewModel(get()) }
}

val orderModule = module {
    factory { RemoteOrderDataSource(get()) }
    factory {
        OrderRepository(get(RemoteOrderDataSource::class)) as IOrderRepository
    }
    factory { OrderInteractor(get()) as IOrderInteractor }

    viewModel { OrderViewModel(get()) }
}