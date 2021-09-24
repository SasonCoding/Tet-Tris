package tetris;

import javax.swing.JOptionPane;

public class Tetris 
{
    private static GameForm gf;
    private static StartUpForm sf;
    private static LeaderBoardForm lf;
    
    private static AudioPlayer audio = new AudioPlayer();
            
    public static void start()
    {
        gf.setVisible(true);
        gf.startGame();
        
    }
    public static void showLeaderBoard()
    {
       lf.setVisible(true);
    }
    public static void showStartUp()
    {
        sf.setVisible(true);
    }
    public static void gameOver(int score)
    {
        playGameover();
        
        String playerName = JOptionPane.showInputDialog("Game over:\n Please enter your name.");
       
        gf.setVisible(false);
        lf.addPlayer(playerName,score);
        
    }
    
    public static void playClear()
    {
        audio.playClearLine();
    }
    
    public static void playGameover()
    {
        audio.playGameover();
    }
    
    public static void main(String[] args) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                gf = new GameForm();
                sf = new StartUpForm();
                lf = new LeaderBoardForm();

                sf.setVisible(true);
            }
        });
        
    }
    
}
