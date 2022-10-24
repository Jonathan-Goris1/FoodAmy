package com.zybooks.foodamy.data.local.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.zybooks.foodamy.data.local.local_dto.ImageDb

//@ProvidedTypeConverter
//class ImageListConverter {
//
//    @TypeConverter
//    fun imageListToJson(images: List<ImageDb>): String {
//        return toJson<List<ImageDb>>(images)
//    }
//
//    @TypeConverter
//    fun jsonToImageList(imageListSrc: String): List<ImageDb> {
//        return fromJson(imageListSrc)
//    }
//}