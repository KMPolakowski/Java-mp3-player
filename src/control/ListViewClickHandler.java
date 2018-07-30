package control;

import java.util.Optional;

import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import model.Song;
import model.SongManager;
import view.EditSongInManagerDialog;

public class ListViewClickHandler implements EventHandler<MouseEvent>{
	
	ListView songs;
	SongManager sM;
	
	public ListViewClickHandler(ListView songs, SongManager sM)
	{
		this.songs = songs;
		this.sM = sM;
		
	}

	@Override
	public void handle(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		int i = songs.getSelectionModel().getSelectedIndex();
		Song song = sM.getObsList().get(i);
		
		EditSongInManagerDialog dlg = new EditSongInManagerDialog(sM, i, song.getTitle(), song.getInterpret(), song.getAlbum(), song.getPath(), song.getReleaseYear());
		
		Optional<Song> res = dlg.showAndWait();
		
		if(res.isPresent())
		{
			Song a = res.get();
			sM.addSong(a);
		}
		
		}
		
		
	
	}

	

