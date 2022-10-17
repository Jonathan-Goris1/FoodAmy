package com.zybooks.foodamy.data.repository

import com.zybooks.foodamy.data.local.dao.RecipeDao
import com.zybooks.foodamy.data.local.local_dto.RecipeDb
import com.zybooks.foodamy.data.remote.network_api.RecipeApi
import com.zybooks.foodamy.data.remote.response.recipe.RecipeResponse
import com.zybooks.foodamy.data.remote.response.recipe.DataResponse
import com.zybooks.foodamy.domain.repository.RecipeRepository
import com.zybooks.foodamy.util.Resource
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecipeRepositoryImpl @Inject constructor(
    private val api: RecipeApi,
    private val dao: RecipeDao

): RecipeRepository {

    private suspend fun getRecipeFromDatabase(): Resource<List<RecipeDb>>{
        return dao.getRecipeListing()

    }


    override suspend fun getRecipeInfo(recipeID: Int): Resource<DataResponse> {
        return try {
            val result = api.getRecipe(recipeID)
            Resource.Success(result)
        } catch (e: IOException){
            e.printStackTrace()
            Resource.Error(
                message = e.message.toString()
            )

        } catch (e: HttpException){
            e.printStackTrace()
            Resource.Error(
                message = e.message()
            )

        }
    }

    override suspend fun getEditorsChoiceInfo(): Resource<List<RecipeResponse>> {
        return try {
            val result = api.getEditorsChoice().recipe
            Resource.Success(result)
        } catch (e: IOException){
            e.printStackTrace()
            Resource.Error(
                message = e.message.toString()
            )

        } catch (e: HttpException){
            e.printStackTrace()
            Resource.Error(
                message = e.message()
            )

        }
    }
}