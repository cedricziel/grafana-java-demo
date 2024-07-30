package com.example.otelspringdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.ui.Model;

@SpringBootApplication
@Controller
class OtelSpringDemoApplication {
    @GetMapping("/")
    fun index(@RequestParam(name="name", required=false, defaultValue="World") name: String, model: Model): String {
        model.addAttribute("name", name);

        return "index"
    }

    // json endpoint
    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): Map<String, String> {
        return mapOf("greeting" to "Hello, $name")
    }
}

fun main(args: Array<String>) {
    runApplication<OtelSpringDemoApplication>(*args)
}
