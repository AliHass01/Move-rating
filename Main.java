package com.NewProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Read from a Files
        try {
            //Read the name of the films from the .txt file

            Scanner inputName = new Scanner(new File("/Users/Downloads/Assignment2/FilmsNames.txt"));

            String[] name = new String[5];
            int i = 1;
            while (i <= 4) {
                //System.out.println(input.nextLine());
                name[i] = inputName.next();

                i++;
            }
            inputName.close();

            //Read the rating of the films from the .txt file and calculate the highest and the lowest rating

            Scanner inputRating = new Scanner(new File("/Users/Downloads/Assignment2/rating.txt"));

            double[] rating = new double[5];
            int j = 1;
            double min = 10.0;
            double max = 0.0;

            while (j <= 4) {
                rating[j] = inputRating.nextDouble();
                max = Math.max(max, rating[j]);
                min = Math.min(min, rating[j]);
                j++;
            }

            for (j = 1; j < rating.length; j++) {

                if (max == rating[j]) {
                    System.out.println("The highest rating movie is:" + name[j] + "\t Rating is: " + max);
                }
            }
            for (j = 1; j < rating.length; j++) {
                if (rating[j] == min) {
                    System.out.println("The lowest rating movie is:" + name[j] + "\t Rating is: " + min);
                }
            }


            inputRating.close();

            //Read the years of the films from the .txt file and calculate the oldest movie

            Scanner inputYear = new Scanner(new File("/Users/Downloads/Assignment2/filmsyears.txt"));


            int[] year = new int[5];
            int x = 1;
            LocalDate today = LocalDate.now();
            //calculate the oldest movie using the year
            int mini = today.getYear();
            while (x <= 4) {
                year[x] = inputYear.nextInt();
                mini = Math.min(mini, year[x]);
                x++;
            }

            for (x = 1; x < year.length; x++) {
                if (mini == year[x]) {
                    System.out.println("The oldest movie is:" + name[x] + "\t\t\t Year: " + year[x]);
                }
            }
            inputYear.close();

            //Read the Genre of the films from the .txt file

            Scanner inputGenre = new Scanner(new File("/Users/Downloads/Assignment2/genre.txt"));
            String[] genre = new String[5];
            int b = 1;
            while (b <= 4) {
                genre[b] = inputGenre.nextLine();
                b++;
            }


            //calculate the avg for each genre

            String ChosenGenre = "Action";

            double avg;
            int count = 0;
            double sum = 0;
            for (x = 1; x < genre.length; x++) {
                if (ChosenGenre.equalsIgnoreCase(genre[x])) {
                    sum += rating[x];
                    count++;
                }


            }



            if (ChosenGenre == "Action") {
                avg = sum / count;
                System.out.println("The average rating for the Action genre is: " + avg);

            } else if (ChosenGenre == "Adventure") {
                avg = sum / count;
                System.out.println("The average rating for the Adventure genre is: " + avg);
            } else if (ChosenGenre == "Comedy") {
                avg = sum / count;
                System.out.println("The average rating for the Comedy genre is: " + avg);
            } else
                System.out.println("The genre not found ");






            inputGenre.close();

        } catch (FileNotFoundException e) {
            System.out.println("not found");
        }

    }
}
