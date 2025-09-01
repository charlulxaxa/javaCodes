/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package music;

import java.util.*;

/**
 *
 * @author charl
 */
public class Music {
      Scanner scan = new Scanner(System.in);
      ArrayList<Playlist> playlist= new ArrayList<>();
   
      Song song;                                                                //Name for the class object of song declare to be used inside the class to prevent instantiating everytime
      Playlist play;                                                            //Name for the class object Playlist is play declare to be used inside the class to prevent instantiating everytime
      Playlist Select=null;                                                     //create a class object to use when select option in Select Playlist set to null means no value to be used for the condition select playlist
      boolean loop;                                                             //to loop the program until exit
      boolean check;                                                            //checking if select
      String songTitle,songArtist,songAlbum;                                    //song,artist,and album variable when adding song
      String ListName;                                                          //String Holder for playlist name
      int ListNum=0;                                                            /* temporary variable name (changeable) for the playist number*/  
      int np;                                                                   // to set the now playing label
      int minute=0,second=10;                                                   // for the timer of the songs

     
    public static void main(String[] args) {
        
        System.out.println("                    Hello, Welcome to Music Library!\n\n");
        Music main = new Music();// Main object named main with the small "m"
        main.init();
        main.options();                                                         //main option method
   
    }
      void init(){
        play= new Playlist("Default");                                          // setting the default playlist
        song = new Song("Doobie dapdap","Willie Revillame","Wowowillie","Pop",2005);                    // setting the default playlist
        play.addSong(song);                                                     // setting the default song playlist using addSong function from
        song = new Song("Para Paraan","Willie Revillame","Wowowillie","Pop",2005);
        play.addSong(song); 
        playlist.add(play);   
      }
      void options(){ // options menu function/method
                                                          // adding the play object into the playlist using the add function and entering the play object
        
        
         while(true){                                                           //Repeat until Exit program
           boolean repeat = true; 
          //Main Menu
          while(repeat){
              
          check=false; //setting the check false to reset the checker for select playlist
             String red="\u001B[33m";
             String green = "\u001B[32m";
             String RESET = "\u001B[0m";
             System.out.println(red+"[x]        [x]"+green+"  [x]     [x]"+red+" [x][x][x][x]"+green+" [x][x][x][x]"+red+" [x][x][x][x]");
             System.out.println(red+"[x][x]  [x][x]"+green+"  [x]     [x]"+red+" [x]         "+green+"     [x]     "+red+" [x]         ");
             System.out.println(red+"[x]  [x]   [x]"+green+"  [x]     [x]"+red+" [x][x][x][x]"+green+"     [x]     "+red+" [x]         ");
             System.out.println(red+"[x]        [x]"+green+"  [x]     [x]"+red+"          [x]"+green+"     [x]     "+red+" [x]         ");
             System.out.println(red+"[x]        [x]"+green+"   [x][x][x] "+red+" [x][x][x][x]"+green+" [x][x][x][x]"+red+" [x][x][x][x]"+RESET);
          //System out MUSIC ICON fro the start for aesthetic purposes
          
          System.out.println("_____________________________________________________________________");
             System.out.printf("%38s","1 Open playlist");                     //%40s is to create 40 spaces beside the String also counting the String in the process
             System.out.println("");
             System.out.printf("%40s","2 Create playlist");                     
             System.out.println("");
             System.out.printf("%40s","3 Delete playlist");             
             System.out.println("");
             System.out.printf("%38s","4 Edit playlist");
             System.out.println("");
             System.out.printf("%29s","5 Exit");                                //%29s is to create 29 spaces beside the String also counting the String in the process
             System.out.println("");
             System.out.println("_____________________________________________________________________");
             System.out.print("\nChoose Option: ");
             
          int choose=scan.nextInt();                                            // choose input from the user
          scan.nextLine();                                                      //reset the scanner after using the scan nextInt bug
          
          //Open Playlist
          if(choose==1){                                       
            check = true; 
            
            do{                                                                 //do while loop to check if iput is correct
                System.out.println("\n\n(PLAYLISTS)");
              
                  for (int i = 0; i < playlist.size(); i++) {                   //for loop to get name of the arraylist name and use the int to print the numbering
                    System.out.println((i + 1) + ". " + playlist.get(i).getName());//playlist.get(i) index and use the arrayList of object play and use its function/method getName(); which returns the String
                  }
              
                System.out.println("\n\nEnter Playlist Number or type '0' to go back");
                ListNum =scan.nextInt();                                        //for the playlist number
                //break to go back
                if(ListNum==0){
                  break;
                  }
                  if(ListNum>playlist.size()){                                  //Checks if the input is valid to create an output
                   System.out.println("\n\nInvalid Input\n\n");
                  }
              
                 }
            while(ListNum>playlist.size());                                     //Checks if the input is valid to repeat
              if(ListNum!=0){
                scan.nextLine();
                play = playlist.get(ListNum-1);                                 //getting the playlist using -1 since index starts from zero so u need to subtract 1 to get the right element
                repeat=false;
              }
              loop=true;
          }
          
          //Create new Playlist
          else if(choose==2){                                                  //choice 2 in Main Menu
                                                                  
              System.out.println("Enter new Playlist Name (Leave Blank to go back)");
              ListName= scan.nextLine();
              if(ListName.isEmpty()){                                           //checks if scanner input is empty
                  options();
              }
                //For loop to Check same PlaylistName
                for (int i = 0; i < playlist.size(); i++) {                    
                   
                   if(ListName.equals(playlist.get(i).getName())){              //condition to check the inputed name to the arraylist name of playlist
                       System.out.println("\n\nPlayList name has been Taken\n\n");
                       options();
                   }
                 }
                
                play = new Playlist(ListName);                                  //adding the playlist name to the object constructor parameter
                playlist.add(play);                                             //adding the play object to the playlist array
                choose=0;
                System.out.println("\n\n_____________________________________________________________________");
                System.out.println("\u001B[34m"+ListName+"\u001B[0m     *Playlist successfully added*");   // \u001b blue color text
                System.out.println("_____________________________________________________________________\n\n");
              
          }
          
          //Delete Playlist 
          else if(choose==3){
              System.out.println("\n\n(PLAYLISTS)"); 
              
              for (int i = 0; i < playlist.size(); i++) {                       //Iterate the playlist name only
                System.out.println((i + 1) + ". " + playlist.get(i).getName());            
              }
              //validation
              System.out.println("Enter Playlist number to remove '0' to go back");
              int num = scan.nextInt();scan.nextLine();                         
              if(num==0){                                                       //when user input is 0 goes back to the menu
                 options();
              }
              
              System.out.println("Are you Sure You want to remove Y/N?");           
              char yn = scan.next().charAt(0);
              scan.nextLine();                                                  //reset scanner
              switch(yn){                                                       //switch for remove validation
                  case 'y':  
                      case 'Y':
                      System.out.println( playlist.get(num-1).getName()+" has been removed"); // display the playlist index and get the name
                      playlist.remove(num-1);                                   //using the arraylist funtion .remove to remove the playlist -1 since index starts at 0
                      break;
                  case 'n':
                      case 'N':
                      System.out.println("Action Cancelled");
                      break;
                  default:
                      System.out.println("Invalid Input");
              }
              
          }
           //EXIT
          else if(choose==4){
               System.out.println("\n\n(PLAYLISTS)"); 
              for (int i = 0; i < playlist.size(); i++) {                       //Iterate the playlist name only
                System.out.println((i + 1) + ". " + playlist.get(i).getName());            
              }
              System.out.println("Enter Playlist number to edit '0' to go back");
              int num = scan.nextInt();scan.nextLine();                       
              if(num==0){                                                       //when user input is 0 goes back to the menu
                 options();
              }
              System.out.println("Enter new Playlist Name");
              ListName= scan.nextLine();
              if(ListName.isEmpty()){
                  options();
              }
                //For loop to Check same PlaylistName
                for (int i = 0; i < playlist.size(); i++) {                    
                   
                   if(ListName.equals(playlist.get(i).getName())){              //condition to check the inputed name to the arraylist name of playlist
                       System.out.println("\n\nPlayList name has been Taken\n\n");
                       options();
                   }
                 }
              System.out.println("Are you Sure You want to rename Y/N?");           
              char yn = scan.next().charAt(0);
              scan.nextLine();                                                  //reset scanner
              switch(yn){                                                       //switch for remove validation
                  case 'y':  
                      case 'Y':
                      System.out.println( playlist.get(num-1).getName()+" has been renamed to" +ListName); // display the playlist index and get the name
                      playlist.get(num-1).Name=ListName;                        //using the arraylist funtion .set to set the new playlist name -1 since index starts at 0
                      break;
                  case 'n':
                      case 'N':
                      System.out.println("Action Cancelled");
                      break;
                  default:
                      System.out.println("Invalid Input");
              }  
           }
         
          //EXIT
          else if(choose==5){
              //validation for exit
              System.out.println("Are you Sure You want to exit? Y/N?");
              char yn = scan.next().charAt(0);
              scan.nextLine();
              switch(yn){
                  case 'y':  
                      case 'Y':  
                          System.out.println("Thank you for using the app");                    //The end of the Program (EXIT)
                          return;                                                               //return terminate the method
                  case 'n':
                      case 'N':
                      System.out.println("Action Cancelled");
                      break;
                  default:
                      System.out.println("Invalid Input");
                      break;
              }       
          }else{
              System.out.println("\n\nInvalid Input\n\n");
              
          }
         }
          
          
          while(loop){
            System.out.println("\n\nCurrent Playlist : "+play.Name);
            play.displayList();
            System.out.println("\n");
            System.out.println("1. Add song\n2. Remove song\n3. Play Playlist\n4. Exit");
            System.out.println("Choose Option: ");
            String opt= scan.nextLine();
         
              switch(opt){
           
                 case "1":
                    case "Add Song":
                       case "add song":
                        //Song INFO
                        System.out.println("Enter Song Title '0' to go back");
                        do{
                        songTitle = scan.nextLine();
                        }while(songTitle.isBlank());
                        if(songTitle.equals("0")){
                            break;
                        }
                        System.out.println("Enter Artist");
                     
                        songArtist = scan.nextLine();
                        
                        System.out.println("Enter Album");
                        
                        songAlbum = scan.nextLine();
                        
                        System.out.println("Enter Genre");
                        
                        String songGenre = scan.nextLine();
                        
                        System.out.println("Enter Year Released");
                        int songYear = scan.nextInt();scan.nextLine();
                        
                        //Format song title to capitalize 1st letter
                        //The substring() method in Java extracts a portion of a string, returning it as a new string
                        if(songTitle.length()!=0){
                            songTitle = songTitle.substring(0,1).toUpperCase()+songTitle.substring(1);  //substring(0,1)Gets the first character of the string and substring(1) Gets the remainder of the string starting from the second
                        }
                        if(songArtist.length()!=0){
                            songArtist =songArtist.substring(0,1).toUpperCase()+songArtist.substring(1); //substring(0,1)Gets the first character of the string and substring(1) Gets the remainder of the string starting from the second
                        }
                        if(songAlbum.length()!=0){
                            songAlbum =songAlbum.substring(0,1).toUpperCase()+songAlbum.substring(1); //substring(0,1)Gets the first character of the string and substring(1) Gets the remainder of the string starting from the second
                        } 
                        if(songGenre.length()!=0){
                            songGenre =songGenre.substring(0,1).toUpperCase()+songGenre.substring(1); //substring(0,1)Gets the first character of the string and substring(1) Gets the remainder of the string starting from the second
                        }
                        song = new Song(songTitle,songArtist,songAlbum,songGenre,songYear);        // adding the formatted songs to the playlist
                        play.addSong(new Song(songTitle,songArtist,songAlbum,songGenre,songYear)); // adding the formatted songs to the playlist
                     
                        System.out.println("\n"+songTitle+" by "+songArtist+" Successfully Added\n");
                     
                        break;
                 //remove song case
                 case "2":
                    case "Remove Song":
                      case "remove song":
                        play.displayList();                                 
                        System.out.println("\nEnter Song Number to Remove Song");
                        int removeNum = scan.nextInt();
                        System.out.println("Are you Sure You want to remove Y/N?");
                        char yn = scan.next().charAt(0);
                        scan.nextLine();
                    switch(yn){
                      case 'y':  
                         case 'Y':
                            play.removeSong(removeNum);                         //validate if yes then remove the song using .removeSong() function with the parameter removeNum
                            break;
                      case 'n':
                         case 'N':                                      
                            System.out.println("Action Cancelled");
                            break;
                      default:
                            System.out.println("Invalid Input");
                            break;
                    }
                    break;
                 //play song case
                 case "3":
                    case "Play":
                        case"play":
                        Playx();                                                //open play function
                        break;
                 //exit playlist
                 case "4":
                    case "exit":
                       case "Exit":
                       //validation for exit
                       System.out.println("Are you Sure You want to exit? Y/N?");
                       yn = scan.next().charAt(0);
                       scan.nextLine();
                       switch(yn){
                        case 'y':  
                         case 'Y':  
                            loop=false;
                            break;
                        case 'n':
                          case 'N':
                            System.out.println("Action Cancelled");
                            break;
                        default:
                            System.out.println("Invalid Input");
                        }  
                        break;
                default:
                    System.out.println("Error Wrong Input");
                    break;
               }
          }
       
                 if(!check){
                 
                   playlist.add(play);
                 }
              
              
        }
    }
        //play function to play music
      void Playx(){
          
          System.out.println("\nCurrent Playlist");
          play.displayList();
          np = play.songs.size();
          System.out.println("\n\n");
          System.out.println("1. Play first Song\n2. Choose Song to play\n3. Exit");
          int choice= scan.nextInt();
          scan.nextLine();
         
          switch (choice){
            //case 1 
            case 1:
             
              animation();
              System.out.println("Songs");
              for(int i=0; i <np;i++){
                  while(play.minutes>=0){
                   
                      while(play.seconds!=0){
                          System.out.println("");
                          System.out.printf("%-22s %-22s%-19s%-15s%-14s%-14s","Title","  Artist","Album","Genre","Year","                      Time");
                          System.out.print("\n-------------------------------------------------------------------------------------------------------------------------------\n");
                         for(int j=0; j<np;j++){
                              
                              System.out.print((j+1)+") ");
                              System.out.printf("%-22s",play.songs.get(j));
                             
                             if(i==j){
                              System.out.printf("%3s%-1s%-1s%-5s",play.minutes,":", play.seconds,"     now Playing");}
                            else{
                              System.out.printf("%-1s%1s%1s",minute,":",second);
                            }
                             System.out.println("");
                  }
                  try {
                        System.out.print("\n-------------------------------------------------------------------------------------------------------------------------------\n");
                        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n");
                      Thread.sleep(1000);
                      play.seconds-=1;
                     
                  }
                  catch (InterruptedException ex) {
                  }
                  }
                      play.seconds=10;
                      play.minutes-=1;
                  }
                  play.minutes=0;
                  System.out.println();
              }
              break;
              
              //case 2
              
              case 2:
                  System.out.println("");
                  System.out.printf("%-22s %-22s%-19s%-15s%-14s%-14s","Title","  Artist","Album","Genre","Year","                      Time");
                  System.out.print("\n-----------------------------------------------------------------------------------------\n");
                   for(int j=0; j<np;j++){
                             System.out.print((j+1)+") ");
                             System.out.printf("%-22s%-1s%-1s%-1s",play.songs.get(j),minute,":",second);
                             System.out.println("");
                   }
                  System.out.print("\n-----------------------------------------------------------------------------------------\n");
                  System.out.println("Choose what Song Number?");
                  int choose = scan.nextInt();
                  scan.nextLine();
                  if(choose>np){System.out.println("Error There is no Song in "+choose);
                  break;}
                  else{
                  animation();
                  int check=0;
                  if(choose>1){
                      check+=choose-1;}
                  else{
                      check=0;
                  }
                      System.out.println(np+""+(choose-1));
                  for(int i=0; i <np-check;i++){
                    while(play.minutes>=0){
                      while(play.seconds!=0){
                          System.out.printf("%-22s %-22s%-19s%-15s%-14s%-14s","Title","  Artist","Album","Genre","Year","                      Time");
                          System.out.print("\n-----------------------------------------------------------------------------------------\n");
                          for(int j=0; j<np;j++){                   
                             System.out.print((j+1)+") ");
                             System.out.printf("%-22s",play.songs.get(j));
                             if(j==(choose-1)){
                               System.out.printf("%3s%-1s%-1s%-5s",play.minutes,":", play.seconds,"     now Playing");
                             }
                             else if(i==j&&choose==0){
                              System.out.printf("%3s%-1s%-1s%-5s",play.minutes,":", play.seconds,"     now Playing");}
                             else{
                              System.out.printf("%-1s%1s%1s",minute,":",second);
                            }
                             System.out.println("");
                             }
                        try {
                        System.out.print("\n-----------------------------------------------------------------------------------------\n");
                        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n");
                        Thread.sleep(1000);
                        play.seconds-=1;
                         }
                  catch (InterruptedException ex) {
                  }
                  }
 
                      play.minutes-=1;
                      play.seconds=10;
                      
                  }choose++;
                  play.minutes=0;
                  System.out.println();
                  }
                  }    
              break;
             

              //case 3
              
              case 3:
                  //validation for exit
                       System.out.println("Are you Sure You want to exit? Y/N?");
                       char yn = scan.next().charAt(0);
             
                       switch(yn){
                        case 'y':  
                         case 'Y':
                            break;
                        case 'n':
                          case 'N':
                            System.out.println("Action Cancelled");
                            Playx();
                            break;
                        default:
                            System.out.println("Invalid Input");
                            break;
                        }           
                  break;
              default:
                  System.out.println("Error Wrong Input");
                  Playx();
                  
          }
      }
      
