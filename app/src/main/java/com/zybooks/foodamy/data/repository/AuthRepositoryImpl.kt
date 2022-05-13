package com.zybooks.foodamy.data.repository

import com.zybooks.foodamy.data.remote.AuthApi
import com.zybooks.foodamy.data.remote.response.auth.AuthResponse
import com.zybooks.foodamy.domain.repository.AuthRepository
import com.zybooks.foodamy.util.Resource
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val api: AuthApi
): AuthRepository {


    override suspend fun postLoginInfo(email: String, password: String): Resource<AuthResponse> {
        return try {
            val result = api.postLogin(email, password)
            Resource.Success(result)
        } catch (e: IOException){
            e.printStackTrace()
            Resource.Error(
                message = "Login failed"
            )

        } catch (e: HttpException){
            e.printStackTrace()
            Resource.Error(
                message = "Login Failed"
            )

        }
    }

    override suspend fun postRegisterInfo(
        email: String,
        password: String,
        username: String,
        name: String,
        surname: String,
        gender: String?,
        birthday: String?
    ): Resource<AuthResponse> {
        return try {
            val result = api.postRegister(email,password,username, name, surname, gender, birthday)
            Resource.Success(result)
        } catch (e: IOException){
            e.printStackTrace()
            Resource.Error(
                message = "Register failed"
            )

        } catch (e: HttpException){
            e.printStackTrace()
            Resource.Error(
                message = "Register Failed"
            )

        }
    }
}