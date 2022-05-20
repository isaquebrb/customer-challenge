package br.com.isaquebrb.customerchallenge.adapter.presenter.pagination;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class SimplePage<T> {

    List<T> content;
    SimplePageable pageable;

    public SimplePage(Page<T> page) {
        this.content = page.getContent();
        this.pageable = new SimplePageable(page.getPageable().getPageNumber(),
                page.getPageable().getPageSize(), page.getContent().size(),
                page.getTotalElements());
    }

    @Getter
    static class SimplePageable {
        int pageNumber;
        int pageSize;
        int pageElements;
        long totalElements;

        public SimplePageable(int pageNumber, int pageSize, int pageElements, long totalElements) {
            this.pageNumber = pageNumber;
            this.pageSize = pageSize;
            this.pageElements = pageElements;
            this.totalElements = totalElements;
        }
    }
}