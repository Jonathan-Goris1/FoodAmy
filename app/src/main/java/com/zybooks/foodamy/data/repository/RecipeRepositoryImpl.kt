package com.zybooks.foodamy.data.repository

import com.zybooks.foodamy.data.remote.RecipeApi
import com.zybooks.foodamy.data.remote.response.recipe.Data
import com.zybooks.foodamy.data.remote.response.recipe.RecipeResponse
import com.zybooks.foodamy.domain.repository.RecipeRepository
import com.zybooks.foodamy.util.Resource
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecipeRepositoryImpl @Inject constructor(
    private val api: RecipeApi
): RecipeRepository {


    override suspend fun getRecipeInfo(recipeID: Int): Resource<RecipeResponse> {
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

    override suspend fun getEditorsChoiceInfo(): Resource<List<Data>> {
        return try {
            val result = api.getEditorsChoice().data
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