    public static void animation(){
         String space="";          
         for(int xd=0;xd<100;xd++){
                 System.out.println(space+"[x]      [x]  [x][x][x]  [x]         [x] [x][x][x]  [x]          [x][x]    [x]      [x] [x][x] [x][x] [x]      [x] [x][x][x][x]              ");
                 System.out.println(space+"[x][x]   [x] [x]     [x] [x]         [x] [x]    [x] [x]        [x]    [x]   [x]    [x]       [x]      [x][x]   [x] [x]              ");
                 System.out.println(space+"[x][x][x][x] [x]     [x] [x]         [x] [x]    [x] [x]       [x]      [x]    [x] [x]        [x]      [x][x][x][x] [x]  [[x][x]            ");
                 System.out.println(space+"[x]   [x][x] [x]     [x] [x]   [x]   [x] [x][x][x]  [x]       [x][x][x][x]      [x]          [x]      [x]   [x][x] [x]  [x] [x]            ");
                 System.out.println(space+"[x]     [[x] [x]     [x]  [x]  [x]  [x]  [x]        [x]       [x]      [x]      [x]          [x]      [x]     [[x] [x]      [x]           ");
                 System.out.println(space+"[x]      [x]  [x][x][x]     [x][x][x]    [x]        [x][x][x] [x]      [x]      [x]     [x][x] [x][x] [x]      [x] [x][x][x][x]              ");
         try{
             System.out.print("\n\n\n\n\n\n");
             space+=" ";
             Thread.sleep(30);
         }catch(InterruptedException ex){
            
         }
         }
     } 
}



