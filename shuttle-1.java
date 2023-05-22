import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * This is the Class that controlls the movements of a spaceship on its trip to the Moon
 * and back to Earth again.  The actor is the Object Shuttle.
 * 
 * @author Randy Gallant 
 * @version 1.0 Nov. 2007
 */
public class shuttle extends Actor
{
    /**
     * These are the class' variables that are set up to make the trip to the Moon Possible
     */

    private static final int EAST = 0;      //variables for direction
    private static final int WEST = 1;
    private static final int NORTH = 2;
    private static final int SOUTH = 3;
    private  int CentreTurnX;       //initial turning points for manouvers
    private  int CentreTurnY;
    private static int Fuel;
    private int count = 0;//fuel variable
    public Flag F1;     //flag object
    public Home H1;     //welcome home sign object
    public OutofFuel OOF;   //out of fuel object
    private int fuelstops = 0;      //fuel stops flag
    private int direction;
    private Counter FCounter;   //fuel counter object
    public Explosion EXP;       //Explosion object
    public Explosion1 EXP1;     //explosion1 object
    private  static boolean manouverRight;  
    private  static boolean manouverRight1; //flagts for manouvering around the rocks
    private  static boolean manouverLeft;
    private  static boolean manouverLeft1;
    private  static boolean manouverCentre;
    private  static boolean manouverCentre1;
    private  static boolean returntrip;     //flag for return trip
    private int weaponCount;        //variable to keep track of your weapons

    /**---------------------------------------Shuttle Constuctor --------------------------------------
     * This is the Constructor for the class Shuttle which sets initial conditions
     */
    public shuttle()
    {
        setDirection(NORTH);       //set initial direction
        Fuel = 1500;       //set initial fuel to 1500 pounds
        weaponCount = 1;     //set weapon count to 1
        manouverRight = false;     //set inital flags
        manouverLeft = false;
        manouverCentre = false;
        returntrip = false;
    }

    /**-------------------------------------- Found Space Station ----------------------------------------
     * This method detects that you have found the space station
     */

    public boolean FoundSpaceStation()  //Found Space Station
    {
        Actor SpaceS = getOneObjectAtOffset(-15, -15, spacestation.class); //detects objects at offset from shuttle
        if(SpaceS != null) {
            return true;
        }
        else {
            return false;
        }
    }

    /**-------------------------------------- Found Moon Landing ----------------------------------------
     * This method detects that you have found the small Moon Landing pad
     */
    public boolean FoundMoonLanding()  //Found Space Station
    {
        Actor SpaceS1 = getOneObjectAtOffset(0, -15, MoonLandingPad.class); //detects objects at offset from shuttle
        if(SpaceS1 != null) {
            return true;
        }
        else {
            return false;
        }
    }

    /**-------------------------------------- Found Moon ----------------------------------------
     * This method destoys the ship and Moon if you hit the Moon not the landing point
     */
    public boolean FoundMoon()      //Found Moon
    {
        Actor MoonL = getOneObjectAtOffset(0, 0, MoonLand.class);   // detects object at offset from shuttle
        if(MoonL != null) {
            return true;
        }
        else {
            return false;
        }
    }

