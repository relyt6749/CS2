/*************************************************************************
 *  Compilation:  javac Rogue.java
 * 
 *************************************************************************/
/*my code*/
import java.io.*;
import java.util.*;
/*end my code*/
public class Rogue {
    private Game game;
    private Dungeon dungeon;
    private int N;

    // constructor - save away some useful information
    public Rogue(Game game) {
        this.game    = game;
        this.dungeon = game.getDungeon();
        this.N       = dungeon.size();
    }


    // TAKE A RANDOM LEGAL MOVE
    // YOUR MAIN TASK IS TO RE-IMPLEMENT THIS METHOD TO DO SOMETHING INTELLIGENT
    public Site move() {
        Site monster = game.getMonsterSite();
        Site rogue   = game.getRogueSite();
        Site move    = null;
        
        /****************************my code***********************************/
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        boolean loop = true;
        Site site = null;
        int roguey = rogue.i();
        int roguex = rogue.j();
        
        System.out.println("Would you like to go:" + 
                              "\n\t8: North" + 
                              "\n\t9: North East" + 
                              "\n\t6: East" + 
                              "\n\t3: South East" + 
                              "\n\t2: South" + 
                              "\n\t1: South West" + 
                              "\n\t4: West" + 
                              "\n\t7: North west" + 
                              "\n\t5: Stay Sill");
        
        while(loop)
        {
            choice = scanner.nextLine();
            
            switch(choice)
            {
                case "8"://N
                    
                    site = new Site(roguey-1, roguex);
                    if (dungeon.isLegalMove(rogue, site))
                    {
                        move = site;
                        loop = false;
                    }
                    else
                    {
                        System.out.println("Can't go that way. Lose your turn!");
                        loop = false;
                        site = new Site(roguey, roguex);
                        return site;
                    }
                    
                    break;
                    
                case "9"://NE
                    
                    site = new Site(roguey-1, roguex+1);
                    if (dungeon.isLegalMove(rogue, site))
                    {
                        move = site;
                        loop = false;
                    }
                    else
                    {
                        System.out.println("Can't go that way. Lose your turn!");
                        loop = false;
                        site = new Site(roguey, roguex);
                        return site;
                    }
                    
                    break;
                
                case "6"://E
                    
                    site = new Site(roguey, roguex+1);
                    if (dungeon.isLegalMove(rogue, site))
                    {
                        move = site;
                        loop = false;
                    }
                    else
                    {
                        System.out.println("Can't go that way. Lose your turn!");
                        loop = false;
                        site = new Site(roguex, roguey);
                        return site;
                    }
                    
                    break;
                    
                case "3"://SE
                    
                    site = new Site(roguey+1, roguex+1);
                    if (dungeon.isLegalMove(rogue, site))
                    {
                        move = site;
                        loop = false;
                    }
                    else
                    {
                        System.out.println("Can't go that way. Lose your turn!");
                        loop = false;
                        site = new Site(roguey, roguex);
                        return site;
                    }
                    
                    break;
                    
                case "2"://S
                    
                    site = new Site(roguey+1, roguex);
                    if (dungeon.isLegalMove(rogue, site))
                    {
                        move = site;
                        loop = false;
                    }
                    else
                    {
                        System.out.println("Can't go that way. Lose your turn!");
                        loop = false;
                        site = new Site(roguey, roguex);
                        return site;
                    }
                    
                    break;
                    
                case "1"://SW
                    
                    site = new Site(roguey+1, roguex-1);
                    if (dungeon.isLegalMove(rogue, site))
                    {
                        move = site;
                        loop = false;
                    }
                    else
                    {
                        System.out.println("Can't go that way. Lose your turn!");
                        loop = false;
                        site = new Site(roguey, roguex);
                        return site;
                    }
                    
                    break;
                
                case "4"://W
                    
                    site = new Site(roguey, roguex-1);
                    if (dungeon.isLegalMove(rogue, site))
                    {
                        move = site;
                        loop = false;
                    }
                    else
                    {
                        System.out.println("Can't go that way. Lose your turn!");
                        loop = false;
                        site = new Site(roguey, roguex);
                        return site;
                    }
                    
                    break;
                    
                case "7"://NW
                    
                    site = new Site(roguey-1, roguex-1);
                    if (dungeon.isLegalMove(rogue, site))
                    {
                        move = site;
                        loop = false;
                    }
                    else
                    {
                        System.out.println("Can't go that way. Lose your turn!");
                        loop = false;
                        site = new Site(roguey, roguex);
                        return site;
                    }
                    
                    break;
                
                case "5"://Stay
                    
                    site = new Site(roguey, roguex);
                    if (dungeon.isLegalMove(rogue, site))
                    {
                        move = site;
                        loop = false;
                    }
                    
                    break;
                    
                default:
                
                  System.out.println("InValid Selection. Try again...");
            }
        }
        
        /****************************end my code***********************************/

        // take random legal move
        /*
        int n = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Site site = new Site(i, j);
                if (dungeon.isLegalMove(rogue, site)) {
                    n++;
                    if (Math.random() <= 1.0 / n) move = site;
                }
            }
        }
        */
        return move;
    }

}
