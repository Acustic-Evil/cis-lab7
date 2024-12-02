package com.lab7.controller;

import com.lab7.entity.PathSegment;
import com.lab7.service.PathSegmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/path_segment")
@Tag(name = "Path Segment API", description = "API для работы с путями сегментов")
public class PathSegmentController {

    private final PathSegmentService pathSegmentService;

    public PathSegmentController(PathSegmentService pathSegmentService) {
        this.pathSegmentService = pathSegmentService;
    }

    @PostMapping
    @Operation(summary = "Добавить новый сегмент пути", description = "Добавляет новый путь в базу данных")
    public ResponseEntity<String> addPathSegment(@RequestBody PathSegment pathSegment) {
        pathSegmentService.addPathSegment(pathSegment);
        return ResponseEntity.ok("PathSegment added successfully!");
    }

    @PutMapping
    @Operation(summary = "Обновить сегмент пути", description = "Обновляет существующий путь в базе данных")
    public ResponseEntity<String> updatePathSegment(@RequestBody PathSegment pathSegment) {
        pathSegmentService.updatePathSegment(pathSegment);
        return ResponseEntity.ok("PathSegment updated successfully!");
    }

    @GetMapping
    @Operation(summary = "Получить все активные пути", description = "Возвращает список всех активных путей")
    public List<PathSegment> getActivePathSegments() {
        return pathSegmentService.getActivePathSegments();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Деактивировать путь", description = "Деактивирует путь по его идентификатору")
    public ResponseEntity<String> deactivatePathSegment(@PathVariable Long id) {
        pathSegmentService.deactivatePathSegment(id);
        return ResponseEntity.ok("PathSegment deactivated successfully!");
    }

    @DeleteMapping("/full_delete/{id}")
    @Operation(summary = "Удалить путь", description = "Полностью удаляет путь из базы данных")
    public ResponseEntity<String> deletePathSegment(@PathVariable Long id) {
        pathSegmentService.deletePathSegment(id);
        return ResponseEntity.ok("PathSegment deleted successfully!");
    }
}

