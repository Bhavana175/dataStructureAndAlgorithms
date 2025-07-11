package lld.designpatterns.structural;

public class FacadePattern {
/*
     imagine a building, the facade is the outer wall that people see,
     but behind it is a complex network of wires, pipes, and other systems
     that make the building function. The facade pattern is like that outer wall.

      It hides the complexity of the underlying system and provides
      a simple interface that clients can use to interact with the system.

     Let’s consider a hotel. This hotel has a hotel keeper.
     There are a lot of restaurants inside the hotel e.g. Veg restaurants, Non-Veg restaurants, and Veg/Non Both restaurants.
     You, as a client want access to different menus of different restaurants.
     You do not know what are the different menus they have. You just have access to a
     hotel keeper who knows his hotel well. Whichever menu you want, you tell
     the hotel keeper  he takes it out of the respective restaurants and hands it over to you.

    So here, Hotel-Keeper is Facade and respective Restaurants is system.

     */
}

interface Hotel{
    Menus getMenus();
}
class Menus{}
class VegMenu extends Menus{}
class NonVegMenu extends Menus{}
class Both extends Menus{}
class VegRestaurant implements Hotel{
    @Override
    public Menus getMenus() {
        return new VegMenu();
    }
}
class NonVegRestaurant implements Hotel{
    @Override
    public Menus getMenus() {
        return new NonVegMenu();
    }
}
class VegNonVegRestaurant implements Hotel{
    @Override
    public Menus getMenus() {
        return new Both();
    }
}

interface FacadeHotelKeeper {

    VegMenu getVegMenu();
    NonVegMenu getNonVegMenu();
    Both getBothMenu();

}
class HotelKeeper implements FacadeHotelKeeper{

    @Override
    public VegMenu getVegMenu() {
       VegRestaurant vegRestaurant= new VegRestaurant();
       return  (VegMenu) vegRestaurant.getMenus();
    }

    @Override
    public NonVegMenu getNonVegMenu() {
        NonVegRestaurant  nonVegRestaurant= new NonVegRestaurant();
        return  (NonVegMenu) nonVegRestaurant.getMenus();
    }

    @Override
    public Both getBothMenu() {
        VegNonVegRestaurant vegNonVegRestaurant = new VegNonVegRestaurant();
        return  (Both) vegNonVegRestaurant.getMenus();
    }
}

class client {

    public static void main(String[] args) {

        HotelKeeper keeper = new HotelKeeper();
        VegMenu vegMenu = keeper.getVegMenu();
        System.out.println(vegMenu);

    }

}
