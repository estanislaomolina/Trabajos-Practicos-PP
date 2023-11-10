package linea;

public abstract class GameMode {

   public abstract Boolean isGameOver(Linea linea);
   public abstract Boolean isTie(Linea linea);

   public abstract char getModeChar();

}
