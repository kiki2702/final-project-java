package com.investree.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "transaksi")
public class Transaksi implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int tenor;
    private double total_pinjaman;
    private double bunga_persen;
    private String status;


    @ManyToOne
    @JoinColumn(name = "id_peminjam")
    private User userPeminjam;


    @ManyToOne
    @JoinColumn(name = "id_meminjam")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "transaksi")
    private List<PaymentHistory> paymentHistory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTenor() {
        return tenor;
    }

    public void setTenor(int tenor) {
        this.tenor = tenor;
    }

    public double getTotal_pinjaman() {
        return total_pinjaman;
    }

    public void setTotal_pinjaman(double total_pinjaman) {
        this.total_pinjaman = total_pinjaman;
    }

    public double getBunga_persen() {
        return bunga_persen;
    }

    public void setBunga_persen(double bunga_persen) {
        this.bunga_persen = bunga_persen;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUserPeminjam() {
        return userPeminjam;
    }

    public void setUserPeminjam(User userPeminjam) {
        this.userPeminjam = userPeminjam;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<PaymentHistory> getPaymentHistory() {
        return paymentHistory;
    }

    public void setPaymentHistory(List<PaymentHistory> paymentHistory) {
        this.paymentHistory = paymentHistory;
    }
}
