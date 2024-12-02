package com.lab7.mapper;

import com.lab7.entity.PathSegment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PathSegmentMapper {

    @Insert("INSERT INTO path_segment (id, path_length, path_name, is_active) VALUES (#{id}, #{pathLength}, #{pathName}, #{isActive})")
    void insertPathSegment(PathSegment pathSegment);

    @Update("UPDATE path_segment SET path_name = #{pathName}, path_length = #{pathLength}, is_active = #{isActive} WHERE id = #{id}")
    void updatePathSegment(PathSegment pathSegment);

    @Select("SELECT * FROM path_segment WHERE is_active = TRUE")
    @Results({
            @Result(property = "pathLength", column = "path_length"),
            @Result(property = "pathName", column = "path_name"),
            @Result(property = "isActive", column = "is_active")
    })
    List<PathSegment> selectActivePathSegments();

    @Update("UPDATE path_segment SET is_active = FALSE WHERE id = #{id}")
    void deactivatePathSegment(Long id);

    @Delete("DELETE FROM path_segment WHERE id = #{id}")
    void deletePathSegment(Long id);

}
