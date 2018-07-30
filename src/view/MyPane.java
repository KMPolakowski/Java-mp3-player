package view;

import control.ListViewClickHandler;
import control.MyHandler;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Song;
import model.SongManager;

public class MyPane extends BorderPane {
	
	Stage primaryStage;
	SongManager manager;
	AddSongDialog dialog;
	
	MyHandler handler;
	
	
	BorderPane content = new BorderPane();
	
	ListView<Song> songList;
	ObservableList<Song> obsList;
	
	public MyPane(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
		manager = new SongManager();
		handler = new MyHandler(this);
		
		
		obsList = manager.getObsList();
		songList = new ListView<Song>(obsList);
		
		init();
	}
			
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}


	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}


	public void init()
	{
		ListViewClickHandler clickHandler = new ListViewClickHandler(songList, manager);
		songList.addEventHandler(MouseEvent.MOUSE_CLICKED, clickHandler);
		
		this.setTop(getMenuBar());
		this.setCenter(getCenterContent());
		
	}
	
	public MenuBar getMenuBar()
	{
		MenuBar mB = new MenuBar();
		
		Menu manage = new Menu("Manage");
		manage.setUserData("manage");
		Menu song = new Menu("Song");
		Menu settings = new Menu("Settings");
		
		MenuItem manageSongs = new MenuItem("Manage Songs");
		
		manage.getItems().add(manageSongs);
		
		mB.getMenus().addAll(manage, song, settings);
		
		
		return mB;
	}
	
	
	public BorderPane getCenterContent()
	{
		Button addButton = new Button("Add");
		addButton.setUserData("add");
		addButton.setOnAction(handler);
		
		songList.setMinWidth(300);
		content.setLeft(songList);
		content.setCenter(addButton);
		
		return content;
	}
	
	public void showSongList()
	{	
		songList.setItems(manager.getObsList());
		
		
	}
	
	public void addSong(Song song)
	{
		manager.addSong(song);
	}
	
	
}
