package com.zybooks.foodamy.data.repository

import com.zybooks.foodamy.data.remote.LoginApi
import com.zybooks.foodamy.data.remote.response.LoginResponse
import com.zybooks.foodamy.domain.repository.LoginRepository
import com.zybooks.foodamy.util.Resource
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepositoryImpl @Inject constructor(
    private val api: LoginApi
): LoginRepository {


    override suspend fun postLoginInfo(email: String, password: String): Resource<LoginResponse> {
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
}