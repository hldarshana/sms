package com.example.sms.shared.model;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * This generic class is used to expose paginated data through api responses
 * @param <T>
 */
public class PagedResponse<T> {

    private List<T> content;
    private int page;
    private int pageSize;
    private int totalPages;
    private long totalElements;
    private boolean first;
    private boolean last;
    private String sortBy;
    private String sortDirection;

    public PagedResponse(Page<T> page, String sortBy, String sortDirection){
        this.content = page.getContent();
        this.page = page.getNumber() + 1;//page is 0 based in service level
        this.pageSize = page.getSize();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.first = page.isFirst();
        this.last = page.isLast();
        this.sortBy = sortBy;
        this.sortDirection = sortDirection;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }
}
