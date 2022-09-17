package com.ferdian.todocleanarchitecture.domain.product.usecase

import com.ferdian.todocleanarchitecture.data.common.utils.WrappedListResponse
import com.ferdian.todocleanarchitecture.data.common.utils.WrappedResponse
import com.ferdian.todocleanarchitecture.data.product.remote.dto.ProductResponse
import com.ferdian.todocleanarchitecture.domain.common.base.BaseResult
import com.ferdian.todocleanarchitecture.domain.product.ProductRepository
import com.ferdian.todocleanarchitecture.domain.product.entity.ProductEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllMyProductUseCase @Inject constructor(private val productRepository: ProductRepository) {
    suspend fun invoke(): Flow<BaseResult<List<ProductEntity>, WrappedListResponse<ProductResponse>>> {
        return productRepository.getAllMyProducts()
    }
}