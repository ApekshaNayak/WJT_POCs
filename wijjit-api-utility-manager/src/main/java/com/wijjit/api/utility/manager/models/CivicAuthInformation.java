package com.wijjit.api.utility.manager.models;

import com.wijjit.api.utility.manager.constants.CivicDataType;

import java.util.List;

public class CivicAuthInformation {
    private final CivicDataType civicDataType=CivicDataType.AUTH;
    private List<Data> dataList;

    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }

}
