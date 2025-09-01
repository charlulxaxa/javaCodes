/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package music;

/**
 *
 * @author charl
 */
public class Song extends Music{
         String Title;
         String Artist;
         String Album;
         String Genre;
         int Year;
        Song(String title, String artist,String album,String genre,int year){
            this.Title=title;
            this.Artist=artist;
            this.Album=album;
            this.Genre=genre;
            this.Year=year;
        }
        public String getTitle(){
            return Title;
        }
        public String getArtist(){
            return Artist;
        }
        public String getAlbum(){
            return Album;
        }
        public String getGenre(){
            return Genre;
        }
        public int getYear(){
            return Year;
        }
        @Override
        public String toString(){
            System.out.printf("%-20s %-20s%-20s%-15s%-15s",Title,Artist,Album,Genre,Year);
            return "";
        }
}




