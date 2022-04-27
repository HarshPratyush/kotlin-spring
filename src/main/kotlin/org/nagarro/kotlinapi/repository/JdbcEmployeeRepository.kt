/**
 * Copyright 2022 Harsh Pratyush

 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at

 * http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.nagarro.kotlinapi.repository

import org.nagarro.kotlinapi.model.Employee
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.DataClassRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class JdbcEmployeeRepository(val jdbcTemplate:JdbcTemplate) : JdbcRepository<Employee,Int>{

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