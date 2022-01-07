package com.kgh.kotlinspringpractice.controller.delete


import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@RestController
@RequestMapping("/api")
@Validated
class DeleteApiController {
    // path variable
    @DeleteMapping(path =["/v1"])
    fun deleteMapping(

        @RequestParam(value="name") _name: String,
        @NotNull(message = "The value is missing")
        @Min(value=20, message = "It has to be greater than 20" )
        @RequestParam(value="age") _age: Int
    ): String {
        println(_name)
        println(_age)
        return _name + " " + _age;
    }
    // request params
    @DeleteMapping(path = ["/v2/name/{name}/age/{age}"])
    fun deleteMappingPath(@PathVariable(value="name")
        @Size(min = 2, max = 5)
        @Min(value = 10, message = "It has to be greater than 10")
        @NotNull
        _name: String,

        @NotNull(message = "The value is missing")
        @Min(value = 20, message = "It has to be grater than 20")
        @PathVariable(value="age") _age: Int): String{
        println(_name)
        println(_age)
        return _name + " " + _age;
    }
}