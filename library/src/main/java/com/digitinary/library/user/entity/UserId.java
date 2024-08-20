package com.digitinary.library.user.entity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Embeddable
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "UserId")
public class UserId {
    @Id
    private Integer userId;
}
