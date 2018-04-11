package com.rekik.eventspeakecompositionapril;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

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
        ArrayList<Event> pastEvents = new ArrayList<>();
        ArrayList<Event> upcomingEvents = new ArrayList<>();

        LocalDate rightNow= LocalDate.now();
        LocalDate anyDay = null;
        LocalDate endDate=null;
        DateTimeFormatter longFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Today is: "+rightNow.format(dTF) + " welcome!");



        do {

            System.out.println("1. Create an event ");
            System.out.println("2. Add a speaker to an event  ");
            System.out.println("3. Show all the speakers for all events ");
            System.out.println("4. Show all the speakers for a given event (selected by the user)");
            System.out.println("5. Show upcoming events ");
            System.out.println("6. Show past events ");
            System.out.println("7. Enter a day to search for past and upcoming events ");

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


            else if (choice == 7){

                System.out.println("Enter a date: ");
                String myDate = reader.nextLine();

                anyDay = LocalDate.parse(myDate, dTF);


                if(!events.isEmpty()) {
                    for (Event eachEvent : events
                            ) {
                        endDate = LocalDate.parse(eachEvent.getEndDate(),dTF);
                        System.out.println(endDate.format(longFormat));

                        System.out.println(endDate.format(dTF).compareTo(anyDay.format(dTF)));

                        if(endDate.format(dTF).compareTo(anyDay.format(dTF)) > 0){

                            //System.out.println("Added to the upcoming events");
                            upcomingEvents.add(eachEvent);
                        }
                        else{
                            //System.out.println("Added to the past events");
                            pastEvents.add(eachEvent);
                        }


                    }

                    System.out.println("The upcoming events are the following");

                        if(!upcomingEvents.isEmpty()) {
                            for (Event past : upcomingEvents
                                    ) {

                                System.out.println(past.getTitle());


                            }
                        }
                        else System.out.println("There are no upcoming events");

                    System.out.println("The past events are the following");

                        if(!pastEvents.isEmpty()) {
                            for (Event past : pastEvents
                                    ) {

                                System.out.println(past.getTitle());
                            }
                        }
                        else System.out.println("There are no past events");








                }

                else System.out.println("There are no events");





                   /* boolean isBefore = rightNow.isBefore(endDate);

                    if(isBefore)
                        System.out.println("I am rocking");*/


            }

/*
            do{

                System.out.println("Enter a date: ");
                String myDate = reader.nextLine();

                anyDay = LocalDate.parse(myDate, dTF);

                //treating endDate as a date
                //endDate = LocalDate.parse(anEvent.getEndDate(),dTF);
                //System.out.println(endDate.format(longFormat));

                if(!events.isEmpty()) {
                    for (Event eachEvent : events
                            ) {
                        endDate = LocalDate.parse(eachEvent.getEndDate(),dTF);
                        System.out.println(endDate.format(longFormat));
                    }
                }

                else System.out.println("There are no events");



                if(endDate.format(dTF).compareTo(anyDay.format(dTF)) > 0){
                    System.out.println("Added to the upcoming events");
                    upcomingEvents.add(anEvent);
                }
                else{
                    System.out.println("Added to the past events");
                    pastEvents.add(anEvent);
                }

            }while(true); */



            ////////////////////////////////
            else if (choice == 2) {

                do {
                    System.out.println("Enter the title of the event you want to add a speaker to");
                    eventName=reader.nextLine();

                    do {
                        aSpeaker=new Speaker();
                        System.out.println("Enter the speaker of the event");
                        aSpeaker.setName(reader.nextLine());

                        for (Event thisEvent:events) {
                            if (thisEvent.getTitle().equalsIgnoreCase(eventName)){
                                thisEvent.addSpeaker(aSpeaker);
                            }


                            /*for (Speaker speakeri : thisEvent.getSpeakers()){
                                System.out.printf(speakeri.getName());
                            }*/
                        }



                        /*int j =0;
                        Event tempEvent = new Event();

                            for (Event eachEvent :
                                    events) {
                               if (eachEvent.getTitle().equalsIgnoreCase(eventName)) {

                                    j=events.indexOf(eachEvent);
                                }
                                events.set(j, tempEvent);

                              */



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

                if(!events.isEmpty()) {
                    for (Event eachEvent : events
                            ) {
                        System.out.println("Event :" + eachEvent.getTitle());
                        if (!eachEvent.getSpeakers().isEmpty()) {
                            for (Speaker eachSpeaker : eachEvent.getSpeakers()) {
                                System.out.println("Speaker: " + eachSpeaker.getName());
                            }
                        } else System.out.println("No speakers for this event");

                    }
                }
                else System.out.println("There are no events");
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

                if(!events.isEmpty()) {
                    for (Event eachEvent : events) {

                        if (eachEvent.getTitle().equalsIgnoreCase(eventName)) {
                            //k = events.indexOf(eachEvent);
                            //System.out.println(eachEvent.getTitle());
                            System.out.println("The speakers for " + eachEvent.getTitle() + " are: ");
                            if(!eachEvent.getSpeakers().isEmpty()) {
                                for (Speaker eachSpeak : eachEvent.getSpeakers()) {

                                    System.out.println(eachSpeak.getName());
                                }
                            }
                            else System.out.println("This event has no speakers");
                        }
                    }
                }else System.out.println("there are no events");
                    //events.set(k, tempEvent);
                }



            else if(choice == 5){
                if(!upcomingEvents.isEmpty()) {
                    for (Event past : upcomingEvents
                            ) {

                        System.out.println(past.getTitle());


                    }
                }
                else System.out.println("There are no upcoming events");
            }

            else if(choice == 6){
                if(!pastEvents.isEmpty()) {
                    for (Event past : pastEvents
                            ) {

                        System.out.println(past.getTitle());
                    }
                }
                else System.out.println("There are no past events");
            }



            System.out.println("Do you want to see the menu again");
            menuAnswer=reader.nextLine();

            if (menuAnswer.equalsIgnoreCase("no") || menuAnswer.equalsIgnoreCase("n"))
                menuDone=false;
            else menuDone=true;


        }while(menuDone);



    }
}
