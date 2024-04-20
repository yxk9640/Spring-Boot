package com.restv2.rest_v2.Filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class FilterBean {
    private String filer1;
    private String filter2;

    @JsonIgnore
    private String filter3;

    public FilterBean(String filer1, String filter2, String filter3) {
        this.filer1 = filer1;
        this.filter2 = filter2;
        this.filter3 = filter3;
    }

    public String getFiler1() {
        return filer1;
    }

    public String getFilter2() {
        return filter2;
    }

    public String getFilter3() {
        return filter3;
    }

    public void setFiler1(String filer1) {
        this.filer1 = filer1;
    }

    public void setFilter2(String filter2) {
        this.filter2 = filter2;
    }

    public void setFilter3(String filter3) {
        this.filter3 = filter3;
    }
}
