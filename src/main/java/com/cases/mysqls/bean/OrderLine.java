package com.cases.mysqls.bean;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
@Entity
@Table(name="order_line")
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_line_generator")
    @SequenceGenerator(name="order_line_generator", sequenceName = "line_seq")
    @Column(name="lineid")
    private int lineId;

    public OrderHeader getOrderHeader() {
        return orderHeader;
    }

    public void setOrderHeader(OrderHeader orderHeader) {
        this.orderHeader = orderHeader;
    }

    @Column(name="item_number")
    private String itemNumber;
    @Column(name="quantity")
    private int quantity;
    @Column(name="unit")
    private BigDecimal unitPrice;


    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "line_header_id")
    private OrderHeader orderHeader;

    public int getLineId() {
        return lineId;
    }

    public void setLineId(int lineId) {
        this.lineId = lineId;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public OrderLine() {

    }
}
