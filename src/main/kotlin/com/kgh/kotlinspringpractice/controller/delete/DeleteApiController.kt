package com.kgh.kotlinspringpractice.controller.delete

import org.jetbrains.annotations.NotNull
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.Min

@RestController
@RequestMapping("/api")
@Validated
class DeleteApiController {
    // path variable
    @DeleteMapping(path =["/v1"])
    fun deleteMapping(
        @RequestParam(value="name") _name: String,
        @NotNull("The value is missing")
        @Min(value=20, message = "It has to be greater than 20" )
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