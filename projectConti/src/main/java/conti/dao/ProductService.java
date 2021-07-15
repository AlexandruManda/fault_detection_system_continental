package conti.dao;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProductService {

	@Autowired
	ProductRepository products;
	
	
	
}
