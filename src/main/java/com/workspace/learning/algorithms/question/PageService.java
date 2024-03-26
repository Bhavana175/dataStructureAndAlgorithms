package com.workspace.learning.algorithms.question;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PageService {
  /*  EPAM 4th Round (DSA):

    Confluence Pages have popularity (an integer) which can be increased
    or decreased. Build the below functionalities:

    Func:
            1. inc the popularity -> increase by 1
            2. dec the popularity -> decrease by 1
            3. get Most popular content at any point in time

    constraints:
    popularity can be equal -> if its equal, choose the latest one.
    popularity cant go negative

    Also tell what will be the time complexity for each operation*/
    Map<Integer, Page> pageMap = new HashMap<>();
    PriorityQueue<Page> priorityQueue = new PriorityQueue<>();
            //((o1, o2) -> o2.getPopularity()-1-o1.popularity);

    public void setPageMap(Page p){
        pageMap.put(p.id, p);
        priorityQueue.add(p);
    }

    public void increasePopularity(int pageId){
        //time complexity O(1) hashMap
        if(pageMap.containsKey(pageId)){
            Page page = pageMap.get(pageId);
            page.popularity++;
            priorityQueue.add(priorityQueue.remove());

        }
    }

    public void decreasePopularity(int pageId){

        if(pageMap.containsKey(pageId)){
            Page page = pageMap.get(pageId);
            page.popularity--;
            if(page.popularity<0){
                page.popularity=0;
            }
            priorityQueue.add(priorityQueue.remove());
        }
    }

    public Page getMostPopularPage(){
      // time complexity  O(n)
       return priorityQueue.peek();

               //pageMap.values().stream()
              //  .max(Comparator.comparingInt(Page::getPopularity)).get();
    }

    public static void main(String[] args) {
        Page p1 = new Page(1, 10);
        Page p2 = new Page(2, 11);
        Page p3 = new Page(3, 1);
        Page p4 = new Page(4, 99);
        Page p5 = new Page(5, 97);

        PageService pageService= new PageService();
        pageService.setPageMap(p1);
        pageService.setPageMap(p2);
        pageService.setPageMap(p3);
        pageService.setPageMap(p4);
        pageService.setPageMap(p5);

        System.out.println( pageService.getMostPopularPage() );
        pageService.increasePopularity(p5.id);
        pageService.increasePopularity(p5.id);
        System.out.println( pageService.getMostPopularPage() );
        pageService.increasePopularity(p5.id);
        System.out.println( pageService.getMostPopularPage() );
        pageService.increasePopularity(p4.id);

        System.out.println( pageService.getMostPopularPage() );


    }
}
