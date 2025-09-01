/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package music;

import java.util.*;
public class Playlist  {
    String Name;
    ArrayList <Song> songs;
    public int minutes = 0;
    public int seconds = 10;
    
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
              String songInfo=songs.get(a-1).getTitle()+" by "+songs.get(a-1).getArtist(); //store the song info since arrayList toString format is modified 
              System.out.println("\n\n_____________________________________________________________________");
              System.out.println(songInfo+" has been removed from the playlist");
              System.out.println("_____________________________________________________________________\n\n");
              songs.remove(a-1);
             
          }
      }
      public void displayList(){
        
          System.out.println(songs.size());
          System.out.println("\nSongs:");
          System.out.printf("%-23s %-20s%-20s%-15s%-15s%-20s","Title","Artist","Album","Genre","Year","                    Time");
          System.out.print("\n-------------------------------------------------------------------------------------------------------------------------------\n");
          if(songs.size()==0){
              System.out.println("\n                      ***EMPTY***                                ");
          }
          int numbering=1;
          for(Song x:songs){
                  System.out.print(numbering+") ");
                  System.out.printf("%-20s%-1s%-1s%-1s",x,minutes,":",seconds); 
                  if(songs.size()>0){
                      System.out.println("");
                  }
                 
                  numbering++;
              }  
          
          System.out.print("\n-------------------------------------------------------------------------------------------------------------------------------\n");
      }
}
       



