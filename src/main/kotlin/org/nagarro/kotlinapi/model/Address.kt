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

data class Address(val addressId:Int?,val street1:String,val street2:String,val street3:String?,
                   val city:String, val state:String,
                   val country:String, val pincode:String){

    companion object{
        const val TABLE_NAME = "address";
        const val INSERT_QUERY = "INSERT INTO  $TABLE_NAME (street1, street2, street3, city, state, country,pincode) VALUES(:street1, :street2, :street3, :city, :state, :country,:pincode);";
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Address

        if (street1 != other.street1) return false
        if (street2 != other.street2) return false
        if (street3 != other.street3) return false
        if (city != other.city) return false
        if (state != other.state) return false
        if (country != other.country) return false
        if (pincode != other.pincode) return false

        return true
    }

    override fun hashCode(): Int {
        var result = street1.hashCode()
        result = 31 * result + street2.hashCode()
        result = 31 * result + (street3?.hashCode() ?: 0)
        result = 31 * result + city.hashCode()
        result = 31 * result + state.hashCode()
        result = 31 * result + country.hashCode()
        result = 31 * result + pincode.hashCode()
        return result
    }

    override fun toString(): String {
        return "Address(street1='$street1', street2='$street2', street3=$street3, city='$city', state='$state', country='$country', pincode='$pincode')"
    }

//    @JsonIgnore
//    fun getInsertQuery():String{
//        return  MessageFormat.format(
//            Address.INSERT_QUERY,"'${this.street1}'","'${this.street2}'",
//            "'${this.street3}'","'${this.city}'","'${this.state}'","'${this.country}', ${this.pincode}")
//    }

}
