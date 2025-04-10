package com.example.ntwlista4zad2;

import com.example.ntwlista4zad2.classes.Product;
import jakarta.transaction.Transactional;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import com.example.ntwlista4zad2.repos.ProductRepository;

@Component
public class LoadData implements
        ApplicationListener<ContextRefreshedEvent> {

        final ProductRepository productRepository;

        boolean alreadySetup = false;

        public LoadData(ProductRepository productRepository) {
                this.productRepository = productRepository;
        }

        @Override
        @Transactional
        public void onApplicationEvent(ContextRefreshedEvent event) {

                if (alreadySetup)
                        return;


                Product pro1 = new Product("Laptop", "Intel", "Intel xdc", "Najlepszy laptop na świecie1", 9996,"1.png", true);
                Product pro2 = new Product("Laptop", "Intel", "Intel 091238is", "Najlepszy laptop na świecie2222", 3333,"2.png", true);
                Product pro3 = new Product("Klawiatura", "Intel", "Intel 0109293", "najlepsza klawiatura", 412,"3.png", true);
                Product pro4 = new Product("Klawiatura", "Intel", "Intel Klav1", "najlepsza klawiatura2222", 354,"4.png", true);
                Product pro5 = new Product("Klawiatura", "HP", "HP Klawa1", "najlepsza klawiatur333333a", 123,"5.png", true);
                Product pro6 = new Product("Klawiatura", "HP", "HP Klawa2", "najlepsza klawiatura44444", 653,"6.png", true);
                Product pro7 = new Product("Komputer", "HP", "HP PC9182", "Najlepszy na świecie komputer", 9354,"7.png", true);
                Product pro8 = new Product("Komputer", "HP", "HP PC kaSSss", "Najlepszy na świecie komputer2222", 2552,"8.png", true);
                Product pro9 = new Product("Komputer", "ASUS", "ASUS KOMPUTERPC", "Najlepszy na świecie komputer333333", 5622,"9.png", true);
                Product pro0 = new Product("Komputer", "ASUS", "ASUS PC123", "Najlepszy na świecie komputer444444", 7743,"10.png", true);
                Product pro10 = new Product("Mysz", "ASUS", "ASUS Razer2", "myszka best111", 132,"11.png", false);
                Product pro11 = new Product("Mysz", "ASUS", "ASUS Moussy", "myszka best22222222222222", 65,"12.png", false);
                Product pro12 = new Product("Mysz", "Acer", "Acer myszk1", "myszka best33333333", 887,"13.png", false);
                Product pro13 = new Product("Mysz", "Acer", "Acer Rararar", "myszka best44", 245,"14.png", false);
                Product pro14 = new Product("Mysz", "Acer", "Acer l12jhudfsi", "myszka best555555555", 111,"15.png", false);


                productRepository.save(pro1);
                productRepository.save(pro2);
                productRepository.save(pro3);
                productRepository.save(pro4);
                productRepository.save(pro5);
                productRepository.save(pro6);
                productRepository.save(pro7);
                productRepository.save(pro8);
                productRepository.save(pro9);
                productRepository.save(pro10);
                productRepository.save(pro0);
                productRepository.save(pro11);
                productRepository.save(pro12);
                productRepository.save(pro13);
                productRepository.save(pro14);

                alreadySetup = true;
        }

        }
