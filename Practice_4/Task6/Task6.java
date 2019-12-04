import java.util.*;

public class Task6 {
    public static void main(String[] args) {
        String[] players = {"semen 16", "Ivan 5", "Petr 3", "Alex 10", "Petr 8", "Ivan 6", "Alex 5", "Ivan 1", "Petr 5", "Alex 1"};
        showWinner(players);
    }

    //Показываем победителя игры
    private static void showWinner(String[] strPlayers){
        Map<String, Integer> players = new HashMap<>(); //словарь игроков с набранными очками

        String winner = ""; //имя победителя

        for (String strPlayer: strPlayers){
            //Парсим имя и очки игрока из строки
            String[] tmpInfo = strPlayer.split(" ");
            String name = tmpInfo[0];
            Integer balls =  Integer.valueOf(tmpInfo[1]);
            //если игрок уже есть в словаре, то пересчитываем общие очки
            if (players.containsKey(name)) {
                balls = players.get(name) + balls;
            }
            //добавляем в словарь
            players.put(name, balls);
            //проверка на победителя
            if (winner.isEmpty())
                winner = name;
            else if (balls > players.get(winner))
                winner = name;
        }

        System.out.println("Победитель: " + winner + ", набранные очки:  " + players.get(winner));

    }
}
