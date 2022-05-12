package com.ferdian.todocleanarchitecture.domain.login

import com.ferdian.todocleanarchitecture.data.common.utils.WrappedResponse
import com.ferdian.todocleanarchitecture.data.login.remote.dto.LoginRequest
import com.ferdian.todocleanarchitecture.data.login.remote.dto.LoginResponse
import com.ferdian.todocleanarchitecture.domain.common.base.BaseResult
import com.ferdian.todocleanarchitecture.domain.login.entity.LoginEntity
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    suspend fun login(loginRequest: LoginRequest) : Flow<BaseResult<LoginEntity, WrappedResponse<LoginResponse>>>
}