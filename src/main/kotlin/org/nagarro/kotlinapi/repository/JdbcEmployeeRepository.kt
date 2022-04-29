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
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.core.namedparam.SqlParameterSource
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.jdbc.support.KeyHolder
import org.springframework.stereotype.Repository

@Repository
class JdbcEmployeeRepository(val jdbcTemplate: NamedParameterJdbcTemplate) : JdbcRepository<Employee,Long>{

    override fun save(entity: Employee): Long {
        val data: SqlParameterSource = BeanPropertySqlParameterSource(entity)
        val keyHolder: KeyHolder = GeneratedKeyHolder()
        jdbcTemplate.update(Employee.INSERT_QUERY,data,keyHolder)
        return keyHolder.keys?.get("employee_id") as Long

    }

    override fun save(entities: Iterable<Employee>) {
        jdbcTemplate.batchUpdate(Employee.INSERT_QUERY,entities.map {employee : Employee -> BeanPropertySqlParameterSource(employee) }.toTypedArray())
    }

    override fun findAll(): List<Employee> {
        return  jdbcTemplate.query("SELECT * FROM ${Employee.TABLE_NAME}",DataClassRowMapper.newInstance(Employee::class.java))
    }

    override fun findById(id: Int): Employee? {
        return try {
            val propMap:HashMap<String,Any> = HashMap();
            propMap["employeeId"] = id;
            jdbcTemplate.
            queryForObject("SELECT * FROM ${Employee.TABLE_NAME} where employee_id = :employeeId",propMap,DataClassRowMapper.newInstance(Employee::class.java))
        }catch (exception:EmptyResultDataAccessException){null}
    }
}