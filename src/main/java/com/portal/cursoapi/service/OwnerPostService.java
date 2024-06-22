package com.portal.cursoapi.service;

import com.portal.cursoapi.dto.OwnerPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface OwnerPostService {
    void createOwnerCart(OwnerPostDTO ownerPostDTO);
}
