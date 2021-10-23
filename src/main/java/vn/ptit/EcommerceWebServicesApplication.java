package vn.ptit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import vn.ptit.entities.electronics.Laptop;
import vn.ptit.entities.electronics.Manufacturer;
import vn.ptit.repositories.electronics.LaptopRepository;
import vn.ptit.repositories.electronics.ManufacturerRepository;

@SpringBootApplication
public class EcommerceWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceWebServicesApplication.class, args);
	}

}
