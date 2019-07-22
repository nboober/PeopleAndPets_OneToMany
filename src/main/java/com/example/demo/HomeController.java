package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    PetRepository petRepository;

    @RequestMapping("/")
    public String index(Model model){

        //First Create a Pet
        Pet pet = new Pet();
        pet.setName("Scooby");
        pet.setAge(6);
        pet.setAnimal("Boston Terrier");

        //Now lets create a Person
        People person = new People();
        person.setName("Nick");
        person.setAge(27);

        //Add the person to an empty Repository
        Set<People> people = new HashSet<People>();
        people.add(person);

        //Add a second person
        person = new People();
        person.setName("Gaby");
        person.setAge(29);
        people.add(person);

        //Create a second Pet
        Pet pet2 = new Pet();
        pet2.setName("Toby");
        pet2.setAge(4);
        pet2.setAnimal("Beagle");

        //Add the list of people to the pet's owner list
        pet.setPeople(people);
        pet2.setPeople(people);

        //Save the Pet to the database
        petRepository.save(pet);
        petRepository.save(pet2);

        //Grab all the pets from the database and send them to the template
        model.addAttribute("pets", petRepository.findAll());
        return "index";
    }

}
