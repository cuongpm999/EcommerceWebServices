package vn.ptit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import vn.ptit.entities.clothes.Jeans;
import vn.ptit.entities.electronics.Laptop;
import vn.ptit.entities.electronics.Manufacturer;
import vn.ptit.entities.shoes.Sneaker;
import vn.ptit.repositories.clothes.JeansRepository;
import vn.ptit.repositories.electronics.LaptopRepository;
import vn.ptit.repositories.electronics.ManufacturerRepository;
import vn.ptit.repositories.shoes.SneakerRepository;

@SpringBootApplication
public class EcommerceWebServicesApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EcommerceWebServicesApplication.class, args);
//		ManufacturerRepository manufacturerRepository = context.getBean(ManufacturerRepository.class);
//		Manufacturer manufacturer = new Manufacturer();
//		manufacturer.setName("HP");
//		manufacturer.setAddress("Hà Nội");
//		manufacturerRepository.save(manufacturer);
		
//		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);
//		Laptop laptop = new Laptop();
//		laptop.setName("Laptop HP ProBook 430 G8");
//		laptop.setSpecifications("Test");
//		laptop.setWarranty(2);
//		laptop.setScreendSize(14.6);
//		laptop.setRam("8 GB");
//		laptop.setCpu("Core i7");
//		laptop.setCard("AMD");
//		laptop.setManufacturer(manufacturerRepository.findAll().get(0));
//		laptopRepository.save(laptop);
		
//		JeansRepository jeansRepository = context.getBean(JeansRepository.class);
//		Jeans jeans = new Jeans();
//		jeans.setColor("Đen");
//		jeans.setMaterial("Vải");
//		jeans.setName("Quần a");
//		jeans.setStyle("ABC");
//		jeans.setPipe("Rộng");
//		jeans.setSize("M");
//		jeansRepository.save(jeans);
		
//		SneakerRepository sneakerRepository = context.getBean(SneakerRepository.class);
//		Sneaker sneaker = new Sneaker();
//		sneaker.setSize("40");
//		sneaker.setColor("Đen");
//		sneaker.setMaterial("Vải");
//		sneaker.setStyle("VjpPro");
//		sneaker.setName("Sneaker 2021");
//		sneaker.setClinch(true);
//		sneaker.setSole("5 cm");
//		sneakerRepository.save(sneaker);
	}

}
