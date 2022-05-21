package br.com.isaquebrb.customerchallenge.core.pagination;

import lombok.Getter;

import java.util.List;

@Getter
public class SimplePage<T> {

    private final List<T> content;
    private final SimplePageable pageable;

    public SimplePage(List<T> content, int pageNumber, int pageSize, long totalElements) {
        this.content = content;
        this.pageable = new SimplePageable(pageNumber, pageSize, content.size(), totalElements);
    }

    @Getter
    public static class SimplePageable {
        private final int pageNumber;
        private final int pageSize;
        private final int pageElements;
        private final long totalElements;

        public SimplePageable(int pageNumber, int pageSize, int pageElements, long totalElements) {
            this.pageNumber = pageNumber;
            this.pageSize = pageSize;
            this.pageElements = pageElements;
            this.totalElements = totalElements;
        }
    }
}