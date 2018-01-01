package com.snowfish.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.snowfish.domain.PageBean;
import com.snowfish.domain.Student;

public interface StudentMapper {
	@Select("select * from t_student")
	public List<Student> findAll();
	
	@Select("select * from t_student where t_number=#{t_number}")
	public Student find(String t_number);
	
	@Delete("delete from t_student where t_number = #{t_number}")
	public void delete(String t_number);
	
	@Update("update t_student set t_desc = #{t_desc} "
			+ ", t_hobby=#{t_hobby} , t_major=#{t_major} , t_name=#{t_name} , "
			+ "t_sex=#{t_sex} , t_phone=#{t_phone} "
			+ "where t_number = #{t_number}")
	public void update(Student student);
	
	@Select("select count(*)  from t_student")
	public int getTotleRecoder();
	
	/**
	 * 
	 * @param currentPage  从那开始查询
	 * @param recoderForPage 查询多少记录 
	 * @return
	 */
	@Select("select * from t_student limit #{currentPage} , #{recoderForPage}")
	public List<Student> findAllByLimit(@Param("currentPage")int currentPage, 
			@Param("recoderForPage")int recoderForPage);
}
