/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musiclibrary;

import java.util.*;
public class Playlist {
     String Name;
    
    ArrayList <Song> songs;
    public int minutes = 2;
    public int seconds = 59;
    
    Playlist(String name){
          this.Name = name;
          songs= new ArrayList<>();
      }
      public String getName(){
          return Name;
      }
      
      public void addSong(Song song){
           songs.add(song);
      }
      public void removeSong(int a){
         if(a>songs.size()){
               System.out.println("\nNo Song in number "+a+"\n");
          }else{
              songs.remove(a-1);
              System.out.println("\nSong removed\n");
          }
      }
      public void displayList(){
          System.out.println(Name);
          for(Song s:songs){
                  System.out.println(""+s+"    "+minutes+":"+seconds);
              }  
      }
}
