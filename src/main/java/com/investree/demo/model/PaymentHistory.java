package com.investree.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "payment_history")
public class PaymentHistory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int pembayaran_ke;
    private double jumlah;
    private String bukti_pembayaran;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPembayaran_ke() {
        return pembayaran_ke;
    }

    public void setPembayaran_ke(int pembayaran_ke) {
        this.pembayaran_ke = pembayaran_ke;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public String getBukti_pembayaran() {
        return bukti_pembayaran;
    }

    public void setBukti_pembayaran(String bukti_pembayaran) {
        this.bukti_pembayaran = bukti_pembayaran;
    }

    public Transaksi getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    @ManyToOne
    @JoinColumn(name = "id_transaksi")
    Transaksi transaksi;
}
