package com.example.kmptemplate.sqldelight

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.example.kmptemplate.AppDatabase
import com.example.kmptemplate.models.TestObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow

interface CacheData{
    fun addToTest(testObject: TestObject)
    fun getAllFromTest(): Flow<List<TestObject>>
}

class CacheDataImpl(
    databaseDriverFactory: DatabaseDriverFactory
): CacheData {

    private val database = AppDatabase( databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries
    override fun addToTest(testObject: TestObject) {
        dbQuery.insertIntoTest(testObject.id, testObject.name)
    }

    override fun getAllFromTest(): Flow<List<TestObject>> =
        dbQuery.selectAll(::TestObject)
            .asFlow()
            .mapToList(Dispatchers.IO)

}