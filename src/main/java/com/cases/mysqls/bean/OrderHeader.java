package com.cases.mysqls.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="order_header")
public class OrderHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_header_generator")
    @SequenceGenerator(name="order_header_generator", sequenceName = "header_seq")
    @Column(name="headerid")
    private int headerId;
    @Column(name="order_number")
    private String orderNumber;
    @Temporal(TemporalType.DATE)
    @Column(name="last_update_date")
    private Date lastUpdateDate;
    @Temporal(TemporalType.TIME)
    @Column(name="creation_time")
    private Date creationTime;
    @Column(name="location")
    private String location;

    @OneToMany(mappedBy = "orderHeader",cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("lineId asc")
    private List<OrderLine> orderLine;

    public List<OrderLine> getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(List<OrderLine> orderLine) {
        this.orderLine = orderLine;
    }

    public OrderHeader() {

    }

    public int getHeaderId() {
        return headerId;
    }

    public void setHeaderId(int headerId) {
        this.headerId = headerId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
