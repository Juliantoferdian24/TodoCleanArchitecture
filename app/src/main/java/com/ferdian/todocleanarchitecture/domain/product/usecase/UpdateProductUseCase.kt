package com.ferdian.todocleanarchitecture.domain.product.usecase

import com.ferdian.todocleanarchitecture.data.common.utils.WrappedResponse
import com.ferdian.todocleanarchitecture.data.product.remote.dto.ProductResponse
import com.ferdian.todocleanarchitecture.data.product.remote.dto.ProductUpdateRequest
import com.ferdian.todocleanarchitecture.domain.common.base.BaseResult
import com.ferdian.todocleanarchitecture.domain.product.ProductRepository
import com.ferdian.todocleanarchitecture.domain.product.entity.ProductEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpdateProductUseCase @Inject constructor(private val productRepository: ProductRepository){
    suspend fun invoke(productUpdateRequest: ProductUpdateRequest, id: String) : Flow<BaseResult<ProductEntity, WrappedResponse<ProductResponse>>>{
        return productRepository.updateProduct(productUpdateRequest, id)
    }
}