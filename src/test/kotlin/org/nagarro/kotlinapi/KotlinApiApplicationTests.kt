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
package org.nagarro.kotlinapi

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.nagarro.kotlinapi.model.Address
import org.nagarro.kotlinapi.model.Employee
import org.nagarro.kotlinapi.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.time.LocalDate

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@TestMethodOrder(value = MethodOrderer.OrderAnnotation::class)
class KotlinApiApplicationTests {

	@Autowired
	var employeeService: EmployeeService?=null;

	@Test
	fun contextLoads() {
	}

	@Test
	@Order(1)
	fun  createEmployee(){
		val employee:Employee = Employee(firstName = "Harsh", lastName = "Pratyush" ,
			contactNumber = "7684876516", dob = LocalDate.parse("1994-06-12"), email = "harsh@gmail.com", addressId = null, middleName = null, employeeId = null)
		employee.address = Address(state = "Jharkhand", city = "Ranchi",
			street1 = "Street1", street2 = "street2", pincode = "abcd", country = "India", addressId = null, street3 = null)
		employeeService!!.saveEmployee(employee);
	}

	@Test
	@Order(2)
	fun getAllEmployee(){
		val employee:Employee = employeeService!!.getEmployeeById(1);
		assert(employee.firstName == "Harsh")
	}

}
