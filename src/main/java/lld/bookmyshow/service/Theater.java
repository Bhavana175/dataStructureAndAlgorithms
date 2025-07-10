package lld.bookmyshow.service;

import lld.bookmyshow.model.Screen;
import lld.bookmyshow.model.Show;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Theater {
    private String id;
    private String name;
    private String city;
    List<Screen> screens;
    List<Show> showList;

    public Theater(String id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.showList = new ArrayList<>();
        this.screens = new ArrayList<>();
    }

    public void addShow(Show show){
        showList.add(show);
    }

    public void addScreen(Screen screen){
        screens.add(screen);
    }


}
