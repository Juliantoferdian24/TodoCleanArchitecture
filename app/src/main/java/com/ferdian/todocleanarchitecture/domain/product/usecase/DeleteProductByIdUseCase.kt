package com.ferdian.todocleanarchitecture.domain.product.usecase

import com.ferdian.todocleanarchitecture.data.common.utils.WrappedResponse
import com.ferdian.todocleanarchitecture.data.product.remote.dto.ProductResponse
import com.ferdian.todocleanarchitecture.domain.common.base.BaseResult
import com.ferdian.todocleanarchitecture.domain.product.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DeleteProductByIdUseCase @Inject constructor(private val productRepository: ProductRepository) {
    suspend fun invoke(id: String) : Flow<BaseResult<Unit, WrappedResponse<ProductResponse>>> {
        return productRepository.deleteProductById(id)
    }
}