package com.project.davinci.service;

import com.project.davinci.domain.GoodsAttribute;
import com.project.davinci.domain.GoodsAttributeExample;
import com.project.davinci.persistence.GoodsAttributeDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class GoodsAttributeService {
    @Resource
    private GoodsAttributeDAO goodsAttributeMapper;

    public List<GoodsAttribute> queryByGid(Integer goodsId) {
        GoodsAttributeExample example = new GoodsAttributeExample();
        example.or().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return goodsAttributeMapper.selectByExample(example);
    }

    public void add(GoodsAttribute goodsAttribute) {
        goodsAttribute.setAddTime(LocalDateTime.now());
        goodsAttribute.setUpdateTime(LocalDateTime.now());
        goodsAttributeMapper.insertSelective(goodsAttribute);
    }

    public GoodsAttribute findById(Integer id) {
        return goodsAttributeMapper.selectByPrimaryKey(id);
    }

    public void deleteByGid(Integer gid) {
        GoodsAttributeExample example = new GoodsAttributeExample();
        example.or().andGoodsIdEqualTo(gid);
        goodsAttributeMapper.logicalDeleteByExample(example);
    }
}
