package com.ferdian.todocleanarchitecture.domain.register

import com.ferdian.todocleanarchitecture.data.common.utils.WrappedResponse
import com.ferdian.todocleanarchitecture.data.register.remote.dto.RegisterRequest
import com.ferdian.todocleanarchitecture.data.register.remote.dto.RegisterResponse
import com.ferdian.todocleanarchitecture.domain.common.base.BaseResult
import com.ferdian.todocleanarchitecture.domain.register.entity.RegisterEntity
import kotlinx.coroutines.flow.Flow

interface RegisterRepository {
    suspend fun register(registerRequest: RegisterRequest) : Flow<BaseResult<RegisterEntity, WrappedResponse<RegisterResponse>>>
}