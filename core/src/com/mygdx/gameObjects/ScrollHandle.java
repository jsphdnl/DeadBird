package com.mygdx.gameObjects;

public class ScrollHandle {
    private Grass frontGrass, backGrass;
    private Pipe pipe1, pipe2, pipe3;
    
    public static final int SCROLL_SPEED = -10;
    public static final int PIPE_GAP = 70;
    
    public ScrollHandle(float yPos) {
        frontGrass = new Grass(0, yPos, 143, 11, SCROLL_SPEED);
        backGrass = new Grass(frontGrass.getTailX(), yPos, 143, 11,
                SCROLL_SPEED);

        pipe1 = new Pipe(210, 0, 22, 60, SCROLL_SPEED);
        pipe2 = new Pipe(pipe1.getTailX() + PIPE_GAP, 0, 22, 70, SCROLL_SPEED);
        pipe3 = new Pipe(pipe2.getTailX() + PIPE_GAP, 0, 22, 60, SCROLL_SPEED);
    }

    public void update(float delta) {
        // Update our objects
        frontGrass.update(delta);
        backGrass.update(delta);
        pipe1.update(delta);
        pipe2.update(delta);
        pipe3.update(delta);

        // Check if any of the pipes are scrolled left,
        // and reset accordingly
        if (pipe1.isScrolledLeft()) {
            pipe1.reset(pipe3.getTailX() + PIPE_GAP);
        } else if (pipe2.isScrolledLeft()) {
            pipe2.reset(pipe1.getTailX() + PIPE_GAP);

        } else if (pipe3.isScrolledLeft()) {
            pipe3.reset(pipe2.getTailX() + PIPE_GAP);
        }

        // Same with grass
        if (frontGrass.isScrolledLeft()) {
            frontGrass.reset(backGrass.getTailX());

        } else if (backGrass.isScrolledLeft()) {
            backGrass.reset(frontGrass.getTailX());

        }
    }

	public Grass getFrontGrass() {
		return frontGrass;
	}

	public void setFrontGrass(Grass frontGrass) {
		this.frontGrass = frontGrass;
	}

	public Grass getBackGrass() {
		return backGrass;
	}

	public void setBackGrass(Grass backGrass) {
		this.backGrass = backGrass;
	}

	public Pipe getPipe1() {
		return pipe1;
	}

	public void setPipe1(Pipe pipe1) {
		this.pipe1 = pipe1;
	}

	public Pipe getPipe2() {
		return pipe2;
	}

	public void setPipe2(Pipe pipe2) {
		this.pipe2 = pipe2;
	}

	public Pipe getPipe3() {
		return pipe3;
	}

	public void setPipe3(Pipe pipe3) {
		this.pipe3 = pipe3;
	}
	

    
    
}
