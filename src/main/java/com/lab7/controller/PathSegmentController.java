package com.lab7.controller;

import com.lab7.entity.PathSegment;
import com.lab7.service.PathSegmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/path_segment")
public class PathSegmentController {

    private final PathSegmentService pathSegmentService;

    public PathSegmentController(PathSegmentService pathSegmentService) {
        this.pathSegmentService = pathSegmentService;
    }

    @PostMapping
    public void addPathSegment(@RequestBody PathSegment pathSegment) {
        System.out.println(pathSegment);
        pathSegmentService.addPathSegment(pathSegment);
    }

    @PutMapping
    public void updatePathSegment(@RequestBody PathSegment pathSegment) {
        pathSegmentService.updatePathSegment(pathSegment);
    }

    @GetMapping
    public List<PathSegment> getActivePathSegments() {
        return pathSegmentService.getActivePathSegments();
    }

    @DeleteMapping("/{id}")
    public void deactivatePathSegment(@PathVariable Long id) {
        pathSegmentService.deactivatePathSegment(id);
    }

    @DeleteMapping("/full_delete/{id}")
    public void deletePathSegment(@PathVariable Long id) {
        pathSegmentService.deletePathSegment(id);
    }
}
