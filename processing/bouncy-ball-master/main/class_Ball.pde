class Ball{
  // declaration of variables
  int diameter;
  float xPos; // x position of the ball
  float yPos; // y position of the ball
  float speed; 
  float gravity;
  int passedX, passedY,passedDiameter;
  
  Ball(int passedX, int passedY, int passedDiameter){
    diameter = passedDiameter;
    //print(mouseX + "\t" + mouseY);
    xPos = passedX; // x position of the ball
    yPos =  passedY;//0 + diameter/2; // y position of the ball
    speed = 0; 
    gravity = 0.66;
  }
  
  void fallandjump(){ //this function (fallandjump()) calculates the new position of the object one time, but it is called multiple times by the draw function in main sketch
    // Site from www.learningprocessing.com
    speed = speed + gravity;
    yPos = yPos + speed;
  
    // Condition to make the ball stop
    if ( speed < 0.001 && yPos > height - diameter/2) {
      //println("bottom");
      speed = 0;
      gravity = 0;
    }
    else if (yPos > height - diameter/2) {
      //println(speed);
      speed = speed * -1;
      //println("Change Direction");
    }
  }
  
  void display(){ // this function (display()) draws a figure with its new positional data xPos and yPos previously calculated by the function fallaandjump() if previously called, like in main sketch
    fill(255);
    ellipse(xPos, yPos, diameter, diameter);
  }
}
