package com.guoxuezhishi.pojo.wechat;

/**
 * @author: jiang
 * @date: 2019/12/2
 */
public class ReadExcel {
    //总行数
    private int totalRows = 0;

    //总条数
    private int totalCells = 0;

    //错误信息的收集类
    private String errorMsg;

    @Override
    public String toString() {
        return "ReadExcel{" +
                "totalRows=" + totalRows +
                ", totalCells=" + totalCells +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalCells() {
        return totalCells;
    }

    public void setTotalCells(int totalCells) {
        this.totalCells = totalCells;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
