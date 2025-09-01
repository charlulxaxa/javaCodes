/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musiclibrary;

/**
 *
 * @author charl
 */
public class Song {
     String Title;
    String Artist;
        Song(String title, String artist){
            this.Title=title;
            this.Artist=artist;
        }
        public String toString(){
            return Title +" by "+ Artist;
        }
}
