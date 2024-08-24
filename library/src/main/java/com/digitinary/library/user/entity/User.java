package com.digitinary.library.user.entity;

import com.digitinary.library.catalog.entity.Book;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Users")
public class User {

    @EmbeddedId
    private UserId userId;

    @Column(name = "name")
    private String name;

}
