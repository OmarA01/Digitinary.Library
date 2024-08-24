package com.digitinary.library.loaning.mapper;

import com.digitinary.library.catalog.mapper.BookMapper;
import com.digitinary.library.loaning.entity.Loan;
import com.digitinary.library.loaning.model.LoanModel;
import com.digitinary.library.user.mapper.UserMapper;

public class LoanMapper {

    public static Loan toEntity(LoanModel loanModel){
        return Loan.builder()
                .loanId(loanModel.getLoanId())
                .user(UserMapper.toEntity(loanModel.getUser()))
                .book(BookMapper.toEntity(loanModel.getBook()))
                .loanDate(loanModel.getLoanDate())
                .dueDate(loanModel.getDueDate())
                .returnDate(loanModel.getReturnDate())
                .status(loanModel.getStatus())
                .build();
    }

    public static LoanModel toModel(Loan loan){
        return LoanModel.builder()
                .loanId(loan.getLoanId())
                .user(UserMapper.toModel(loan.getUser()))
                .book(BookMapper.toModel(loan.getBook()))
                .loanDate(loan.getLoanDate())
                .dueDate(loan.getDueDate())
                .returnDate(loan.getReturnDate())
                .status(loan.getStatus())
                .build();
    }

}
