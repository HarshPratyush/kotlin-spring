package org.nagarro.kotlinapi.repository

interface JdbcRepository<T> {

    fun save(entity:T):Int;

    fun findAll():List<T>;

    fun findById(id:Int):T?;

    fun save(entities:Iterable<T>)
}