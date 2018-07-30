package control;


import java.io.File;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import model.Song;
import view.AddSongDialog;
import view.EditSongDialog;
import view.MyPane;

public class MyHandler implements EventHandler<ActionEvent> {

	private MyPane pane;
	
	public MyHandler(MyPane pane)
	{
		this.pane = pane;
	}
	
	
	@Override
	public void handle(ActionEvent event) {

		if(event.getSource() instanceof MenuItem)
		{
			String userData = (String)((MenuItem)event.getSource()).getUserData();
			
			switch(userData)
			{
			
			case "manage" : pane.showSongList();
						 break;
						 
			}
			
		}
		
		if(event.getSource() instanceof Button)
		{
			String userData = (String)((Button)event.getSource()).getUserData();
			
			
			switch(userData)
			{
			
			case "add" : 
				
				AddSongDialog dlg = new AddSongDialog(this);
				Optional<Song> res = dlg.showAndWait();
						
						if(res.isPresent())
						{
							
							Song a = res.get();
							pane.addSong(a);
						}
						
			break;
			
			
			case "choose" :
				
				
				
				FileChooser chooser = new FileChooser();
				chooser.setTitle("Choose the song");
				File f = chooser.showOpenDialog(pane.getPrimaryStage());

					
				try
				{
				IP3reader IP3 = new IP3reader(f);
				EditSongDialog editDlg = new EditSongDialog(IP3.getTitle(), IP3.getInterpret(),IP3.getAlbum(), IP3.getPath(), IP3.getRelYear());
				
				Optional<Song> editRes = editDlg.showAndWait();
				
				if(editRes.isPresent())
				{
					Song a = editRes.get();
					pane.addSong(a);
				}
				
				
				
				}
				
				
				catch(Exception e)
				{
				break;
				}
				
				
				
				break;
			
			
			
			
			
						 
			}
		
		}
	
	

	
	}
	
}
