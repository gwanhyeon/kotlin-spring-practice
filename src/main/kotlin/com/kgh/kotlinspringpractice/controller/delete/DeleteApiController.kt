package com.kgh.kotlinspringpractice.controller.delete

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class DeleteApiController {
    // path variable
    @DeleteMapping(path =["/v1"])
    fun deleteMapping(
        @RequestParam(value="name") _name: String,
        @RequestParam(value="age") _age: Int
    ): String {
        println(_name)
        println(_age)
        return _name + " " + _age;
    }
    // request params
    @DeleteMapping(path = ["/v2/name/{name}/age/{age}"])
    fun deleteMappingPath(@PathVariable(value="name") _name: String, @PathVariable(value="age") _age: Int): String{
        println(_name)
        println(_age)
        return _name + " " + _age;
    }
}