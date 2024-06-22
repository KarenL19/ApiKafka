package com.portal.cursoapi.service.ServiceImpl;

import com.portal.cursoapi.client.CarPostStoreClient;
import com.portal.cursoapi.dto.OwnerPostDTO;
import com.portal.cursoapi.service.OwnerPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {
    @Autowired private CarPostStoreClient cartPostStoreClient;

    /**
     * @param ownerPostDTO
     */
    @Override
    public void createOwnerCart(OwnerPostDTO ownerPostDTO) {
        cartPostStoreClient.ownerPostClient(ownerPostDTO);

    }
}
