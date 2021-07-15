package conti.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer productId;
	public String moduleName;
	@Column( unique = true)
	public String moduleId;
	public String resistorId;
	public long resistorQuantity;
	public String capacitorId;
	public long capacitorQuantity;
	public String faulty;
	
	public Product() {
		
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return moduleName;
	}

	public void setName(String name) {
		this.moduleName = name;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getResistorId() {
		return resistorId;
	}

	public void setResistorId(String resistorId) {
		this.resistorId = resistorId;
	}

	public long getResistorQuantity() {
		return resistorQuantity;
	}

	public void setResistorQuantity(long resistorQuantity) {
		this.resistorQuantity = resistorQuantity;
	}

	public String getCapacitorId() {
		return capacitorId;
	}

	public void setCapacitorId(String capacitorId) {
		this.capacitorId = capacitorId;
	}

	public long getCapacitorQuantity() {
		return capacitorQuantity;
	}

	public void setCapacitorQuantity(long capacitorQuantity) {
		this.capacitorQuantity = capacitorQuantity;
	}

	public String getFaulty() {
		return faulty;
	}

	public void setFaulty(String faulty) {
		this.faulty = faulty;
	}

	public Product(Integer productId, String name, String moduleId, String resistorId, long resistorQuantity,
			String capacitorId, long capacitorQuantity, String faulty) {
		this.productId = productId;
		this.moduleName = name;
		this.moduleId = moduleId;
		this.resistorId = resistorId;
		this.resistorQuantity = resistorQuantity;
		this.capacitorId = capacitorId;
		this.capacitorQuantity = capacitorQuantity;
		this.faulty = faulty;
	}
	
}
