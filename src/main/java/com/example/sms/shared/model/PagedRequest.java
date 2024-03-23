package com.example.sms.shared.model;

import org.springframework.data.domain.Sort;

/**
 * This class is used to pass pagination parameters to service level from controller. Later more parameters can be
 * added like search query parameters
 */
public class PagedRequest {

    private int page;
    private int pageSize;
    private String sortBy;
    private Sort.Direction sortDirection;

    public PagedRequest(int page, int pageSize, String sortBy, Sort.Direction sortDirection){
        this.page = page - 1; //page is 0 based in service level
        this.pageSize = pageSize;
        this.sortBy = sortBy;
        this.sortDirection = sortDirection;
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

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public Sort.Direction getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(Sort.Direction sortDirection) {
        this.sortDirection = sortDirection;
    }
}
