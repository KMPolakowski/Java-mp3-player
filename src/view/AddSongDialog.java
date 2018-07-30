package view;



import control.MyHandler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import model.Song;

public class AddSongDialog extends Dialog<Song>{
	
	Button chooseButton = new Button("Choose Song");
	
	
	
	FileChooser fileChooser = new FileChooser();
	
	MyHandler handler;
	
	TextField tfTitle = new TextField();
	TextField tfInterpret = new TextField();
	TextField tfAlbum = new TextField();
	TextField tfPath = new TextField();
	TextField tfRelYear = new TextField();
	
	
	
	

	public AddSongDialog(MyHandler handler)
	{
		this.handler = handler;
		
		
		
		this.setTitle("Add Song");
		this.setHeaderText("Please enter the information in order to record a new song");
		this.getDialogPane().setContent(getGrid());
		ButtonType okButton = new ButtonType("OK", ButtonData.OK_DONE);
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
	
	public void update()
	{
		DialogPane pane = this.getDialogPane();
		pane.setContent(getGrid());
		this.setDialogPane(pane);
	}
	
	public Button getChooseButton() {
		return chooseButton;
	}

	public void setChooseButton(Button chooseButton) {
		this.chooseButton = chooseButton;
	}

	public FileChooser getFileChooser() {
		return fileChooser;
	}

	public void setFileChooser(FileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}

	public MyHandler getHandler() {
		return handler;
	}

	public void setHandler(MyHandler handler) {
		this.handler = handler;
	}

	public TextField getTfTitle() {
		return tfTitle;
	}

	public void setTfTitle(TextField tfTitle) {
		this.tfTitle = tfTitle;
	}

	public TextField getTfInterpret() {
		return tfInterpret;
	}

	public void setTfInterpret(TextField tfInterpret) {
		this.tfInterpret = tfInterpret;
	}

	public TextField getTfAlbum() {
		return tfAlbum;
	}

	public void setTfAlbum(TextField tfAlbum) {
		this.tfAlbum = tfAlbum;
	}

	public TextField getTfPath() {
		return tfPath;
	}

	public void setTfPath(TextField tfPath) {
		this.tfPath = tfPath;
	}

	public TextField getTfRelYear() {
		return tfRelYear;
	}

	public void setTfRelYear(TextField tfRelYear) {
		this.tfRelYear = tfRelYear;
	}

	public void addTitle(String title)
	{
		tfTitle.setText(title);
	}
	
	public void addInterpret(String interpret)
	{
		tfInterpret.setText(interpret);
	}
	
	public void addAlbum(String album)
	{
		tfAlbum.setText(album);
	}
	
	public void addPath(String path)
	{
		tfPath.setText(path);
	}
	
	public void addRelYear(String relYear)
	{
		tfRelYear.setText(relYear);
	}


	public GridPane getGrid()
	{
		GridPane gp = new GridPane();
		
		Button chooseButton = new Button("Choose Song");
		chooseButton.setUserData("choose");
		chooseButton.setOnAction(handler);
		
		gp.addRow(0, chooseButton);
		gp.addRow(1, new Label("Title: "), tfTitle);
		gp.addRow(2, new Label("Interpret: "), tfInterpret);
		gp.addRow(3, new Label("Album: "), tfAlbum);
		gp.addRow(4, new Label("Path: "), tfPath);
		gp.addRow(5, new Label("Release Year: "), tfRelYear);
		
		return gp;
	}

}
