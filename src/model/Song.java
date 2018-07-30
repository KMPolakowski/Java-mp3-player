package model;

import java.time.LocalDate;

public class Song {
	
	String title;
	String interpret;
	String album;
	String path;
	String releaseYear;
	public Song(String title, String interpret, String album, String path, String releaseYear)
	{
		setTitle(title);
		setInterpret(interpret);
		setAlbum(album);
		setPath(path);
		setReleaseYear(releaseYear);
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInterpret() {
		return interpret;
	}
	public void setInterpret(String interpret) {
		this.interpret = interpret;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(String releaseYear) {
		if(Integer.parseInt(releaseYear) <= LocalDate.now().getYear())
		{
		this.releaseYear = releaseYear;
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}
	
	
	public String toString()
	{
		return "Title: " + title + ", Interpret: " + interpret +  ", Album: " + album + ", Path: " + path +  ", Release Year: " + releaseYear;
		
	}
	
	
	
	

}
