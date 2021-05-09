package com.johnfunk;

import java.util.Arrays;

public class FirstCodeChallenge {
    public static boolean test_firstcode_challenge(){
       int array[]={4,1,4,1,4,1,4,1} ;
       int expected_hops = 2 ;
       int hops = calculateHops( array) ;
       if( hops != expected_hops){
           System.out.printf("Test with values %s returned %d hops but expected %d\n", Arrays.toString(array), hops, expected_hops);
           return false ;
       }

        array= new int[]{1,4,3,1,4,3,1,4,3} ;
        expected_hops = 3;
        hops = calculateHops( array) ;
        if( hops != expected_hops){
            System.out.printf("Test with values %s returned %d hops but expected %d\n", Arrays.toString(array), hops, expected_hops);
            return false ;
        }

        array= new int[]{2,1,1,2,1,3,1,1,1} ;
        expected_hops = 5;
        hops = calculateHops( array) ;
        if( hops != expected_hops){
            System.out.printf("Test with values %s returned %d hops but expected %d\n", Arrays.toString(array), hops, expected_hops);
            return false ;
        }

        array= new int[]{2,1,2,1,3,1,1,4} ;
        expected_hops = 3;
        hops = calculateHops( array) ;
        if( hops != expected_hops){
            System.out.printf("Test with values %s returned %d hops but expected %d\n", Arrays.toString(array), hops, expected_hops);
            return false ;
        }


        return true ;
    }

    public static int calculateHops( int[] array){
        boolean oob = false ;
        int outterIndex = 0 ;

        int maxHop = 0 ;
        int maxHopIndex = 0 ;
        int numberOfHops = 0 ;

        System.out.printf("%s\n\r",Arrays.toString(array));

        do {
            int outterValue = array[outterIndex];
            int innerStartIndex = outterIndex +1;
            int innerEndIndex = innerStartIndex + outterValue;
            numberOfHops+=1 ;

           String s = "                                                ".substring(0,3*(outterIndex)+1) +"^" ;
           System.out.printf("%s\n\r",s);

            //find furthest next hop
            String s1 = "                                                ".substring(0,3*(innerStartIndex)) +"[";
            String s2 = "                                                ".substring(0,3*(outterValue)-2) +"]";
            System.out.printf("%s%s\n\r",s1,s2);

            for(int i=innerStartIndex;i < innerEndIndex; i++) {
                if (i < array.length) {
                    int currentHop = array[i];
                    if (maxHop <= currentHop) {
                        maxHop = currentHop;
                        maxHopIndex = i;
                    }

                }
            }
            outterIndex+= maxHop ;

            if(outterIndex < array.length) {   //if we're done no need to print
                String s3 = "                                                ".substring(0, 3 * (maxHopIndex) + 1) + "*";
                System.out.printf("%s\n\r", s3);
            }

        } while( outterIndex < array.length) ;

        return numberOfHops ;
    }

}
