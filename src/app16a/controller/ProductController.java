package app16a.controller;

import app16a.domain.Product;
import app16a.form.ProductForm;
import app16a.service.ProductService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    @Autowired
    //按照名称，注入指定的接口实现类
    @Qualifier("productService")
    ProductService productService;
    private static final Log logger =
            LogFactory.getLog(ProductController.class);

    @RequestMapping(value = "/product_input")
    public String inputProduct() {
        logger.info("inputProduct called");
        return "ProductForm";
    }

    //参数productForm中的字段与提交表当中的text文本框name一一对应
    @RequestMapping(value = "/product_save")
    public String saveProduct(ProductForm productForm, Model model, RedirectAttributes redirectAttributes){
        logger.info("saveProduct called");
        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        try {
            product.setPrice(Float.parseFloat(
                    productForm.getPrice()));
        } catch (NumberFormatException e) {
        }

        productService.add(product);

        //转发
        //model里面的内容作为request属性传递给jsp_servlet
        //model.addAttribute("product", product);
        //return "ProductDetails";

        //重定向
        // 客户端重新发送请求，Model无效
        //通过addFlashAttribute，可以在jsp中引用对象
        redirectAttributes.addFlashAttribute(product);
        return "redirect:/product_details";
    }

    @RequestMapping(value = "/product_details")
    public String productDetail(){
        logger.info("productDetail called");
        return "ProductDetails";
    }

    //路径变量的使用
    //http://localhost:8080/app16a/product/1
    @RequestMapping(value = "/product/{id}")
    public String productGet(@PathVariable Long id,Model model){
        Product product = productService.get(id);
        model.addAttribute(product);
        logger.info("productGet called");
        return "ProductDetails";
    }


    //获取请求参数
    //http://localhost:8080/app16a/product?id=1
    @RequestMapping(value = "/product")
    public String productGetWithParams(@RequestParam Long id,Model model){
        Product product = productService.get(id);
        model.addAttribute(product);
        logger.info("productGetWithParams called");
        return "ProductDetails";
    }
}
