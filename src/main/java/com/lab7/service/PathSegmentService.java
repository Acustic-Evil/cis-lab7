package com.lab7.service;

import com.lab7.entity.PathSegment;
import com.lab7.mapper.PathSegmentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PathSegmentService {

    private final PathSegmentMapper pathSegmentMapper;

    public PathSegmentService(PathSegmentMapper pathSegmentMapper) {
        this.pathSegmentMapper = pathSegmentMapper;
    }

    public void addPathSegment(PathSegment pathSegment) {
        pathSegmentMapper.insertPathSegment(pathSegment);
    }

    public void updatePathSegment(PathSegment pathSegment) {
        pathSegmentMapper.updatePathSegment(pathSegment);
    }

    public List<PathSegment> getActivePathSegments() {
        return pathSegmentMapper.getActivePathSegments();
    }

    public void deactivatePathSegment(Long id) {
        pathSegmentMapper.deactivatePathSegment(id);
    }

    public void deletePathSegment(Long id) {
        pathSegmentMapper.deletePathSegment(id);
    }

    public List<PathSegment> getAllPathSegments() {
       return pathSegmentMapper.getAllPathSegments();
    }

    public List<PathSegment> getInactivePathSegments() {
        return pathSegmentMapper.getInactivePathSegments();
    }

}
