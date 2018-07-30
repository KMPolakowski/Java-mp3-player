package view;

import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import model.Song;
import model.SongManager;

public class EditSongInManagerDialog extends Dialog<Song>
{
	TextField tfTitle = new TextField();
	TextField tfInterpret = new TextField();
	TextField tfAlbum = new TextField();
	TextField tfPath = new TextField();
	TextField tfRelYear = new TextField();
	
	public EditSongInManagerDialog(SongManager sM, int i, String title, String interpret, String album, String path, String relYear)
	{
		
		tfTitle.setText(title);
		tfInterpret.setText(interpret);
		tfAlbum.setText(album);
		tfPath.setText(path);
		tfRelYear.setText(relYear);
		
		this.setTitle("Edit Song");
		this.setHeaderText("Please edit the information or delete the song.");
		this.getDialogPane().setContent(getGrid());

		ButtonType okButton = new ButtonType("Edit", ButtonData.OK_DONE);
		ButtonType cancelButton = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
		ButtonType delButton = new ButtonType("Delete Song", ButtonData.OTHER);

		this.getDialogPane().getButtonTypes().addAll(okButton, cancelButton, delButton);
		this.setResultConverter(new Callback<ButtonType, Song>()
			{

					@Override
					public Song call(ButtonType param) {
						// TODO Auto-generated method stub
						
						if(param == okButton)
						{
							try
							{
							Song a = new Song(tfTitle.getText(),
									tfInterpret.getText(), tfAlbum.getText(),
									tfPath.getText(), tfRelYear.getText());
							
							sM.setSongAtIndex(i, a);
							
							}
							catch(IllegalArgumentException e)
							{
								return null;
							}
							
							
						}
						
						if(param == delButton)
						{
							sM.delSongAtIndex(i);
						}
						
						return null;
						
					}
					
		
		});
		
	
		
		
	}
	
	
	public GridPane getGrid()
	{
		GridPane gp = new GridPane();
		
		gp.addRow(0, new Label("Title: "), tfTitle);
		gp.addRow(1, new Label("Interpret: "), tfInterpret);
		gp.addRow(2, new Label("Album: "), tfAlbum);
		gp.addRow(3, new Label("Path: "), tfPath);
		gp.addRow(4, new Label("Release Year: "), tfRelYear);
		
		return gp;
	}

}
