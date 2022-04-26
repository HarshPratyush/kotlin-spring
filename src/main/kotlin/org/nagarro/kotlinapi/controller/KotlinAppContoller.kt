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

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class KotlinAppContoller {


    @GetMapping("hello")
    fun home():ResponseEntity<String>{
        return ResponseEntity.ok("Hello");
    }

    @GetMapping("sum")
    fun sum(@RequestParam("a") a:Int, @RequestParam("b") b :Int):ResponseEntity<Int>{
        return ResponseEntity.ok(a+b);
    }

    @GetMapping("getSumTill")
    fun sumTill(@RequestParam("a")a:Int,@RequestParam("b")b:Int):ResponseEntity<Void>{
        for(counter: Int in 1 until   b+1 step  1){
        println(counter)
        }
        return ResponseEntity.noContent().build();
    }
}