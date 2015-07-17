package com.mehdi.easymock.rotates;

/**
 * @author Mehdi Afsari Kashi
 * @version 1.0.0
 *          <p/>
 *          Creation Date: 2015/07/17
 * @since 1.0.0
 */
public class RotateMock {
    private RotateService rotateService;

    public RotateMock(RotateService rotateService){
        this.rotateService = rotateService;
    }

    public boolean isEqual( ) {
        int[][] leftRotated = rotateService.rotateLeft();
        int[][] rightRotated = rotateService.rotateRight();
        boolean equal = true;

        for(int i=0;i<leftRotated.length;i++) {
            for(int j=0;j<leftRotated.length;j++) {
                if(leftRotated[i][j]!= rightRotated[i][j]) {
                    equal = false; //The two boards are not same.
                    return equal;
                }
            }
        }

        return equal;
    }

}
