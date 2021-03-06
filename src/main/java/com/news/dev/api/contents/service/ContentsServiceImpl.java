package com.news.dev.api.contents.service;

import com.news.dev.adaptor.KakaoAdaptor;
import com.news.dev.adaptor.WoowahanAdaptor;
import com.news.dev.api.contents.dto.ContentsDto;
import com.news.dev.api.contents.dto.ContentsResponse;
import com.news.dev.jpa.entity.ContentsEntity;
import com.news.dev.jpa.repository.ContentsRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContentsServiceImpl implements ContentsService {

    private final WoowahanAdaptor woowahanAdaptor;
    private final KakaoAdaptor kakaoAdaptor;
    private final ContentsRepository contentsRepository;

    @Override
    @Cacheable("contents")
    @Transactional(readOnly = true)
    public List<ContentsResponse> list() {

        // 1. Get Contents
        List<ContentsEntity> contentsEntityList = contentsRepository.findAll();

        // 2. Convert Response
        List<ContentsResponse> contentsResponse = contentsEntityList.stream().map(
                content -> new ModelMapper().map(content, ContentsResponse.class)
            ).collect(Collectors.toList());

        return contentsResponse;
    }

    @Override
    public void update() {
        // 1. Contents Update
//        List<ContentsDto> contents = woowahanAdaptor.initContents();
//
//
//        List<ContentsEntity> contentsEntityList = contents.stream().map(
//                content -> new ModelMapper().map(content, ContentsEntity.class)
//            ).collect(Collectors.toList());
//
//        contentsRepository.saveAll(contentsEntityList);
    }
}
