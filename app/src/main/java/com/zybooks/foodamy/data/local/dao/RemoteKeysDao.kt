package com.zybooks.foodamy.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zybooks.foodamy.data.local.local_dto.RemoteKeyComment
import com.zybooks.foodamy.data.local.local_dto.RemoteKeysCategory
import com.zybooks.foodamy.data.local.local_dto.RemoteKeysEditor

@Dao
interface RemoteKeysDao {

    // EditorChoices Recipes Remote Keys
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEditorRemoteKeys(remoteKeys: List<RemoteKeysEditor>)

    @Query("select * from remote_keys_editor where id =:id")
    suspend fun getEditorRemoteKeys(id: Int): RemoteKeysEditor

    @Query("delete from remote_keys_editor")
    suspend fun deleteEditorKeys()



    // Recipe Comments Remote Key
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCommentsRemoteKeys(remoteKeys: List<RemoteKeyComment>)

    @Query("select * from remote_key_comments where id =:id")
    suspend fun getCommentsRemoteKey(id: Int): RemoteKeyComment

    @Query("delete from remote_key_comments")
    suspend fun deleteCommentsRemoteKeys()

    // Category Recipes Remote Key
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategoryRecipesRemoteKeys(remoteKeys: List<RemoteKeysCategory>)

    @Query("select * from remote_keys_category where id =:id")
    suspend fun getCategoryRemoteKeys(id: Int): RemoteKeysCategory

    @Query("delete from remote_keys_category")
    suspend fun deleteCategoryRecipesKeys()


}