package com.investree.demo.view.impl;

import com.investree.demo.model.Transaksi;
import com.investree.demo.model.User;
import com.investree.demo.repository.TransaksiRepository;
import com.investree.demo.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class TransaksiPaymentImple implements TransaksiService {

    @Autowired
    private TransaksiRepository transaksiRepository;

    @Override
    public Map save(Transaksi obj) {
        Map map = new HashMap();
        try {


            Transaksi save = transaksiRepository.save(obj);
            map.put("data", save);
            map.put("status", "sukses");
            map.put("code", "200");
            return map;
        } catch (Exception e) {
            map.put("status", "failed");
            map.put("code", "500");
            return map;
        }
    }

    @Override
    public Map updateStatus(Transaksi obj) {
        Map map = new HashMap();
        try {
            Transaksi update = transaksiRepository.getbyID(obj.getId());
            update.setStatus("lunas");
            Transaksi doSave = transaksiRepository.save(update);
            map.put("data", doSave);
            map.put("status", "success");
            map.put("code", "200");
        } catch (Exception e) {
            map.put("status", "failed");
            map.put("code", "500");
            return map;
        }
        return map;
    }
}
