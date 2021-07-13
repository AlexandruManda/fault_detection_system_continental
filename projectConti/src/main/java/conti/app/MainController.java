package conti.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

//	@GetMapping("/")
//	public String viewIndex() {
//		return "index";
//	}
	@GetMapping("/index")
	public String viewHomePage() {
		return "index";	
	}
	
	@GetMapping("/reports")
	public String viewReportPage() {
		return "reports";	
	}
	
	@GetMapping("/products")
	public String viewProductsPage() {
		return "products";	
	}
	
}
