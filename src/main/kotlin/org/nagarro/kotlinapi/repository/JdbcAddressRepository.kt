package org.nagarro.kotlinapi.repository

import org.nagarro.kotlinapi.model.Address
import org.nagarro.kotlinapi.model.Employee
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class JdbcAddressRepository(val jdbcTemplate: JdbcTemplate) : JdbcRepository<Address> {
    override fun save(entity: Address): Int {
        TODO("Not yet implemented")
    }

    override fun save(entities: Iterable<Address>) {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Address> {
        TODO("Not yet implemented")
    }

    override fun findById(id: Int): Address? {
        TODO("Not yet implemented")
    }
}