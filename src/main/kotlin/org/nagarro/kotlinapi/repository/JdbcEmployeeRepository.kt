package org.nagarro.kotlinapi.repository

import org.nagarro.kotlinapi.model.Employee
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.DataClassRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class JdbcEmployeeRepository(val jdbcTemplate:JdbcTemplate) : JdbcRepository<Employee>{

    override fun save(entity: Employee): Int {
     return   jdbcTemplate.update(entity.getInsertQuery())
    }

    override fun save(entities: Iterable<Employee>) {
        jdbcTemplate.batchUpdate(entities.map(Employee::getInsertQuery)[entities.count()])
    }

    override fun findAll(): List<Employee> {
        return  jdbcTemplate.query("SELECT * FROM ${Employee.TABLE_NAME}",DataClassRowMapper.newInstance(Employee::class.java))
    }

    override fun findById(id: Int): Employee? {
        return try {
            jdbcTemplate.
            queryForObject("SELECT * FROM ${Employee.TABLE_NAME} where employee_id = ?",DataClassRowMapper.newInstance(Employee::class.java),id)
        }catch (exception:EmptyResultDataAccessException){null}
    }
}