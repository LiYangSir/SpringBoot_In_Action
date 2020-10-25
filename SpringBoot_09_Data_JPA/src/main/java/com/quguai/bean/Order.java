package com.quguai.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ordertime;

    private Long total;

    @JsonIgnore
//    @JsonIgnoreProperties("orders")
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "uid", referencedColumnName = "id")
    private User user;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + ordertime +
                ", total=" + total +
                ", user=" + user +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return ordertime;
    }

    public void setDate(Date date) {
        this.ordertime = date;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
