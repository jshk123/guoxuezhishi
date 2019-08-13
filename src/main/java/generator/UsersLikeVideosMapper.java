package generator;

import generator.UsersLikeVideos;

public interface UsersLikeVideosMapper {
    int deleteByPrimaryKey(String id);

    int insert(UsersLikeVideos record);

    int insertSelective(UsersLikeVideos record);

    UsersLikeVideos selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UsersLikeVideos record);

    int updateByPrimaryKey(UsersLikeVideos record);
}