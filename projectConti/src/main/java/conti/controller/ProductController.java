package conti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import conti.dao.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	ProductRepository products;
	
	@GetMapping("/products")
	public String viewProductsPage(Model model) {
		model.addAttribute("product", products.findAll());
		return "products";	
	}
	
}
