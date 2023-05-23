package com.luiz.thenews.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.luiz.thenews.data.model.Article


@TypeConverters(Converters::class)
@Database(entities = [Article::class], version = 1, exportSchema = false)
abstract class ArticleDatabase: RoomDatabase() {
    abstract fun getArticleDAO():ArticleDao
}