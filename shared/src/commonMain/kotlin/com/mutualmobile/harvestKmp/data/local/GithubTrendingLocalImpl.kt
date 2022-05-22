package com.mutualmobile.harvestKmp.data.local

import com.mutualmobile.harvestKmp.db.BaseIoDB
import com.mutualmobile.harvestKmp.db.asFlow
import com.mutualmobile.harvestKmp.db.mapToList
import com.mutualmobile.harvestKmp.domain.model.GithubReposItem
import com.squareup.sqldelight.db.SqlDriver
import db.Trending_repos
import kotlinx.coroutines.flow.Flow

class GithubTrendingLocalImpl(override var driver: SqlDriver? = null) : GithubTrendingLocal {
    private val database by lazy { BaseIoDB(driver!!) }
    private val dbQuery by lazy { database.baseIoDBQueries }

    fun clearDatabase() {
        dbQuery.transaction {
            dbQuery.deleteAllRepos()
        }
    }

    override fun getAll(): Flow<List<Trending_repos>> {
        return dbQuery.selectAllRepos().asFlow().mapToList()
    }

    override fun saveRepos(input: List<GithubReposItem>) {
        dbQuery.transaction {
            dbQuery.deleteAllRepos()
            input.forEach {
                dbQuery.insertRepo(
                    uid = it.author + it.url,
                    author = it.author,
                    avatar = it.avatar,
                    description = it.description,
                    language = it.language,
                    name = it.name,
                    url = it.url
                )
            }
        }
    }
}