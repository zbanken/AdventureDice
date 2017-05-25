public class Rooms {

    int r = 0;
    int c = 2;
    int[] currentRoom = {r, c};
    AdventureDice game;
    String[][] roomArray = {
            {"", "", "Entrance", "", "", "", ""},
            {"", "", "Ladder", "", "", "", ""},
            {"Sword in a stone", "Passage with a monster", "Rocky Room", "Blazing Fire", "Locked Green Door", "Red Monster", ""},
            {"", "", "", "Unlocked Purple door", "", "", ""},
            {"", "", "", "Ladder going down", "", "", ""},
            {"", "Room with a monster", "Tunnel", "Tall Room", "BookShelf", "Secret Room", ""},
            {"", "", "", "Tunnel", "", "", ""},
            {"Room with a monster", "Tunnel", "Tunnel", "Narrom Room", "Tunnel", "Tunnel", "Room with a monster"},
            {"", "", "", "Locked Yellow Door", "", "", ""},
            {"", "Room with a well", "Tunnel", "Long Room", "Tunnel", "Large Chest", ""},
            {"", "", "", "Tunnel", "", "", ""},
            {"Golden Chest", "Damp Room", "Locked Door", "Smelly Room", "Locked Door", "Spike Pit", ""},
            {"", "Tunnel", "", "Tunnel", "", "", ""},
            {"Bucket", "Puzzle Room", "", "Grey Monster", "", "", ""},
            {"", "", "", "", "", "", ""},
            {"", "", "", "", "", "", ""},
            {"", "", "", "", "", "", ""},
            {"", "", "", "", "", "", ""},
            {"", "", "", "", "", "", ""},
            {"", "", "", "", "", "", ""},
            {"", "", "", "", "", "", ""},
    };

    public Rooms(AdventureDice g) {
        game = g;
    }

    public void updateRoom(int directionX, int directionY) {
        if (currentRoom[1] + directionX >= 0 && currentRoom[0] + directionY >= 0 && roomArray[currentRoom[0] + directionY][currentRoom[1] + directionX] != "") {
            currentRoom[0] += directionY;
            currentRoom[1] += directionX;
            game.journey.changeText(roomArray[currentRoom[0]][currentRoom[1]]);
        }
        else {
            game.journey.changeText("You shall not pass!");
            //game.journey.changeText(roomArray[currentRoom[0]][currentRoom[1]]);
        }
    }


}
