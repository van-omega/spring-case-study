package com.example.casestudy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BorrowersReport {
    private String bookTitle;
    private String authorName;
    private String borrowedBy;
    private String expectedReturnDate;
}
