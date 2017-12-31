package com.snowfish.mybatis;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

public interface StudentMapper {

	public Student findById(Integer id);

	@Select("SELECT * FROM s_student WHERE s_age = #{s_age}")
	public  Student fingByAge(Integer age);

	@Delete("DELETE FROM s_student WHERE s_id = #{s_id}")
	public Boolean deleteById(Long id);
}
