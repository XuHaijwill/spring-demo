package com.shardingjdbc.model;

import java.io.Serializable;

public class TOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Integer userId;
    private Integer orderId;
    private String cloumn;
    private String dayDate;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getCloumn() {
        return cloumn;
    }

    public void setCloumn(String cloumn) {
        this.cloumn = cloumn;
    }

    public String getDayDate() {
        return dayDate;
    }

    public void setDayDate(String dayDate) {
        this.dayDate = dayDate;
    }
}
