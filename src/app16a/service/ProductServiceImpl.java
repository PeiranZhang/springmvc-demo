package app16a.service;

import app16a.domain.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

//service加上名称，在一个接口多个实现类时，可以这样区分
@Service("productService")
public class ProductServiceImpl implements ProductService {
    private Map<Long, Product> products =
            new HashMap<Long, Product>();
    private AtomicLong generator = new AtomicLong();
    @Override
    public Product add(Product product) {
        long newId = generator.incrementAndGet();
        product.setId(newId);
        products.put(newId, product);
        System.out.println("Add" + product);
        return product;
    }

    @Override
    public Product get(long id) {
        return products.get(id);
    }
}
