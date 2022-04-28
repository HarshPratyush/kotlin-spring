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
package org.nagarro.kotlinapi.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.text.MessageFormat
import java.time.LocalDate
import java.time.Period

data class Employee(val employeeId:Int?,val firstName: String,val lastName:String,
                    val middleName:String?,val dob:LocalDate,val contactNumber: String,
                    val email:String,var addressId:Long?){

    var address:Address?=null;

    companion object{
        const val TABLE_NAME = "employee";
        const val INSERT_QUERY = "INSERT INTO  $TABLE_NAME (first_name, last_name, middle_name, dob, contact_number, email,address_id) VALUES(:firstName, :lastName, :middleName, :dob, :contactNumber, :email,:addressId);";
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Employee

        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (middleName != other.middleName) return false
        if (dob != other.dob) return false
        if (contactNumber != other.contactNumber) return false
        if (email != other.email) return false
        if (addressId != other.addressId) return false


        return true
    }

    override fun hashCode(): Int {
        var result = firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + (middleName?.hashCode() ?: 0)
        result = 31 * result + dob.hashCode()
        result = 31 * result + contactNumber.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + (addressId?.hashCode()?:0)
        return result
    }

    override fun toString(): String {
        return "Employee(firstName='$firstName', lastName='$lastName', middleName=$middleName, dob=$dob, contactNumber='$contactNumber', email='$email', addressId = '$addressId' )"
    }

    fun getAge():String{
        val currentDate = LocalDate.now();
        val agePeriod:Period = dob.until(currentDate)
        return "${agePeriod.years} Years ${agePeriod.months} Months"
    }
}
