package com.digitinary.library.user.model;

import com.digitinary.library.user.entity.UserId;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    private UserId userId;

    private String name;
}
