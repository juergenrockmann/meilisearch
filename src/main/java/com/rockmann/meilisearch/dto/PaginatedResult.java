package com.rockmann.meilisearch.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaginatedResult<T> {

    private int page;
    private int size;
    private long totalElements;
    private long totalPages;
    private List<T> data;


    public static <T> PaginatedResult<T> of(int page, int pageSize, long total, long totalPages, List<T> data) {
        return new PaginatedResult<>(page, pageSize, total, totalPages, data);
    }
}