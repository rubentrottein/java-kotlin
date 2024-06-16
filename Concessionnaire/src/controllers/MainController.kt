package controllers

import content.TextContent
import models.Car

class MainController {
    private var garage = ArrayList<Car>();
    private var run = true;
    private val text = TextContent();
    private var ids = 0;

    fun start(){
        do {
            println(text.WELCOMETEXT);
            menu();
        } while (run)
    }

    private fun menu(){
        val saisie = readlnOrNull()
        when(saisie){
            "1" -> displayCars();
            "2" -> addCar();
            "3" -> editCar();
            "4" -> deleteCar();
            "5" -> run = quit("\n A bientot !");
            else -> println("Saisie incorrecte")
        }
    }

    private fun quit(s: String): Boolean {
        println(s);
        return false;
    }

    private fun addCar() {
        println("Caractéristique du véhicule \n");
        val car = newCar();
        garage.add(car)
        println(car);
    }

    private fun editCar() {
        println(garage.toString());
        println("Select car by Id");
        val id = readLine()?.toInt();
        println("Voiture selectionnée : $id");
        val car = newCar();
        garage[id!!] = car;
    }

    private fun newCar(): Car {
        val id = ids++;
        println("model : \n")
        val model = readlnOrNull();
        println("brand : \n")
        val brand = readlnOrNull();
        println("description : \n")
        val description = readlnOrNull();
        println("year : \n")
        val year = readlnOrNull();

        val car = Car(id, model, brand, description, year?.toInt());
        return car;
    }

    private fun deleteCar(){
        println(garage.toString());
        println("\n Id du vehicule a supprimer?")
        val id = readlnOrNull()?.toInt();
        if (id != null) {
            garage.removeAt(id)
        }
        println("\n Le véhicule N°$id a bien été supprimé.")
    };

    private fun displayCars(){
        println(garage.toString());
    }
}