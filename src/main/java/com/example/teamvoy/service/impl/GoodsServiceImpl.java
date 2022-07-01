package com.example.teamvoy.service.impl;

import com.example.teamvoy.model.Goods;
import com.example.teamvoy.repository.GoodsRepository;
import com.example.teamvoy.service.GoodsService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {
    private final GoodsRepository goodsRepository;

    public GoodsServiceImpl(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @Override
    public Goods save(Goods goods) {
        return goodsRepository.save(goods);
    }

    @Override
    public Goods findByProductId(Long id) {
        return goodsRepository.findByProductId(id).orElseThrow();
    }

    @Override
    public List<Goods> findAll() {
        return goodsRepository.findAll();
    }
}
