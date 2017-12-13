package com.example.mvvm.data.helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.mvvm.data.model.Comic
import org.jetbrains.anko.db.*

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 12/13/17.
 */
class DatabaseHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "WayLocalDatabase", null, 1) {
    companion object {
        private var instance: DatabaseHelper? = null

        @Synchronized
        fun getInstance(context: Context): DatabaseHelper {
            if (instance == null) {
                instance = DatabaseHelper(context.applicationContext)
            }
            return instance!!
        }
    }

    override fun onCreate(database: SQLiteDatabase) {
        createTableComic(database)
    }

    override fun onUpgrade(database: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        dropTableComic(database)
    }

    private fun createTableComic(database: SQLiteDatabase) {
        database.createTable(Comic.TABLE_NAME, true, Comic.COLUMN_ID to TEXT,
                Comic.COLUMN_NAME to TEXT,
                Comic.COLUMN_CHAPTER_COUNT to TEXT,
                Comic.COLUMN_AUTHOR to TEXT,
                Comic.COLUMN_INTRO to TEXT,
                Comic.COLUMN_CHAPTER_NUMBER to TEXT,
                Comic.COLUMN_READ_COUNT to TEXT,
                Comic.COLUMN_LIKE_COUNT to TEXT)
    }

    private fun dropTableComic(database: SQLiteDatabase) {
        database.dropTable(Comic.TABLE_NAME, true)
    }

    fun insertComicWithArray(comics: MutableList<Comic>) {
        comics.forEach {
            use {
                with(it) {
                    insert(Comic.TABLE_NAME,
                            Comic.COLUMN_ID to storyId,
                            Comic.COLUMN_NAME to storyName,
                            Comic.COLUMN_CHAPTER_COUNT to chaptersCount,
                            Comic.COLUMN_AUTHOR to author,
                            Comic.COLUMN_INTRO to intro,
                            Comic.COLUMN_CHAPTER_NUMBER to numberOfChapters,
                            Comic.COLUMN_READ_COUNT to readCount,
                            Comic.COLUMN_LIKE_COUNT to likeCount)
                }
            }
        }
    }

    fun getComicWithCondition(queryData: String): MutableList<Comic> {
        val result = use {
            select(Comic.TABLE_NAME)
                    .whereArgs("${Comic.COLUMN_ID} like ($queryData)")
                    .exec {
                        parseList(classParser<Comic>())
                    }
        }
        return result as MutableList<Comic>
    }

    fun getAllComic(): MutableList<Comic> {
        val result = use {
            select(Comic.TABLE_NAME)
                    .exec {
                        parseList(classParser<Comic>())
                    }
        }
        return result as MutableList<Comic>
    }
}

val Context.wayDatabase: DatabaseHelper get() = DatabaseHelper.getInstance(applicationContext)
