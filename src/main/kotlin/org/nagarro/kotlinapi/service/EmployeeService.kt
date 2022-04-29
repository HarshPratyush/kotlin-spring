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

package org.nagarro.kotlinapi.service

import org.nagarro.kotlinapi.exceptions.DataNotFound
import org.nagarro.kotlinapi.model.Employee
import org.nagarro.kotlinapi.repository.JdbcAddressRepository
import org.nagarro.kotlinapi.repository.JdbcEmployeeRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EmployeeService(private val jdbcEmployeeRepository: JdbcEmployeeRepository,private  val jdbcAddressRepository: JdbcAddressRepository){

    val logger:Logger = LoggerFactory.getLogger("EmployeeService");
    fun getAllEmployee():List<Employee>{
        return  jdbcEmployeeRepository.findAll();
    }

    @Transactional
    fun saveEmployee(employee: Employee){
        logger.info("Saving employee with details $employee")
        employee.address?.let {
            val addressId =jdbcAddressRepository.save(it);
            employee.addressId = addressId
        }
        jdbcEmployeeRepository.save(employee)
    }

    @Transactional
    fun saveEmployee(employees: List<Employee>){
        employees.map { employee :Employee ->
            employee.address?.let {
                val addressId = jdbcAddressRepository.save(it);
                employee.addressId = addressId
            }
        }
        jdbcEmployeeRepository.save(employees);
    }

    fun getEmployeeById(id:Int):Employee{
        return jdbcEmployeeRepository.findById(id)?:throw DataNotFound(message = "Employee not found with id $id") ;
    }
}