package com.github.keyzou.villagerrun.rooms;

import com.github.keyzou.villagerrun.entities.VillagerPlayer;
import net.samagames.api.games.Game;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dean on 15/03/2016.
 */
public class RoomManager {

    private List<Room> rooms = new ArrayList<>();
    private List<Room> roomsPlaying = new ArrayList<>();

    private Game currentGame;

    public RoomManager(Game game){
        this.currentGame = game;
    }

    public void createRoom(Location loc, VillagerPlayer attachedPlayer) {
        rooms.add(new Room(loc, attachedPlayer));
    }

    public void startGame(){
        roomsPlaying.addAll(rooms);
        for(Room r : roomsPlaying){
            r.startGame();
        }
    }

}
