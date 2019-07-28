/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cornerstone.utilities;

/**
 *
 * @author Kornel
 */
public class TableHelper {
    private int rowNum;
    private int colNum;

    public TableHelper(int rowNum, int colNum) {
        this.rowNum = rowNum;
        this.colNum = colNum;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getColNum() {
        return colNum;
    }

    public void setColNum(int colNum) {
        this.colNum = colNum;
    }
    
    
}

