package com.example.teamvoy.service;

import com.example.teamvoy.model.Goods;
import java.util.List;

public interface GoodsService {
    Goods save(Goods goods);

    Goods findByProductId(Long id);

    List<Goods> findAll();
}
