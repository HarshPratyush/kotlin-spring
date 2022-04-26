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
package org.nagarro.kotlinapi.controller

import org.nagarro.kotlinapi.model.Employee
import org.nagarro.kotlinapi.service.EmployeeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RequestMapping("employees")
@RestController
class EmployeeController (private val employeeService: EmployeeService){


    @GetMapping("")
    fun getAllEmployees():ResponseEntity<List<Employee>>{
        return ResponseEntity.ok(employeeService.getAllEmployee())
    }

    @PostMapping
    fun saveEmployee(@RequestBody employee: Employee):ResponseEntity<Void>{
        employeeService.saveEmployee(employee)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("{employeeId}")
    fun getEmployee(@PathVariable("employeeId")employeeId:Int):ResponseEntity<Employee>{
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId))
    }

    @PostMapping("bulkSave")
    fun saveEmployee(@RequestBody employee: List<Employee>):ResponseEntity<Void>{
        employeeService.saveEmployee(employee)
        return ResponseEntity.noContent().build()
    }
}