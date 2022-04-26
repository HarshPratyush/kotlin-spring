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