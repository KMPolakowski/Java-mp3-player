package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SongManager {

	ObservableList<Song> obsList;
	
	
	public SongManager()
	{
		obsList = FXCollections.observableArrayList();
	}
	
	public void addSong(Song song)
	{
		obsList.add(song);
		
	}
	
	public void delSongAtIndex(int i)
	{
		obsList.remove(i);
	}
	
	public void setSongAtIndex(int i, Song song)
	{
		obsList.set(i, song);
	}
	
	public void saveSongs() throws IOException
	{
		FileOutputStream out = new FileOutputStream("songs.txt");
		
		ObjectOutputStream s = new ObjectOutputStream(out);
		
		s.writeObject(obsList);
	}
	
	
	public void readSongs() throws IOException, ClassNotFoundException
	{
		FileInputStream in = new FileInputStream("songs.txt");
		
		ObjectInputStream s = new ObjectInputStream(in);
		
		setObsList((ObservableList<Song>)s.readObject());
	}

	public ObservableList<Song> getObsList()
    {
		return obsList;
	}

	public void setObsList(ObservableList<Song> obsList) {
		this.obsList = obsList;
	}
	
}
