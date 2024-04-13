package org.example.demo.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.demo.Services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
@Tag(name = "Аутентифікація")
public class ExampleController {
    private final UserService service;

    @GetMapping
    @Operation(summary = "Доступний лише авторизованим користувачам")
    public String example() {
        return "Привіт, світ!";
    }

    @GetMapping("/admin")
    @Operation(summary = "Доступний лише авторизованим користувачам з роллю ADMIN")
    @PreAuthorize("hasRole('ADMIN')")
    public String exampleAdmin() {
        return "Привіт, адміністраторе!";
    }

    @GetMapping("/get-admin")
    @Operation(summary = "Отримати роль ADMIN (для демонстрації)")
    public void getAdmin() {
        service.getAdmin();
    }
}
