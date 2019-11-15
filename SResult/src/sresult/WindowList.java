package sresult;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowList implements WindowListener{

    @Override
    public void windowOpened(WindowEvent e) {
        
        System.out.println(" WINDOW OPENED ");
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowClosing(WindowEvent e) {
         System.out.println(" WINDOW CLOSING ");
         System.exit(0);
       // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println(" WINDOW CLOSED ");
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println(" WINDOW ICONi ");
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println(" WINDOW DeCONi ");
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println(" WINDOW ACT ");
       // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println(" WINDOW DeACT ");
       //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
