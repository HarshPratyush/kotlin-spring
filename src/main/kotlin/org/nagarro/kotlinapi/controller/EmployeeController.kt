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