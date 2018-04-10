package com.rekik.eventspeakecompositionapril;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        boolean eventDone = true;
        boolean speakerDone = true;
        String eventAnswer = "";
        String speakerAnswer = "";
        boolean menuDone = true;
        String menuAnswer = "";
        int choice =1;
        Event anEvent;
        Speaker aSpeaker;
        String eventName="";
        ArrayList<Event> events = new ArrayList<>();

        do {

            System.out.println("1. Create an event ");
            System.out.println("2. Add a speaker to an event  ");
            System.out.println("3. Show all the speakers for all events ");
            System.out.println("4. Show all the speakers for a given event (selected by the user)");

            System.out.println("Enter your choice from the menu");
            choice=reader.nextInt();
            reader.nextLine();


            if (choice == 1) {

                do {

                    System.out.println("Enter the title of the event");
                    anEvent=new Event(reader.nextLine());

                    System.out.println("Enter the start date of the event");
                    anEvent.setStartDate(reader.nextLine());

                    System.out.println("Enter the end date of the event");
                    anEvent.setEndDate(reader.nextLine());

                    events.add(anEvent);

                    System.out.println("Do you want to add another event");
                    eventAnswer=reader.nextLine();

                    if (eventAnswer.equalsIgnoreCase("no") || eventAnswer.equalsIgnoreCase("n"))
                        eventDone=false;
                    else eventDone=true;


                } while (eventDone);

            }

            ////////////////////////////////
            else if (choice == 2) {

                do {
                    System.out.println("Enter the title of the event you want to add a speaker to");
                    eventName=reader.nextLine();

                    do {
                        aSpeaker=new Speaker();
                        System.out.println("Enter the speaker of the event");
                        aSpeaker.setName(reader.nextLine());

                        int j =0;
                        Event tempEvent = new Event();
                        //Speaker tempSpeaker = new Speaker();


                        if(!events.isEmpty()) {
                            for (Event eachEvent :
                                    events) {
                               if (eachEvent.getTitle().equalsIgnoreCase(eventName)) {
                                   tempEvent.setTitle(eachEvent.getTitle());
                                   tempEvent.setStartDate(eachEvent.getStartDate());
                                   tempEvent.setEndDate(eachEvent.getEndDate());
                                    tempEvent.addSpeaker(aSpeaker);
                                    j=events.indexOf(eachEvent);
                                }


                                System.out.println(eachEvent.getTitle());
                            }
                            events.set(j, tempEvent);
                        }
                        else System.out.println("No events");

                        //imprtant step



//                        for (int i=0; i < events.size(); i++) {
//
//                            if (events.get(i).getTitle().equalsIgnoreCase(eventName)) {
//                                System.out.println("hi "+events.get(i).getTitle());
//                                //           events.get(i).addSpeaker(aSpeaker);
//                                newEvent = events.get(i);
//                                newEvent.addSpeaker(aSpeaker);
//                            }
//                        }

                        System.out.println("Do you want to add another speaker?");
                        speakerAnswer=reader.nextLine();

                        if (speakerAnswer.equalsIgnoreCase("no") || speakerAnswer.equalsIgnoreCase("n"))
                            speakerDone=false;
                        else speakerDone=true;

                    } while (speakerDone);

                    System.out.println("Do you want to add another event");
                    eventAnswer=reader.nextLine();

                    if (eventAnswer.equalsIgnoreCase("no") || eventAnswer.equalsIgnoreCase("n"))
                        eventDone=false;
                    else eventDone=true;


                } while (eventDone);

            }

            ///////////////////////////////

            else if (choice == 3){

                for (Event eachEvent : events
                        ) {
                    System.out.println("my events ar :" +eachEvent.getTitle());
                    if(!eachEvent.getSpeakers().isEmpty()) {
                        for (Speaker eachSpeaker : eachEvent.getSpeakers()) {
                            System.out.println("All speakers for all events are " + eachSpeaker.getName());
                        }
                    }
                    else System.out.println("No speakers for this event");

                }
        }

        /////////////////////////////////

               else if (choice == 4){

                int k = 0;
                    System.out.println("Enter the title of the event you want to see speakers of");
                    eventName=reader.nextLine();

                    /*for (int i=0; i < events.size(); i++) {
                        if (events.get(i).getTitle().equalsIgnoreCase(eventName)) {
                            events.get(i).getSpeakers().toString();
                        }
                    }*/



                for (Event eachEvent : events) {
                    if (eachEvent.getTitle().equalsIgnoreCase(eventName)) {
                        k = events.indexOf(eachEvent);
                        System.out.println(eachEvent.getTitle());
                        for (Speaker eachSpeak: eachEvent.getSpeakers()) {
                            System.out.println("Each speaker hhdhfhd "+eachSpeak.getName());
                        }
                    }
                    }
                    //events.set(k, tempEvent);
                }


            System.out.println("Do you want to see the menu again");
            menuAnswer=reader.nextLine();

            if (menuAnswer.equalsIgnoreCase("no") || menuAnswer.equalsIgnoreCase("n"))
                menuDone=false;
            else menuDone=true;


        }while(menuDone);


        for (Event everyEvent: events
             ) {
            System.out.println("Hiiiii lowww"+ everyEvent.getTitle());
            if(everyEvent.getSpeakers()!=null) {
                for (Speaker everySpeaker :
                        everyEvent.getSpeakers()) {
                    System.out.println("Speakers " + everySpeaker.getName());
                }
            }
            else System.out.println("No speakers fot this event1");
        }



    }
}