    /**-------------------------------------- Found Rock Right Return ----------------------------------------
     * This method detects that you found a Right Rock on your return trip
     */ 
    public boolean FoundRockRight1()  
    {
        Actor Rock1 = getOneObjectAtOffset(0, 15, RockRight.class);       //detect object at offset to shuttle
        if(Rock1 != null) 
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    /**-------------------------------------- Found Rock Left Return ----------------------------------------
     * This method detects that you found a Left Rock on your return trip
     */ 
    public boolean FoundRockLeft1() 
    {//found right rock on return trip
        Actor Rock2 = getOneObjectAtOffset(0, 15, RockLeft.class);       //detect object at offset to shuttle
        if(Rock2 != null) 
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    /**-------------------------------------- Found Rock Centre Return ----------------------------------------
     * This method detects that you found a Centre Rock on your return trip
     */ 
    public boolean FoundRockCentre1()  
    {//found right rock on return trip
        Actor Rock3 = getOneObjectAtOffset(0, 15, RockCentre.class);
        //detect object at offset to shuttle
        if(Rock3 != null) 
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    /**-------------------------------------- Found Rock Right ----------------------------------------
     * This method detects that you found a Right Rock on your to the Moon trip
     */
    public boolean FoundRockRight()  
    {//found right rock on return trip
        Actor Rock4 = getOneObjectAtOffset(0, -15, RockRight.class);       //detect object at offset to shuttle
        if(Rock4 != null) 
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    /**-------------------------------------- Found Rock Left ----------------------------------------
     * This method detects that you found a Left Rock on your to the Moon trip
     */
    public boolean FoundRockLeft()    
    {//found right rock on return trip
        Actor Rock5 = getOneObjectAtOffset(0, -15, RockLeft.class);       //detect object at offset to shuttle
        if(Rock5 != null) 
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    /**-------------------------------------- Found Rock Centre ----------------------------------------
     * This method detects that you found a Centre Rock on your to the Moon trip
     */
    public boolean FoundRockCentre()    
    {//found right rock on return trip
        Actor Rock6 = getOneObjectAtOffset(0, -15, RockCentre.class);       //detect object at offset to shuttle
        if(Rock6 != null) 
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    /**-------------------------------------- Found Big Rock  ----------------------------------------
     * This method detects that you found a Big Rock on your to the Moon trip
     */
    public boolean FoundBigRock()  
    {//found right rock on return trip
        Actor Rock6 = getOneObjectAtOffset(0, -15, BigRock.class);       //detect object at offset to shuttle
        if(Rock6 != null) 
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    /**-------------------------------------- Found Earth Landing ----------------------------------------
     * This method detects that you have found the small Earth Landing pad
     */
    public boolean FoundEarthLanding()  //Found Space Station
    {
        Actor SpaceS1 = getOneObjectAtOffset(0, -15, EarthLandingPad.class); //detects objects at offset from shuttle
        if(SpaceS1 != null) {
            return true;
        }
        else {
            return false;
        }
    }

    /**-------------------------------------- Found Earth ----------------------------------------
     * This method destoys the ship and Earth if you hit the Earth not the landing point
     */
    public boolean FoundEarth()
    {
        Actor EarthL = getOneObjectAtOffset(0, 0, Earth.class); // detects object at offset from shuttle
        if(EarthL != null) {
            return true;
        }
        else {
            return false;
        }
    }

    /**-------------------------------------- Can Move ----------------------------------------
     * This method determines if the ship can move or not.  If it has come in contact with
     * an Object in space or has detected the edge of the world
     */   
    public boolean canMove()
    {
        World myWorld = getWorld();
        int x = getX();
        int y = getY();
        switch(direction) 
        {
            case SOUTH :
                y++;
                break;
            case EAST :
                x++;
                break;
            case NORTH :
                y--;
                break;
            case WEST :
                x--;
                break;
        }

        if (x >= myWorld.getWidth() || y >= myWorld.getHeight()) 
        {
            return false;
        }
        else if (x < 0 || y < 0) 
        {
            return false;
        }

        return true;
    }

    /**-------------------------------------- Set Direction ----------------------------------------
     * This method sets the direction of the graphic of your ship to match your movements
     */ 
    public void setDirection(int direction)
    {
        this.direction = direction;
        switch(direction) {
            case SOUTH :
                setRotation(180);
                break;
            case EAST :
                setRotation(90);
                break;
            case NORTH :
                setRotation(0);
                break;
            case WEST :
                setRotation(270);
                break;
            default :
                break;
        }
    }

    /**-------------------------------------- Fuel Dec ----------------------------------------
     * This method creates a new fuel counter and updates it every time you act
     */
    public void FuelDec()
    {
        if(FCounter == null) 
        {
            FCounter = new Counter("Fuel: ", Fuel);   //new fuel counter  
            getWorld().addObject(FCounter, 720, 280);       //add object to world at location
        }        
        FCounter.Decrement();   //decrement the fuel counter
    }

    /**-------------------------------------- Destroy -- ----------------------------------------
     * This method creates a new explosion and destroys object at offset
     */
    public void Destroy()
    {
        Explode();      //call to destroy the rock
        weaponCount--;
        Actor rock = getOneObjectAtOffset(0, -15, BigRock.class);   //detect object at offset to shuttle
        if(rock != null) 
        {
            getWorld().removeObject(rock);
        }
    }

    /**-------------------------------------- Explode ----------------------------------------
     * This method creates a new explosion 
     */ 
    public void Explode()
    {
        EXP1 = new Explosion1();        // new explosion1 object
        getWorld().addObject(EXP1,getX(),getY());    //add object to world at position
    }

    /**-------------------------------------- Destroy Ship ----------------------------------------
     *This method creates a new explosion and destroys all that touches it
     */
    public void DestroyShip()
    {
        EXP = new Explosion();  // new explosion object
        getWorld().addObject(EXP,getX(),getY());      //add object to world at position
    }

    /**-------------------------------------- Set Flag ----------------------------------------
     * This method creates a new Flag and displays it on the moon
     */  
    public void SetFlag()
    {
        F1 = new Flag();       //new flag object
        getWorld().addObject(F1,450,50);

    }

    /**--------------------------------------Welcome Home ----------------------------------------
     * This method creates a new welcome home sign and displays it
     */ 
    public void WelcomeHome()
    {
        H1 = new Home();       //new welcome home sign
        getWorld().addObject(H1,550,750);  //add new object to world at location
    }

    /**------------------------------------- Act -------------------------------------------------
     * This metod act controls the overall movement of your ship for every 1 grid location you move
     * Act - do whatever the shuttle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        /**-------------------------------Trip to Moon ------------------------------------------
         * The first part of this code is for setting the direction of the movements
         *on the way to the moon.  There is different code to control the return trip
         */
        //if(canMove())
        //move();
        if(returntrip == false)     //Checks to see if you have already been to the Moon
        {
            if(Fuel <=0)        //check to see if you are out of fuel
            {
                OOF = new OutofFuel();  //new out of fuel object
                getWorld().addObject(OOF,getX(),getY());    //add object to world at position 
            }

            /**  Your code that goes here must detect the objects and conduct the movements or take the action
             * required of your Shuttle at this point of the initial trip
             * 
             * This is the largest area of code you will enter.
             * 
             * My code below is there to destroy your ship if you do not detect the objects an hit them.  This code must 
             * stay and you can add yours above it.
             * 
             * The code you must enter here are all of the else if statements to determine what is in your path and what to 
             * what to do about it.  So things like:
             **/ 
            // // Follow the examples in the labs if you get stuck!!

            //FoundSpaceStation() for this part will reset your fuel to 2500 for the trip to the Moon.
            else if(manouverCentre == true)     //Centre rock manouvers code Part 1 from Lab 4
            {
                int x = getX();      //get location for next turn
                int y = getY();
                Fuel = 1500;

                if (CentreTurnX+170 == x && CentreTurnY ==y)  // detect next turning point for manouvers
                {
                    setDirection(NORTH);
                    move();
                }

                else if(CentreTurnX+170 == x && CentreTurnY-65 == y) // detect next turning point for manouvers
                {
                    setDirection(WEST);
                    move();
                }

                else if((CentreTurnX==x) &&(CentreTurnY-65 == y))    // detect next turning point for manouvers
                {
                    setDirection(NORTH);
                    manouverCentre = false;      //end manouver
                    move();
                }
                else
                {
                    move();
                }
            }

            /** You will need to remove the comments on the following code before use!
             * 
             */

            else if(manouverRight == true)      //Right rock manouvers
            {
                int x = getX();      //gets points for manouvering around rocks
                int y = getY();

                if (CentreTurnX+85 == x && CentreTurnY ==y)     //locates next turning point in manouver
                {
                    setDirection(NORTH);
                    move();
                }

                else if(CentreTurnX+85 == x && CentreTurnY-65 == y)     //locates next turning point in manouver
                {
                    setDirection(WEST);
                    move();
                }

                else if((CentreTurnX==x) &&(CentreTurnY-65 == y))    //locates next turning point in manouver
                {
                    setDirection(NORTH);
                    manouverRight = false;      //end of manouver
                    move();
                }
                else
                {
                    move();
                }
            }

        
            else if(manouverLeft == true)       //Left rock manouvers
            {
                int x = getX();      //gets points for manouvering around rocks
                int y = getY();

                if (CentreTurnX-85 == x && CentreTurnY ==y)     //locates next turning point in manouver
                {
                    setDirection(NORTH);
                    move();
                }

                else if(CentreTurnX-85 == x && CentreTurnY-65 == y)     //locates next turning point in manouver
                {
                    setDirection(EAST);
                    move();
                }

                else if((CentreTurnX==x) &&(CentreTurnY-65 == y))    //locates next turning point in manouver
                {
                    setDirection(NORTH);
                    manouverLeft = false;      //end of manouver
                    move();
                }
                else
                {
                    move();
                }
            }

            else if (FoundRockRight())      //checks for finding the RockRight
            {
                manouverLeft = true;      //start of manouver
                setDirection(WEST);
                CentreTurnX = getX();       //gets turning original point for location in space
                CentreTurnY = getY();
                move();
            }

            else if (FoundRockLeft())  //checks for finding the RockLeft
            {
                manouverRight = true;      //start of manouver
                setDirection(EAST);
                CentreTurnX = getX();       //gets turning original point for location in space
                CentreTurnY = getY();
                move();
            }

            else if (FoundRockCentre())  //checks for finding the RockCentre  code Part 2 from Lab 4!
            {
                manouverCentre = true;      //start of manouvers
                setDirection(EAST);
                CentreTurnX = getX();       //set starting point for manouvers
                CentreTurnY = getY();
                move();
            } 
            else if( FoundMoonLanding())
            {
                SetFlag();
                setDirection(SOUTH);
                returntrip = true;
                move();
            }

             
            
            //----------------------------This code must stay to destroy your ship if needed---------------
            else if (FoundMoon())
            {       
                DestroyShip();      //call to destroy your ship you hit something           
            }          
            else if (FoundEarth())
            {       
                DestroyShip();    //call to destroy your ship you hit something              
            }
            else if (FoundRockRight())
            {       
                DestroyShip();   //call to destroy your ship you hit something               
            }
            else if (FoundRockLeft())
            {       
                DestroyShip();    //call to destroy your ship you hit something              
            }
            else if (FoundRockCentre())
            {       
                DestroyShip();    //call to destroy your ship you hit something              
            }
            else if (FoundBigRock())
            {       
                Destroy();   //call to destroy your ship you hit something              
            }
            else if(getX() == 400 && getY() == 350)      //must locate point X = 400 & y = 350 and change direction
            {
            count++;
           // System.out.println(count);
            if(count == 1)
            {
            setDirection(EAST);
            move();
            }
            else
            {
                setDirection(NORTH);
                move();
            }
            }

            else if (FoundSpaceStation())
            {
                Fuel =2500;     //reset the fuel to 2500 for continued trip to the moon
                FCounter.Reset(Fuel);
                setDirection(WEST);
                move();
            }  
        else if(canMove()) 
        {
            move();
        }
        else 
        {
            turn();
            move();
        }
        }

        /**----------------------------------Return Trip back to Earth -----------------------
         * The following code controls the movement of your ship for the return trip to Earth
         * Notice that some of the directions of motion have changed from the first part
         */

        else if(returntrip == true)  //Checks to see if you have already been to the Moon
        {
            if(canMove())
                move();
            if(Fuel <=0)
            {
                OOF = new OutofFuel();  //new out of fuel object
                getWorld().addObject(OOF,getX(),getY());        //add object to world at position
            }
            else if(manouverCentre1 == true)     //Centre rock manouvers code Part 1 from Lab 4 with different directions and points
            {                                   //pay very close attention to this, this is where the differences are!
                int x = getX();  //sets points for next turn
                int y = getY();

                if (CentreTurnX+170 == x && CentreTurnY ==y)     //checks for next turn
                {
                    setDirection(SOUTH);
                    move();
                }

                else if(CentreTurnX+170 == x && CentreTurnY+65 == y) //checks for next turn
                {
                    setDirection(WEST);
                    move();
                }

                else if((CentreTurnX==x) &&(CentreTurnY+65 == y))    //checks for next turn
                {
                    setDirection(SOUTH);
                    manouverCentre = false;      //end of manouver
                    move();
                }
                else
                {
                    move();
                }
            }
            /** You will need to remove the comments on the following code before use!
             * 
             */ 

            else if(manouverRight1 == true)      //Right rock manouvers
            {
                int x = getX();      //gets points for manouvering around rocks
                int y = getY();

                if (CentreTurnX+85 == x && CentreTurnY ==y)     //locates next turning point in manouver
                {
                    setDirection(SOUTH);
                    move();
                }

                else if(CentreTurnX+85 == x && CentreTurnY+65 == y)     //locates next turning point in manouver
                {
                    setDirection(WEST);
                    move();
                }

                else if((CentreTurnX==x) &&(CentreTurnY+65 == y))    //locates next turning point in manouver
                {
                    setDirection(SOUTH);
                    manouverRight = false;      //end of manouver
                    move();
                }
                else
                {
                    move();
                }
            }

            else if(manouverLeft1 == true)       //Left rock manouvers
            {
                int x = getX();      //gets points for manouvering around rocks
                int y = getY();

                if (CentreTurnX-85 == x && CentreTurnY ==y)     //locates next turning point in manouver
                {
                    setDirection(SOUTH);
                    move();
                }

                else if(CentreTurnX-85 == x && CentreTurnY+65 == y)     //locates next turning point in manouver
                {
                    setDirection(EAST);
                    move();
                }

                else if((CentreTurnX==x) &&(CentreTurnY+65 == y))    //locates next turning point in manouver
                {
                    setDirection(SOUTH);
                    manouverLeft = false;      //end of manouver
                    move();
                }
                else
                {
                    move();
                }
            }
            else if(FoundMoonLanding())
            {
                //     Your code goes here!
            }
            else if (FoundRockRight1())      //checks for finding the RockRight
            {
                manouverLeft1 = true;      //start of manouver
                setDirection(WEST);
                CentreTurnX = getX();       //gets turning original point for location in space
                CentreTurnY = getY();
                move();
            }

            else if (FoundRockLeft1())  //checks for finding the RockLeft
            {
                manouverRight1 = true;      //start of manouver
                setDirection(EAST);
                CentreTurnX = getX();       //gets turning original point for location in space
                CentreTurnY = getY();
                move();
            }

            else if (FoundRockCentre1())  //checks for finding the RockCentre  code Part 2 from Lab 4!
            {
                manouverCentre1 = true;      //stat of manouver
                setDirection(EAST);
                CentreTurnX = getX();       //gets starting points of the inital turn
                CentreTurnY = getY();
                move();
            }

            /**  Your code that goes here must detect the objects and conduct the movements or take the action
             * required of your Shuttle at this point of the return trip
             * 
             * Again This is the largest area of code you will enter.
             * 
             * My code below is there to destroy your ship if you do not detect the objects an hit them.  This code must 
             * stay and you can add yours above it.
             * 
             * The code you must enter here are all of the else if statements to determine what is in your path and what to 

            what to do about it.  So things like:
             **/

            else if(FoundEarthLanding())
            {
                //Your code goes here!
            }

            // Follow the examples in the labs if you get stuck!!

            //FoundSpaceStation() for this part will reset your fuel to 1500 for the trip home.

            //----------------------------This code must stay to destroy your ship if needed---------------
            else if (FoundMoon())
            {       
                DestroyShip();     //call to destroy your ship you hit something            
            }       
            else if (FoundEarth())
            {       
                DestroyShip();       //call to destroy your ship you hit something          
            }
            else if (FoundRockRight())
            {       
                DestroyShip();       //call to destroy your ship you hit something          
            }
            else if (FoundRockLeft())
            {       
                DestroyShip();        //call to destroy your ship you hit something         
            }
            else if (FoundRockCentre())
            {       
                DestroyShip();        //call to destroy your ship you hit something         
            }
            else if (FoundBigRock())
            {       
                DestroyShip();       //call to destroy your ship you hit something          
            }                    
            else if (FoundSpaceStation())
            {
                Fuel =1500;     //reset the fuel to 1500 for continued trip back to the earth
                FCounter.Reset(Fuel);
                setDirection(WEST);
                move();
            }
        } 
        else if(canMove()) 
        {
            move();
        }
        else 
        {
            turn();
            move();
        }

    }

    /**-------------------------------- Turn ------------------------------
     * This method you can use to control your ships direction at any point
     */ 
    public void turn()
    {
        switch(direction) 
        {
            case SOUTH :
                setDirection(EAST);
                break;
            case EAST :
                setDirection(SOUTH);
                break;
            case NORTH :
                setDirection(EAST);
                break;
            case WEST :       
                setDirection(NORTH);               
                break;
        }
    }

    /**------------------------------------- Move ------------------------------------
     * This method keeps track of your fuel for every movement
     * This method also moves your ship 1 place on th grid
     */
    public void move()
    {
        Fuel --;        //decrement fuel variable
        FuelDec();      //call to decrement the fuel counter
        switch(direction) {
            case SOUTH :
                setLocation(getX(), getY() + 1);
                break;
            case EAST :
                setLocation(getX() + 1, getY());
                break;
            case NORTH :
                setLocation(getX(), getY() - 1);
                break;
            case WEST :
                setLocation(getX() - 1, getY());
                break;
        }
    }

}//end of class
