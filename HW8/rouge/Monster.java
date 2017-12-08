/*************************************************************************
 *  Compilation:  javac Monster.java
 * 
 *************************************************************************/

public class Monster {
    private Game game;
    private Dungeon dungeon;
    private int N;

    // constructor - save away some useful information
    public Monster(Game game) {
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
        
        //my code
        Site site = null;
        Site site2 = null;
        Site site3 = null;
        Site site4 = null;
        int mony = monster.i();
        int monx = monster.j();
        int roguey = rogue.i();
        int roguex = rogue.j();
        
        if(roguey > mony && roguex > monx)
        {
            site = new Site(mony+1, monx+1);
            if (dungeon.isLegalMove(monster, site))
            {
                move = site;
            }

            else
            {
               site = new Site(mony+1,monx);
               site2 = new Site(mony,monx+1);
               site3 = new Site(mony,monx-1);
               site4 = new Site(mony-1,monx);
               if (dungeon.isLegalMove(monster, site))
               {
                   move = site;
               }
               else if(dungeon.isLegalMove(monster, site2))
               {
                   move = site;
               }
               else if(dungeon.isLegalMove(monster, site3))
               {
                   move = site;
               }
               else if(dungeon.isLegalMove(monster, site4))
               {
                   move = site;
               }
            }
        }
        
        if(roguey > mony && roguex == monx)
        {
            site = new Site(mony+1, monx);
            if (dungeon.isLegalMove(monster, site))
            {
                move = site;
            }

            else
            {
               site = new Site(mony+1,monx);
               site2 = new Site(mony,monx+1);
               site3 = new Site(mony,monx-1);
               site4 = new Site(mony-1,monx);
               if (dungeon.isLegalMove(monster, site))
               {
                   move = site;
               }
               else if(dungeon.isLegalMove(monster, site2))
               {
                   move = site;
               }
               else if(dungeon.isLegalMove(monster, site3))
               {
                   move = site;
               }
               else if(dungeon.isLegalMove(monster, site4))
               {
                   move = site;
               }
            }
        }
        
        if(roguey > mony && roguex < monx)
        {
            site = new Site(mony+1, monx-1);
            if (dungeon.isLegalMove(monster, site))
            {
                move = site;
            }

            else
            {
               site = new Site(mony+1,monx);
               site2 = new Site(mony,monx-1);
               site3 = new Site(mony,monx+1);
               site4 = new Site(mony-1,monx);
               if (dungeon.isLegalMove(monster, site))
               {
                   move = site;
               }
               else if(dungeon.isLegalMove(monster, site2))
               {
                   move = site;
               }
               else if(dungeon.isLegalMove(monster, site3))
               {
                   move = site;
               }
               else if(dungeon.isLegalMove(monster, site4))
               {
                   move = site;
               }
            }
        }
        
        if(roguey < mony && roguex > monx)
        {
            site = new Site(mony-1, monx+1);
            if (dungeon.isLegalMove(monster, site))
            {
                move = site;
            }

            else
            {
               site = new Site(mony-1,monx);
               site2 = new Site(mony,monx+1);
               site3 = new Site(mony,monx-1);
               site4 = new Site(mony+1,monx);
               if (dungeon.isLegalMove(monster, site))
               {
                   move = site;
               }
               else if(dungeon.isLegalMove(monster, site2))
               {
                   move = site;
               }
               else if(dungeon.isLegalMove(monster, site3))
               {
                   move = site;
               }
               else if(dungeon.isLegalMove(monster, site4))
               {
                   move = site;
               }
            }
        }
        
        if(roguey < mony && roguex == monx)
        {
            site = new Site(mony-1, monx);
            if (dungeon.isLegalMove(monster, site))
            {
                move = site;
            }

            else
            {
               site = new Site(mony-1,monx);
               site2 = new Site(mony,monx+1);
               site3 = new Site(mony,monx-1);
               site4 = new Site(mony+1,monx);
               if (dungeon.isLegalMove(monster, site))
               {
                   move = site;
               }
               else if(dungeon.isLegalMove(monster, site2))
               {
                   move = site;
               }
               else if(dungeon.isLegalMove(monster, site3))
               {
                   move = site;
               }
               else if(dungeon.isLegalMove(monster, site4))
               {
                   move = site;
               }
            }
        }
        
        if(roguey < mony && roguex < monx)
        {
            site = new Site(mony-1, monx-1);
            if (dungeon.isLegalMove(monster, site))
            {
                move = site;
            }

            else
            {
               site = new Site(mony-1,monx);
               site2 = new Site(mony,monx-1);
               site3 = new Site(mony,monx+1);
               site4 = new Site(mony+1,monx);
               if (dungeon.isLegalMove(monster, site))
               {
                   move = site;
               }
               else if(dungeon.isLegalMove(monster, site2))
               {
                   move = site;
               }
               else if(dungeon.isLegalMove(monster, site3))
               {
                   move = site;
               }
               else if(dungeon.isLegalMove(monster, site4))
               {
                   move = site;
               }
            }
        }
        
        if(roguey == mony && roguex > monx)
        {
            site = new Site(mony, monx+1);
            if (dungeon.isLegalMove(monster, site))
            {
                move = site;
            }

            else
            {
               site = new Site(mony,monx+1);
               site2 = new Site(mony-1,monx);
               site3 = new Site(mony+1,monx);
               site4 = new Site(mony,monx-1);
               if (dungeon.isLegalMove(monster, site))
               {
                   move = site;
               }
               else if(dungeon.isLegalMove(monster, site2))
               {
                   move = site;
               }
               else if(dungeon.isLegalMove(monster, site3))
               {
                   move = site;
               }
               else if(dungeon.isLegalMove(monster, site4))
               {
                   move = site;
               }
            }
        }
        
        if(roguey == mony && roguex < monx)
        {
            site = new Site(mony, monx-1);
            if (dungeon.isLegalMove(monster, site))
            {
                move = site;
            }

            else
            {
               site = new Site(mony,monx-1);
               site2 = new Site(mony+1,monx);
               site3 = new Site(mony-1,monx);
               site4 = new Site(mony,monx+1);
               if (dungeon.isLegalMove(monster, site))
               {
                   move = site;
               }
               else if(dungeon.isLegalMove(monster, site2))
               {
                   move = site;
               }
               else if(dungeon.isLegalMove(monster, site3))
               {
                   move = site;
               }
               else if(dungeon.isLegalMove(monster, site4))
               {
                   move = site;
               }
            }
        }
        /************************************end my code***************************************************/
        
        
        // take random legal move
        /*
        int n = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Site site = new Site(i, j);
                if (dungeon.isLegalMove(monster, site)) {
                    n++;
                    if (Math.random() <= 1.0 / n) 
                        move = site;
                }
            }
        }
        */
        return move;
    }

}
