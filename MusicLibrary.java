/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package musiclibrary;

import java.util.*;
public class MusicLibrary {

   
       public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();
  } 
    public static void main(String[] args) {
        System.out.println("Hello, Welcome to Music Library!");
        addRemove ar= new addRemove();
        MusicLibrary main = new MusicLibrary();
        main.options();
    
    }
    Scanner scan = new Scanner(System.in);
      ArrayList<Playlist> playlist= new ArrayList<>();
    
      Song song;
      Playlist play;
      Playlist Select=null;
      boolean loop;
      boolean check;
      String a,b;
      String ListName;
      int x=0;
      int minute=2,second=59;
    
      void options(){
        play= new Playlist("Default");
        song = new Song("Doobie dapdap","Kuya William Imperial");
        play.addSong(song);
        playlist.add(play);
          
         while(true){
         
          check=false;
          System.out.println("1 Choose playlist  \n2 Create playlist");
          int choose=scan.nextInt();
          scan.nextLine();
          
          if(choose==1){
            int ll=0;
              for(Playlist p: playlist){
                  ll++;
                  System.out.print(ll+". ");
                  p.displayList();
                  
              }
              System.out.println("Enter Playlist Number");
              x =scan.nextInt();
              scan.nextLine();
              play = playlist.get(x-1);
            
          }else if(choose==2){
           
              System.out.println("Enter new Playlist Name");
              ListName= scan.nextLine();
              play = new Playlist(ListName);
      
          }
        
          loop=true;
          System.out.println("Current Playlist");
            
          while(loop){
            
            System.out.println("1. Add song\n2. Remove song\n3. Play Playlist\n4. Exit");
               String opt= scan.nextLine();
         
              switch(opt){
            
                 case "1":
                    case "Add Song":
                       case "add song":
                           
                        if(x!=0){
                        check= true;
                        }
                     
                        System.out.println("Enter Song name");
                      
                        a = scan.nextLine();
                    
                        System.out.println("Enter Artist");
                     
                        b = scan.nextLine();
                        song = new Song(a,b);
                        play.addSong(new Song(a,b));
                     
                        System.out.println("\nSuccessfully Added Song\n");
                      
                        break;
              
                 case "2":
                    case "Remove Song":
                      case "remove song":
              
                        System.out.println("\nEnter Song Number to Remove Song");
                        int x = scan.nextInt();
                        scan.nextLine();
                        play.removeSong(x);
                        break;
            
                 case "3":
                    case "Play":
                       case"play":
                      
                        System.out.println("\nCurrent Playlist");
                    
                        play.displayList();
         
                        System.out.println("\n\n");
                        Playx();
                        break;
              
                 case "4":
                    case "exit":
                       case "Exit":
                       loop=false;
                       break;
               }
          }
        
                 if(!check){
                   playlist.add(play);
               }
            
        }
    }
      void Playx(){
          MusicLibrary Main = new MusicLibrary();
          
          System.out.println("1. Play first Song\n2. Choose Song to play\n3. Exit");
          int x= scan.nextInt();
          scan.nextLine();
          
          switch (x){
              
              case 1:
              Main.clearScreen();
              
              for(int i=0; i <playlist.size();i++){
                  while(play.minutes!=0){ 
                    
                      while(play.seconds!=0){
                         for(int j=0; j<playlist.size();j++){
                              System.out.print("\n"+play.songs.get(j));
                             if(i==j){
                              System.out.print("  "+play.minutes+":"+ play.seconds+"     now Playing");
                            }
                            else{
                              System.out.print("  "+minute+":"+second);
                            }
                  } 
                  try {
                      Thread.sleep(1000);
                      play.seconds-=1;
                  }
                  catch (InterruptedException ex) {
                  }
                  Main.clearScreen();}
                      play.seconds=59;
                      play.minutes-=1;
                  }
                  play.minutes=2;
                  System.out.println();
              }
              break;
              case 2:
              break;
              case 3:
              break;
          }
      }
      void input(){
        System.out.println("");
          
      }
    
}
    
