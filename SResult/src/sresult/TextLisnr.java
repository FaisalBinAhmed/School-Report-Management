package sresult;

import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class TextLisnr implements TextListener{

    private TextField txt;
    
    public TextLisnr(TextField txt)
    {
        this.txt=txt;
    }
    
    @Override
    public void textValueChanged(TextEvent e) {
        //txt.setText("*");
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
