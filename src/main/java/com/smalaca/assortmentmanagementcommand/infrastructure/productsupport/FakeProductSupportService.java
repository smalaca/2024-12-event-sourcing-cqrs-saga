package com.smalaca.assortmentmanagementcommand.infrastructure.productsupport;

import com.smalaca.assortmentmanagementcommand.domain.productsupport.ProductSupportService;
import org.springframework.stereotype.Service;

@Service
public class FakeProductSupportService implements ProductSupportService {
    @Override
    public boolean isSupported(String productIdentifier) {
        return false;
    }
}
