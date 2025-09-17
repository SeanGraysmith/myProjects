import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Piece class. 
 * 
 * Player 1 Piece image (gold coin) is from: https://commons.wikimedia.org/wiki/File:Post_medieval_gold_coin_%28FindID_448212%29.jpg and is in compliance with free use policies. 
 * Player 2 Piece image (silver coin) is from: https://upload.wikimedia.org/wikipedia/commons/f/f9/Silver_coin_of_James_II_of_Cyprus.jpg and complies with free use policies
 * 
 * @author 
 * @version 12/11/2024
 */
public class Piece extends Actor
{
    /* FIELDS */
    private boolean canMove;
    private int[] startingPositionXY;
    private int locIndex;
    private int targetLocIndex;
    private int playerNum;
    private boolean tempPieceStatus;
    private boolean inInfoScreen;
    /**
     * Piece Constructor.
     * 
     * @param playerNumber      Number/index of the current player (0 or 1)
     */
    public Piece(int playerNumber, int startingX, int startingY, boolean tempPieceStatus)
    {
        canMove = true;
        this.locIndex = -1;
        this.targetLocIndex = -1;
        startingPositionXY = new int[] {startingX, startingY};
        this.playerNum = playerNumber; // store who this piece belongs to.
        this.tempPieceStatus = tempPieceStatus;
        if (playerNum == 0) 
        {
            this.setImage("red_Piece.png");
        }// end if
        else
        {
            this.setImage("blue_Piece.png");
        }// end if
        if (tempPieceStatus == true)
        {
            getImage().setTransparency(150);
        }// end if
    } // end constructor Piece
    /**
     * Act method.
     */
    public void act()
    {
        if (canMove && inInfoScreen != true) 
        {
            getImage().setTransparency(255);
        }// end if
        else if (canMove == false && inInfoScreen != true)
        {
            getImage().setTransparency(150);
        }// end if
    } // end method act
    /**
     * Getter for canMove.
     * 
     * @return If the piece can move or not
     */
    public boolean isMoveable() 
    {
        return canMove;
    } // end method isMoveable
    /**
     * Setter for setMoveable
     * 
     * @param moveable      Boolean value to set moveable status to.
     */
    public void setMoveable(boolean moveable)
    {
        this.canMove = moveable; 
    }// end method setMoveable
    /**
     * Getter for current location index.
     * 
     * @return The current location index
     */
    public int getLocIndex() 
    {
        return locIndex;
    }// end method getLocIndex
    /**
     * Sets the location index for the current piece.
     * 
     * @param boardLocIndex     Location index to set the location to for the piece. (int)
     */
    public void setLocIndex(int boardLocIndex)
    {
        this.locIndex = boardLocIndex;
    }// end method setLocIndex
    /**
     * Getter for target location index.
     * 
     * @return The target location index.
     */
    public int getTargetLocIndex()
    {
        return targetLocIndex;
    }// end method getTargetLocIndex
    /**
     * Setter for target location index.
     * 
     * @param targetLocation      Target location index to give the piece. (int)  
     */
    public void setTargetLocIndex(int targetLocation)
    {
        this.targetLocIndex = targetLocation;
    }// end method setTargetLocIndex
    /**
     * Getter for the starting x coordinate.
     * 
     * @return The x value for the starting coordinate of this piece. 
     */
    public int getStartingXCoord()
    {
        return startingPositionXY[0];
    }// end method getStartingXCoord
    /**
     * Getter for the starting y coordinate.
     * 
     * @return The y value for the starting coordinate of this piece.
     */
    public int getStartingYCoord()
    {
        return startingPositionXY[1];
    }// end method getStartingYCoord
    /**
     * Getter for the player this piece belongs to.
     * 
     * @return The player index this piece belongs to.
     */
    public int getPlayerNum()
    {
        return playerNum;
    } // end method getPlayerNum
    /**
     * Setter for the inInfoScreen variable
     * 
     * @param infoStatus  boolean of whether the user is currently engaged with the info screen. 
     */
    public void setInfoStatus(boolean infoStatus)
    {
        inInfoScreen = infoStatus;
    }// end method setInfoStatus
} // end class Piece
