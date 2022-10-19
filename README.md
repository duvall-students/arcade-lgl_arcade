# arcade

Team names: Lilly, Griffon, Luke

Project desciption: Make a program that runs both breakout and galaga.

How to run/play the game:

Where to find design plan:

INTERFACES:

  - Moveable
      - .move()
  - Collidable
      - .getHitBox()
  - Drawable
      - .getSelf()
      - .getX()
      - .getY()

SUPER CLASSES:

  - Projectile (Abstract), Implements: Collidable & Moveable
      - Subclasses: Ball, Beam
      - Public Methods: move, getHitBox, getX, getY, getSelf
    
  - Player (Abstract) Implements: Collidable
      - Subclasses: Paddle, Ship
      - Public Methods: getHitBox, handleKeyInput, getX, getY, getSelf
     
  - Target (Abstract) Implements: Collidable
      - Subclasses: Brick, Enemy Implements Moveable
      - Public Methods: getHitBox, remove, checkIfRemoved, getX, getY, getSelf
      
  - Level (Abstract)
      - Subclasses: GalagaLevel (1-3), BreakoutLevel (Done)
      - Public Methods: run, remake
      

SUBCLASSES:

  - Ball
      - Methods: changeCourse
  - Beam
      - Methods: Beam Constructor, remove
  - Paddle
      - Methods: 
  - Ship
      - Methods: handleKeyInput (Override)
  - Brick
      - Methods: 
  - Enemy Implements Moveable
      - Methods: move
  - GalagaLevel (1-3)
      - Methods: 
  - BreakoutLevel
      - Methods: 

OTHER: 

  - GameView
      - Methods: 
  - CollisionHandler
      - Methods: 
  - FileReader
  - FileWriter

ASSIGNMENTS:

  - Lilly
      - GameView, CollisionHandler, BreakoutLevel, GalagaLevel
      - Moveable, Collidable, Drawable
  - Luke
      - GalagaLevel 2-3
      - Target, Brick, Enemy
  - Griffin
      - Projectile, Ball, Beam
      - Player, Paddle, Ship

TESTING:

  - Each member handles their own tests


