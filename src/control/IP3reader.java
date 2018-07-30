package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class IP3reader {
	
	String title = "";
	String interpret = ""; 
	String album = "";
	String path = "";
	String relYear = "";
	
	
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

	public String getRelYear() {
		return relYear;
	}

	public void setRelYear(String relYear) {
		this.relYear = relYear;
	}


	
	ArrayList<Character> lastBytes = new ArrayList<Character>();
	
	public IP3reader(File f)
	{
		readFromFile(f);
		
	}
	
	public void readFromFile(File f)
	{	
		setPath(f.getPath());
		
		try(FileReader fr = new FileReader(f))
		{
			ArrayList<Character> bytes = new ArrayList<Character>();
			
			
			
			int x;
			while ((x=fr.read()) != -1)
			{
				bytes.add((char) x);
			}
			
			
			int idx = 0;
			
			for(int i = 0; i < bytes.size(); i++)
			{
				if(i >= (bytes.size()-128))
				{				
					lastBytes.add(bytes.get(i));
					
				}
			}
			
	
			parseID3Tag();
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void parseID3Tag()
	{
		
		for(int i = 0; i < lastBytes.size(); i++)
		{
			
			if(i > 2 && i < 31)
			{
				
				setTitle(title + lastBytes.get(i).toString());
			}
			
			if(i > 32 && i < 63)
			{
				setInterpret(interpret + lastBytes.get(i).toString());
			}
			
			if(i > 62 && i < 93)
			{
				setAlbum(album + lastBytes.get(i).toString());
			}
			
			if(i > 92 && i < 97)
			{
				setRelYear(relYear + lastBytes.get(i).toString());
			}
			
			
			
		}
		
	
		
		
		
	}
	
	
}
