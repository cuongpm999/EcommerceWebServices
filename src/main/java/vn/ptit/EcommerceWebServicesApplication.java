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
		ApplicationContext context = SpringApplication.run(EcommerceWebServicesApplication.class, args);
		ManufacturerRepository manufacturerRepository = context.getBean(ManufacturerRepository.class);
//		Manufacturer manufacturer = new Manufacturer();
//		manufacturer.setName("HP");
//		manufacturer.setAddress("Hà Nội");
//		manufacturerRepository.save(manufacturer);
		
		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);
		Laptop laptop = new Laptop();
		laptop.setName("Laptop HP ProBook 430 G8");
		laptop.setSpecifications("Test");
		laptop.setWarranty(2);
		laptop.setScreendSize(14.6);
		laptop.setRam("8 GB");
		laptop.setCpu("Core i7");
		laptop.setCard("AMD");
		laptop.setManufacturer(manufacturerRepository.findAll().get(0));
		laptopRepository.save(laptop);
		
	}

}
