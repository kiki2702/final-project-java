package com.investree.demo.repository;

import com.investree.demo.model.PaymentHistory;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaymentHistoryRepository extends PagingAndSortingRepository<PaymentHistory,Long> {
}
