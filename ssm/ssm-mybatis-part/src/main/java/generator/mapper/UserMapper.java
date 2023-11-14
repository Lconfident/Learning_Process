package generator.mapper;

import generator.com.atguigu.pojo.User;

/**
* @author www
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-11-13 17:02:40
* @Entity generator.com.atguigu.pojo.User
*/
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
