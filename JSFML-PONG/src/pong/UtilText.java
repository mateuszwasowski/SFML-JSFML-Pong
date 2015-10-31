package pong;


import java.nio.file.Paths;
import java.io.IOException;


import org.jsfml.graphics.*;

public class UtilText {

	public UtilText(String str) {
		
		try {
			font.loadFromFile(Paths.get("arial.ttf"));
		} catch(IOException ex){
			ex.printStackTrace();
		}
		
		Tekst.setFont(font);
		Tekst.setString(str);
	}

	void setText(int a, int b, int c, Color color) {
		Tekst.setPosition(a, b);
		Tekst.setCharacterSize(c);
		Tekst.setColor(color);
	}

	Text getObject() {
		return Tekst;
	}

	void setString(String s) {
		Tekst.setString(s);
	}

	private Text Tekst = new Text();
	Font font = new Font();

}
