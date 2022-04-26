package org.nagarro.kotlinapi.service

import org.nagarro.kotlinapi.exceptions.DataNotFound
import org.nagarro.kotlinapi.model.Employee
import org.nagarro.kotlinapi.repository.JdbcEmployeeRepository
import org.springframework.stereotype.Service

@Service
class EmployeeService(private val jdbcEmployeeRepository: JdbcEmployeeRepository){

    fun getAllEmployee():List<Employee>{
        return  jdbcEmployeeRepository.findAll();
    }

    fun saveEmployee(employee: Employee){
        jdbcEmployeeRepository.save(employee);
    }

    fun saveEmployee(employee: List<Employee>){
        jdbcEmployeeRepository.save(employee);
    }

    fun getEmployeeById(id:Int):Employee{
        return jdbcEmployeeRepository.findById(id)?:throw DataNotFound(message = "Employee not found with id $id") ;
    }
}