import java.awt.*;
import java.awt.event.*;

public class ZombieShootingGame extends Frame {
    private int score;
    private int bullets;
    private boolean isGameOver;
    
    public ZombieShootingGame() {
        score = 0;
        bullets = 10;
        isGameOver = false;
        
        setSize(400, 400);
        setTitle("Zombie Shooting Game");
        setVisible(true);
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (!isGameOver && bullets > 0) {
                    int mouseX = me.getX();
                    int mouseY = me.getY();
                    
                    if (isHitZombie(mouseX, mouseY)) {
                        score += 10;
                    } else {
                        score -= 5;
                    }
                    
                    bullets--;
                    
                    if (bullets == 0) {
                        isGameOver = true;
                    }
                    
                    repaint();
                }
            }
        });
    }
    
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 20, 40);
        g.drawString("Bullets: " + bullets, 20, 70);
        
        if (isGameOver) {
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("Game Over", 120, 200);
        }
    }
    
    private boolean isHitZombie(int x, int y) {
        // Logic to determine if the zombie is hit based on its position
        // and the coordinates of the mouse click
        // Return true if the zombie is hit, false otherwise
        return false;
    }
    
    public static void main(String[] args) {
        ZombieShootingGame game = new ZombieShootingGame();
    }
}
