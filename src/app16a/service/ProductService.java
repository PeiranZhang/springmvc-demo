package app16a.service;

import app16a.domain.Product;

public interface ProductService {
    Product add(Product product);
    Product get(long id);
}
