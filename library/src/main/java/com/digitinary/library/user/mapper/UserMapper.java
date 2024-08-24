package com.digitinary.library.user.mapper;

import com.digitinary.library.user.entity.User;
import com.digitinary.library.user.model.UserModel;

public class UserMapper {

    public static User toEntity(UserModel userModel){
        return User.builder()
                .userId(userModel.getUserId())
                .name(userModel.getName())
                .build();
    }

    public static UserModel toModel(User user){
        return UserModel.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .build();
    }

}
