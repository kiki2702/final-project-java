package com.investree.demo.repository;

import com.investree.demo.model.Transaksi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface TransaksiRepository extends PagingAndSortingRepository<Transaksi,Long> {

    @Query("select c from Transaksi c WHERE c.id = :id")
    public Transaksi getbyID(@Param("id") Long id);

    @Query("select c from Transaksi c WHERE c.status like %:status%")
    Page<Transaksi> getByStatus(String status, Pageable pageable);

    @Query("select c from Transaksi c")
    Page<Transaksi> getList(Pageable pageable);
}
