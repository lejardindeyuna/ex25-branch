package com.yac.ex25_branch.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yac.ex25_branch.domain.Student;

@Mapper
public interface StudentMapper {

	//@Select("SELECT * FROM student ORDER BY #{id} DESC")
	List<Student> findAll();

	Student findById(Long id);

	void insert(Student student);

	void update(Student student);

	void delete(Long id);
}
