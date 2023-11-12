package linea;

import java.util.Scanner;

public class Game {

    public static void main( String[] args) throws Exception {
        System.out.println( "Dimensiones?");
        Line game = new Line( prompt( "Base? " ), prompt( "Altura? " ), 'C' );
        System.out.println( game.show() );
        while ( !game.finished() ) {
            game.playRedAt( prompt( "Rojas? " ) );
            System.out.println( game.show() );
            if ( !game.finished() ) {
                game.playBlueAt( prompt( "Azules? " ) );
                System.out.println( game.show() );
            }
        }

    }
    private static int prompt( String message ) {
        System.out.print( message );
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();

    }
}