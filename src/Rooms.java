public class Rooms {

    private final int r = 0;
    private final int c = 2;
    private int[] currentRoom = {r, c};
    AdventureDice game;
    private String[][] roomArray = {
            {"", "", "Entrance", "", "", "", ""},
            {"", "", "Ladder", "", "", "", ""},
            {"CHEST,SWORD:Sword in a stone", "MONSTER:Passage with a monster", "Rocky Room", "CHEST,RED: Blazing Fire", "LOCKED:Locked Green Door", "MONSTER:Red Monster", ""},
            {"", "", "", "Purple door", "", "", ""},
            {"", "", "", "Ladder going down", "", "", ""},
            {"", "MONSTER:Room with a monster", "Tunnel", "Tall Room", "LOCKED:BookShelf", "CHEST,RAINBOW: Secret Room", ""},
            {"", "", "", "Tunnel", "", "", ""},
            {"MONSTER:Room with a monster", "Tunnel", "Tunnel", "Narrow Room", "Tunnel", "Tunnel", "MONSTER:Room with a monster"},
            {"", "", "", "LOCKED:Locked Yellow Door", "", "", ""},
            {"", "CHEST,WELL:Room with a well", "Tunnel", "Long Room", "Tunnel", "CHEST,ROLLS:Large Chest", ""},
            {"", "", "", "Tunnel", "", "", ""},
            {"CHEST,SHIELD:Small Chest", "Damp Room", "LOCKED:Locked Purple Door", "Smelly Room", "LOCKED:Locked Orange Door", "SPIKE:Spike Pit", ""},
            {"", "Tunnel", "", "Tunnel", "", "", ""},
            {"BUCKET:Bucket", "Puzzle Room- \n A sign reads \" \n Those who enter must extinguish \n their fears with water from the \n depths of the earth\" ", "", "MONSTER:Grey Monster", "", "", ""},
            {"", "KEY,RED:Locked Red Door", "", "", "", "", ""},
            {"MONSTER:Dark-Gray Monster", "Big Room", "Tunnel", "MONSTER:Sea-Green Monster", "Tunnel", "MONSTER:Magenta Monster", "Blue Room"},
            {"", "Tunnel", "", "Tunnel", "", "", "Tunnel"},
            {"", "MONSTER:Turquoise Monster", "Tunnel", "Tunnel", "MONSTER:Pink Monster", "", "MONSTER:Dark Green Monster"},
            {"CHEST,HEALTH:Dark Red Chest", "Tunnel", "", "Tunnel", "", "", "Tunnel"},
            {"", "Tunnel", "", "Tunnel", "", "", "KEY,GOLD:Locked Gold Door"},
            {"CHEST,GOLD:Gold Chest", "KEY,RAINBOW:Locked Rainbow Door", "Tunnel", "MONSTER:Burnt Orange Monster", "SPIKE:Spike Pit", "", "MONSTER,BOSS:A Giant Golden Dragon Lurks In A Vast Cavern"},
        };

    public Rooms(AdventureDice g) {
        game = g;
    }

    public String[] readTags()
    {
        int end = roomArray[currentRoom[0]][currentRoom[1]].indexOf(':');

        if (end != -1) {
            String[] tag = roomArray[currentRoom[0]][currentRoom[1]].substring(0,end).split(",");

            return tag;
        }
        String[] NORMAL = {"NORM"};
        return NORMAL;
    }

    public void callTags() {
        String[] tags = readTags();

        for(String tag : tags) {
            switch (tag) {
                case "MONSTER":
                    //game.choice.disableButtons();
            }
        }
    }

    public void updateRoom(int directionX, int directionY) {
        if (currentRoom[1] + directionX >= 0 && currentRoom[0] + directionY >= 0 && !roomArray[currentRoom[0] + directionY][currentRoom[1] + directionX].equals("")) {
            currentRoom[0] += directionY;
            currentRoom[1] += directionX;
            callTags();
            int end = roomArray[currentRoom[0]][currentRoom[1]].indexOf(':');
            if (end != -1) {
                game.journey.changeText(roomArray[currentRoom[0]][currentRoom[1]].substring(end + 1));
            }
            else {
                game.journey.changeText(roomArray[currentRoom[0]][currentRoom[1]]);
            }
        }

        else {
            game.journey.appendText("You shall not pass!");
            //             for (String item : readTag()) {
            //                 game.journey.appendText(item);
            //}
        }

    }
}
