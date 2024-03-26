package com.workspace.learning.algorithms.question;

public class Page implements Comparable{


    int id;
    int popularity;

    String text;

    public Page(int id, int popularity) {
        this.id = id;
        this.popularity = popularity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Page{" +
                "id=" + id +
                ", popularity=" + popularity +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Page p = (Page) o;
        return p.popularity -this.popularity;
    }
}
