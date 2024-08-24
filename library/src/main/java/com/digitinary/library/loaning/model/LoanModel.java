package com.digitinary.library.loaning.model;

import com.digitinary.library.catalog.model.BookModel;
import com.digitinary.library.loaning.entity.LoanStatus;
import com.digitinary.library.user.model.UserModel;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanModel {

    private Integer loanId;

    private UserModel user;

    private BookModel book;

    private LocalDate loanDate;

    private LocalDate dueDate;

    private LocalDate returnDate;

    private LoanStatus status;
}
