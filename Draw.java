import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.swing.Timer;
import java.util.Random;

public class Draw extends JComponent{

	private BufferedImage image;
	private BufferedImage backgroundImage;
	private URL resource = getClass().getResource("run0.png");


	// circle s positon
	public int x = 0;
	public int y = 430;
	public int height = 0;
	public int width = 0;

	public int state = 0;

	public Random randomizer;

	public int enemyCount ;
	Monster[] monsters = new Monster[10];

	public Draw(){

		randomizer = new Random();
		spawnEnemy();
		
		try{
			image = ImageIO.read(resource);
			backgroundImage = ImageIO.read(getClass().getResource("bg1.jpg"));
		}
		catch(IOException e){
			e.printStackTrace();
		}

		height = image.getHeight();
		width = image.getWidth();

		startGame();
	}

	public void startGame(){
		Thread gameThread = new Thread(new Runnable(){
			public void run(){
				while(true){
					try{
						for(int c = 0; c < monsters.length; c++){
							if(monsters[c]!=null){
								monsters[c].moveTo(x,y);
								repaint();
							}
						}
						Thread.sleep(100);
					} catch (InterruptedException e) {
							e.printStackTrace();
					}
				}
			}
		});
		gameThread.start();
	}
	public void spawnEnemy(){
		if(enemyCount < 10){
			monsters[enemyCount] = new Monster(randomizer.nextInt(500), randomizer.nextInt(500), this);
			enemyCount++;
		}
	}

	public void reloadImage(){
		state++;

        if (state == 0){
            resource = getClass().getResource("run0.png");
        }

        else if (state == 1){
            resource = getClass().getResource("run1.png");
        }

        else if (state == 2){
            resource = getClass().getResource("run2.png");
        }

        else if (state == 3){
            resource = getClass().getResource("run3.png");
        }
        
        else if (state == 4){
            resource = getClass().getResource("run4.png");
        }

        else if (state == 5){
            resource = getClass().getResource("run5.png");
            state = 0;
        }

        try {
            image = ImageIO.read(resource);
        }
        catch(IOException e){
            e.printStackTrace();
        }
	}
	public void swordAttackAnimation(){
		Thread sword1 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 5; ctr++){
					try {
						if(ctr==4){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("attack"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		sword1.start();
	}
	public void atkAnimation(){
		Thread thread1 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 6; ctr++){
					try {
						if(ctr==4){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("atk"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for(int x=0; x<monsters.length; x++){
					if(monsters[x]!=null){
						if(monsters[x].contact){
							monsters[x].life = monsters[x].life - 10;
						}
					}
				}
			}
		});
		thread1.start();
	}
	public void swirlAtkAnimation(){
		Thread thread2 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 6; ctr++){
					try {
						if(ctr==4){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("swirlatk"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for(int x=0; x<monsters.length; x++){
					if(monsters[x]!=null){
						if(monsters[x].contact){
							monsters[x].life = monsters[x].life - 10;
						}
					}
				}
			}
		});
		thread2.start();
	}

	public void jumpAnimation(){
		Thread jump1 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 5; ctr++){
					try {
						if(ctr==4){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("jump"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		jump1.start();
	}
	public void slideAnimation(){
		Thread slide1 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 6; ctr++){
					try {
						if(ctr==4){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("slide"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		slide1.start();
	}
	public void bowAnimation(){
		Thread bow1 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 9; ctr++){
					try {
						if(ctr==4){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("bow"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		bow1.start();
	}
	public void atakAnimation(){
		Thread atak1 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 5; ctr++){
					try {
						if(ctr==4){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("atak"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		atak1.start();
	}
	public void swirlatk(){
		swirlAtkAnimation();
		reloadImage();
		repaint();
	}
	public void atak1(){
		atakAnimation();
		reloadImage();
		repaint();
	}
	public void atk(){
		atkAnimation();
		reloadImage();
		repaint();
	}
	public void bow(){
		bowAnimation();	
		reloadImage();
		repaint();
	}
	public void slide(){
		slideAnimation();
		x = x + 20;
		reloadImage();
		repaint();
	}

	public void jump(){
		y = y - 20;
		jumpAnimation();
		reloadImage();
		repaint();
	}

	public void attack(){
		swordAttackAnimation();
		reloadImage();
		repaint();
	}

	public void moveUp(){
		y=y - 5;
		reloadImage();
		repaint();
	}
	public void moveDown(){
		if(y > 470){
			y = 470;
		}
		y=y + 5;
		reloadImage();
		repaint();
		
	}
	public void moveLeft(){
		if(x < 5){
			x = 5;
		}
		x=x - 5;
		reloadImage();
		repaint();
		
	}
	public void moveRight(){
		x=x + 5;
		reloadImage();
		repaint();
		
	}
	public void checkCollision(){
		int xChecker = x + width;
		int yChecker = y;

		for(int x=0; x<monsters.length; x++){
			boolean collideX = false;
			boolean collideY = false;

			if(monsters[x]!=null){
				monsters[x].contact = false;

				if(yChecker > monsters[x].yPos){
					if(yChecker-monsters[x].yPos < monsters[x].height){
						collideY = true;
					}
				}
				else{
					if(monsters[x].yPos - yChecker < monsters[x].height){
						collideY = true;
					}
				}

				if(xChecker > monsters[x].xPos){
					if(xChecker-monsters[x].xPos < monsters[x].width){
						collideX = true;
					}
				}
				else{
					if(monsters[x].xPos - xChecker < 5){
						collideX = true;
					}
				}
			}

			if(collideX && collideY){
				System.out.println("collision!");
				monsters[x].contact = true;
			}
		}
	}
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.YELLOW);
        g.drawImage(backgroundImage, 0, 0, this);
        g.drawImage(image, x , y, this);
        for(int c = 0; c < monsters.length; c++){
			if(monsters[c]!=null){
				g.drawImage(monsters[c].image, monsters[c].xPos, monsters[c].yPos, this);
				g.setColor(Color.GREEN);
				g.fillRect(monsters[c].xPos+7, monsters[c].yPos, monsters[c].life, 2);
			}	
		}


	}
}