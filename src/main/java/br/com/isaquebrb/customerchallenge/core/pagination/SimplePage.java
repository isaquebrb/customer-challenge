package br.com.isaquebrb.customerchallenge.core.pagination;

import lombok.Getter;

import java.util.List;

@Getter
public class SimplePage<T> {

    private final List<T> content;
    private final Pageable pageable;

    public SimplePage(List<T> content, Integer pageNumber, Integer pageSize, Long totalElements) {
        this.content = content;
        this.pageable = new Pageable(pageNumber, pageSize, content.size(), totalElements);
    }

    @Getter
    public static class Pageable {
        private final Integer pageNumber;
        private final Integer pageSize;
        private final Integer pageElements;
        private final Long totalElements;

        public Pageable(Integer pageNumber, Integer pageSize, Integer pageElements, Long totalElements) {
            this.pageNumber = pageNumber;
            this.pageSize = pageSize;
            this.pageElements = pageElements;
            this.totalElements = totalElements;
        }
    }
}