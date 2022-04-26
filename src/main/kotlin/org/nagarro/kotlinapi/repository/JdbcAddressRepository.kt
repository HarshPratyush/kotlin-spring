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