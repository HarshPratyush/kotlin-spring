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

import org.nagarro.kotlinapi.model.Address
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.DataClassRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.core.namedparam.SqlParameterSource
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.jdbc.support.KeyHolder
import org.springframework.stereotype.Repository


@Repository
class JdbcAddressRepository(val jdbcTemplate: NamedParameterJdbcTemplate) : JdbcRepository<Address,Long> {
    override fun save(entity: Address): Long {
        val data: SqlParameterSource = BeanPropertySqlParameterSource(entity)
        val keyHolder: KeyHolder = GeneratedKeyHolder()
        jdbcTemplate.update(Address.INSERT_QUERY,data,keyHolder)
        return keyHolder.keys?.get("address_id") as Long
    }

    override fun save(entities: Iterable<Address>) {
        jdbcTemplate.batchUpdate(Address.INSERT_QUERY,entities.map {  BeanPropertySqlParameterSource(it)
        }.toTypedArray())
    }

    override fun findAll(): List<Address> {
        return  jdbcTemplate.query("SELECT * FROM ${Address.TABLE_NAME}", DataClassRowMapper.newInstance(Address::class.java))
    }

    override fun findById(id: Int): Address? {
        return try {
            val propMap:HashMap<String,Any> = HashMap();
            propMap["address"] = id;
            jdbcTemplate.
            queryForObject("SELECT * FROM ${Address.TABLE_NAME} where address_id = :address",propMap,DataClassRowMapper.newInstance(Address::class.java))
        }catch (exception: EmptyResultDataAccessException){null}
    }
}