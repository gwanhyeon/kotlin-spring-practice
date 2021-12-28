package com.kgh.kotlinspringpractice.controller.response

import com.kgh.kotlinspringpractice.model.UserRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/status")
class ResponseApiController {

    // 1. get 4xx

    @GetMapping("/v1")
    fun v1(@RequestParam age: Int?): ResponseEntity<String>{
        /* method 2 */
        return age?.let {
            // param not null
            if(it < 20){
                return ResponseEntity.status(400).body("bad request params")
            }
            ResponseEntity.ok("OK")
        }?: kotlin.run {
            return ResponseEntity.status(400).body("Incorrect request params")
        }
        /* method 1
        println(age)
        // param == null -> 400
        if(age == null){
            // ResponseEntity.badRequest().body("fail")
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("bad request params ")
        }
        // param -> 20 -> 400 error
        if(age < 20){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect request params ")
        }
        return ResponseEntity.ok("correct request params");
         */

    }

    // 2. post 200 object mapper -> object -> json
    @PostMapping("/v2")
    fun v2(@RequestBody userRequest: UserRequest?): ResponseEntity<Any>{
        return ResponseEntity.status(200).body(userRequest)
    }

    // 3. put 201

    @PutMapping("/v3")
    fun v3(@RequestBody userRequest: UserRequest?): ResponseEntity<UserRequest>{
        return ResponseEntity.status(HttpStatus.CREATED).body(userRequest)
    }

    // 4. delete 500

    @DeleteMapping("/v4/{id}")
    fun v4(@PathVariable id:Int): ResponseEntity<Any>{
        return ResponseEntity.status(500).body(null);
    }

}