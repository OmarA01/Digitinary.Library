package com.digitinary.library.catalog.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BookId")
public class BookId {
    @Id
    private Integer bookId;
}
