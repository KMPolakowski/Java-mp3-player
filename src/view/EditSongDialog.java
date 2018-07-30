package view;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import model.Song;

public class EditSongDialog extends Dialog<Song>
{
	TextField tfTitle = new TextField();
	TextField tfInterpret = new TextField();
	TextField tfAlbum = new TextField();
	TextField tfPath = new TextField();
	TextField tfRelYear = new TextField();
	
	public EditSongDialog(String title, String interpret, String album, String path, String relYear)
	{
		
		tfTitle.setText(title);
		tfInterpret.setText(interpret);
		tfAlbum.setText(album);
		tfPath.setText(path);
		tfRelYear.setText(relYear);
		
		this.setTitle("Edit Song");
		this.setHeaderText("Please check the information and confirm.");
		this.getDialogPane().setContent(getGrid());

		ButtonType okButton = new ButtonType("Edit", ButtonData.OK_DONE);
		ButtonType cancelButton = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

		this.getDialogPane().getButtonTypes().addAll(okButton, cancelButton);
		this.setResultConverter(new Callback<ButtonType, Song>()
			{

					@Override
					public Song call(ButtonType param) {
						// TODO Auto-generated method stub
						
						if(param == okButton)
						{
							try
							{
							return new Song(tfTitle.getText(),
									tfInterpret.getText(), tfAlbum.getText(),
									tfPath.getText(), tfRelYear.getText());
							}
							catch(IllegalArgumentException e)
							{
								return null;
							}
							
							
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
