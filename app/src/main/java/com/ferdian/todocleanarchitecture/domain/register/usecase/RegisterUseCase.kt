package com.ferdian.todocleanarchitecture.domain.register.usecase

import com.ferdian.todocleanarchitecture.data.common.utils.WrappedResponse
import com.ferdian.todocleanarchitecture.data.register.remote.dto.RegisterRequest
import com.ferdian.todocleanarchitecture.data.register.remote.dto.RegisterResponse
import com.ferdian.todocleanarchitecture.domain.common.base.BaseResult
import com.ferdian.todocleanarchitecture.domain.register.RegisterRepository
import com.ferdian.todocleanarchitecture.domain.register.entity.RegisterEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val registerRepository: RegisterRepository) {
    suspend fun invoke(registerRequest: RegisterRequest) : Flow<BaseResult<RegisterEntity, WrappedResponse<RegisterResponse>>> {
        return registerRepository.register(registerRequest)
    }
}