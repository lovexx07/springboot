package net.xdclass.demo2.mapper;

import net.xdclass.demo2.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    /**
     * 推荐使用  #{} 取值， 不使用${} 避免注入风险
     * @param user
     * @return
     */
    @Insert("INSERT INTO user(name, phone, create_time, age) VALUES(#{name}, #{phone}, #{createTIme}, #{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id") //keyProperty java对象属性  keyColumn数据库字段
    int insert(User user);

    @Select("SELECT * FROM user")
    @Results({
            @Result(column = "create_time", property = "createTIme")
    })
    List<User> getAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(column = "create_time", property = "createTIme")
    })
    User findById(Long id);

    @Update("UPDATE user SET name=#{name} WHERE id = #{id}")
    void update(User user);


    @Delete("DELETE FROM user WHERE id = #{userId}")
    void delete(Long userId);
}
