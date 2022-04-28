package com.ferdian.todocleanarchitecture.domain.login.usecase

import com.ferdian.todocleanarchitecture.data.common.utils.WrappedResponse
import com.ferdian.todocleanarchitecture.data.login.remote.dto.LoginRequest
import com.ferdian.todocleanarchitecture.data.login.remote.dto.LoginResponse
import com.ferdian.todocleanarchitecture.domain.common.base.BaseResult
import com.ferdian.todocleanarchitecture.domain.login.LoginRepository
import com.ferdian.todocleanarchitecture.domain.login.entitiy.LoginEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val loginRepository: LoginRepository){
    suspend fun execute(loginRequest: LoginRequest): Flow<BaseResult<LoginEntity, WrappedResponse<LoginResponse>>> {
        return loginRepository.login(loginRequest)
    }
}